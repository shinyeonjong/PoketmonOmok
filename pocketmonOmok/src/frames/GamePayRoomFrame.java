package frames;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import enums.frames.GamePayRoomEnum;
import enums.frames.searchIdEnum;

public class GamePayRoomFrame extends JFrame{
	private Image icon;
	private JLabel basicMoneyJLabel;
	private JLabel itemQuantityLabel;
	private JLabel equals;
	private JLabel totalAmountLabel;
	
	private JButton payButton;
	private JButton cancelButton;
	private BufferedImage backGround;
	
	public GamePayRoomFrame() throws IOException {
		
		
		
		
		//���ȭ�� �����ֱ�
		backGround = ImageIO.read(new File(""));
		this.backGround.getScaledInstance(
				GamePayRoomEnum.GAME_PAY_ROOM_WIDTH.getSize(),
				GamePayRoomEnum.GAME_PAY_ROOM_HEIGHT.getSize(),
				Image.SCALE_SMOOTH);
		this.setContentPane(new JLabel(new ImageIcon(backGround)));
		
		this.setBounds(
				GamePayRoomEnum.GAME_PAY_ROOM_POSITION_X.getSize(),
				GamePayRoomEnum.GAME_PAY_ROOM_POSITION_Y.getSize(),
				GamePayRoomEnum.GAME_PAY_ROOM_WIDTH.getSize(),
				GamePayRoomEnum.GAME_PAY_ROOM_HEIGHT.getSize()
		);
		
		this.setImageLine();
		this.setPayLine();
		this.setButtonLine();
		
		
		this.setResizable(false);
		this.setVisible(true);
	}
	public void setImageLine() {
		//��ǰ�� �����ϴ»���� ���� �������� �ٸ��ϱ�..? �󺧷� ó�� �߾��ϴ�
		
		
	}
	public void setPayLine() {

	}
	public void setButtonLine() {
		
	}
	
	public static void main(String[] args) {
		try {
			new GamePayRoomFrame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
