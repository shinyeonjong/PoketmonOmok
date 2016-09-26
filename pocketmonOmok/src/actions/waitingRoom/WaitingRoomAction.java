package actions.waitingRoom;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.addressing.v200408.MemberSubmissionWsaServerTube;

import actions.adapters.Adapters;
import datasDTO.GameRoomInfoVO;
import datasDTO.UserGamedataInfoDTO;
import datasDTO.UserMessageVO;
import enums.etc.ImageEnum;
import enums.etc.ServerActionEnum;
import enums.etc.UserActionEnum;
import enums.etc.UserPositionEnum;
import frames.waitingRoom.CreateGameRoomFrame;
import frames.waitingRoom.WaitingRoomPanel;

public class WaitingRoomAction extends Adapters {
	private WaitingRoomPanel waitingRoomPanel;
	private CreateGameRoomFrame createRoom;
	private int openPrivate;
	private String listSelectUser; // ������ ����Ʈ���� ������ ������ ������ Ȯ���ϱ� ���� ���
	private int inputCheck;	// ä�ý� Enter �Է��ϸ� �� �� ���ԵǱ� ������ üũ�� ���� ���
	private String targetUser;
	
	public WaitingRoomAction(WaitingRoomPanel waitingRoomPanel) {
		this.waitingRoomPanel = waitingRoomPanel;
		this.listSelectUser = "";
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		this.waitingRoomPanel.getBasicFrame().setVisible(true);
		this.createRoom.setVisible(false);
		this.createRoom.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getSource() instanceof JButton ? ((JButton)e.getSource()).getName() : ((JTextField)e.getSource()).getName();
		System.out.println(((JTextField)e.getSource()).getName());
		
		switch(source) {
		case "createRoomButton" :
			this.createRoomFrameView();
			break;

		case "createRoomConfirmButton" :
			try {
				this.newCreateRoom();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		
		case "chattingInputTextField" :
			try {
				this.chattingInput();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		default :
			break;
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
	
	// ���� ������ ����Ʈ, ��Ƽ�� �ʵ�(��üä��) ���� �׼� ����
	@Override
	public void mouseClicked(MouseEvent e) {
		String userID = this.waitingRoomPanel.getBasicFrame().getClientAccept().getUserID();
		
		// ���� ���Ե� ������Ʈ�� �ؽ�Ʈ�ʵ���
		if(e.getSource() instanceof JTextField) {
			this.waitingRoomPanel.getNoticeTextField().setText("��üä��");
		
		// �ƴ϶�� (����Ʈ)
		} else {
			// ���õ� ���� ���̵� 
			String selectValue = this.waitingRoomPanel.getPlayerList().getSelectedValue();
			
			// ���� ���� ����� ������(ó�� Ŭ���� ����� ���̵�) ���ٸ� 
			if(this.listSelectUser.equals(selectValue)) {
				// ������ ������ �ٸ� �������Ը� �ӼӸ� ���� ����. (�ӼӸ�)
				if(!userID.equals(selectValue)) {	
					this.targetUser = selectValue;
					this.waitingRoomPanel.getNoticeTextField().setText(selectValue + " ���� �ӼӸ�");
				}
				
				UserGamedataInfoDTO gameData = new UserGamedataInfoDTO(UserPositionEnum.POSITION_WAITING_ROOM);
				gameData.setUserAction(UserActionEnum.USER_CONFIRM_USERINFO);
				gameData.setUserID(this.listSelectUser);
				try {
					this.waitingRoomPanel.getBasicFrame().getClientOS().writeObject(gameData);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				this.listSelectUser = this.waitingRoomPanel.getPlayerList().getSelectedValue();
			}
		}
		
	}
	
	// �游��������� new
	public void createRoomFrameView() {
		try {
			this.createRoom = this.waitingRoomPanel.newCreateGameRoomFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.waitingRoomPanel.getBasicFrame().setVisible(false);
	}
	
	// �游���-Ȯ�ι�ư
	public void newCreateRoom() throws IOException {
		// ���ӹ� ���� ����
		GameRoomInfoVO gameRoomInfo = new GameRoomInfoVO(UserPositionEnum.POSITION_WAITING_ROOM);
		gameRoomInfo.setUserAction(UserActionEnum.USER_CREATE_ROOM);
		gameRoomInfo.setRoomName(this.createRoom.getCreateRoomNameText().getText());
		gameRoomInfo.setOwner(this.waitingRoomPanel.getBasicFrame().getClientAccept().getUserID());
		gameRoomInfo.setRoomNumber(this.waitingRoomPanel.getRoomNumber());
		gameRoomInfo.setPersons(1);
		if(this.openPrivate == 1) {
			gameRoomInfo.setImage(ImageEnum.WAITINGROOM_ROOM_ENTERCHECK_IMAGE_MAP.getMap().get("��й�"));
			gameRoomInfo.setPwd(this.createRoom.getCreateRoomPwdText().getText());			
		} else {
			gameRoomInfo.setImage(ImageEnum.WAITINGROOM_ROOM_ENTERCHECK_IMAGE_MAP.getMap().get("���尡��"));
		}
				
		this.waitingRoomPanel.getBasicFrame().getClientOS().writeObject(gameRoomInfo);
	}
	
	public void chattingInput() throws IOException {
		this.inputCheck++; 		// ������ ������ �� ����
		if(inputCheck == 2) {	// �� ���� ������ ������ ����
			this.inputCheck = 0;// ���԰� �ʱ�ȭ
			String userMessage = this.waitingRoomPanel.getChattingInputTextField().getText();
			UserMessageVO userMessageVO = new UserMessageVO(UserPositionEnum.POSITION_WAITING_ROOM);
			userMessageVO.setUserID(this.waitingRoomPanel.getBasicFrame().getClientAccept().getUserID());
			userMessageVO.setMessage(userMessage + "\n");
			if(this.waitingRoomPanel.getNoticeTextField().getText().equals("��üä��")) {
				userMessageVO.setUserAction(UserActionEnum.USER_MESSAGE_DEFAULT);
			} else {
				userMessageVO.setUserAction(UserActionEnum.USER_MESSAGE_SECRET);
				userMessageVO.setTargetID(this.targetUser);
			}
			this.waitingRoomPanel.getBasicFrame().getClientOS().writeObject(userMessageVO);
			this.waitingRoomPanel.getChattingInputTextField().setText("");
		}
	}
}