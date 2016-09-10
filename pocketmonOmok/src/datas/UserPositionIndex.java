package datas;

import enums.UserPositionEnum;

// ������ ���� ��ġ�� �˷��� �ε��� Ŭ���� (�߻�)
public abstract class UserPositionIndex {
	UserPositionEnum position;
	
	public UserPositionIndex(UserPositionEnum position) {
		this.position = position;
	}

	public UserPositionEnum getPosition() {
		return position;
	}
	
	
}
