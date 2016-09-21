package datasDAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import datasDTO.UserPersonalInfoDTO;
import enums.etc.UserActionEnum;
import enums.etc.UserPositionEnum;

public class JoinDAO implements Serializable{
	// ID �ߺ�üũ. ������ 0�̸� ��� ����, 1�̸� �̹� �����ϴ� ID.
	public UserPersonalInfoDTO checkOverlapID(UserPersonalInfoDTO personalDTO) {
		Connection connection = null;
		PreparedStatement ps  = null;
		
		// DB Pool ������ ����, ������ �ν��Ͻ� ��������
		DBConnectionPool dbPool = DBConnectionPool.getInstance();
		
		ResultSet resultSet = null;
		UserPersonalInfoDTO resultDTO = new UserPersonalInfoDTO(UserPositionEnum.POSITION_JOIN);
		resultDTO.setUserAction(UserActionEnum.USER_JOIN_ID_OVERLAP_CHECK);
		try {
			connection = dbPool.getConnection();
			StringBuffer sql = new StringBuffer();
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
	
	public int userJoin(UserPersonalInfoDTO personalDTO) {
		Connection connection = null;
		PreparedStatement ps  = null;
		
		DBConnectionPool dbPool = DBConnectionPool.getInstance();
		
		int result = 0;
		UserPersonalInfoDTO resultDTO = new UserPersonalInfoDTO(UserPositionEnum.POSITION_JOIN);
		resultDTO.setUserAction(UserActionEnum.USER_JOIN_JOINACTION);
		
		try {
			connection = dbPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO USER_PERSONAL_INFO ( ");
			sql.append("USER_ID, ");
			sql.append("USER_PASSWD, ");
			sql.append("USER_NAME, ");
			sql.append("USER_GENDER, ");
			sql.append("USER_BIRTH, ");
			sql.append("USER_EMAIL, ");
			sql.append("USER_JOINDATE ");
			if(resultDTO.getUserPhoneNumber() == null) {
				sql.append(") VALUES ( ");
				sql.append("?, ?, ?, ?, ?, ?, sysdate )");				
				ps = connection.prepareStatement(sql.toString());
				ps.setString(1, personalDTO.getUserID());
				ps.setString(2, personalDTO.getUserPasswd());
				ps.setString(3, personalDTO.getUserName());
				ps.setInt	(4, personalDTO.getUserGender());
				ps.setString(5, personalDTO.getUserBirth());
				ps.setString(6, personalDTO.getUserEmail());

			} else {
				sql.append("USER_PHONENUMBER, ");
				sql.append(") VALUES ( ");
				sql.append("?, ?, ?, ?, ?, ?, sysdate, ? )");
				ps = connection.prepareStatement(sql.toString());
				ps.setString(1, personalDTO.getUserID());
				ps.setString(2, personalDTO.getUserPasswd());
				ps.setString(3, personalDTO.getUserName());
				ps.setInt	(4, personalDTO.getUserGender());
				ps.setString(5, personalDTO.getUserBirth());
				ps.setString(6, personalDTO.getUserEmail());
				ps.setString(7, personalDTO.getUserPhoneNumber());
			}
			System.out.println(sql);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbPool.freeConnection(connection, ps);
		}
		
		return result;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		UserPersonalInfoDTO udto = new UserPersonalInfoDTO(UserPositionEnum.POSITION_JOIN);
		udto.setUserBirth("19890726");
		udto.setUserEmail("sirupe@nate.com");
		udto.setUserGender(1);
		udto.setUserID("sirupe11");
		udto.setUserName("������");
		udto.setUserPasswd("7133");
		udto.setUserPhoneNumber("010-7123-7123");
		System.out.println(new JoinDAO().userJoin(udto));
	}
}