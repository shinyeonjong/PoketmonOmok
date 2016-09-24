package frames.serchFrames;


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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import enums.frames.GameRoomEnum;
import enums.frames.searchIdEnum;
import enums.frames.searchPwdEnum;
import enums.frames.searchRePwdEnum;

@SuppressWarnings("serial")
public class SearchRePwdPanel extends JPanel {
	private JPanel searchRePwdPanel;
	private Image backGround;
	
	private JLabel searchPwdLabel;
	private JLabel searchRePwdLabel;
	private JTextField searchPwdText;
	private JTextField searchRePwdText;
	private JLabel searchRePwdErrorLabel;
	private JButton searchConfirmButton;

	public SearchRePwdPanel() throws IOException {
<<<<<<< HEAD
		
		this.setLayout(null);
=======
		this.setLayout(null);

>>>>>>> c1b9ddef1d3260d234ae45ada6f4dff569088eca
		this.setsearchPwdPanel();
		
	} //������
	// �г� ���� -- ��й�ȣ �Է�, ���й�ȣ �Է� �ؽ�Ʈ
	public void setsearchPwdPanel() throws IOException {
		
		// �г��� ����̹���
		backGround = ImageIO.read(new File("resources/background/popup.png")).getScaledInstance(
				searchPwdEnum.SEARCH_PWD_FRAME_WIDTH.getSize(),
				searchPwdEnum.SEARCH_PWD_FRAME_HEIGHT.getSize(),
                Image.SCALE_SMOOTH);
		this.add(new JLabel(new ImageIcon(backGround)));

		this.setBounds(
				searchRePwdEnum.SEARCH_REPWD_FRAME_POSITION_X.getSize(),
				searchRePwdEnum.SEARCH_REPWD_FRAME_POSITION_Y.getSize(),
				searchRePwdEnum.SEARCH_REPWD_FRAME_WIDTH.getSize(),
				searchRePwdEnum.SEARCH_REPWD_FRAME_HEIGHT.getSize()
				);
		//��й�ȣ ��
		
		this.searchPwdLabel = new JLabel("PW");
		this.searchPwdLabel.setBounds(searchRePwdEnum.SEARCH_PWD_LABEL.getRectangle());
		this.searchPwdLabel.setFont(searchIdEnum.LABELFONT_DEFAULT.getFont());
		
		//��й�ȣ �Է�â
<<<<<<< HEAD
		this.searchPwdText = new JTextField();
		this.searchPwdText.setBounds(searchRePwdEnum.SEARCH_PWD_TEXTFIELD.getRectangle());
		this.searchPwdText.setFont(searchIdEnum.LABELFONT_DEFAULT.getFont());
=======
		JTextField searchPwdText = new JTextField();
		searchPwdText.setBounds(searchRePwdEnum.SEARCH_PWD_TEXTFIELD.getRectangle());
		searchPwdText.setFont(searchIdEnum.LABELFONT_DEFAULT.getFont());
>>>>>>> c1b9ddef1d3260d234ae45ada6f4dff569088eca

		// ���й�ȣ ��
		this.searchRePwdLabel = new JLabel("PW���Է�");
		this.searchRePwdLabel.setBounds(searchRePwdEnum.SEARCH_REPWD_LABEL.getRectangle());
		this.searchRePwdLabel.setFont(searchIdEnum.LABELFONT_DEFAULT.getFont());
		
		// ����й�ȣ �ؽ�Ʈâ
<<<<<<< HEAD
		this.searchRePwdText = new JTextField();
		this.searchRePwdText.setBounds(searchRePwdEnum.SEARCH_REPWD_TEXTFIELD.getRectangle());
		this.searchRePwdText.setFont(searchIdEnum.LABELFONT_DEFAULT.getFont());
=======
		JTextField searchRePwdText = new JTextField();
		searchRePwdText.setBounds(searchRePwdEnum.SEARCH_REPWD_TEXTFIELD.getRectangle());
		searchRePwdText.setFont(searchIdEnum.LABELFONT_DEFAULT.getFont());
>>>>>>> c1b9ddef1d3260d234ae45ada6f4dff569088eca
		
		// ���� �޼��� ��
		this.searchRePwdErrorLabel = new JLabel
				("<html>��й�ȣ�� ��ġ���� �ʽ��ϴ�. "
				+ "<br>�ٽ� �Է����ּ���<br></html>");
		searchRePwdErrorLabel.setBounds(searchRePwdEnum.SEARCH_ERROR_LABEL.getRectangle());
		searchRePwdErrorLabel.setFont(searchIdEnum.LABELFONT_ERROR.getFont());
		searchRePwdErrorLabel.setForeground(searchIdEnum.LABELCOLOR_ERROR.getColor());
		//Ȯ�� ��ưâ
		
		this.searchConfirmButton = new JButton() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/signUp/confirm.jpg")), 
						0, 
						0, 
						searchRePwdEnum.SEARCH_CONFIRM_BUTTON.getRectangle().width,
						searchRePwdEnum.SEARCH_CONFIRM_BUTTON.getRectangle().height,
						this);
				} catch (IOException e) {
					e.printStackTrace();
				}		
			}
		};	
		this.searchConfirmButton.setBounds(searchRePwdEnum.SEARCH_CONFIRM_BUTTON.getRectangle());
//				
		this.add(searchPwdLabel);
		this.add(searchRePwdText);
		this.add(searchPwdText);
		this.add(searchRePwdLabel);
		this.add(searchRePwdErrorLabel);
		this.add(searchConfirmButton);
	
		


	
	}

}
