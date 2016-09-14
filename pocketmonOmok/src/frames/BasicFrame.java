package frames;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.ClientSender;
import datas.UserPositionIndex;
import enums.LoginFrameSizesEnum;
// �¼�
import enums.UserPositionEnum;

@SuppressWarnings("serial")
public class BasicFrame extends JFrame implements Serializable{
	//�̹��� ȭ�� ������ ���缭 �ٲ�� �ϱ� ���� �̹��� ���
	private Image reimage;
	private CardLayout cardLayout;
	private JPanel loginPanel;
	private JPanel waitingRoomPanel;
	
	private ClientSender clientSender;
	
	public BasicFrame(ClientSender clientSender) throws IOException {
		this.clientSender = clientSender;
		
		//����̹��� ������� �ػ󵵿� ���� �����ǰ� ����
		this.reimage = ImageIO.read(new File("resources/login/background.jpg")).getScaledInstance(
					LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize(),
					LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize(),
					Image.SCALE_SMOOTH);
		
		this.setContentPane(new JLabel(new ImageIcon(reimage)));   
		
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
		
		this.waitingRoomPanel = new WaitingroomPanel();
		
		this.gameExit();
		this.setLayout(this.cardLayout);
		this.add("loginPanel", this.loginPanel);
		this.add("waitingRoomPanel", this.waitingRoomPanel);
		this.setTitle("Login");
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public void gameExit() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("�ε����� �����մϴ�.");
				UserPositionIndex index = new UserPositionIndex(UserPositionEnum.POSITION_EXIT);
				try {
					clientSender.getClientOS().writeObject(index);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				e.getWindow().setVisible(false);
			}
		
		});
	}
	
	public void inWaitingRoom() {
		this.cardLayout.show(this.getContentPane(), "waitingRoomPanel");
	}

	public ClientSender getClientSender() {
		return clientSender;
	}
}