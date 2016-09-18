package frames;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import client.ClientAccept;
import datas.UserPositionIndex;
import enums.LoginFrameSizesEnum;
import enums.LoginSizesEnum;
// �¼�
import enums.UserPositionEnum;

@SuppressWarnings("serial")
public class BasicFrame extends JFrame implements Serializable{
	//�̹��� ȭ�� ������ ���缭 �ٲ�� �ϱ� ���� �̹��� ���
	private Image reimage;
	private CardLayout cardLayout;
	private LoginPanel loginPanel;
	private WaitingRoomPanel waitingRoomPanel;
	private GameRoomPanel gameRoomPanel;
	
	private ClientAccept clientAccept;
	
	
	
	public BasicFrame(ClientAccept clientAccept) throws IOException {
		this.clientAccept = clientAccept;
		
		//����̹��� ������� �ػ󵵿� ���� �����ǰ� ����
		this.reimage = ImageIO.read(new File("resources/login/background.jpg")).getScaledInstance(
					LoginSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize(),
					LoginSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize(),
					Image.SCALE_SMOOTH);
		
		this.setContentPane(new JLabel(new ImageIcon(reimage)));   
		
		//������ ȭ�� ��� ��ġ ����
		this.setBounds(   
					LoginSizesEnum.LOGIN_FRAME_POSITION_X.getSize(),
					LoginSizesEnum.LOGIN_FRAME_POSITION_Y.getSize(),
					LoginSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize(), 
					LoginSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize()
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
	
		
		
		this.gameExit();
		this.newGameRoomPanel();
		this.setLayout(this.cardLayout);
//		this.add("loginPanel", this.loginPanel);

		this.add("waitingRoomPanel", this.waitingRoomPanel);
	//	this.add("gameRoomPanel", this.gameRoomPanel);

		this.setTitle("Login");
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public void gameExit() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				UserPositionIndex index = new UserPositionIndex(UserPositionEnum.POSITION_EXIT);
				try {
					clientAccept.getClientOS().writeObject(index);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				e.getWindow().setVisible(false);
			}
		
		});
	}
	
	// GameRoom �� �ᱹ �г��̹Ƿ� �г� ������ �͸�Ŭ������ �̿��Ͽ�  paintComponent �� �������̵� �ϸ�
	// ���� GameRoom �ȿ��� ���ο� �г��� �����Ͽ� ����� ����� �ʿ䰡 ���� �ȴ�. 
	public void newGameRoomPanel() {
		this.gameRoomPanel = new GameRoomPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/background/background.png")), 
						0, 
						0, 
						LoginSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize(), LoginSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize(),
						this
					);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
	}
	
	public void inWaitingRoom() {
		this.cardLayout.show(this.getContentPane(), "waitingRoomPanel");
	}

	public ObjectOutputStream getClientOS() {
		return this.clientAccept.getClientOS();
	}
	
	public LoginPanel getLoginPanel() {
		return loginPanel;
	}
	
	public static void main(String[] args) {
		try {
			new BasicFrame(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}