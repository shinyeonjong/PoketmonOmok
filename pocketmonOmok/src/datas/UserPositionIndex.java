package datas;

import java.io.Serializable;

import enums.UserPositionEnum;

// ������ ���� ��ġ�� �˷��� �ε��� Ŭ���� (�߻�)
public abstract class UserPositionIndex implements Serializable {
	UserPositionEnum position;
	
	public UserPositionIndex(UserPositionEnum position) {
		this.position = position;
	}

	public UserPositionEnum getPosition() {
		return position;
	}
	
	
}
