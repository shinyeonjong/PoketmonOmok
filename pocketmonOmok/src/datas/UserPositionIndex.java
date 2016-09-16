package datas;

import java.io.Serializable;

import enums.UserPositionEnum;

// ������ ���� ��ġ�� �˷��� �ε��� Ŭ���� (�߻�)
@SuppressWarnings("serial")
public class UserPositionIndex implements Serializable {
	UserPositionEnum position;
	
	public UserPositionIndex(UserPositionEnum position) {
		this.position = position;
	}

	public UserPositionEnum getPosition() {
		return position;
	}

	public void setPosition(UserPositionEnum position) {
		this.position = position;
	}
}
