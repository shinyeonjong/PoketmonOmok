package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import enums.ServerIPEnum;

// Ŭ���̾�Ʈ ����� Ŭ���̾�Ʈ ���� �� ������ ��� ����
public class ClientAccept {
	private Socket clientSocket;
	private ObjectInputStream clientIS;
	private ObjectOutputStream clientOS;
	// TODO ���⿡ ������ �־����
	
	public ClientAccept() throws UnknownHostException, IOException {
		System.out.println("ClientAccept ������ ����");
		this.clientSocket = new Socket(ServerIPEnum.SERVER_IP.getServerIP(), ServerIPEnum.SERVER_PORT.getServerPort());
		System.out.println("���ϻ���");
		this.clientOS = new ObjectOutputStream(this.clientSocket.getOutputStream());
		System.out.println("�ƿ�ǲ ����");
		//TODO ���⼭ ������ ����.
		System.out.println(this.clientSocket.getInputStream());
		this.clientIS = new ObjectInputStream(this.clientSocket.getInputStream());
		System.out.println("��ǲ ����");
		ClientReciever reciever = new ClientReciever(this);
		reciever.start();
	}

//	public void recieverStart() {
//		new ClientReciever(this).start();
//	}
	
	public ObjectInputStream getClientIS() {
		return clientIS;
	}
	

}
