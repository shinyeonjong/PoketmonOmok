package frames;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import enums.LoginFrameSizesEnum;
// �¼�

@SuppressWarnings("serial")
public class BasicFrame extends JFrame {
	//�̹��� ȭ�� ������ ���缭 �ٲ�� �ϱ� ���� �̹��� ���
	private Image reimage;

	private CardLayout cardLayout;
	
	private JPanel loginPanel;
	private JPanel waitingRoomPanel;
	public BasicFrame() throws IOException {

//		//����̹��� ������� �ػ󵵿� ���� �����ǰ� ����
//		reimage = ImageIO.read(new File("resources/login/background.jpg")).getScaledInstance(
//					LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize(),
//					LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize(),
//					Image.SCALE_SMOOTH);
//		
//		
//		this.setContentPane(new JLabel(new ImageIcon(reimage)));   
		
		//������ ȭ�� ��� ��ġ ����
		this.setBounds(   
					LoginFrameSizesEnum.LOGIN_FRAME_POSITION_X.getSize(),
					LoginFrameSizesEnum.LOGIN_FRAME_POSITION_Y.getSize(),
					LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize(), 
					LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize()
		);
		
		this.loginPanel = new LoginPanel(this);
		this.loginPanel.setOpaque(false);
		this.cardLayout = new CardLayout();
		
		this.waitingRoomPanel = new WaitingRoomPanel(){
			@Override
			protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			try {
				g.drawImage(ImageIO.read(
					new File("resources/login/blackhole.png")), 
					0, 
					0,
					LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize(),
					LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize(),
					this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}};
		
		this.setLayout(this.cardLayout);
//		this.add("loginPanel", this.loginPanel);
		this.add("waitingRoomPanel", this.waitingRoomPanel);
		this.setTitle("Login");
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public void inWaitingRoom() {
		this.cardLayout.show(this.getContentPane(), "waitingRoomPanel");
	}
	
	public static void main(String[] args) {
		try {
			new BasicFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}