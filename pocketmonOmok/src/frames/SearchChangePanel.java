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
	private JPanel backGround;
	private JLabel changeConfirmLabel;
	
	private JButton changeConfirmButton;

	public SearchChangePanel() {
		String searchChange = "��й�ȣ ������ �Ϸ� �Ǿ����ϴ�. /n" +
								"�ٽ� �α��� ���ּ���";
		this.changeConfirmLabel = new JLabel(searchChange);
		this.changeConfirmLabel.setForeground(searchPwdEnum.LABELCOLOR_ERROR.getColor());
		
		changeConfirmButton  = new JButton();
		
		changeConfirmButton.setBorderPainted(false);
		changeConfirmButton.setFocusPainted(false);
		changeConfirmButton.setContentAreaFilled(false);
		this.add(changeConfirmButton);
		
		//���̺� ��Ʈ
		Font default_Font  = searchPwdEnum.LABELFONT_DEFAULT.getFont(); //�Ϲ�
		this.changeConfirmLabel.setFont(default_Font);
		
//		//���̺�, �ؽ�Ʈ, ��ư �ҷ�����
        this.setLabelPosition();
	     try {
			this.setButtonPosition();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	     
//	     this.add(this.searchPwdPanel);
//	     this.setLayout(new CardLayout());
	
	}
	public void setLabelPosition() {
		
	}
	public void setButtonPosition() throws IOException {
		this.changeConfirmButton.setIconTextGap(this.changeConfirmButton.getIconTextGap() - 15);
    	
    	this.changeConfirmButton.setIcon(
    			new ImageIcon(ImageIO.read(
    				new File("resources/signUp/up_up_confirm.jpg")).getScaledInstance(
    						searchRePwdEnum.SEARCH_REPWD_FRAME_WIDTH.getSize(),
    						searchRePwdEnum.SEARCH_REPWD_FRAME_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING))
    		);

    	this.changeConfirmButton.setBounds(searchRePwdEnum.SEARCH_CONFIRM_BUTTON.getRectangle());
    	
    	 
    	this.add(changeConfirmButton);
	}
	
}
