package frames;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import enums.LoginFrameSizesEnum;
// �¼�

@SuppressWarnings("serial")
public class LoginFrame extends JFrame implements ActionListener{
   
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
   
   private Image image;
   private Image reimage;
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

   public LoginFrame() throws IOException {
      this.dataId            = new String("ceterman");
      this.dataPw            = new String("1234");
      
      this.textFieldFont     = new Font("", Font.BOLD, 20);
      
      this.loginFailText      = new JTextArea();
         
      
      //����̹��� ������� �ػ󵵿� ���� �����ǰ� ����
      image = ImageIO.read(new File("resources/login/background.jpg"));
      reimage = image.getScaledInstance(
                     LoginFrameSizesEnum.LOGIN_FRAME_SIZE_WIDTH.getSize(),
                     LoginFrameSizesEnum.LOGIN_FRAME_SIZE_HEIGHT.getSize(),
                     Image.SCALE_SMOOTH);
         
      this.setContentPane(new JLabel(new ImageIcon(reimage)));   
      
      //������ ȭ�� ��� ��ġ ����
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
      
      this.setLayout(null);
      this.setTitle("Login");
      this.setVisible(true);
      this.setResizable(false);
   }   
   
   @Override
   public void actionPerformed(ActionEvent e) {
      this.putId = idField.getText();
      this.putPw = new String(pwField.getPassword());
      
      if(this.loginButton == e.getSource()) {
         if(putId.equals(dataId) && putPw.equals(dataPw)){
         new LoginAccess();
               
         //�α��� ���� �ڿ� ���̵� �ؽ�Ʈ�ʵ� �ʱ�ȭ
         this.idField.setText("");
         //�α��� �����ڿ� ��й�ȣ �ؽ�Ʈ�ʵ� �ʱ�ȭ
         this.pwField.setText("");
            
         }  if(!(putId.equals(dataId)) && putPw.equals(dataPw)) {
            this.loginFail();
         } else if(!(putPw.equals(dataPw)) && putId.equals(dataId)) {
            this.loginFail();
         } else {
            this.loginFail();
         }
      }
   }
   
   public void loginFail(){
      this.setLayout(null);
      this.loginFailText.setBounds(572, 415, 155, 15);
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
      ID        = ImageIO.read(new File("resources/login/ID.png"));
      IDreimage = ID.getScaledInstance(
                     LoginFrameSizesEnum.SIZE_LABEL_WIDTH.getSize(),
                     LoginFrameSizesEnum.SIZE_LABEL_HEIGHT.getSize(),
                     Image.SCALE_SMOOTH);
      
      this.idImage       = new JButton(new ImageIcon(IDreimage));
      
      PW         = ImageIO.read(new File("resources/login/PW.png"));
      PWreimage = PW.getScaledInstance(
                     LoginFrameSizesEnum.SIZE_LABEL_WIDTH.getSize(), 
                     LoginFrameSizesEnum.SIZE_LABEL_HEIGHT.getSize(),
                     Image.SCALE_SMOOTH);
      
      this.passwordImage    = new JButton(new ImageIcon(PWreimage));
      
      
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
      
      this.add(this.idImage);
      this.add(this.passwordImage);
   }
   
   public void setButtonPosition() throws IOException{
      this.join  = ImageIO.read(new File("resources/login/signup.png"));
      this.joinreimage = join.getScaledInstance(
                     LoginFrameSizesEnum.LOGIN_ICON_WIDTH.getSize(),
                     LoginFrameSizesEnum.SIZE_JOIN_ICON_HEIGTH.getSize(),
                     Image.SCALE_AREA_AVERAGING);
      this.joinButton    = new JButton(new ImageIcon(joinreimage));
      
      this.login  = ImageIO.read(new File("resources/login/login.jpg"));
      this.loginreimage = login.getScaledInstance(
                     LoginFrameSizesEnum.LOGIN_ICON_WIDTH.getSize(),
                     LoginFrameSizesEnum.LOGIN_ICON_HEIGHT.getSize(),
                     Image.SCALE_AREA_AVERAGING);
      this.loginButton    = new JButton(new ImageIcon(loginreimage));
      
      this.searchid  = ImageIO.read(new File("resources/login/forgotID.png"));
      this.searchidreimage = searchid.getScaledInstance(
                     LoginFrameSizesEnum.LOGIN_ICON_WIDTH.getSize(),
                     LoginFrameSizesEnum.SIZE_JOIN_ICON_HEIGTH.getSize(),
                     Image.SCALE_AREA_AVERAGING);
      this.searchIdButton = new JButton(new ImageIcon(searchidreimage));
      
      this.searchpw  = ImageIO.read(new File("resources/login/forgotPW.png"));
      this.searchpwreimage = searchpw.getScaledInstance(
                     LoginFrameSizesEnum.SIZE_PW_ICON_WIDTH.getSize(),
                     LoginFrameSizesEnum.SIZE_JOIN_ICON_HEIGTH.getSize(),
                     Image.SCALE_AREA_AVERAGING);
      this.searchPwButton = new JButton(new ImageIcon(searchpwreimage));
      
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
      this.loginButton.addActionListener(this);
      
      //ȸ������ ��ư ��ġ ����
      this.joinButton.setBounds(
            LoginFrameSizesEnum.LOGIN_RESOURCE_JOIN_BUTTON_POSITION_X.getSize(),
            LoginFrameSizesEnum.LOGIN_RESOURCE_JOIN_BUTTON_POSITION_Y.getSize(),
                LoginFrameSizesEnum.LOGIN_ICON_WIDTH.getSize(), 
                LoginFrameSizesEnum.SIZE_JOIN_ICON_HEIGTH.getSize()
        );
      
      this.joinButton.setBorderPainted(false);
      this.joinButton.setContentAreaFilled(false);
      this.joinButton.setFocusPainted(false);
      this.joinButton.setToolTipText("ȸ������");
      
      //���̵�ã�� ��ư ��ġ ����
      this.searchIdButton.setBounds(
            LoginFrameSizesEnum.LOGIN_RESOURCE_SEARCHID_BUTTON_POSITION_X.getSize(),
            LoginFrameSizesEnum.LOGIN_RESOURCE_SEARCHID_BUTTON_POSITION_Y.getSize(),
                LoginFrameSizesEnum.LOGIN_ICON_WIDTH.getSize(), 
                LoginFrameSizesEnum.SIZE_JOIN_ICON_HEIGTH.getSize()
        );
      
      this.searchIdButton.setBorderPainted(false);
      this.searchIdButton.setContentAreaFilled(false);
      this.searchIdButton.setFocusPainted(false);
      this.searchIdButton.setToolTipText("���̵� ã��");
      
      //��й�ȣã�� ��ư ��ġ ����
      this.searchPwButton.setBounds(
            LoginFrameSizesEnum.LOGIN_RESOURCE_SEARCHPW_BUTTON_POSITION_X.getSize(),
            LoginFrameSizesEnum.LOGIN_RESOURCE_SEARCHPW_BUTTON_POSITION_Y.getSize(),
                LoginFrameSizesEnum.SIZE_PW_ICON_WIDTH.getSize(), 
                LoginFrameSizesEnum.SIZE_JOIN_ICON_HEIGTH.getSize()
        );
      
      this.searchPwButton.setBorderPainted(false);
      this.searchPwButton.setContentAreaFilled(false);
      this.searchPwButton.setFocusPainted(false);
      this.searchPwButton.setToolTipText("��й�ȣ ã��");
      
      
      this.add(this.loginButton);
      this.add(this.joinButton);
      this.add(this.searchIdButton);
      this.add(this.searchPwButton);
   }
   
   public void setTextFieldPosition(){
      this.idField = new JTextField("", 10);
      this.pwField = new JPasswordField("", 10);
      
      this.idField.setBounds(
            LoginFrameSizesEnum.LOGIN_RESOURCE_ID_FIELD_POSITION_X.getSize(),
            LoginFrameSizesEnum.LOGIN_RESOURCE_ID_FIELD_POSITION_Y.getSize(),
                LoginFrameSizesEnum.SIZE_TEXT_WIDTH.getSize(), 
                LoginFrameSizesEnum.SIZE_TEXT_HEIGHT.getSize());
      this.idField.setFont(this.textFieldFont);
      
      this.pwField.setBounds(
            LoginFrameSizesEnum.LOGIN_RESOURCE_PW_FIELD_POSITION_X.getSize(),
            LoginFrameSizesEnum.LOGIN_RESOURCE_PW_FIELD_POSITION_Y.getSize(),
                LoginFrameSizesEnum.SIZE_TEXT_WIDTH.getSize(), 
                LoginFrameSizesEnum.SIZE_TEXT_HEIGHT.getSize());
      this.pwField.setFont(this.textFieldFont);

      this.add(this.idField);
      this.add(this.pwField);
   }
   
   public static void main(String[] args) {
      try {
         new LoginFrame();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}