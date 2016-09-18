package client;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

import datasDTO.UserPersonalInfoDTO;
import datasDTO.UserPositionIndex;
import enums.ClientJoinSizesEnum;
import enums.ServerIPEnum;
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

	public void loginSuccessCheck(UserPositionIndex data, BasicFrame basicFrame) {
		UserPersonalInfoDTO userPersonalDTO = (UserPersonalInfoDTO)data;
		if(userPersonalDTO.getUserID() == null) {
			this.basicFrame.getLoginPanel().loginFailLabelReset();
			this.basicFrame.getLoginPanel().loginFail("���̵�, �н����� �����Դϴ�.");
		} else {
			
			this.basicFrame.inWaitingRoom();
		}
		
	}
	
	public void joinIDOverlapCheck(UserPositionIndex data, BasicFrame basicFrame) {
		UserPersonalInfoDTO userPersonalInfoDTO = (UserPersonalInfoDTO)data;
		System.out.println(userPersonalInfoDTO.getUserID() == null);
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
