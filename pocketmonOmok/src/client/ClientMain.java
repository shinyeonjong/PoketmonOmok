package client;

import java.io.IOException;

import frames.LoginFrame;

// Ŭ���̾�Ʈ ����
public class ClientMain {
	public static void main(String[] args) {
		try {
			new ClientAccept();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
