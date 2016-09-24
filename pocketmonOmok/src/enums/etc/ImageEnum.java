package enums.etc;

import java.util.HashMap;
import java.util.Map;

public enum ImageEnum {
//BasieFrame �̹���-----------------------------------------------------
	BASIC_BACKGROUND("resources/background/background.png"),
//Loginpanel �̹���-----------------------------------------------------
	LOGINPANEL_LOGIN("resources/login/login.jpg"),
//GameRoom �̹�����------------------------------------------------------	
	GAMEROOM_MALE_IMAGE("resources/gameRoom/userImageMale.png"),
	GAMEROOM_FEMALE_IMAGE("resources/gameRoom/userImageFemale.png"),
	GAMEROOM_DEFALTUSER_IMAGE("resources/gameRoom/logo.png"),
	
	
	GAMEROOM_MENU_IMAGES_OWNER(new String[] {
			"resources/gameroom/start.png",			// gamestart
			"resources/gameroom/alone.png",			// ȥ���ϱ�
			"resources/gameroom/giveup.png",			// ���
			"resources/gameroom/itemgameout.png",	// ������
			"resources/gameroom/itemunity.png",		// ���� ���Ͻ�Ű��
			"resources/gameroom/itemtimeplus.png",	// �ð��߰�
			"resources/gameroom/gamereturn.png",	// �ϵǵ�����
			"resources/gameRoom/gamecoin.png"		// ����
	}),
	
	GAMEROOM_MENU_IMAGES_GUEST(new String[] {
			"resources/gameroom/ready.png",			// ready
			"resources/gameroom/alone.png",			// ȥ���ϱ�
			"resources/gameroom/giveup.png",			// ���
			"resources/gameroom/itemgameout.png",	// ������
			"resources/gameroom/itemunity.png",		// ���� ���Ͻ�Ű��
			"resources/gameroom/itemtimeplus.png",	// �ð��߰�
			"resources/gameroom/gamereturn.png",	// �ϵǵ�����
			"resources/gameroom/gamecoin.png"		// ����
	}),
	
	GAMEROOM_STONE_CHARMANDER("resources/omokball/charmander.png"),

	WAITINGROOM_USER_GRADE_IMAGE_MAP(userGradeImageMap()),
	WAITINGROOM_ROOM_ENTERCHECK_IMAGE_MAP(enterRoomCheckImage());
	
	private static Map<String, String> userGradeImageMap() {
		Map<String, String> images = new HashMap<String, String>();
		images.put("�ʺ�", "resources/user/userbegining.png");
		images.put("�߼�", "resources/user/usermediumgrade.png");
		images.put("���", "resources/user/userhigh.png");
		images.put("�ʰ��", "resources/user/usermorehigh.png");
		images.put("����", "resources/user/usermaster.png");
		images.put("����", "resources/user/userhero.png");
		images.put("��", "resources/user/usertop.png");
		
		return images;
	}
	
	private static Map<String, String> enterRoomCheckImage() {
		Map<String, String> images = new HashMap<String, String>();
		images.put("���尡��", "resources/waitingRoom/admission.png");
		images.put("��й�", "resources/waitingRoom/private.png");
		images.put("����Ұ�", "resources/waitingRoom/NoAdmittance.png");
		
		return images;
	}
//-------------------------------------------------------------------------	
	
	private String imageDir;
	private String[] images;
	private Map<String, String> map;
	
	private ImageEnum(String image) {
		this.imageDir = image;
	}
	
	private ImageEnum(String[] images) {
		this.images = images;
	}
	
	private ImageEnum(Map<String, String> map) {
		this.map = map;
	}
	
	public String getImageDir() {
		return imageDir;
	}
	
	public String[] getImages() {
		return images;
	}
	
	public Map<String, String> getMap() {
		return map;
	}
}
