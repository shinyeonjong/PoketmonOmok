package datasDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import datasDTO.UserPersonalInfoDTO;
import enums.UserPositionEnum;

public class JoinDAO {
	// ID �ߺ�üũ. ������ 0�̸� ��� ����, 1�̸� �̹� �����ϴ� ID.
	public UserPersonalInfoDTO checkOverlapID(UserPersonalInfoDTO personalDTO) {
		Connection connection = null;
		PreparedStatement ps  = null;
		
		// DB Pool ������ ����, ������ �ν��Ͻ� ��������
		DBConnectionPool dbPool = DBConnectionPool.getInstance();
		
		ResultSet resultSet = null;
		UserPersonalInfoDTO resultDTO = new UserPersonalInfoDTO(UserPositionEnum.POSITION_JOIN);
		try {
			connection = dbPool.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT USER_ID ");
			sql.append("FROM USER_PERSONAL_INFO ");
			sql.append("WHERE USER_ID=?");
			
			ps = connection.prepareStatement(sql.toString());
			ps.setString(1, personalDTO.getUserID());

			resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				resultDTO.setUserID(resultSet.getString("USER_ID"));
				System.out.println(resultSet.getString("USER_ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ������ dbPool �� Ŀ�ؼ��� free.
			dbPool.freeConnection(connection, ps);
		}
		
		return resultDTO;
	}
}