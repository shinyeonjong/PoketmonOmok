package actions.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import datas.UserPersonalInfoDTO;
import enums.UserPositionEnum;
import frames.BasicFrame;
import frames.LoginPanel;

public class LoginAction implements ActionListener{
	private LoginPanel loginPanel;
	
	public LoginAction(LoginPanel loginPanel){
		this.loginPanel = loginPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// id�Է�ĭ�̳� pw�Է�ĭ �� �ϳ��� ����־ �Է��϶�� �޼��� ���.
		System.out.println(this.loginPanel.getIdField().getText().isEmpty());
		char[] passwd = this.loginPanel.getPwField().getPassword();
		String passwdStr = new String(passwd, 0, passwd.length);
		if(this.loginPanel.getIdField().getText().isEmpty() || passwdStr.isEmpty()) {
			this.loginPanel.loginFailTextReset();
			this.loginPanel.loginFail("���̵�� ��й�ȣ�� ��� �Է����ּ���.");
		} else {
			UserPersonalInfoDTO personalDTO = new UserPersonalInfoDTO(UserPositionEnum.POSITION_LOGIN);
			personalDTO.setUserID(this.loginPanel.getIdField().getText());
			personalDTO.setUserPasswd(passwdStr);
			try {
				this.loginPanel.getBasicFrame().getClientOS().writeObject(personalDTO);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}