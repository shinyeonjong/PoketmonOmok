package frames;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import enums.frames.LoginSizesEnum;
import enums.frames.searchPwdEnum;
import enums.frames.searchRePwdEnum;

@SuppressWarnings("serial")
public class SearchChangePanel extends JPanel {
	private JPanel searchChangePanel;
	private Image backGround;
	
	public SearchChangePanel() throws IOException {
		this.setLayout(null);
		
		//�г� ���� �� �ҷ�����
		this.searchChangePanel  = new JPanel(); 	
		this.setchangePanel();
	}
	
	//�����ߴٴ� �г� ����
	public void setchangePanel() throws IOException {
		this.searchChangePanel.setLayout(null);
		this.searchChangePanel.setOpaque(false);
		
		// �г� ���ȭ��
		backGround = ImageIO.read(new File("resources/signUp/backg.png")).getScaledInstance(
				searchPwdEnum.SEARCH_PWD_FRAME_WIDTH.getSize(),
				searchPwdEnum.SEARCH_PWD_FRAME_HEIGHT.getSize(),
                Image.SCALE_SMOOTH);
		this.add(new JLabel(new ImageIcon(backGround)));
		//this.setContentPane(new JLabel(new ImageIcon(backGround))); 
		
		this.setBounds(
				searchRePwdEnum.SEARCH_REPWD_FRAME_POSITION_X.getSize(),
				searchRePwdEnum.SEARCH_REPWD_FRAME_POSITION_Y.getSize(),
				searchRePwdEnum.SEARCH_REPWD_FRAME_WIDTH.getSize(),
				searchRePwdEnum.SEARCH_REPWD_FRAME_HEIGHT.getSize()
				);
		// ���� �Ϸ�â ��
		JLabel changeConfirmMsgLabel = new JLabel("<html>��й�ȣ ������ �Ϸ� �Ǿ����ϴ�."
				+ "<br>�ٽ� �α������ּ���!<br></html>");
		changeConfirmMsgLabel.setBounds(searchRePwdEnum.SEARCH_CONFIRM_CHANGE_LABEL.getRectangle());
		

		// Ȯ�� ��ư â
		JButton changeConfirmButton  = new JButton() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/signUp/confirm.jpg")), 
						0, 
						0, 
						searchRePwdEnum.SEARCH__CHANGE_CONFIRM_BUTTON.getRectangle().width,
						searchRePwdEnum.SEARCH__CHANGE_CONFIRM_BUTTON.getRectangle().height,
						this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		this.searchChangePanel.add(changeConfirmMsgLabel);
		this.searchChangePanel.add(changeConfirmButton);
		}
		
	}