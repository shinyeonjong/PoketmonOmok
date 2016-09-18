package frames;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import enums.searchPwdEnum;
import enums.searchRePwdEnum;

public class SearchChangePanel extends JPanel {
	private Image backGround;
	private JLabel changeConfirmLabel;
	
	private JButton changeConfirmButton;

	public SearchChangePanel() throws IOException {
		
		String searchChange ="<html>��й�ȣ ������ �Ϸ� �Ǿ����ϴ�."
							+ "<br>�ٽ� �α������ּ���!<br></html>";
		this.changeConfirmLabel = new JLabel(searchChange);
		this.changeConfirmLabel.setForeground(searchRePwdEnum.LABELCOLOR_ERROR.getColor());
		
		//Ȯ�� ��ư ���� -- > Ȯ�� ������ login ȭ������
		changeConfirmButton  = new JButton();
		
		changeConfirmButton.setBorderPainted(false);
		changeConfirmButton.setFocusPainted(false);
		changeConfirmButton.setContentAreaFilled(false);
		this.add(changeConfirmButton);
		
		//���̺� ��Ʈ
		Font default_Font  = searchRePwdEnum.LABELFONT_DEFAULT.getFont(); //�Ϲ�
		this.changeConfirmLabel.setFont(default_Font);
		
		//���ȭ��	
		backGround = ImageIO.read(new File("resources/signUp/backg.png")).getScaledInstance(
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
		this.setLabelPosition();
		this.setButtonPosition();
		
		this.setLayout(null);
	    this.setVisible(true);    
	}
	//���̺� ��ġ 
	public void setLabelPosition() {
		this.changeConfirmLabel.setBounds(searchRePwdEnum.SEARCH_CONFIRM_CHANGE_LABEL.getRectangle());
		this.add(changeConfirmLabel);
	}
	
	// ��ư �̹��� ������  - Enum�� searchRePwdPanel���� �߰��ؼ� ��
	public void setButtonPosition() throws IOException {
		this.changeConfirmButton.setIconTextGap(this.changeConfirmButton.getIconTextGap() - 15);
		this.changeConfirmButton.setBounds(searchRePwdEnum.SEARCH_REPWD_TEXTFIELD.getRectangle());
		
    	this.changeConfirmButton.setIcon(
    			new ImageIcon(ImageIO.read(
    				new File("resources/signUp/confirm.jpg")).getScaledInstance(
    						searchRePwdEnum.SEARCH_CONFIRM_CHANGE_LABEL.getRectangle().width,
    						searchRePwdEnum.SEARCH_CONFIRM_CHANGE_LABEL.getRectangle().height,
    					Image.SCALE_AREA_AVERAGING))
    		);

    	this.changeConfirmButton.setBounds(searchRePwdEnum.SEARCH_CONFIRM_BUTTON.getRectangle());
    	
    	 
    	this.add(changeConfirmButton);
    	
	}
	
	
}
