package dataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import datas.UserPersonalInfoDTO;
import enums.UserPositionEnum;

public class LoginDAO {
	
	public UserPersonalInfoDTO checkIDMatchesPW(String id) {
		// try-catch������ �����Ͽ� ���� finally �� �������� �޶� ���� �߻�. �̸� �������ش�.
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		UserPersonalInfoDTO userPersonalInfo = new UserPersonalInfoDTO(UserPositionEnum.POSITION_LOGIN);
		
		// DB Pool ������ ����, ������ �ν��Ͻ� ��������
		DBConnectionPool dbPool = DBConnectionPool.getInstance();
		
		try {
			// ���� ��û
			connection = dbPool.getConnection();
			
			// sql ��
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT USER_ID, USER_PASSWD ");
			sql.append("FROM USER_PERSONAL_INFO ");
			sql.append("WHERE USER_ID=?");
			
			// ���� ������ �� ��������
			ps = connection.prepareStatement(sql.toString());
			ps.setString(1, id);
			resultSet = ps.executeQuery();
			
			// DAO �� ������ �� ����
			while(resultSet.next()) {
				userPersonalInfo.setUserID(resultSet.getString("USER_ID"));
				userPersonalInfo.setUserPasswd(resultSet.getString("USER_PASSWD"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ������ dbPool �� Ŀ�ؼ��� free.
			dbPool.freeConnection(connection, ps, resultSet);
		}
		
		// ������ڿ��� DAO ��ȯ
		return userPersonalInfo;
	}
}
