package frames;

import java.awt.Color;
import java.awt.Font;
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

import enums.frames.searchPwdEnum;

public class SearchPwdPanel extends JPanel {

	private JLabel searchIdLabel;
	private JLabel searchemailLabel;
	private JLabel searchErrorMsgLabel;
	private JLabel searchAnswerMsg;
	private JLabel searchTimeLabel;
	
	private JTextField searchIdTextField;
	private JTextField searchemailTextField;
	private JTextField searchConfirmTextField;
	
	private JButton searchConfirmButton;
	//private Image backGround;
	
	private SearchPwdFrame searchPwdFrame;
	
	
	public SearchPwdPanel(SearchPwdFrame searchPwdFrame) throws IOException {
		this.setLayout(null);
		this.searchPwdFrame = searchPwdFrame;	     
	     
		//�� ���� TODO
		this.searchIdLabel    = new JLabel("ID");
		this.searchemailLabel = new JLabel("Email");
	
//		�ؽ�Ʈ �ʵ����
		this.searchIdTextField      = new JTextField(10);
		this.searchemailTextField   = new JTextField(10);
		this.searchConfirmTextField = new JTextField(10);
		
		this.add(searchIdLabel);
		this.add(searchemailLabel);
		
//		//���� �޼��� ���̺�
		String searchErrorMsg = "<html>3���ʰ��� �Ǿ����ϴ�.<br>�ٽ� ������ �޾� �ּ���<br></html>";
		this.searchErrorMsgLabel = new JLabel(searchErrorMsg);
		this.searchErrorMsgLabel.setForeground(searchPwdEnum.LABELCOLOR_ERROR.getColor());
		
		String searchAnswer = "<html>������ �̸��Ϸ� "
				           + "<br>������ȣ�� �߼۵Ǿ����ϴ�.<br></html>";
		this.searchAnswerMsg = new JLabel(searchAnswer);
		this.searchAnswerMsg.setForeground(searchPwdEnum.LABELCOLOR_DEFAULT.getColor());
		
		String time = "3:00";
		this.searchTimeLabel = new JLabel(time);
		this.searchTimeLabel.setForeground(searchPwdEnum.LABELCOLOR_ERROR.getColor());
		

		//this.add(searchConfirmButton);
		
		
		//���̺� ��Ʈ
		Font default_Font  = searchPwdEnum.LABELFONT_DEFAULT.getFont(); //�Ϲ�
		Font error_FONT    = searchPwdEnum.LABELFONT_ERROR.getFont(); //����
		this.searchIdLabel.setFont(default_Font);
		this.searchemailLabel.setFont(default_Font);
		this.searchErrorMsgLabel.setFont(error_FONT);
//		
//		// �ؽ�Ʈ ��Ʈ
		this.searchemailTextField.setFont(default_Font);
		this.searchIdTextField.setFont(default_Font);
		this.searchConfirmTextField.setFont(default_Font);
		
		this.searchErrorMsgLabel.setFont(error_FONT);
		this.searchAnswerMsg.setFont(error_FONT);
		
//		
//		//�ؽ�Ʈ �ʵ� �׵θ� ���ֱ�
		EmptyBorder emptyBorder = searchPwdEnum.LABEL_DEFAULT.getBorder();
		searchIdTextField.setBorder(emptyBorder);
		//this.searchIdTextField.setOpaque(true);
		searchemailTextField.setBorder(emptyBorder);
		//this.searchemailTextField.setOpaque(true);
		searchConfirmTextField.setBorder(emptyBorder);
		//this.searchConfirmTextField.setOpaque(true);
		
		
//		//���̺�, �ؽ�Ʈ, ��ư �ҷ�����
		this.setLabelPosition();
		this.setTextFieldPosition();
		this.setButtonPosition();
	 
	}
//	//�̸�, �̸��� , ���� �޼���  ���̺�!!!!!! ��ġ �� ũ��
		public void setLabelPosition() {
			this.searchIdLabel.setBounds(searchPwdEnum.SEARCH_ID_LABEL.getRectangle());
			this.searchemailLabel.setBounds(searchPwdEnum.SEARCH_EMAIL_LABEL.getRectangle());
			this.searchErrorMsgLabel.setBounds(searchPwdEnum.SEARCH_ERROR_LABEL.getRectangle());
			this.searchAnswerMsg.setBounds(searchPwdEnum.SEARCH_ANSWER_LABEL.getRectangle());
			this.searchTimeLabel.setBounds(searchPwdEnum.SEARCH_Time_LABEL.getRectangle());
			this.add(searchIdLabel);
			this.add(searchemailLabel);
			this.add(searchErrorMsgLabel);
			this.add(searchAnswerMsg);
			this.add(searchTimeLabel);
			this.searchIdLabel.setOpaque(false);
	    }
		
//	// �̸� �̸���, ���� �ؽ�Ʈ�ʵ�!!!!!!!!!!!!!! ��ġ �� ũ��
	    public void setTextFieldPosition() {
	    	this.searchIdTextField.setBounds(searchPwdEnum.SEARCH_ID_TEXTFIELD.getRectangle());
	    	this.searchemailTextField.setBounds(searchPwdEnum.SEARCH_EMAIL_TEXTFIELD.getRectangle());
	    	this.searchConfirmTextField.setBounds(searchPwdEnum.SEARCH_CONFIRM_TEXTFIELD.getRectangle());
	    	this.add(searchIdTextField);
	    	this.add(searchemailTextField);
	    	this.add(searchConfirmTextField);
	    }
	
	    public void setButtonPosition() throws IOException {   	
			//��ư ����
			this.searchConfirmButton  = new JButton();
			
			this.searchConfirmButton.setBorderPainted(false);
			this.searchConfirmButton.setFocusPainted(false);
			this.searchConfirmButton.setContentAreaFilled(false);
	    	this.searchConfirmButton.setIconTextGap(this.searchConfirmButton.getIconTextGap() - 15);    	
	    	this.searchConfirmButton.setIcon(
	    			new ImageIcon(ImageIO.read(
	    				new File("resources/signUp/up_up_confirm.jpg")).getScaledInstance(
	    						searchPwdEnum.SEARCH_CONFIRM_BUTTON.getRectangle().width,
	    						searchPwdEnum.SEARCH_CONFIRM_BUTTON.getRectangle().height,
	    					Image.SCALE_AREA_AVERAGING))
	    		);
	    	this.searchConfirmButton.setBounds(searchPwdEnum.SEARCH_CONFIRM_BUTTON.getRectangle()); 
	    	this.add(searchConfirmButton);    	 
	    }   
	    
	    public SearchPwdFrame getSearchPwdMain() {
	    	return searchPwdFrame;
	    }
	    
	}

