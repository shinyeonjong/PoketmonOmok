package start;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;

import client.ClientAccept;

// Ŭ���̾�Ʈ ����
public class ClientMain implements Serializable {
	public static void main(String[] args) throws Exception {
		try {
			new ClientAccept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

		
	}
}
