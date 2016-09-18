package datasDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import datasDTO.UserPersonalInfoDTO;
import enums.UserPositionEnum;

public class LoginDAO {
	// DTO �� ID�� �ԷµǾ� ���޵Ǹ� DTO �� ID�� PW�� ��� �ǵ������ϴ�. ������� NULL �� ��ȯ�˴ϴ�.
	public UserPersonalInfoDTO checkIDMatchesPW(UserPersonalInfoDTO personalDTO) {
		// try-catch������ �����Ͽ� ���� finally �� �������� �޶� ���� �߻�. �̸� �������ش�.
		Connection connection = null;
		PreparedStatement ps  = null;
		ResultSet resultSet   = null;

		// DB Pool ������ ����, ������ �ν��Ͻ� ��������
		DBConnectionPool dbPool = DBConnectionPool.getInstance();
		
		UserPersonalInfoDTO userPersonalInfo = new UserPersonalInfoDTO(UserPositionEnum.POSITION_LOGIN);
		
		try {
			// ���� ��û
			connection = dbPool.getConnection();
			
			// sql ��
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT USER_ID, USER_PASSWD ");
			sql.append("FROM USER_PERSONAL_INFO ");
			sql.append("WHERE USER_ID=? AND USER_PASSWD=?");
			
			// ���� ������ �� ��������
			ps = connection.prepareStatement(sql.toString());
			ps.setString(1, personalDTO.getUserID());
			ps.setString(2, personalDTO.getUserPasswd());
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
