package datasDTO;

import java.io.Serializable;

import enums.etc.ServerActionEnum;
import enums.etc.UserActionEnum;
import enums.etc.UserPositionEnum;

// ������ ���� ��ġ�� �˷��� �ε��� Ŭ���� (�߻�)
@SuppressWarnings("serial")
public class AbstractEnumsDTO implements Serializable {
	private UserPositionEnum position;
	private UserActionEnum userAction;
	private ServerActionEnum serverAction;
	
	public AbstractEnumsDTO(UserPositionEnum position) {
		this.position = position;
		System.out.println("������ ��� : " + position);
	}
	
	public UserPositionEnum getPosition() {
		return position;
	}
	
	public UserActionEnum getUserAction() {
		return userAction;
	}
	
	public ServerActionEnum getServerAction() {
		return serverAction;
	}

	public void setPosition(UserPositionEnum position) {
		this.position = position;
		System.out.println("������ ��� : " + position);
	}
	
	public void setUserAction(UserActionEnum userAction) {
		this.userAction = userAction;
		System.out.println("�����׼� ��� : " + userAction);
	}
	
	public void setServerAction(ServerActionEnum serverAction) {
		this.serverAction = serverAction;
		System.out.println("�����׼� ��� : " + serverAction);
	}
}
