package omokGame.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import datasDAO.JoinDAO;
import datasDAO.LoginDAO;
import datasDAO.UserGamedataInfoDAO;
import datasDAO.UserStoreInfoDAO;
import datasDAO.UserStoreSkinInfoDAO;
import datasDTO.AbstractEnumsDTO;
import datasDTO.GameRoomInfoVO;
import datasDTO.RoomAndUserListDTO;
import datasDTO.ServerMessageDTO;
import datasDTO.UserGamedataInfoDTO;
import datasDTO.UserPersonalInfoDTO;
import enums.etc.ImageEnum;
import enums.etc.ServerActionEnum;
import enums.etc.ServerIPEnum;
import enums.etc.UserActionEnum;
import enums.etc.UserPositionEnum;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import utility.SendEmail;

public class OmokServer {
	private ServerSocket serverSocket;
	private Socket socket;
	private Map<String, OmokPersonalServer> loginUsersMap;
	private List<GameRoomInfoVO> gameRoomList;
	private List<UserGamedataInfoDTO> userIDList;
	
	private JoinDAO joinDAO;
	private LoginDAO loginDAO;
	private UserGamedataInfoDAO gamedataDAO;
	private UserStoreInfoDAO storeDAO;
	private UserStoreSkinInfoDAO skinDAO;
	
	public OmokServer() throws IOException {
		this.serverSocket = new ServerSocket(ServerIPEnum.SERVER_PORT.getServerPort());
		this.joinDAO 	  = new JoinDAO();
		this.loginDAO 	  = new LoginDAO();
		this.gamedataDAO  = new UserGamedataInfoDAO();
		this.storeDAO	  = new UserStoreInfoDAO();
		this.skinDAO	  = new UserStoreSkinInfoDAO();
		
		this.loginUsersMap = new HashMap<String, OmokPersonalServer>();
		this.gameRoomList  = new ArrayList<GameRoomInfoVO>();
		this.userIDList    = new ArrayList<UserGamedataInfoDTO>();
		
//TODO test data ---------------------------------------------------------
//		GameRoomInfoVO vo = new GameRoomInfoVO();
//		vo.setImage(ImageEnum.WAITINGROOM_ROOM_ENTERCHECK_IMAGE_MAP.getMap().get("O"));
//		vo.setOwner("test");
//		vo.setPersons(1);
//		vo.setRoomName("test���Ӵ�");
//		vo.setRoomNumber(1);
//		GameRoomInfoVO vo2 = new GameRoomInfoVO();
//		vo2.setImage(ImageEnum.WAITINGROOM_ROOM_ENTERCHECK_IMAGE_MAP.getMap().get("X"));
//		vo2.setOwner("test");
//		vo2.setPersons(1);
//		vo2.setRoomName("test���Ӵ�");
//		vo2.setRoomNumber(1);
//		
//		this.gameRoomList.add(vo);
//		this.gameRoomList.add(vo2);
//------------------------------------------------------------------------
	}
	
	public void gameServerOn() throws IOException {
		System.out.println("Server On...");
		
		while(true) {
			System.out.println("Waiting User...");
			this.socket = this.serverSocket.accept();
			OmokPersonalServer personalServer = new OmokPersonalServer(this, this.socket);
			personalServer.start();
			System.out.println("User Accept .. " + socket.getLocalAddress());
		}
	}
	
//�α���--------------------------------------------------------------------------
	public void login(AbstractEnumsDTO data, OmokPersonalServer personalServer) throws IOException {
		// Ŭ���̾�Ʈ���Լ� ���� ������ DTO�� ��ȯ
		UserPersonalInfoDTO inputUserPersonalInfo = (UserPersonalInfoDTO) data;
		// DB�� ���̵� �н����带 ���� ��ġ���� ��� DTO�� ����
		UserPersonalInfoDTO resultDTO = this.loginDAO.checkIDMatchesPW(inputUserPersonalInfo);
		
		// ���� Ŭ���̾�Ʈ�� ������ DB�� �ִٸ� 
		if(resultDTO.getServerAction() == ServerActionEnum.LOGIN_SUCCESS) {
			//Ŭ���̾�Ʈ�� ID�� ó�� ���Ե� ���̶��
			if(this.loginUsersMap.get(resultDTO.getUserID()) == null) {
				// ������ ������ ���� ������Ͽ� �߰�
				this.loginUsersMap.put(resultDTO.getUserID(), personalServer);
				// ����ڿ��� ���� ���� ������ ��Ͽ� �߰�
				this.userIDList.add(gamedataDAO.getUserGrade(resultDTO));
			//Ŭ���̾�Ʈ�� ID�� �̹� �����ڸ���Ʈ�� �����Ѵٸ�
			} else {
				resultDTO.setServerAction(ServerActionEnum.LOGIN_FAIL_OVERLAP_ACCEPT);
			}
		}
		personalServer.getServerOutputStream().writeObject(resultDTO);
	}
	
//����--------------------------------------------------------------------------
	public void waitingRoom(AbstractEnumsDTO listDTO, OmokPersonalServer personalServer) throws IOException {
		switch(listDTO.getUserAction()) {
		case USER_LOGIN_SUCCESS :
			this.waitingRoom_LoginSuccess(listDTO, personalServer);
			break;
		case USER_CREATE_ROOM :
			this.waitingRoom_CreateRoom(listDTO, personalServer);
			break;
		default :
			break;
		}
	}
	
	public void waitingRoom_LoginSuccess(AbstractEnumsDTO listDTO, OmokPersonalServer personalServer) throws IOException {
		// �����ڸ���Ʈ �� ���ӹ� ����Ʈ�� ���� �������� ���������� ��� Ŭ���̾�Ʈ�� �߼�
		RoomAndUserListDTO roomAndUserListDTO = new RoomAndUserListDTO(UserPositionEnum.POSITION_WAITING_ROOM);
		roomAndUserListDTO.setServerAction(ServerActionEnum.WAITING_ROOM_ENTER);
		roomAndUserListDTO.setUserList(this.userIDList);
		
		roomAndUserListDTO.setGameRoomList(this.gameRoomList);
		roomAndUserListDTO.setUserGameData(this.gamedataDAO.userGameData(((UserPersonalInfoDTO)listDTO).getUserID()));
		personalServer.getServerOutputStream().writeObject(roomAndUserListDTO);
		
		// ���� �������� �����鿡�� ���ο� �������� ������ ����
		UserGamedataInfoDTO newUserDTO = roomAndUserListDTO.getUserGameData();
		newUserDTO.setPosition(UserPositionEnum.POSITION_WAITING_ROOM);
		newUserDTO.setServerAction(ServerActionEnum.LOGIN_NEW_USER);
		for(String id : this.loginUsersMap.keySet()) {
			if(!id.equals(roomAndUserListDTO.getUserGameData().getUserID())) {
				this.loginUsersMap.get(id).getServerOutputStream().writeObject(newUserDTO);
			}
		}
	}
	
	// �������Լ� ������ϰڴ� ��� �޼����� ������ ������ ���ӹ渮��Ʈ�� ���� �߰����� �� ����ڿ��� ����� �����ش�.
	// ���� 20���� �Ѵ´ٸ� �游��� ����.
	public void waitingRoom_CreateRoom(AbstractEnumsDTO listDTO, OmokPersonalServer personalServer) throws IOException {
		GameRoomInfoVO gameRoomInfo = (GameRoomInfoVO)listDTO;
		if(this.gameRoomList.size() < 20) {
			this.gameRoomList.add(gameRoomInfo);
			gameRoomInfo.setServerAction(ServerActionEnum.GAME_CREATEROOM_SUCCESS);
		} else {
			gameRoomInfo.setServerAction(ServerActionEnum.GAME_CREATEROOM_FAIL);			
		}
		personalServer.getServerOutputStream().writeObject(gameRoomInfo);
		
		gameRoomInfo.setServerAction(ServerActionEnum.GAME_ROOM_ADD);
		for(String id : this.loginUsersMap.keySet()) {
			this.loginUsersMap.get(id).getServerOutputStream().writeObject(gameRoomInfo);
		}
	}
//ȸ������--------------------------------------------------------------------------
	public void join(AbstractEnumsDTO data, OmokPersonalServer personalServer) throws IOException {
		UserPersonalInfoDTO personalDTO = (UserPersonalInfoDTO)data;
		// ���̵� �ߺ�üũ�� ���
		if(data.getUserAction() == UserActionEnum.USER_JOIN_ID_OVERLAP_CHECK) {
			UserPersonalInfoDTO resultDTO = this.joinDAO.checkOverlapID(personalDTO);
			personalServer.getServerOutputStream().writeObject(resultDTO);
		
		// ������ȣ �߼��� ���
		} else if(data.getUserAction() == UserActionEnum.USER_JOIN_CERTIFICATION) {
			UserPersonalInfoDTO resultDTO = (UserPersonalInfoDTO)data;
			//������ȣ ����
			String confirmNumber = String.valueOf(new Random().nextInt(900000) + 100000);
			//�̸��Ϲ߼�
			new SendEmail(confirmNumber, resultDTO.getUserEmail());
			
			resultDTO.setCertificationNumber(confirmNumber);
			resultDTO.setServerAction(ServerActionEnum.JOIN_CERTIFICATION);
			personalServer.getServerOutputStream().writeObject(resultDTO);
		// ȸ�������� ���
		} else {
			// ���̵� �ߺ����� �ʴ´ٸ�
			if(this.joinDAO.checkOverlapID(personalDTO).getUserID() == null) {
				ServerMessageDTO serverMessage = new ServerMessageDTO(UserPositionEnum.POSITION_JOIN);
				serverMessage.setUserAction(UserActionEnum.USER_JOIN_JOINACTION);
				// DB�� ������ ������Ʈ 00
				int result = this.joinDAO.creatUserPersonalInfo(personalDTO);
				result += this.joinDAO.createUserGameDataInfo(personalDTO);
				result += this.joinDAO.createUserStoreInfo(personalDTO);
				result += this.joinDAO.createUserSkinInfo(personalDTO);
				// ���������� ������Ʈ �� ���
				if(result == 4) {
					serverMessage.setServerAction(ServerActionEnum.JOIN_SUCCESS);
//TODO
					// ������Ʈ ������ ���
				} else {
					serverMessage.setServerAction(ServerActionEnum.JOIN_FAIL);
				}
				personalServer.getServerOutputStream().writeObject(serverMessage);
			}
		}
	}
	
	public void findID() {
		System.out.println("IDã��");
	}
	
	public void findPW() {
		System.out.println("��й�ȣã��");
	}
	//
	public void findEmail(AbstractEnumsDTO data, OmokPersonalServer PersonalServer) throws IOException {
		UserPersonalInfoDTO personalDTO = (UserPersonalInfoDTO)data;
		if(data.getUserAction() == UserActionEnum.USER_JOIN_CERTIFICATION) {
			UserPersonalInfoDTO resultDTO = (UserPersonalInfoDTO)data;
			
			String ConfirmNumber = String.valueOf(new Random().nextInt(900000) + 100000);
			//���� �߼� -- ���� ��ȣ�� resultDTO�� ��� ����� �̸��Ϸ� ������..
			new SendEmail(ConfirmNumber, resultDTO.getUserEmail());
			
			resultDTO.setCertificationNumber(ConfirmNumber);
			resultDTO.setServerAction(ServerActionEnum.JOIN_CERTIFICATION);
			PersonalServer.getServerOutputStream().writeObject(resultDTO);
		}
	}
	public void gameRoom() {
		System.out.println("���ӹ�");
	}
	
	public void store() {
		System.out.println("����");
	}
	
	public void otherUserInfo() {
		System.out.println("�ٸ������������");
	}
	
	public void modifyMyInfo() {
		System.out.println("����������");
	}

	public void exitProgram(AbstractEnumsDTO index, OmokPersonalServer personalServer) throws IOException {
		System.out.println("���α׷� ����");
		personalServer.getServerOutputStream().writeObject(index);
		
		personalServer.getServerOutputStream().close();
		personalServer.getServerInputStream().close();
		personalServer.getPersonalSocket().close();
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	public Map<String, OmokPersonalServer> getPsersonalServerMap() {
		return loginUsersMap;
	}


}
