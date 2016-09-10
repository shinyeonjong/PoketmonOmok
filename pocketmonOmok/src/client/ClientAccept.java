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
		this.clientSocket = new Socket(ServerIPEnum.SERVER_IP.getServerIP(), ServerIPEnum.SERVER_PORT.getServerPort());
		this.clientIS = new ObjectInputStream(this.clientSocket.getInputStream());
		this.clientOS = new ObjectOutputStream(this.clientSocket.getOutputStream());
		//TODO ���⼭ ������ ����.
		new ClientReciever(this).start();
	}

	public ObjectInputStream getClientIS() {
		return clientIS;
	}
	

}
