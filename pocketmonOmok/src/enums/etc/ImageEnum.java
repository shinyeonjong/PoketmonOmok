package enums.etc;

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
//WaitingRoom �̹�����-------------------------------------------------------
	WAITINGROOM_ENTER_POSSIBLE_IMAGE("resources/waitroom/waitingvacancy.jpg"),
	WAITINGROOM_ENTER_PRIVATE_IMAGE("resources/waitroom/waitingprivate.jpg"),
	WAITINGROOM_ENTER_FULL_IMAGE("resources/waitroom/watingfull.jpg");
	

	private String imageDir;
	private String[] images;
	
	private ImageEnum(String image) {
		this.imageDir = image;
	}
	
	private ImageEnum(String[] images) {
		this.images = images;
	}
	
	public String getImageDir() {
		return imageDir;
	}
	
	public String[] getImages() {
		return images;
	}
}
