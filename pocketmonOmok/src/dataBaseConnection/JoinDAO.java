package dataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import datas.UserPersonalInfoDTO;

public class JoinDAO {
	// ID �ߺ�üũ. ������ 0�̸� ��� ����, 1�̸� �̹� �����ϴ� ID.
	public int checkOverlapID(String id) {
		Connection connection = null;
		PreparedStatement ps  = null;
		
		// DB Pool ������ ����, ������ �ν��Ͻ� ��������
		DBConnectionPool dbPool = DBConnectionPool.getInstance();
		
		int result = 0;
		try {
			connection = dbPool.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT USER_ID ");
			sql.append("FROM USER_PERSONAL_INFO ");
			sql.append("WHERE USER_ID=?");
			
			ps = connection.prepareStatement(sql.toString());
			ps.setString(1, id);

			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ������ dbPool �� Ŀ�ؼ��� free.
			dbPool.freeConnection(connection, ps);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new JoinDAO().checkOverlapID("test2"));
	}
}
