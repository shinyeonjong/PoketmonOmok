package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import enums.WaitingRoomSizesEnum;

public class WaitingRoomPanel extends JPanel implements ActionListener {
	private JPanel background;
	private JLabel waitingRoomInfo;
	private JList<String> waitingRoomList;
	private Vector<String> vector;
	private JButton gamestartButton;
	private JButton createRoomButton;
	private JTextArea chattingOutput;
	private JTextField chattingInput;
	
	public WaitingRoomPanel() throws IOException {	
		
		this.vector = new Vector<String>();
		this.waitingRoomInfo = new JLabel(" OX " + "  NO  "
				+ "                 TITLE                 "
				+ "     MASTER     " + "NUMBER");
		this.waitingRoomList = new JList<>(this.vector);
		this.vector.add("1111111111111111111111111��");
		this.vector.add("2222222222222222222222222��");
		this.chattingOutput = new JTextArea();
		this.chattingInput = new JTextField();
		this.gamestartButton = new JButton();
		this.createRoomButton = new JButton();
		this.roomListPosition();
	}

	
	
	public void roomListPosition() throws IOException {
		
		this.waitingRoomList.setBackground(Color.BLUE);

		//�渮��Ʈ ������ ��ġ�� ũ�⸦ ������
		this.waitingRoomInfo.setBounds(
				WaitingRoomSizesEnum.WAITING_ROOM_INFO_POSITION_X.getSize(),
				WaitingRoomSizesEnum.WAITING_ROOM_INFO_POSITION_Y.getSize(),
				WaitingRoomSizesEnum.WAITING_ROOM_INFO_WIDTH.getSize(),
				WaitingRoomSizesEnum.WAITING_ROOM_INFO_HEIGHT.getSize()
		);
		
		//�渮��Ʈ ��ġ�� ũ�⸦ ������
		this.waitingRoomList.setBounds(
				WaitingRoomSizesEnum.WAITING_ROOM_LIST_POSITION_X.getSize(),
				WaitingRoomSizesEnum.WAITING_ROOM_LIST_POSITION_Y.getSize(),
				WaitingRoomSizesEnum.WAITING_ROOM_SIZE_WIDTH.getSize(),
				WaitingRoomSizesEnum.WAITING_ROOM_SIZE_HEIGHT.getSize()
		);
		
		//ä�� �Է�â�� ��ġ�� ũ�⸦ ������
		this.chattingOutput.setBounds(
				WaitingRoomSizesEnum.WAITING_CHATTING_OUTPUT_POSITION_X.getSize(),
				WaitingRoomSizesEnum.WAITING_CHATTING_OUTPUT_POSITION_Y.getSize(),
				WaitingRoomSizesEnum.WAITING_CHATTING_OUTPUT_SIZE_WIDTH.getSize(),
				WaitingRoomSizesEnum.WAITING_CHATTING_OUTPUT_SIZE_HEIGHT.getSize()
		);
		//ä�� ���â�� ��ġ�� ũ�⸦ ������
		this.chattingInput.setBounds(
				WaitingRoomSizesEnum.WAITING_CHATTING_INPUT_POSITION_X.getSize(),
				WaitingRoomSizesEnum.WAITING_CHATTING_INPUT_POSITION_Y.getSize(),
				WaitingRoomSizesEnum.WAITING_CHATTING_INPUT_SIZE_WIDTH.getSize(),
				WaitingRoomSizesEnum.WAITING_CHATTING_INPUT_SIZE_HEIGHT.getSize()	
		);
		
		//���ӽ��� ��ư ��ġ�� ũ�⸦ ������
		this.gamestartButton.setBounds(
				WaitingRoomSizesEnum.GAMESTART_JBUTTON_POSITION_X.getSize(), 
				WaitingRoomSizesEnum.GAMESTART_JBUTTON_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.GAMESTART_JBUTTON_WIDTH.getSize(),
				WaitingRoomSizesEnum.GAMESTART_JBUTTON_HEIGHT.getSize()
		);
		//���ӽ��� ��ư�� �̹����� �ҷ���
		this.gamestartButton.setIcon(
			new ImageIcon(ImageIO.read(
				new File("resources/waitingroom/_gamestart.jpg")).getScaledInstance(
					WaitingRoomSizesEnum.GAMESTART_JBUTTON_WIDTH.getSize(),
					WaitingRoomSizesEnum.GAMESTART_JBUTTON_HEIGHT.getSize(),
					Image.SCALE_AREA_AVERAGING))
		);
		
		//����� ��ư ��ġ�� ũ�⸦ ������
		this.createRoomButton.setBounds(
				WaitingRoomSizesEnum.CREATEROOM_JBUTTON_POSITION_X.getSize(), 
				WaitingRoomSizesEnum.CREATEROOM_JBUTTON_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.CREATEROOM_JBUTTON_WIDTH.getSize(),
				WaitingRoomSizesEnum.CREATEROOM_JBUTTON_HEIGHT.getSize()
		);
		//����� ��ư�� �̹����� �ҷ���
		this.createRoomButton.setIcon(
				new ImageIcon(ImageIO.read(
					new File("resources/waitingroom/_createRoom.jpg")).getScaledInstance(
						WaitingRoomSizesEnum.CREATEROOM_JBUTTON_WIDTH.getSize() ,
						WaitingRoomSizesEnum.CREATEROOM_JBUTTON_HEIGHT.getSize(),
						Image.SCALE_AREA_AVERAGING))
			);
		
		
		//���ӽ��� ��ư�׵θ� ȿ���� ������
		this.gamestartButton.setBorderPainted(false);
		this.gamestartButton.setContentAreaFilled(false);
		this.gamestartButton.setFocusPainted(false);
		//���ӽ��� ��ư�̹��� ©���°� �̹��� �����̵����� �ذ�����
		this.gamestartButton.setIconTextGap(this.createRoomButton.getIconTextGap() - 15);
		
		//����� ��ư�׵θ� ȿ���� ������
		this.createRoomButton.setBorderPainted(false);
		this.createRoomButton.setContentAreaFilled(false);
		this.createRoomButton.setFocusPainted(false);
		//����� ��ư�̹��� ©���°� �̹��� �����̵����� �ذ�����
		this.createRoomButton.setIconTextGap(this.createRoomButton.getIconTextGap() - 15);
		
		
		//������ ��Ʈ
		this.waitingRoomInfo.setForeground(Color.WHITE);
		this.waitingRoomInfo.setFont(new Font("a��������", Font.BOLD, 18));
		
		this.setLayout(null);
		
		this.add(waitingRoomInfo);
		this.add(waitingRoomList);
		this.add(chattingOutput);
		this.add(chattingInput);
		this.add(gamestartButton);
		this.add(createRoomButton);

	}

	private void waitingRoomInfoFont(Font font) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
	}
}
