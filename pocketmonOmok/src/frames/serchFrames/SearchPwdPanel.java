package frames.serchFrames;

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

import enums.frames.SearchIdEnum;
import enums.frames.SearchPwdEnum;

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
		
		//���� �޼��� ���̺�
		String searchErrorMsg = "<html>3���ʰ��� �Ǿ����ϴ�.<br>�ٽ� ������ �޾� �ּ���<br></html>";
		this.searchErrorMsgLabel = new JLabel(searchErrorMsg);
		this.searchErrorMsgLabel.setForeground(SearchPwdEnum.LABELCOLOR_ERROR.getColor());
		
		String searchAnswer = "<html>������ �̸��Ϸ� "
				           + "<br>������ȣ�� �߼۵Ǿ����ϴ�.<br></html>";
		this.searchAnswerMsg = new JLabel(searchAnswer);
		this.searchAnswerMsg.setForeground(SearchPwdEnum.LABELCOLOR_DEFAULT.getColor());
		
		String time = "3:00";
		this.searchTimeLabel = new JLabel(time);
		this.searchTimeLabel.setForeground(SearchPwdEnum.LABELCOLOR_ERROR.getColor());
		

		//this.add(searchConfirmButton);
		
		
		//���̺� ��Ʈ - searchIdEnum ���� �ҷ��Խ��ϴ�.
		Font default_Font  = SearchIdEnum.LABELFONT_DEFAULT.getFont(); //�Ϲ�
		Font error_FONT    = SearchIdEnum.LABELFONT_ERROR.getFont(); //����
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
		
		
//		//���̺�, �ؽ�Ʈ, ��ư �ҷ�����
		this.setLabelPosition();
		this.setTextFieldPosition();
		this.setButtonPosition();
	 
	}
//	//�̸�, �̸��� , ���� �޼���  ���̺�!!!!!! ��ġ �� ũ��
		public void setLabelPosition() {
			//���̵�� ��ġ�� ũ��
			this.searchIdLabel.setBounds(SearchPwdEnum.SEARCH_ID_LABEL.getRectangle());
			//�̸��� �� ��ġ �� ũ��
			this.searchemailLabel.setBounds(SearchPwdEnum.SEARCH_EMAIL_LABEL.getRectangle());
			//���� �޼��� ��ġ �� ũ��
			this.searchErrorMsgLabel.setBounds(SearchPwdEnum.SEARCH_ERROR_LABEL.getRectangle());
			//
			this.searchAnswerMsg.setBounds(SearchPwdEnum.SEARCH_ANSWER_LABEL.getRectangle());
			//3�� Ÿ�� ���� ��ġ �� ũ��
			this.searchTimeLabel.setBounds(SearchPwdEnum.SEARCH_Time_LABEL.getRectangle());
			this.add(searchIdLabel);
			this.add(searchemailLabel);
			this.add(searchErrorMsgLabel);
			this.add(searchAnswerMsg);
			this.add(searchTimeLabel);
			this.searchIdLabel.setOpaque(false);
	    }
		
//	// �̸� �̸���, ���� �ؽ�Ʈ�ʵ�!!!!!!!!!!!!!! ��ġ �� ũ��
	    public void setTextFieldPosition() {
	    	//���̵� �ؽ�Ʈ �ʵ�
	    	this.searchIdTextField.setBounds(SearchPwdEnum.SEARCH_ID_TEXTFIELD.getRectangle());
	    	//�̸��� �Է�â 
	    	this.searchemailTextField.setBounds(SearchPwdEnum.SEARCH_EMAIL_TEXTFIELD.getRectangle());
	    	//���� ��ȣ �Է�â
	    	this.searchConfirmTextField.setBounds(SearchPwdEnum.SEARCH_CONFIRM_TEXTFIELD.getRectangle());
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
	    				new File("resources/yesno/certify.kor.png")).getScaledInstance(
	    						SearchPwdEnum.SEARCH_CONFIRM_BUTTON.getRectangle().width,
	    						SearchPwdEnum.SEARCH_CONFIRM_BUTTON.getRectangle().height,
	    					Image.SCALE_AREA_AVERAGING))
	    		);
	    	this.searchConfirmButton.setBounds(SearchPwdEnum.SEARCH_CONFIRM_BUTTON.getRectangle()); 
	    	this.add(searchConfirmButton);    	 
	    }   
	    
	    public SearchPwdFrame getSearchPwdMain() {
	    	return searchPwdFrame;
	    }
	    
	}

