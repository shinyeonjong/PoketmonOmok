package enums;

public enum ImageEnum {
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
			"resources/gameroom/itemunity.jpg",		// ���� ���Ͻ�Ű��
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
	
	GAMEROOM_STONE_CHARMANDER("resources/omokball/charmander.png");
//---------------------------------------------------------------------

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
