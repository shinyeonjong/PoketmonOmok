package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import enums.frames.ChargeEnum;
import enums.frames.GameRoomCreateEnum;
import enums.frames.WaitingRoomSizesEnum;
import enums.frames.searchIdEnum;

public class ChargeConfirmFrame extends JFrame{
	private Image backGround;
	private JLabel success;
	private JButton confirm;
	
	public ChargeConfirmFrame() throws IOException {
		this.backGround = ImageIO.read(new File("resources/background/popup.png")).getScaledInstance(
				ChargeEnum.CHARGE_CONFIRM_FRAME_SIZE_WIDTH.getSize(),
				ChargeEnum.CHARGE_CONFIRM_FRAME_SIZE_HEIGHT.getSize(),
                Image.SCALE_SMOOTH);

		this.setContentPane(new JLabel(new ImageIcon(backGround)));

		this.setBounds(
				ChargeEnum.CHARGE_CONFIRM_FRAME_SIZE_POSITION_X.getSize(),
				ChargeEnum.CHARGE_CONFIRM_FRAME_SIZE_POSITION_Y.getSize(),
				ChargeEnum.CHARGE_CONFIRM_FRAME_SIZE_WIDTH.getSize(),
				ChargeEnum.CHARGE_CONFIRM_FRAME_SIZE_HEIGHT.getSize()
		);
		
		this.success = new JLabel("���� �Ϸ� :)");	
<<<<<<< HEAD
		this.success.setFont(ChargeEnum.LABELFONT_DEFAULT.getFont());
=======
		//Font font = new Font("a��������" , Font.BOLD , 24);
		this.success.setFont(font);
>>>>>>> 9e60f838960ec564081067d8ec1fc901c6eaeb42
		this.success.setBounds(ChargeEnum.CHARGE_SUCCESS_TEXT_SIZE_RECT.getRect());		
		
		this.confirm = new JButton(){
			@Override
	        protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/myData/confirm.kor.png")), 
						0, 
						0, 
						ChargeEnum.CHARGE_CONFIRM_BUTTON_SIZE_RECT.getRect().width,
						ChargeEnum.CHARGE_CONFIRM_BUTTON_SIZE_RECT.getRect().height,
						this);
				} catch (IOException e) {
					e.printStackTrace();
		        }      
		    }
		};
		confirm.setFocusPainted(false);
		confirm.setBorderPainted(false);
		confirm.setContentAreaFilled(false);
		this.confirm.setBounds(ChargeEnum.CHARGE_CONFIRM_BUTTON_SIZE_RECT.getRect());
		
		this.add(success);
		this.add(confirm);
		this.setLayout(null);
		this.setTitle("����");
		this.setResizable(false);
		this.setVisible(true);
	
	}

	public static void main(String[] args) throws IOException {
		new ChargeConfirmFrame();
	}

}
