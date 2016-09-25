package frames.serchFrames;


import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import actions.findIDandPW.FindIDAction;
import enums.frames.SearchIdEnum;
import frames.LoginPanel;

public class SearchIdFrame extends JFrame {
	private JLabel searchIdLabel;
	private JLabel searchemailLabel;
	private JLabel searchErrorMsgLabel;
	
	private JTextField searchIdTextField;
	private JTextField searchemailTextField;
	private String searchError;
	
	private JButton searchConfirmButton;
	private Image backGround;
	
	private FindIDAction findIDAction;

	public SearchIdFrame(LoginPanel loginPanel) throws IOException {
		this.findIDAction = new FindIDAction(this);
		
		//�� ����
		this.searchIdLabel        = new JLabel("�̸�");
		this.searchemailLabel     = new JLabel("Email"); 

		//�ؽ�Ʈ �ʵ����
		this.searchIdTextField    = new JTextField(10);
		this.searchemailTextField = new JTextField(10);
		
		//���� �޼��� ���̺�
		this.searchError = "ID,Pwd �Է� ����";
		this.searchErrorMsgLabel = new JLabel(searchError);
		this.searchErrorMsgLabel.setForeground(SearchIdEnum.LABELCOLOR_ERROR.getColor());
		
		//��ư ����
		searchConfirmButton  = new JButton();
		searchConfirmButton.setBorderPainted(false);
		searchConfirmButton.setFocusPainted(false);
		searchConfirmButton.setContentAreaFilled(false);
		
		this.add(searchConfirmButton);
		
		//��Ʈ
		Font defaultFont = SearchIdEnum.LABELFONT_DEFAULT.getFont();
		Font errorFont = SearchIdEnum.LABELFONT_ERROR.getFont();
		this.searchIdLabel.setFont(defaultFont);
		this.searchemailLabel.setFont(defaultFont);
		this.searchErrorMsgLabel.setFont(errorFont);
		
		this.searchemailTextField.setFont(defaultFont);
		this.searchIdTextField.setFont(defaultFont);
	   
	    //���ȭ��	
		
		backGround = ImageIO.read(new File("resources/background/popup.png")).getScaledInstance(
				SearchIdEnum.SEARCHFRAME_SIZE_WIDTH.getSize(),
				SearchIdEnum.SEARCHFRAME_SIZE_HEIGHT.getSize(),
                Image.SCALE_SMOOTH);

		this.setContentPane(new JLabel(new ImageIcon(backGround)));
				
		this.setBounds(
			   SearchIdEnum.SEARCHFRAME_POSITION_X.getSize(),
			   SearchIdEnum.SEARCHFRAME_POSITION_Y.getSize(),
			   SearchIdEnum.SEARCHFRAME_SIZE_WIDTH.getSize(),
			   SearchIdEnum.SEARCHFRAME_SIZE_HEIGHT.getSize()
		);
		
		//���̺�, �ؽ�Ʈ, ��ư �ҷ�����
			    this.setLabelPosition();
			    this.setTextFieldPosition();
			    this.setButtonPosition();
				
				this.setLayout(null);
			    this.setTitle("���̵�ã��");
			    this.setVisible(true);
			    this.setResizable(false);	   
			 
	}
	//�̸�, �̸��� , ���� �޼��� ��ġ �� ũ��
	public void setLabelPosition() {
		this.searchIdLabel.setBounds(SearchIdEnum.SEARCH_ID_LABEL.getRectangle());
		this.searchemailLabel.setBounds(SearchIdEnum.SEARCH_EMAIL_LABEL.getRectangle());
		this.searchErrorMsgLabel.setBounds(SearchIdEnum.SEARCH_ERROR_LABEL.getRectangle());
		this.add(searchIdLabel);
		this.add(searchemailLabel);
		this.add(searchErrorMsgLabel);
    }
	// �̸� �̸��� ��ġ �� ũ��
    public void setTextFieldPosition() {
    	this.searchIdTextField.setBounds(SearchIdEnum.SEARCH_ID_TEXTFIELD.getRectangle());
    	this.searchemailTextField.setBounds(SearchIdEnum.SEARCH_EMAIL_TEXTFIELD.getRectangle());
    	this.add(searchIdTextField);
    	this.add(searchemailTextField);
    }
	    
    public void setButtonPosition() throws IOException {
    	
    	// ��ư�̹��� ©���°� �̹��� �����̵����� �ذ�����
    	this.searchConfirmButton.setIconTextGap(this.searchConfirmButton.getIconTextGap() - 15);
    	

    	this.searchConfirmButton.setIcon(
    			new ImageIcon(ImageIO.read(
    				new File("resources/signUp/confirm.jpg")).getScaledInstance(
    						SearchIdEnum.SEARCH_CONFIRM_BUTTON.getRectangle().width,
    						SearchIdEnum.SEARCH_CONFIRM_BUTTON.getRectangle().height,
    						Image.SCALE_AREA_AVERAGING))
    		);
    	this.searchConfirmButton.setBounds(SearchIdEnum.SEARCH_CONFIRM_BUTTON.getRectangle());
    	this.add(searchConfirmButton);    	 
    }
    
    public void searchFailLabelReset(){
		String init = "";
		this.searchErrorMsgLabel.setText(init);
	}
    
    
    public String getsearchError() {
    	return searchError;
    }
    public JLabel getErrorMsgLabel(){
    	return searchErrorMsgLabel;
    }
    
    public JButton getConfirmButton() {
    	return searchConfirmButton;
    }
    
    public JTextField getEmailField() {
    	return searchemailTextField;
    }
    
    public JTextField getIdField() {
    	return searchIdTextField;
    }
//    
//	public static void main(String[] args) throws IOException {
//		new SearchIdFrame();
//	}

}
