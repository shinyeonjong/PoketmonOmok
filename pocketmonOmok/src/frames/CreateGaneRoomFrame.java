package frames;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import enums.frames.GamePayRoomEnum;
import enums.frames.GameRoomCreateEnum;
import enums.frames.GameRoomFullEnum;
import enums.frames.searchIdEnum;
import enums.frames.searchRePwdEnum;

public class CreateGaneRoomFrame extends JFrame {
	private JLabel createRoomNameLabel;
	private JLabel createRoomPwdLabel;
	
	private JTextField createRoomNameText;
	private JTextField createRoomPwdText;
		
	private JButton createRoomConfirmButton;
	private JButton createRoomCancelButton;
	
	private JRadioButton roomCreatePrivate;
	private JRadioButton roomCreateOpen;
	private ButtonGroup roomCreateGroup;
	
	private Image backGround;
	
	public CreateGaneRoomFrame() throws IOException {
		//���̸�, ���й�ȣ �� ����
		this.createRoomNameLabel = new JLabel("���̸�");
		this.createRoomPwdLabel  = new JLabel("���й�ȣ");
		
		//���̸�, ���й�ȣ �ؽ�Ʈ ����
		this.createRoomNameText = new JTextField(10);
		this.createRoomPwdText  = new JTextField(10);
		
		//���� ������� ���� �ڽ�
		this.roomCreateGroup   = new ButtonGroup();
		this.roomCreatePrivate = new JRadioButton("������");
		this.roomCreateOpen    = new JRadioButton("��й�");
		
		//��ư ����
		//Ȯ�� ��ư
		createRoomConfirmButton  = new JButton();
		createRoomConfirmButton.setBorderPainted(false);
		createRoomConfirmButton.setFocusPainted(false);
		createRoomConfirmButton.setContentAreaFilled(false);
		
		//��� ��ư
		createRoomCancelButton  = new JButton();
		createRoomCancelButton.setBorderPainted(false);
		createRoomCancelButton.setFocusPainted(false);
		createRoomCancelButton.setContentAreaFilled(false);
		
		
		
		//���ȭ��	
				backGround = ImageIO.read(new File("resources/background/popup.png")).getScaledInstance(
						searchIdEnum.SEARCHFRAME_SIZE_WIDTH.getSize(),
						searchIdEnum.SEARCHFRAME_SIZE_HEIGHT.getSize(),
		                Image.SCALE_SMOOTH);

				this.setContentPane(new JLabel(new ImageIcon(backGround)));
						
				this.setBounds(
						GameRoomCreateEnum.GAMEROOM_CREATE_FRAME_POSITION_X.getSize(),
						GameRoomCreateEnum.GAMEROOM_CREATE_FRAME_POSITION_Y.getSize(),
						GameRoomCreateEnum.GAMEROOM_CREATE_FRAME_SIZE_WIDTH.getSize(),
						GameRoomCreateEnum.GAMEROOM_CREATE_FRAME_SIZE_HEIGHT.getSize()
				);
				
		//���̺� ��Ʈ -- searchIdEnum ���� �ҷ���
		this.createRoomNameLabel.setFont(searchIdEnum.LABELFONT_DEFAULT.getFont());	
		this.createRoomPwdLabel.setFont(searchIdEnum.LABELFONT_DEFAULT.getFont());
		
		
		this.createRoomNameText.setFont(searchIdEnum.LABELFONT_DEFAULT.getFont());
		this.createRoomPwdText.setFont(searchIdEnum.LABELFONT_DEFAULT.getFont());
		
		this.roomCreateOpen.setFont(searchIdEnum.LABELFONT_DEFAULT.getFont());
		this.roomCreatePrivate.setFont(searchIdEnum.LABELFONT_DEFAULT.getFont());
		//���̺� ����
		this.createRoomNameLabel.setForeground(Color.black);
		this.createRoomPwdLabel.setForeground(Color.black);
				
		this.setLabelPosition();
		this.setTextPosition();
		this.setButtonPosition();
		this.setRadioPosition();
		
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		
	}
	//========================================================================================================
	//�� ��ġ
	public void setLabelPosition() {
		this.createRoomNameLabel.setBounds(GameRoomCreateEnum.GAMEROOM_CREATE_ROOM_NAME_LABEL.getRectangle());
		this.createRoomPwdLabel.setBounds(GameRoomCreateEnum.GAMEROOM_CREATE_ROOM_PWD_NAME_LABEL.getRectangle());
		
		this.add(createRoomPwdLabel);
		this.add(createRoomNameLabel);
	}
	
	//�ؽ�Ʈ�ʵ� ��ġ
	public void setTextPosition() {
		this.createRoomNameText.setBounds(GameRoomCreateEnum.GAMEROOM_CREATE_ROOM_NAME_TEXT.getRectangle());
		this.createRoomPwdText.setBounds(GameRoomCreateEnum.GAMEROOM_CREATE_ROOM_PWD_TEXT.getRectangle());
		this.add(createRoomNameText);
		this.add(createRoomPwdText);
		
	}
	//========================================================================================================
	//Ȯ��, ��� ��ư �޼ҵ�
	public void setButtonPosition() throws IOException {
		//Ȯ�� ��ư
		this.createRoomConfirmButton.setIconTextGap(this.createRoomConfirmButton.getIconTextGap() - 15);
    	this.createRoomConfirmButton.setIcon(
    			new ImageIcon(ImageIO.read(
    				new File("resources/signUp/confirm.jpg")).getScaledInstance(
    						GameRoomCreateEnum.GAMEROOM_CREATE_ROOM_CONFIRM_BUTTON.getRectangle().width,
    						GameRoomCreateEnum.GAMEROOM_CREATE_ROOM_CONFIRM_BUTTON.getRectangle().height,
    						Image.SCALE_AREA_AVERAGING))
    		);
    	this.createRoomConfirmButton.setBounds(GameRoomCreateEnum.GAMEROOM_CREATE_ROOM_CONFIRM_BUTTON.getRectangle());
    	
    //��ҹ�ư
    	this.createRoomCancelButton.setIconTextGap(this.createRoomCancelButton.getIconTextGap() - 15);
    	this.createRoomCancelButton.setIcon(
    			new ImageIcon(ImageIO.read(
    				new File("resources/signUp/reset.jpg")).getScaledInstance(
    						GameRoomCreateEnum.GAMEROOM_CREATE_ROOM_CANCEL_BUTTON.getRectangle().width,
    						GameRoomCreateEnum.GAMEROOM_CREATE_ROOM_CANCEL_BUTTON.getRectangle().height,
    						Image.SCALE_AREA_AVERAGING))
    		);
    	this.createRoomCancelButton.setBounds(GameRoomCreateEnum.GAMEROOM_CREATE_ROOM_CANCEL_BUTTON.getRectangle());
    	
    	this.add(createRoomConfirmButton);
    	this.add(createRoomCancelButton);    	 
	}
	//========================================================================================================
	public void setRadioPosition() throws IOException {
		//��������� �ڽ�
    	this.roomCreateOpen.setBounds(GameRoomCreateEnum.GAMEROOM_CREATE_ROOM_OPEN_RADIO.getRectangle());
    	this.roomCreatePrivate.setBounds(GameRoomCreateEnum.GAMEROOM_CREATE_ROOM_PRIVATE_RADIO.getRectangle());
    	
    	
    	this.roomCreateOpen.setOpaque(false);
    	this.roomCreatePrivate.setOpaque(false);
    	this.add(roomCreatePrivate);
		this.add(roomCreateOpen);
	}
	//========================================================================================================
	public static void main(String[] args) throws IOException {
		new CreateGaneRoomFrame();
	}
}
