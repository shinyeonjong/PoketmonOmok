
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import datas.UserPersonalInfoDTO;
import enums.LoginSizesEnum;
import enums.UserPositionEnum;
import frames.JoinFrame;
import frames.LoginPanel;

public class LoginAction extends MouseAdapter implements ActionListener{
	private LoginPanel loginPanel;
	
	public LoginAction(LoginPanel loginPanel){
		this.loginPanel = loginPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// id�Է�ĭ�̳� pw�Է�ĭ �� �ϳ��� ����־ �Է��϶�� �޼��� ���.
		String buttonName = e.getSource().toString();
		if(buttonName.contains(LoginSizesEnum.BUTTON_NAME_LOGIN.getButtonName())) {
			this.loginAction();
		}
	}
	
	// �̹����� ���콺�� �ø��� ��ư �̹����� �ٲ�ϴ�.
	// �ԷµǴ� ��ư�� ȸ�������� ���, IDã���� ���, PWã���� ���.
	@Override
	public void mouseEntered(MouseEvent e) {
		String buttonName = e.getComponent().toString();
		try {
			if(buttonName.contains(LoginSizesEnum.BUTTON_NAME_SIGNUP.getButtonName())) {
				this.loginPanel.getJoinButton().setIcon(
					new ImageIcon(ImageIO.read(
						new File("resources/login/signupYellow.png")).getScaledInstance(
							LoginSizesEnum.ICON_SIZE_WIDTH.getSize(),
							LoginSizesEnum.ICON_SIZE_HEIGHT.getSize(),
							Image.SCALE_AREA_AVERAGING))
				);
				
			} else if(buttonName.contains(LoginSizesEnum.BUTTON_NAME_SEARCHID.getButtonName())) {
				this.loginPanel.getSearchIdButton().setIcon(
					new ImageIcon(ImageIO.read(
						new File("resources/login/forgotIDYellow.png")).getScaledInstance(
							LoginSizesEnum.ICON_SIZE_WIDTH.getSize(), 
							LoginSizesEnum.ICON_SIZE_HEIGHT.getSize(), 
							Image.SCALE_AREA_AVERAGING))
				);
				
			} else if(buttonName.contains(LoginSizesEnum.BUTTON_NAME_SEARCHPW.getButtonName())) {
				this.loginPanel.getSearchPwButton().setIcon(
					new ImageIcon(ImageIO.read(
						new File("resources/login/forgotPWYellow.png")).getScaledInstance(
							LoginSizesEnum.ICON_SIZE_WIDTH.getSize(), 
							LoginSizesEnum.ICON_SIZE_HEIGHT.getSize(), 
							Image.SCALE_AREA_AVERAGING))
				);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	// �̹������� ���콺�� ���� ���� �̹����� �ǵ��ư��ϴ�.
	// �ԷµǴ� ��ư�� ȸ�������� ���, IDã���� ���, PWã���� ���
	@Override
	public void mouseExited(MouseEvent e) {
		String buttonName = e.getComponent().toString();
		try {
			if(buttonName.contains(LoginSizesEnum.BUTTON_NAME_SIGNUP.getButtonName())) {
				this.loginPanel.getJoinButton().setIcon(
					new ImageIcon(ImageIO.read(
						new File("resources/login/signup.png")).getScaledInstance(
							LoginSizesEnum.ICON_SIZE_WIDTH.getSize(),
							LoginSizesEnum.ICON_SIZE_HEIGHT.getSize(),
							Image.SCALE_AREA_AVERAGING))
				);
			} else if(buttonName.contains(LoginSizesEnum.BUTTON_NAME_SEARCHID.getButtonName())) {
				this.loginPanel.getSearchIdButton().setIcon(
					new ImageIcon(ImageIO.read(
						new File("resources/login/forgotID.png")).getScaledInstance(
							LoginSizesEnum.ICON_SIZE_WIDTH.getSize(), 
							LoginSizesEnum.ICON_SIZE_HEIGHT.getSize(), 
							Image.SCALE_AREA_AVERAGING))
				);
			} else if(buttonName.contains(LoginSizesEnum.BUTTON_NAME_SEARCHPW.getButtonName())) {
				this.loginPanel.getSearchPwButton().setIcon(
					new ImageIcon(ImageIO.read(
						new File("resources/login/forgotPW.png")).getScaledInstance(
							LoginSizesEnum.ICON_SIZE_WIDTH.getSize(), 
							LoginSizesEnum.ICON_SIZE_HEIGHT.getSize(), 
							Image.SCALE_AREA_AVERAGING))
				);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		String buttonName = e.getComponent().toString();
		if(buttonName.contains(LoginSizesEnum.BUTTON_NAME_SIGNUP.getButtonName())) {
			this.loginPanel.getBasicFrame().setVisible(false);
//			new JoinFrame(this.loginPanel);
		} else if(buttonName.contains(LoginSizesEnum.BUTTON_NAME_SEARCHPW.getButtonName())) {
			
		} else if(buttonName.contains(LoginSizesEnum.BUTTON_NAME_SEARCHPW.getButtonName())) {
			
		}
	}
	
	public void loginAction() {
		char[] passwd = this.loginPanel.getPwField().getPassword();
		String passwdStr = new String(passwd, 0, passwd.length);
		if(this.loginPanel.getIdField().getText().isEmpty() || passwdStr.isEmpty()) {
			this.loginPanel.loginFailLabelReset();
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