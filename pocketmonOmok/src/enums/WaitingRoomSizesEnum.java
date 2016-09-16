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
	WAITING_ROOM_SIZE_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 75),
	WAITING_ROOM_SIZE_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 58),
	//������  x,y ��ġ
	WAITING_ROOM_LIST_POSITION_X(WAITING_ROOM_INFO_POSITION_X.getSize()),
	WAITING_ROOM_LIST_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 7),
	
	//ä�� ���â ����,���� ���� 
	WAITING_CHATTING_OUTPUT_SIZE_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 60),
	WAITING_CHATTING_OUTPUT_SIZE_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 31),
	//ä�� ���â x,y ��ġ
	WAITING_CHATTING_OUTPUT_POSITION_X(WAITING_ROOM_INFO_POSITION_X.getSize()),
	WAITING_CHATTING_OUTPUT_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 66),
	
	//ä�� �Է�â ����, ���� ����
	WAITING_CHATTING_INPUT_SIZE_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 60),
	WAITING_CHATTING_INPUT_SIZE_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 6),
	//ä�� �Է�â x,y ��ġ
	WAITING_CHATTING_INPUT_POSITION_X(WAITING_ROOM_INFO_POSITION_X.getSize()),
	WAITING_CHATTING_INPUT_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 98),
	
	//���ӽ��� ��ư ����, ���� ����
	GAMESTART_JBUTTON_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 14),
	GAMESTART_JBUTTON_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 18),
	//���ӽ��� x,y ��ġ
	GAMESTART_JBUTTON_POSITION_X((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 62),
	GAMESTART_JBUTTON_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 66),
	
	//����� ��ư ����, ���� ����
	CREATEROOM_JBUTTON_WIDTH((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() / 100) * 14),
	CREATEROOM_JBUTTON_HEIGHT((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 18),
	//����� x,y ��ġ
	CREATEROOM_JBUTTON_POSITION_X((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize() /100) * 62),
	CREATEROOM_JBUTTON_POSITION_Y((LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize() / 100) * 86);
	
	

	
	
	private int size;
	
	private Dimension dimension;
	
	private WaitingRoomSizesEnum() {}
	
	//()<- �̾ȿ� �� �͵��� �������ε� �̰��� ���������� �ٲ��ֱ����� 
	private WaitingRoomSizesEnum(int x){
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
