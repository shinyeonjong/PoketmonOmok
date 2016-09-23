package enums.etc;

import java.util.HashMap;
import java.util.Map;

import oracle.net.aso.i;

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
			"resources/gameroom/test1.png",			// gamestart
			"resources/gameroom/test2.png",			// ȥ���ϱ�
			"resources/gameroom/test3.png",			// ���
			"resources/gameroom/itemgameout.png",	// ������
			"resources/gameroom/itemunity.png",		// ���� ���Ͻ�Ű��
			"resources/gameroom/itemtimeplus.png",	// �ð��߰�
			"resources/gameroom/gamereturn.png",	// �ϵǵ�����
			"resources/gameRoom/gamecoin.png"		// ����
	}),
	
	GAMEROOM_MENU_IMAGES_GUEST(new String[] {
			"resources/gameroom/test5.png",			// ready
			"resources/gameroom/test2.png",			// ȥ���ϱ�
			"resources/gameroom/test3.png",			// ���
			"resources/gameroom/itemgameout.png",	// ������
			"resources/gameroom/itemunity.jpg",		// ���� ���Ͻ�Ű��
			"resources/gameroom/itemtimeplus.png",	// �ð��߰�
			"resources/gameroom/gamereturn.png",	// �ϵǵ�����
			"resources/gameroom/gamecoin.png"		// ����
	}),
	
	GAMEROOM_STONE_CHARMANDER("resources/omokball/charmander.png"),
//WaitingRoom �̹�����-------------------------------------------------------
	WAITINGROOM_ENTER_POSSIBLE_IMAGE("resources/waitroom/waitingvacancy.jpg"),
	WAITINGROOM_ENTER_PRIVATE_IMAGE("resources/waitroom/waitingprivate.jpg"),
	WAITINGROOM_ENTER_FULL_IMAGE("resources/waitroom/watingfull.jpg"),
	
	WAITINGROOM_USER_GRADE_IMAGE_MAP(userGradeImageMap());
	
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
