package enums;

public enum UtilityEnums {
	SENDER_EMAIL_ADDRESS("jijungsinkim@gmail.com"),
	SENDER_EMAIL_PASSWD("dpswpflsjtm"),
	SENDER_EMAIL_SUBJECT("���ϸ� ���񿡼� �߼��� ������ȣ�Դϴ�.");
	
	private String str;
	
	private UtilityEnums() {}
	private UtilityEnums(String str) {
		this.str = str;
	}
	
	public String getStr() {
		return str;
	}
}
