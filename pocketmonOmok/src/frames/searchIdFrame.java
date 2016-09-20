package frames;


import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



import enums.ClientJoinSizesEnum;
import enums.searchIdEnum;

public class searchIdFrame extends JFrame {
	private JLabel searchIdLabel;
	private JLabel searchemailLabel;
	private JLabel searchErrorMsgLabel;
	
	private JTextField searchIdTextField;
	private JTextField searchemailTextField;
	
	private JButton searchConfirmButton;
	private Image backGround;
	
	
	public searchIdFrame() throws IOException {
		//�� ����
		this.searchIdLabel        = new JLabel("�̸�");
		this.searchemailLabel     = new JLabel("Email"); 

		//�ؽ�Ʈ �ʵ����
		this.searchIdTextField    = new JTextField(10);
		this.searchemailTextField = new JTextField(10);
		
		//���� �޼��� ���̺�
		String searchError = "error Mess age";
		this.searchErrorMsgLabel = new JLabel(searchError);
		this.searchErrorMsgLabel.setForeground(searchIdEnum.LABELCOLOR_ERROR.getColor());
		
		//��ư ����
		searchConfirmButton  = new JButton();
		searchConfirmButton.setBorderPainted(false);
		searchConfirmButton.setFocusPainted(false);
		searchConfirmButton.setContentAreaFilled(false);
		
		this.add(searchConfirmButton);
		
		//��Ʈ
		Font font = searchIdEnum.LABELFONT_DEFAULT.getFont();
		this.searchIdLabel.setFont(font);
		this.searchemailLabel.setFont(font);
		this.searchErrorMsgLabel.setFont(font);
		
		this.searchemailTextField.setFont(font);
		this.searchIdTextField.setFont(font);
		
		//�ؽ�Ʈ �ʵ� �׵θ� ���ֱ�
		EmptyBorder emptyBorder = searchIdEnum.LABEL_DEFAULT.getBorder();
		
		searchIdTextField.setBorder(emptyBorder);
		searchemailTextField.setBorder(emptyBorder);
		
	      
	    //���ȭ��	
		backGround = ImageIO.read(new File("resources/signUp/backg.png")).getScaledInstance(
				searchIdEnum.SEARCHFRAME_SIZE_WIDTH.getSize(),
				searchIdEnum.SEARCHFRAME_SIZE_HEIGHT.getSize(),
                Image.SCALE_SMOOTH);

		this.setContentPane(new JLabel(new ImageIcon(backGround)));
				
		this.setBounds(
			   searchIdEnum.SEARCHFRAME_POSITION_X.getSize(),
			   searchIdEnum.SEARCHFRAME_POSITION_Y.getSize(),
			   searchIdEnum.SEARCHFRAME_SIZE_WIDTH.getSize(),
			   searchIdEnum.SEARCHFRAME_SIZE_HEIGHT.getSize()
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
			this.searchIdLabel.setBounds(searchIdEnum.SEARCH_ID_LABEL.getRectangle());
			this.searchemailLabel.setBounds(searchIdEnum.SEARCH_EMAIL_LABEL.getRectangle());
			this.searchErrorMsgLabel.setBounds(searchIdEnum.SEARCH_ERROR_LABEL.getRectangle());
			this.add(searchIdLabel);
			this.add(searchemailLabel);
			this.add(searchErrorMsgLabel);
	    }
	// �̸� �̸��� ��ġ �� ũ��
	    public void setTextFieldPosition() {
	    	this.searchIdTextField.setBounds(searchIdEnum.SEARCH_ID_TEXTFIELD.getRectangle());
	    	this.searchemailTextField.setBounds(searchIdEnum.SEARCH_EMAIL_TEXTFIELD.getRectangle());
	    	this.add(searchIdTextField);
	    	this.add(searchemailTextField);
	    }
	    
	    public void setButtonPosition() throws IOException {
	    	
	    	// ��ư�̹��� ©���°� �̹��� �����̵����� �ذ�����
	    	
	    	this.searchConfirmButton.setIconTextGap(this.searchConfirmButton.getIconTextGap() - 15);
	    	

	    	this.searchConfirmButton.setIcon(
	    			new ImageIcon(ImageIO.read(
	    				new File("resources/signUp/confirm.jpg")).getScaledInstance(
	    						searchIdEnum.SEARCH_CONFIRM_BUTTON.getRectangle().width,
	    						searchIdEnum.SEARCH_CONFIRM_BUTTON.getRectangle().height,
	    						Image.SCALE_AREA_AVERAGING))
	    		);
	    	this.searchConfirmButton.setBounds(searchIdEnum.SEARCH_CONFIRM_BUTTON.getRectangle());
	    	this.add(searchConfirmButton);    	 
	    }
	   
	public static void main(String[] args) throws IOException {
		new searchIdFrame();

	}

}
