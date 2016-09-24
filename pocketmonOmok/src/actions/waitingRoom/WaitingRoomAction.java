package actions.waitingRoom;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.IOException;

import actions.adapters.Adapters;
import datasDTO.GameRoomInfoVO;
import enums.etc.ImageEnum;
import enums.etc.UserActionEnum;
import enums.etc.UserPositionEnum;
import frames.BasicFrame;
import frames.waitingRoom.CreateGameRoomFrame;

public class WaitingRoomAction extends Adapters {
	private BasicFrame basicFrame;
	private CreateGameRoomFrame createRoom;
	private int openPrivate;
	
	public WaitingRoomAction(BasicFrame basicFrame) {
		this.basicFrame = basicFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getSource().toString();
		// ���� �游��� ��ư
		if(source.contains("createRoomButton")) {
			this.createRoomFrameView();
		
		// �游����������� Ȯ�� ��ư
		} else if(source.contains("createRoomConfirmButton")) {
			try {
				this.newCreateRoom();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	// �游��������ӿ��� ������ ��й� ���ý� ����
	@Override
	public void itemStateChanged(ItemEvent e) {
		this.openPrivate = e.getStateChange();
		if(this.openPrivate == 1) { // ��й��� ���
			this.createRoom.getCreateRoomPwdText().setEditable(true);
		} else { // �������� ���
			this.createRoom.getCreateRoomPwdText().setEditable(false);
		}
	}
	
	// �游��������� new
	public void createRoomFrameView() {
		try {
			this.createRoom = this.basicFrame.getWaitingRoomPanel().newCreateGameRoomFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.basicFrame.setVisible(false);
	}
	
	// �游���-Ȯ�ι�ư
	public void newCreateRoom() throws IOException {
		// ���ӹ� ���� ����
		GameRoomInfoVO gameRoomInfo = new GameRoomInfoVO(UserPositionEnum.POSITION_WAITING_ROOM);
		gameRoomInfo.setUserAction(UserActionEnum.USER_CREATE_ROOM);
		gameRoomInfo.setRoomName(this.createRoom.getCreateRoomNameText().getText());
		gameRoomInfo.setOwner(this.basicFrame.getClientAccept().getUserID());
		gameRoomInfo.setRoomNumber(this.basicFrame.getWaitingRoomPanel().getRoomNumber());
		gameRoomInfo.setPersons(1);
		String roomPwd = null;
		if(this.openPrivate == 1) {
			gameRoomInfo.setImage(ImageEnum.WAITINGROOM_ROOM_ENTERCHECK_IMAGE_MAP.getMap().get("��й�"));
			gameRoomInfo.setPwd(this.createRoom.getCreateRoomPwdText().getText());			
		} else {
			gameRoomInfo.setImage(ImageEnum.WAITINGROOM_ROOM_ENTERCHECK_IMAGE_MAP.getMap().get("���尡��"));
		}
		
		System.out.println(gameRoomInfo.toString());
		
		this.basicFrame.getClientOS().writeObject(gameRoomInfo);
	}
	
}
