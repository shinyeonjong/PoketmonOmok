package frames;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import datas.UserPersonalInfoDTO;
import actions.login.LoginAction;
import enums.LoginFrameSizesEnum;
import enums.UserPositionEnum;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
	private JButton joinButton;
	private JButton loginButton;    
	private JButton searchIdButton;  
	private JButton searchPwButton; 
	private JButton idImage;      
	private JButton passwordImage;  
	
	private JTextField idField;
	private JPasswordField pwField;
	
	private Font textFieldFont;
	private Font loginFailFont;
	
	private JTextArea loginFailText;
	
	//�̹��� ȭ�� ������ ���缭 �ٲ�� �ϱ� ���� �̹��� ���
	private Image ID, IDreimage, PW, PWreimage;
	private Image join, joinreimage;
	private Image login, loginreimage;
	private Image searchid, searchidreimage;
	private Image searchpw, searchpwreimage;
	
	//�׽�Ʈ�� ��Ʈ������
	private String dataId;
	private String dataPw;
	private String putId;
	private String putPw;
	
	private JPanel loginPanel;
	private BasicFrame basicFrame;
	
	private LoginAction loginAction;
	
	public LoginPanel(BasicFrame basicFrame) throws IOException {
		this.loginAction = new LoginAction(this);
		
		this.loginPanel	= new JPanel();
		this.dataId     = new String("1234");
		this.dataPw     = new String("1234");   
		
		this.loginPanel.setLayout(null);
		this.loginPanel.setOpaque(false);
		this.basicFrame = basicFrame;
		//������ ȭ�� ��� ��ġ ����
		
		
		UserPersonalInfoDTO dto = new UserPersonalInfoDTO(UserPositionEnum.POSITION_LOGIN);
		dto.setUserID("test");
		dto.setUserPasswd("1234");
		this.basicFrame.getClientSender().getClientOS().writeObject(dto);
		
		this.setBounds(   
		      LoginFrameSizesEnum.LOGIN_FRAME_POSITION_X.getSize(),
		      LoginFrameSizesEnum.LOGIN_FRAME_POSITION_Y.getSize(),
		      LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize(), 
		      LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize()
		);
		
		//���̵�, ��й�ȣ �Է��ϴ� �ؽ�Ʈ�ʵ� ����
		this.setTextFieldPosition();
		
		//�α���, ȸ������, ���̵�ã��, ��й�ȣ ã�� ��ư ��ġ ����
		this.setButtonPosition();
		
		//���̵�, ��й�ȣ �Է� �˷��ִ� �̹��� ����
		this.setIdPwImagePositon();
		
		this.add(this.loginPanel);
		this.setLayout(new CardLayout());

	}
	
	//���̵� �Ǵ� ��й�ȣ ������ �˷��ִ� �ؽ�Ʈ
	public void loginFail(){
		this.setLayout(null);
		this.loginFailText = new JTextArea();
		this.textFieldFont = new Font("", Font.BOLD, 20);      
		this.loginFailText.setBounds(
					LoginFrameSizesEnum.LOGIN_FAIL_TEXT_POSITION_X.getSize(),
					LoginFrameSizesEnum.LOGIN_FAIL_TEXT_POSITION_Y.getSize(),
					LoginFrameSizesEnum.LOGIN_FAIL_TEXT_WIDTH.getSize(), 
					LoginFrameSizesEnum.LOGIN_FAIL_TEXT_HEIGTH.getSize()
		);
		this.add(this.loginFailText);
		
		this.loginFailFont = new Font("", Font.PLAIN, 13);
		this.loginFailText.setFont(loginFailFont);
		this.loginFailText.setForeground(Color.RED);
		this.loginFailText.setBackground(Color.BLACK);
		this.loginFailText.setText("���̵� �Ǵ� ��й�ȣ ����");
	}
	
	public void loginFailTextReset(){
		this.loginFailText.setText("");
	}
	
	public void setIdPwImagePositon() throws IOException{
		this.ID        = ImageIO.read(new File("resources/login/ID.png"));
		this.IDreimage = this.ID.getScaledInstance(
			               LoginFrameSizesEnum.SIZE_LABEL_WIDTH.getSize(),
			               LoginFrameSizesEnum.SIZE_LABEL_HEIGHT.getSize(),
			               Image.SCALE_SMOOTH);
		
		this.idImage   = new JButton(new ImageIcon(this.IDreimage));
		
		//���̵� �̹��� ��ġ ����
		this.idImage.setBounds(
					LoginFrameSizesEnum.LOGIN_RESOURCE_ID_POSITION_X.getSize(),
					LoginFrameSizesEnum.LOGIN_RESOURCE_ID_POSITION_Y.getSize(),
					LoginFrameSizesEnum.SIZE_LABEL_WIDTH.getSize(), 
					LoginFrameSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		
		this.idImage.setBorderPainted(false);
		this.idImage.setContentAreaFilled(false);
		this.idImage.setFocusPainted(false);
		
		this.PW        = ImageIO.read(new File("resources/login/PW.png"));
		this.PWreimage = PW.getScaledInstance(
					LoginFrameSizesEnum.SIZE_LABEL_WIDTH.getSize(), 
					LoginFrameSizesEnum.SIZE_LABEL_HEIGHT.getSize(),
					Image.SCALE_SMOOTH);
		
		this.passwordImage = new JButton(new ImageIcon(this.PWreimage));  
		
		//��й�ȣ �̹��� ��ġ ����
		this.passwordImage.setBounds(
					LoginFrameSizesEnum.LOGIN_RESOURCE_PASSWORD_POSITION_X.getSize(),
					LoginFrameSizesEnum.LOGIN_RESOURCE_PASSWORD_POSITION_Y.getSize(), 
					LoginFrameSizesEnum.SIZE_LABEL_WIDTH.getSize(), 
					LoginFrameSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		
		this.passwordImage.setBorderPainted(false);
		this.passwordImage.setContentAreaFilled(false);
		this.passwordImage.setFocusPainted(false);
		
		this.loginPanel.add(this.idImage);
		this.loginPanel.add(this.passwordImage);
	}
	
	public void setButtonPosition() throws IOException{
	   //�̹��� ���� ��ȯ
		this.login  	  = ImageIO.read(new File("resources/login/login.jpg"));
		this.loginreimage = login.getScaledInstance(
		               LoginFrameSizesEnum.LOGIN_ICON_WIDTH.getSize(),
		               LoginFrameSizesEnum.LOGIN_ICON_HEIGHT.getSize(),
		               Image.SCALE_AREA_AVERAGING);
		this.loginButton = new JButton(new ImageIcon(this.loginreimage));
	  
		this.join 		 = ImageIO.read(new File("resources/login/signup.png"));
		this.joinreimage = join.getScaledInstance(
		               LoginFrameSizesEnum.ICON_SIZE_WIDTH.getSize(),
		               LoginFrameSizesEnum.ICON_SIZE_HEIGHT.getSize(),
		               Image.SCALE_AREA_AVERAGING);
		this.joinButton = new JButton(new ImageIcon(this.joinreimage));
		
		this.searchid 		 = ImageIO.read(new File("resources/login/forgotID.png"));
		this.searchidreimage = searchid.getScaledInstance(
		               LoginFrameSizesEnum.ICON_SIZE_WIDTH.getSize(),
		               LoginFrameSizesEnum.ICON_SIZE_HEIGHT.getSize(),
		               Image.SCALE_AREA_AVERAGING);
		this.searchIdButton = new JButton(new ImageIcon(this.searchidreimage));
		
		this.searchpw  		 = ImageIO.read(new File("resources/login/forgotPW.png"));
		this.searchpwreimage = searchpw.getScaledInstance(
		               LoginFrameSizesEnum.ICON_SIZE_WIDTH.getSize(),
		               LoginFrameSizesEnum.ICON_SIZE_HEIGHT.getSize(),
		               Image.SCALE_AREA_AVERAGING);
		this.searchPwButton = new JButton(new ImageIcon(this.searchpwreimage));
		
		//�α��� ��ư ��ġ ����
		this.loginButton.setBounds(
					LoginFrameSizesEnum.LOGIN_RESOURCE_LOGIN_BUTTON_POSITION_X.getSize(),
					LoginFrameSizesEnum.LOGIN_RESOURCE_LOGIN_BUTTON_POSITION_Y.getSize(),
					LoginFrameSizesEnum.LOGIN_ICON_WIDTH.getSize(), 
					LoginFrameSizesEnum.LOGIN_ICON_HEIGHT.getSize()
		);
			
		this.loginButton.setBorderPainted(false);
		this.loginButton.setContentAreaFilled(false);
		this.loginButton.setFocusPainted(false);
		this.loginButton.setToolTipText("�α���");
		
		//���߿� �׼� ��� �Ҷ� this�� ������ ��
		this.loginButton.addActionListener(this.loginAction);
		
		//ȸ������ ��ư ��ġ ����
		this.joinButton.setBounds(
					LoginFrameSizesEnum.LOGIN_RESOURCE_JOIN_BUTTON_POSITION_X.getSize(),
					LoginFrameSizesEnum.LOGIN_RESOURCE_JOIN_BUTTON_POSITION_Y.getSize(),
					LoginFrameSizesEnum.ICON_SIZE_WIDTH.getSize(), 
					LoginFrameSizesEnum.ICON_SIZE_HEIGHT.getSize()
		);
		
		this.joinButton.setBorderPainted(false);
		this.joinButton.setContentAreaFilled(false);
		this.joinButton.setFocusPainted(false);
		this.joinButton.setToolTipText("ȸ������");
		
		this.joinButton.addActionListener(this.loginAction);
		
		//���̵�ã�� ��ư ��ġ ����
		this.searchIdButton.setBounds(
					LoginFrameSizesEnum.LOGIN_RESOURCE_SEARCHID_BUTTON_POSITION_X.getSize(),
					LoginFrameSizesEnum.LOGIN_RESOURCE_SEARCHID_BUTTON_POSITION_Y.getSize(),
					LoginFrameSizesEnum.ICON_SIZE_WIDTH.getSize(), 
					LoginFrameSizesEnum.ICON_SIZE_HEIGHT.getSize()
		);
		
		this.searchIdButton.setBorderPainted(false);
		this.searchIdButton.setContentAreaFilled(false);
		this.searchIdButton.setFocusPainted(false);
		this.searchIdButton.setToolTipText("���̵� ã��");
		
		this.searchIdButton.addActionListener(this.loginAction);
		
		//��й�ȣã�� ��ư ��ġ ����
		this.searchPwButton.setBounds(
					LoginFrameSizesEnum.LOGIN_RESOURCE_SEARCHPW_BUTTON_POSITION_X.getSize(),
					LoginFrameSizesEnum.LOGIN_RESOURCE_SEARCHPW_BUTTON_POSITION_Y.getSize(),
					LoginFrameSizesEnum.ICON_SIZE_WIDTH.getSize(), 
					LoginFrameSizesEnum.ICON_SIZE_HEIGHT.getSize()
		);
		
		this.searchPwButton.setBorderPainted(false);
		this.searchPwButton.setContentAreaFilled(false);
		this.searchPwButton.setFocusPainted(false);
		this.searchPwButton.setToolTipText("��й�ȣ ã��");
		
		this.searchPwButton.addActionListener(this.loginAction);     
		
		this.loginPanel.add(this.loginButton);
		this.loginPanel.add(this.joinButton);
		this.loginPanel.add(this.searchIdButton);
		this.loginPanel.add(this.searchPwButton);
	}
	
	public void setTextFieldPosition(){		
		this.idField = new JTextField("", 10);
		this.pwField = new JPasswordField("", 10);
		
		//���̵� �Է�â
		this.idField.setBounds(
					LoginFrameSizesEnum.LOGIN_RESOURCE_ID_FIELD_POSITION_X.getSize(),
					LoginFrameSizesEnum.LOGIN_RESOURCE_ID_FIELD_POSITION_Y.getSize(),
					LoginFrameSizesEnum.SIZE_TEXT_WIDTH.getSize(), 
					LoginFrameSizesEnum.SIZE_TEXT_HEIGHT.getSize()
		);
		this.idField.setFont(this.textFieldFont);
		
		//��й�ȣ �Է�â
		this.pwField.setBounds(
					LoginFrameSizesEnum.LOGIN_RESOURCE_PW_FIELD_POSITION_X.getSize(),
					LoginFrameSizesEnum.LOGIN_RESOURCE_PW_FIELD_POSITION_Y.getSize(),
					LoginFrameSizesEnum.SIZE_TEXT_WIDTH.getSize(), 
					LoginFrameSizesEnum.SIZE_TEXT_HEIGHT.getSize()
		);
		this.pwField.setFont(this.textFieldFont);
		
		this.loginPanel.add(this.idField);
		this.loginPanel.add(this.pwField);
	   
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public JTextField getIdField() {
		return idField;
	}

	public JPasswordField getPwField() {
		return pwField;
	}

	public String getDataId() {
		return dataId;
	}

	public String getDataPw() {
		return dataPw;
	}

	public BasicFrame getBasicFrame() {
		return basicFrame;
	}
}
