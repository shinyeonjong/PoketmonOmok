package enums;

import java.awt.Dimension;

public enum WaitingRoomSizesEnum {
		
	//���� �������Է� ����, ���α���
	WAITING_ROOM_INFO_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 75),
	WAITING_ROOM_INFO_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 3),
	//���� �������Է� x,y ��ġ
	WAITING_ROOM_INFO_POSITION_X(10),
	WAITING_ROOM_INFO_POSITION_Y(18),
		
	//���� ����,���� ����
	WAITING_ROOM_LIST_SIZE_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 75),
	WAITING_ROOM_LIST_SIZE_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 58),
	//������  x,y ��ġ
	WAITING_ROOM_LIST_POSITION_X(WAITING_ROOM_INFO_POSITION_X.getSize()),
	WAITING_ROOM_LIST_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 7),
	
	//���� ��� ����, ���� ����
	WAITING_ROOM_LIST_SIZE_BACKGROUND_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 75),
	WAITING_ROOM_LIST_SIZE_BACKGROUND_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 58),
	//���� ��� x,y ��ġ
	WAITING_ROOM_LIST_BACKGROUND_POSITION_X(WAITING_ROOM_INFO_POSITION_X.getSize()),
	WAITING_ROOM_LIST_BACKGROUND_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 7),
	
	//ä�� ���â ����,���� ���� 
	CHATTING_OUTPUT_SIZE_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 60),
	CHATTING_OUTPUT_SIZE_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 31),
	//ä�� ���â x,y ��ġ
	CHATTING_OUTPUT_POSITION_X(WAITING_ROOM_INFO_POSITION_X.getSize()),
	CHATTING_OUTPUT_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 66),
		
	//ä�� �Է�â ����, ���� ����
	CHATTING_INPUT_SIZE_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 53),
	CHATTING_INPUT_SIZE_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 6),
	//ä�� �Է�â x,y ��ġ
	CHATTING_INPUT_POSITION_X(WAITING_ROOM_INFO_POSITION_X.getSize()),
	CHATTING_INPUT_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 98),
	
	//�޽��� ������ ��ư ����, ���� ����
	SEND_MESSAGE_BUTTON_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 8),
	SEND_MESSAGE_BUTTON_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 6),
	//�޽��� ������ ��ư x,y ��ġ
	SEND_MESSAGE_BUTTON_POSITION_X((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 54),
	SEND_MESSAGE_BUTTON_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 98),
	

	//���ӽ��� ��ư ����, ���� ����
	GAMESTART_JBUTTON_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 14),
	GAMESTART_JBUTTON_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 12),
	//���ӽ��� x,y ��ġ
	GAMESTART_JBUTTON_POSITION_X((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 62),
	GAMESTART_JBUTTON_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 69),
	
	//����� ��ư ����, ���� ����
	CREATEROOM_JBUTTON_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 14),
	CREATEROOM_JBUTTON_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 12),
	//����� x,y ��ġ
	CREATEROOM_JBUTTON_POSITION_X((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() /100) * 62),
	CREATEROOM_JBUTTON_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 85),
	
	//������â ����, ���� ����
	PLAYERS_LIST_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 25),
	PLAYERS_LIST_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 55),
	//������â x,y ��ġ
	PLAYERS_LIST_POSITION_X((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 79),
	PLAYERS_LIST_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 8),
	
	//������â ��� ����, ���� ����
	PLAYERS_LIST_BACKGROUND_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 29),
	PLAYERS_LIST_BACKGROUND_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 61),
	//������â  ���x,y ��ġ
	PLAYERS_LIST_BACKGROUND_POSITION_X((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 77),
	PLAYERS_LIST_BACKGROUND_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 5 ),
	
	//������ �̹��� ����, ���� ����
	MY_INFO_IMAGE_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 10),
	MY_INFO_IMAGE_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 20),
	//������ �̹��� x,y ��ġ
	MY_INFO_IMAGE_POSITION_X((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 79),
	MY_INFO_IMAGE_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 68),
	
	//������ ���̵� ����, ���� ����
	MY_INFO_USERID_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 6),
	MY_INFO_USERID_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 3),
	//������ ���̵� x,y ��ġ
	MY_INFO_USERID_POSITION_X((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 80),
	MY_INFO_USERID_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 90),
	
	//������ ���
	MY_INFO_LEVEL_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 6),
	MY_INFO_LEVEL_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 3),
	//������ ���
	MY_INFO_LEVEL_POSITION_X((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 87),
	MY_INFO_LEVEL_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 96),
		 
	//������ ����
	MY_INFO_SCORE_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 4),
	MY_INFO_SCORE_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 3),
	//������ ����
	MY_INFO_SCORE_POSITION_X((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 90),
	MY_INFO_SCORE_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 71),
	
	//������ �·�
	MY_INFO_WINNINGRATE_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 10),
	MY_INFO_WINNINGRATE_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 5),
	//������ �·�
	MY_INFO_WINNINGRATE_POSITION_X((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 90),
	MY_INFO_WINNINGRATE_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 75),
	
	//������ ����
	MY_INFO_POINT_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 4),
	MY_INFO_POINT_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 3),
	//������ ����
	MY_INFO_POINT_POSITION_X((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 90),
	MY_INFO_POINT_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 81),
	
	//������ ����
	MY_INFO_CORRECT_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 5),
	MY_INFO_CORRECT_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 5),
	//������ ����
	MY_INFO_CORRECT_POSITION_X((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 98),
	MY_INFO_CORRECT_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 95),
	
	//������ ����, ���� ����
	MY_INFO_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 29),
	MY_INFO_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 40),
	//������ x,y ��ġ
	MY_INFO_POSITION_X((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 77),
	MY_INFO_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 65);

	
	
	
	
	private int size;
	
	private Dimension dimension;
	
	private WaitingRoomSizesEnum() {}
	
	
	//()<- �̾ȿ� �� �͵��� �������ε� �̰��� ���������� �ٲ��ֱ����� 
	private WaitingRoomSizesEnum(int x) {
		this.size = x;
	}
	
	private WaitingRoomSizesEnum(Dimension dimension) {
		this.dimension = dimension;
	}
	

	
	public int getSize() {
		return size;
	}
	public Dimension getDimension() {
		return dimension;
	}
}
