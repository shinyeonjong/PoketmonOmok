package server.client;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

import datasDTO.UserPersonalInfoDTO;
import datasDTO.AbstractEnumsDTO;
import enums.etc.ServerIPEnum;
import enums.etc.UserActionEnum;
import enums.frames.ClientJoinSizesEnum;
import frames.BasicFrame;
import frames.LoginPanel;

// Ŭ���̾�Ʈ ����� Ŭ���̾�Ʈ ���� �� ������ ��� ����
@SuppressWarnings("serial")
public class ClientAccept implements Serializable {
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

	public void loginSuccessCheck(AbstractEnumsDTO data, BasicFrame basicFrame) {
		UserPersonalInfoDTO userPersonalDTO = (UserPersonalInfoDTO)data;
		if(userPersonalDTO.getUserID() == null) {
			this.basicFrame.getLoginPanel().loginFailLabelReset();
			this.basicFrame.getLoginPanel().loginFail("���̵�, �н����� �����Դϴ�.");
		} else {
			
			this.basicFrame.inWaitingRoom();
		}
		
	}
	
	public void joinFrameInputAction(AbstractEnumsDTO data, BasicFrame basicFrame) {
		UserPersonalInfoDTO userPersonalInfoDTO = (UserPersonalInfoDTO)data;
		
		if(userPersonalInfoDTO.getUserAction() == UserActionEnum.USER_JOIN_ID_OVERLAP_CHECK) {
			String checkMsg = null;
			Color color = null;
			if(userPersonalInfoDTO.getUserID() == null) {
				checkMsg = "join����";
				color = ClientJoinSizesEnum.LABELCOLOR_DEFAULT.getColor();
			} else {
				checkMsg = "joinID�ߺ�";
				color = ClientJoinSizesEnum.LABELCOLOR_ERROR.getColor();
			}
			
			this.basicFrame.getJoinFrame().labelSetting(
					this.basicFrame.getJoinFrame().getIdErrorLabel(), 
					color, checkMsg);
		} else if(userPersonalInfoDTO.getUserAction() == UserActionEnum.USER_JOIN_JOINACTION) {
			
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
