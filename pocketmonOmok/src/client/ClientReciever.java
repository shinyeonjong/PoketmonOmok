package client;

import java.io.IOException;
import java.io.ObjectInputStream;

import datas.UserPositionIndex;
import frames.BasicFrame;
// �������� �����ִ� �����͸� �о���̴� �༮.
public class ClientReciever extends Thread {
	private ClientAccept clientAccept;
	private ObjectInputStream clientIS;
	private BasicFrame basicFrame;
	
	public ClientReciever(ClientAccept accept, BasicFrame basicFrame) {
		this.clientAccept = accept;
		this.clientIS 	  = accept.getClientIS();
		this.basicFrame   = basicFrame;
	}
	
	//TODO �����Ͱ� �ѳ���� �� ��.
	@Override
	public void run() {
		System.out.println("ClientReciever run!!");
		boolean isAccept = true;
		try {
			while(isAccept) {
				System.out.println("Ŭ���̾�Ʈ ���ú� ����");
				Object object = this.clientIS.readObject();
				System.out.println("");
				UserPositionIndex userPosition = (UserPositionIndex)object;
				switch(userPosition.getPosition()) {
				case POSITION_LOGIN :   
					this.clientAccept.loginSuccessCheck(userPosition, this.basicFrame);
					break;
				case POSITION_WAITING_ROOM :      
					break;
				case POSITION_JOIN :              
					break;
				case POSITION_FIND_ID :   
					break;
				case POSITION_FIND_PW :  
					break;
				case POSITION_GAME_ROOM :         
					break;
				case POSITION_STORE :             
					break;
				case POSITION_OTHER_USER_INFO :   
					break;
				case POSITION_MODIFY_MY_INFO :    
					break;
				case POSITION_EXIT :  
					this.clientAccept.gameExit();
					break;
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
