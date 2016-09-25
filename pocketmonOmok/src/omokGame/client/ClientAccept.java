package omokGame.client;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import datasDTO.AbstractEnumsDTO;
import datasDTO.RoomAndUserListDTO;
import datasDTO.UserGamedataInfoDTO;
import datasDTO.UserPersonalInfoDTO;
import enums.etc.ServerActionEnum;
import enums.etc.ServerIPEnum;
import enums.etc.UserActionEnum;
import enums.etc.UserPositionEnum;
import enums.frames.JoinSizesEnum;
import frames.BasicFrame;
import frames.joinFrames.JoinSuccessFrame;
import frames.waitingRoom.WaitingRoomListTable;

// Ŭ���̾�Ʈ ����� Ŭ���̾�Ʈ ���� �� ������ ��� ����
public class ClientAccept {
	private Socket clientSocket;
	private ObjectInputStream clientIS;
	private ObjectOutputStream clientOS;
	private BasicFrame basicFrame;
	private String userID;
	
	public ClientAccept() throws UnknownHostException, IOException {
		this.clientSocket = new Socket(ServerIPEnum.SERVER_IP.getServerIP(), ServerIPEnum.SERVER_PORT.getServerPort());
		this.clientOS 	  = new ObjectOutputStream(this.clientSocket.getOutputStream());
		this.clientIS	  = new ObjectInputStream(this.clientSocket.getInputStream());
		this.basicFrame	  = new BasicFrame(this);
		ClientReciever reciever = new ClientReciever(this, this.basicFrame);
		reciever.start();

	}

	public void loginSuccessCheck(AbstractEnumsDTO data, BasicFrame basicFrame) throws IOException {
		UserPersonalInfoDTO userPersonalDTO = (UserPersonalInfoDTO)data;
		
		// ������ �޼���
		switch(userPersonalDTO.getServerAction()) {
		// - �α��� �� ������ �Է��� �߸����� ��
		case LOGIN_FAIL_INPUT_ERROR :
			this.basicFrame.getLoginPanel().loginFailLabelReset();
			this.basicFrame.getLoginPanel().loginFail("���̵�, �н����� �����Դϴ�.");
			break;
		// - �α��� �� �̹� ������ ������ ������ �Է����� ��
		case LOGIN_FAIL_OVERLAP_ACCEPT :
			this.basicFrame.getLoginPanel().loginFailLabelReset();
			this.basicFrame.getLoginPanel().loginFail("�̹� �������� ���̵��Դϴ�.");
			break;
		// �α��ο� �������� ��
		case LOGIN_SUCCESS :
			// ���Ƿ� �̵��ϰڴٴ� ������ ��� ������ ���� (������ �̵����� �ʴ´�.)
			this.userID = userPersonalDTO.getUserID();
			userPersonalDTO.setPosition(UserPositionEnum.POSITION_WAITING_ROOM);
			userPersonalDTO.setUserAction(UserActionEnum.USER_LOGIN_SUCCESS);
			this.basicFrame.getClientOS().writeObject(userPersonalDTO);
			break;
		default :
			break;
		}
	}
	
	// ȸ������ ȭ�鿡 ���� ������ ����
	public void joinFrameInputAction(AbstractEnumsDTO data, BasicFrame basicFrame) throws IOException {
		// ���̵� �ߺ�üũ
		if(data.getUserAction() == UserActionEnum.USER_JOIN_ID_OVERLAP_CHECK) {
			UserPersonalInfoDTO userPersonalInfoDTO = (UserPersonalInfoDTO)data;
			String checkMsg = null;
			Color color 	= null;
			
			if(userPersonalInfoDTO.getUserID() == null) {
				checkMsg = "join����";
				color = JoinSizesEnum.LABELCOLOR_DEFAULT.getColor();
			
			} else {
				checkMsg = "joinID�ߺ�";
				color = JoinSizesEnum.LABELCOLOR_ERROR.getColor();
			}
			
			this.basicFrame.getJoinFrame().labelSetting(
					this.basicFrame.getJoinFrame().getIdErrorLabel(), 
					color, checkMsg);
			
		// ȸ������
		} else if(data.getUserAction() == UserActionEnum.USER_JOIN_JOINACTION) {
			if(data.getServerAction() == ServerActionEnum.JOIN_SUCCESS) {
				new JoinSuccessFrame(this.basicFrame.getJoinFrame(), "ȸ������ �Ϸ�:)");
				this.basicFrame.getJoinFrame().setVisible(false);
				this.basicFrame.getJoinFrame().dispose();
			
			} else {
				new JoinSuccessFrame(this.basicFrame.getJoinFrame(), "���� �߻� :(");
				this.basicFrame.getJoinFrame().setVisible(false);
				this.basicFrame.getJoinFrame().dispose();
				
			}
		} else if(data.getUserAction() == UserActionEnum.USER_JOIN_CERTIFICATION) {
			System.out.println("������ȣ �����.." + ((UserPersonalInfoDTO)data).getCertificationNumber());
			this.basicFrame.getJoinFrame().getJoinAction().setCertificationNumber(((UserPersonalInfoDTO)data).getCertificationNumber());
		}
	}

	public void waitingRoomAction(AbstractEnumsDTO data, BasicFrame basicFrame) throws IOException {
		switch(data.getServerAction() != null ? data.getServerAction() : null) {
		// �������� ���� ������ "���ο� ������ �����ߴ�" �� �������
		case LOGIN_NEW_USER :
			UserGamedataInfoDTO newUserData = (UserGamedataInfoDTO)data;
			this.basicFrame.getWaitingRoomPanel().userAddSetting(newUserData);
			break;
			
		// �������� ���� ������ "���� ����" �̶��
		case WAITING_ROOM_ENTER :
			RoomAndUserListDTO waitingRoomInfo = (RoomAndUserListDTO)data;
			
			//----------- Test������----------------//
			WaitingRoomListTable roomTable = new WaitingRoomListTable(waitingRoomInfo.getGameRoomList());
			this.basicFrame.getWaitingRoomPanel().roomListSetting(roomTable);			
			this.basicFrame.getWaitingRoomPanel().userListSetting(waitingRoomInfo.getUserList());
			this.basicFrame.inWaitingRoom();
			break;
		
		// �������� ���� ������ "����� ����" �̶�� TODO
		case GAME_CREATEROOM_SUCCESS :
			this.basicFrame.getWaitingRoomPanel().getCreateGameRoomFrame().dispose();
			this.basicFrame.inGameRoom();
			this.basicFrame.setVisible(true);
			break;
		//TODO ����� ���� �ؾ� ��.
		// �������� ���� ������ "�� �߰�" ���
		case GAME_ROOM_ADD :
			
			break;
		default:
			break;
			
		}
//		if(data.getServerAction() == ServerActionEnum.LOGIN_NEW_USER) {
//		} else if(data.getServerAction() == ServerActionEnum.WAITING_ROOM_ENTER) {
//			RoomAndUserListDTO waitingRoomInfo = (RoomAndUserListDTO)data;
//			
//			//-----------TODO Test������----------------//
//			WaitingRoomListTable roomTable = new WaitingRoomListTable(waitingRoomInfo.getGameRoomList());
//			this.basicFrame.getWaitingRoomPanel().roomListSetting(roomTable);			
//			this.basicFrame.getWaitingRoomPanel().userListSetting(waitingRoomInfo.getUserList());
//			this.basicFrame.inWaitingRoom();
//		} else if() {
//			
//		}
	}
	
	public void gameExit() throws IOException {
		this.clientOS.close();
		this.clientIS.close();
		this.clientSocket.close();
		this.basicFrame.dispose();
		System.exit(0);
	}
	
	public ObjectInputStream getClientIS() {
		return clientIS;
	}

	public ObjectOutputStream getClientOS() {
		return clientOS;
	}
	
	public String getUserID() {
		return userID;
	}

}
