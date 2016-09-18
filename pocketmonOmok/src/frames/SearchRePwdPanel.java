package frames;

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
import javax.swing.JTextField;

import enums.searchPwdEnum;
import enums.searchRePwdEnum;

public class SearchRePwdPanel extends JPanel {
	private JLabel searchPwdLabel;
	private JLabel searchRePwdLabel;
	private JLabel searchPwdErrorLabel;
	
	private JTextField searchPwdTextField;
	private JTextField searchRePwdTextField;
	
	private JButton searchConfirmButton;
	private Image backGround;
	
	
	public SearchRePwdPanel() throws IOException {
		this.searchPwdLabel   = new JLabel("PW");
		this.searchRePwdLabel = new JLabel("PW���Է�");
		
		this.searchPwdTextField   = new JTextField(10);
		this.searchRePwdTextField = new JTextField(10);
		
		this.add(searchPwdTextField);
		this.add(searchRePwdTextField);

		
		String searchErrorMsg = "error message";
		this.searchPwdErrorLabel = new JLabel(searchErrorMsg);
		this.searchPwdErrorLabel.setForeground(searchRePwdEnum.LABELCOLOR_ERROR.getColor());
		
		//��ư ����
				searchConfirmButton  = new JButton();
				
				searchConfirmButton.setBorderPainted(false);
				searchConfirmButton.setFocusPainted(false);
				searchConfirmButton.setContentAreaFilled(false);
				this.add(searchConfirmButton);
		
		
		
		//�ؽ�Ʈ �ʵ� �׵θ� ���ֱ�
				searchPwdTextField.setBorder(searchRePwdEnum.LABEL_DEFAULT.getBorder());
				this.searchPwdTextField.setOpaque(true);
				searchRePwdTextField.setBorder(searchRePwdEnum.LABEL_DEFAULT.getBorder());
				this.searchRePwdTextField.setOpaque(true);
				
					//���̺� ��Ʈ
					this.searchPwdLabel.setFont(searchRePwdEnum.LABELFONT_DEFAULT.getFont());
					this.searchRePwdLabel.setFont(searchRePwdEnum.LABELFONT_DEFAULT.getFont());
				
	//				 
	//				// �ؽ�Ʈ ��Ʈ
					this.searchPwdTextField.setFont(searchRePwdEnum.LABELFONT_DEFAULT.getFont());
					this.searchRePwdLabel.setFont(searchRePwdEnum.LABELFONT_DEFAULT.getFont());
					this.searchPwdErrorLabel.setFont(searchRePwdEnum.LABELFONT_ERROR.getFont());
					
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
		
//		//���̺�, �ؽ�Ʈ, ��ư �ҷ�����
	             this.setLabelPosition();
			     this.setTextFieldPosition();
			     this.setButtonPosition();    
				
				this.setLayout(null);
			    this.setVisible(true);
			 
	}
	public void setLabelPosition() {
		this.searchPwdLabel.setBounds(searchRePwdEnum.SEARCH_PWD_LABEL.getRectangle());
		this.searchRePwdLabel.setBounds(searchRePwdEnum.SEARCH_REPWD_LABEL.getRectangle());
		this.searchPwdErrorLabel.setBounds(searchRePwdEnum.SEARCH_ERROR_LABEL.getRectangle());
		this.add(searchPwdLabel);
		this.add(searchRePwdLabel);
		this.add(searchPwdErrorLabel);
	}
	public void setTextFieldPosition() {
		this.searchPwdTextField.setBounds(searchRePwdEnum.SEARCH_PWD_TEXTFIELD.getRectangle());
		this.searchRePwdTextField.setBounds(searchRePwdEnum.SEARCH_REPWD_TEXTFIELD.getRectangle());
		
    	this.add(searchPwdTextField);
    	this.add(searchRePwdTextField);
	}
	public void setButtonPosition() throws IOException {
		this.searchConfirmButton.setIconTextGap(this.searchConfirmButton.getIconTextGap() - 15);
    	
    	this.searchConfirmButton.setIcon(
    			new ImageIcon(ImageIO.read(
    				new File("resources/signUp/up_up_confirm.jpg")).getScaledInstance(
    						searchRePwdEnum.SEARCH_REPWD_FRAME_WIDTH.getSize(),
    						searchRePwdEnum.SEARCH_REPWD_FRAME_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING))
    		);

    	this.searchConfirmButton.setBounds(searchRePwdEnum.SEARCH_CONFIRM_BUTTON.getRectangle());
    	
    	 
    	this.add(searchConfirmButton);
	}



}
