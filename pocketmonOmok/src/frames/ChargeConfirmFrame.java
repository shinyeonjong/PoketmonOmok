package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import enums.frames.ChargeEnum;

public class ChargeConfirmFrame extends JFrame{
	private JLabel success;
	private JButton confirm;
	
	public ChargeConfirmFrame() {
		
		this.setBounds(
				ChargeEnum.CHARGE_CONFIRM_FRAME_SIZE_POSITION_X.getSize(),
				ChargeEnum.CHARGE_CONFIRM_FRAME_SIZE_POSITION_Y.getSize(),
				ChargeEnum.CHARGE_CONFIRM_FRAME_SIZE_WIDTH.getSize(),
				ChargeEnum.CHARGE_CONFIRM_FRAME_SIZE_HEIGHT.getSize()
		);
		
		this.success = new JLabel("���� �Ϸ� :)");	
		Font font = new Font("a��������" , Font.BOLD , 24);
		this.success.setFont(font);
		this.success.setOpaque(false);
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
		confirm.setBackground(Color.black);
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

	public static void main(String[] args) {
		new ChargeConfirmFrame();
	}

}
