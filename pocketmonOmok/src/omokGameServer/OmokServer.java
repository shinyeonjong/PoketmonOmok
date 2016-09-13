package omokGameServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import enums.ServerIPEnum;

public class OmokServer {
	private ServerSocket serverSocket;
	private Socket socket;
	private List<OmokPersonalServer> psersonalServerList = new ArrayList<OmokPersonalServer>();
	//TODO ������ Ŭ���̾�Ʈ ������ �÷��� �߰� �ʿ�
	
	public OmokServer() throws IOException {
		this.serverSocket = new ServerSocket(ServerIPEnum.SERVER_PORT.getServerPort());
	}
	
	public void gameServerOn() throws IOException {
		System.out.println("Server On...");
		
		while(true) {
			System.out.println("Waiting User...");
			this.socket = this.serverSocket.accept();
			OmokPersonalServer persomalServer = new OmokPersonalServer(this);
			this.psersonalServerList.add(persomalServer);
			persomalServer.start();
			System.out.println("now list size is " + this.psersonalServerList.size());
			System.out.println("User Accept .. " + socket.getLocalAddress());
		}
	}
	
	//TODO ���⿡ ������ �б���� �߰�
	
	public void login() {
		System.out.println("�α���â");
	}
	
	public void waitingRoom() {
		System.out.println("����");
	}
	
	public void join() {
		System.out.println("ȸ������");
	}
	
	public void findID() {
		System.out.println("IDã��");
	}
	
	public void findPW() {
		System.out.println("��й�ȣã��");
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

	
	
	
	public Socket getSocket() {
		return socket;
	}
}
