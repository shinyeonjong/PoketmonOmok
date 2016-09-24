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
import frames.waitingRoomPanels.WaitingRoomListTable;

// Ŭ���̾�Ʈ ����� Ŭ���̾�Ʈ ���� �� ������ ��� ����
public class ClientAccept {
	private Socket clientSocket;
	private ObjectInputStream clientIS;
	private ObjectOutputStream clientOS;
	private BasicFrame basicFrame;
	
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
		System.out.println(userPersonalDTO.getServerAction());
		
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
		System.out.println(data.getUserAction());
		if(data.getUserAction() == UserActionEnum.USER_JOIN_ID_OVERLAP_CHECK) {
			System.out.println("���̵��ߺ�üũ");
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
			System.out.println("ȸ������");
			if(data.getServerAction() == ServerActionEnum.JOIN_SUCCESS) {
				new JoinSuccessFrame(this.basicFrame.getJoinFrame(), "ȸ������ �Ϸ�:)");
				this.basicFrame.getJoinFrame().setVisible(false);
				this.basicFrame.getJoinFrame().dispose();
			
			} else {
				new JoinSuccessFrame(this.basicFrame.getJoinFrame(), "���� �߻� :(");
				this.basicFrame.getJoinFrame().setVisible(false);
				this.basicFrame.getJoinFrame().dispose();
				
			}
		}
	}

	public void waitingRoomAction(AbstractEnumsDTO data, BasicFrame basicFrame) throws IOException {
		// �������� ���� ������ "���ο� ������ �����ߴ�" �� �������
		if(data.getServerAction() == ServerActionEnum.LOGIN_NEW_USER) {
			System.out.println(data.getServerAction() + "if");
			UserGamedataInfoDTO newUserData = (UserGamedataInfoDTO)data;
			this.basicFrame.getWaitingRoomPanel().userAddSetting(newUserData);
		
		// �������� ���� ������ "���� ����" �̶��
		} else if(data.getServerAction() == ServerActionEnum.WAITING_ROOM_ENTER) {
			System.out.println(data.getServerAction() + "else");
			RoomAndUserListDTO waitingRoomInfo = (RoomAndUserListDTO)data;
			
			//-----------TODO Test������----------------//
			WaitingRoomListTable roomTable = new WaitingRoomListTable(waitingRoomInfo.getGameRoomList());
			this.basicFrame.getWaitingRoomPanel().roomListSetting(roomTable);			
			this.basicFrame.getWaitingRoomPanel().userListSetting(waitingRoomInfo.getUserList());
			this.basicFrame.inWaitingRoom();
		}
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
	

}
