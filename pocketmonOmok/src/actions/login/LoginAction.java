package actions.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import frames.BasicFrame;
import frames.LoginPanel;

public class LoginAction implements ActionListener{
	private LoginPanel loginPanel;
	
	public LoginAction(LoginPanel loginPanel){
		this.loginPanel = loginPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		//getPassword() �� �ϸ� String�� char[]�� �������� ������ char[]�ڷ����� passwd ������ �־��д�.
		char[] passwd = this.loginPanel.getPwField().getPassword();

		if(this.loginPanel.getLoginButton() == e.getSource()) {
			
			if(this.loginPanel.getIdField().getText().equals(this.loginPanel.getDataId())
						//passwd������ �־�� getPassword���� String���·� ��ȯ�Ͽ� ���Ѵ�.
						&& new String(passwd, 0, passwd.length).equals(this.loginPanel.getDataPw())){
			
			this.loginPanel.getBasicFrame().inWaitingRoom();
				
			//�α��� ���� �ڿ� ���̵� �ؽ�Ʈ�ʵ� �ʱ�ȭ
			this.loginPanel.getIdField().setText("");
			//�α��� �����ڿ� ��й�ȣ �ؽ�Ʈ�ʵ� �ʱ�ȭ
			this.loginPanel.getPwField().setText("");       
			
			//this.loginFailText.setText("");
			} if(!(this.loginPanel.getIdField().getText().equals(this.loginPanel.getDataId())) 
						&& this.loginPanel.getPwField().getPassword().equals(this.loginPanel.getDataPw())) {
				this.loginPanel.loginFail();
				
			} else if(!(this.loginPanel.getPwField().getPassword().equals(this.loginPanel.getDataPw())) 
						&& this.loginPanel.getIdField().getText().equals(this.loginPanel.getDataId())) {
				this.loginPanel.loginFail();
				
			} else {
				this.loginPanel.loginFail();
			}
		}
	}
}
