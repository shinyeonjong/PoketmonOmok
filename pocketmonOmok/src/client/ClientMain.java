package client;

import java.io.IOException;
import java.io.Serializable;

// Ŭ���̾�Ʈ ����
public class ClientMain implements Serializable {
	public static void main(String[] args) throws Exception {
		try {
			new ClientAccept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		DBConnectionPool dbcp = DBConnectionPool.getInstance();
//		
//		LoginDAO loginDAO = new LoginDAO();
//		UserPersonalInfoDTO userPersonalInfo = loginDAO.checkIDMatchesPW("imcts");
//		
//		System.out.println(userPersonalInfo.getUserID());
//		System.out.println(userPersonalInfo.getUserPasswd());
	}
	
	
}
