package enums.etc;

public enum ServerActionEnum {
	JOIN_SUCCESS("ȸ������ �Ϸ�"),
	JOIN_FAIL("ȸ������ ����");
	
	private String serverMessage;
	
	private ServerActionEnum(){}
	
	private ServerActionEnum(String serverMessage) {
		this.serverMessage = serverMessage;
	}
	
	public String getServerMessage() {
		return serverMessage;
	}
}
