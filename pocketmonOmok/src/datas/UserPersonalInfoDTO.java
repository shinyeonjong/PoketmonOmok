package datas;

import java.io.Serializable;
import java.sql.Date;

import enums.UserPositionEnum;

// ���� �������� DTO (Data Transfer Object)
public class UserPersonalInfoDTO extends UserPositionIndex implements Serializable{
	private String userID;			// ���� ���̵�
	private String userPasswd;		// ���� ��й�ȣ
	private String userName;		// ���� �̸�
	private int userGender;			// ���� ����
	private String userBirth;		// ���� ����
	private String userEmail;		// ���� �̸���
	private String userPhoneNumber;	// ���� �ڵ�����ȣ
	private Date userJoinDate;		// ���� ��������
	
	public UserPersonalInfoDTO(UserPositionEnum position) {
		super(position);
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}
	
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public void setUserJoinDate(Date userJoinDate) {
		this.userJoinDate = userJoinDate;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public String getUserPasswd() {
		return userPasswd;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public int getUserGender() {
		return userGender;
	}
	
	public String getUserBirth() {
		return userBirth;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	
	public Date getUserJoinDate() {
		return userJoinDate;
	}
}
