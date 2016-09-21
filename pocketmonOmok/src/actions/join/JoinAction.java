package actions.join;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Random;

import actions.adapters.Adapters;
import datasDTO.UserPersonalInfoDTO;
import enums.etc.UserActionEnum;
import enums.etc.UserPositionEnum;
import enums.frames.ClientJoinSizesEnum;
import frames.JoinFrame;
import frames.LoginPanel;
import utility.RegexCheck;
import utility.SendEmail;

public class JoinAction extends Adapters {
	private LoginPanel loginPanel;
	private JoinFrame joinFrame;
	
	private String id;
	private String pw;
	private String rePw;
	private String name;
	private int gender;
	private String birthYear;
	private String birthMonth;
	private String birthDate;
	private String emailID;
	private String emailAddr;
	private String telFrontNum;
	private String telMidNum;
	private String telLastNum;
	
	private StringBuffer totalEmail;
	private String confirmNumber;
	
	// ���� ������ ���ŵǱ� ������ birth~ �鿡�� �ʱⰪ�� ����.
	public JoinAction(LoginPanel loginPanel, JoinFrame joinFrame){
		this.loginPanel = loginPanel;
		this.joinFrame = joinFrame;
		this.birthYear = "2016";
		this.birthMonth = "1";
		this.birthDate = "1";
	}
	
	// x��ư�� ������ joinFrame â�� ���� �� BasicFrame�� ���̰� �ϱ� ���� ���� ����.
	@Override
	public void windowClosing(WindowEvent e) {
		this.loginPanel.getBasicFrame().setVisible(true);
		this.joinFrame.setVisible(false);
		this.joinFrame.dispose();
	}
	
	// �ǽð����� Ÿ���� �����Ͽ� �����޼��� ����.
	
	@Override
	public void keyReleased(KeyEvent e) {
		String source = e.getSource().toString();
		if(source.contains("idTextField")) {
			this.idSuitabilityCheck();
		
		} else if(source.contains("pwdField")) {
			this.pwSuitabilityCheck();
		
		} else if(source.contains("rePwdField")) {
			this.rePwSuitabilityCheck();
		
		} else if(source.contains("nameTextField")) {
			this.nameSuitabilityCheck();
		
		} else if(source.contains("emailIDTextField")) {
			this.emailID = this.joinFrame.getEmailIDTextField().getText();			
			this.emailIDSuitabilityCheck();
			
		} else if(source.contains("emailAddrTextField")) {
			this.emailAddrSuitabilityCheck();
			
		} else if(source.contains("telMiddleTextField")) {
			this.telMidTextFieldLengthLimit();
		
		} else if(source.contains("telLastNumTextField")) {
			this.telLastTextFieldLengthLimit();
		
		} else if(source.contains("emailConfTextField")) {
			this.emailConfirm();
		}

	}
	
	// ��ư Ŭ�� �� ���콺�̺�Ʈ�� ���
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().toString().contains("genderManRadio")) {
			System.out.println("Ŭ��?!");
			this.gender = 1;
			this.joinFrame.getGenderErrorLabel().setVisible(false);
		} else if(e.getSource().toString().contains("genderWomanRadio")) {
			this.gender = 2;
			this.joinFrame.getGenderErrorLabel().setVisible(false);
		}
	}

	
	// �޺��ڽ��� �������� ������ ���� �޼ҵ�.
	// �ѹ� Ŭ���ϸ� �� �� ���ԵǴµ�, ����� ���� getstatchange�� 1�� ��, ���� �� ���� 2�� �� ���´�.
	// �׻� �ٲ� ���� ������ ���Ͽ� e.getStateChange() �޼ҵ尡 1�� ��ȯ�� ������ �۾��� �ǽ��Ѵ�.
	@Override
	public void itemStateChanged(ItemEvent e) {
		String source = e.getSource().toString();
		if(e.getStateChange() == 1) {
			if(source.contains("yearChoice")) {
				this.birthYear = e.getItem().toString();
				this.joinFrame.getDateChoice().removeAllItems();
				this.joinFrame.calSetDate(Integer.parseInt(this.birthYear), Integer.parseInt(this.birthMonth));
			
			} else if(source.contains("monthChoice")) {
				this.birthMonth = (String)e.getItem().toString();
				this.joinFrame.getDateChoice().removeAllItems();
				this.joinFrame.calSetDate(Integer.parseInt(this.birthYear), Integer.parseInt(this.birthMonth));

			} else if(source.contains("dateChoice")) {
				this.birthDate = (String)e.getItem().toString();

			} else if(source.contains("emailAddrChoice")) {
				this.emailAddrChoiceResult(e.getItem());
				
			} else if(source.contains("telFrontNumChoice")) {
				this.telFrontNum = (String)e.getItem().toString();

			} else if(source.contains("genderManRadio")) {
				this.gender = 1;
				this.joinFrame.getGenderErrorLabel().setVisible(false);
			
			} else if(source.contains("genderWomanRadio")) {
				this.gender = 2;
				this.joinFrame.getGenderErrorLabel().setVisible(false);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getSource().toString();
		if(source.contains("joinButton")) {
			this.joinAction();
		} else if(source.contains("confirmButton")) {
			this.confirmAction();
		}
	}
	
	//id ��ȿ�� �� ���ռ� �˻�
	public void idSuitabilityCheck() {
		this.id = this.joinFrame.getIdTextField().getText();
		String checkMsg = null;
		Color color = ClientJoinSizesEnum.LABELCOLOR_ERROR.getColor();
		
		if(id.length() < 3 || id.length() > 15) {
			checkMsg = "joinID����";
		
		} else if (!RegexCheck.idRegexCheck(id)) {
			checkMsg = "joinID���ռ�";
		
		} else {
			UserPersonalInfoDTO personalDTO = new UserPersonalInfoDTO(UserPositionEnum.POSITION_JOIN);
			personalDTO.setUserAction(UserActionEnum.USER_JOIN_JOINACTION);
			personalDTO.setUserID(this.joinFrame.getIdTextField().getText());
			try {
				this.loginPanel.getBasicFrame().getClientOS().writeObject(personalDTO);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
//			checkMsg = "join����";
//			color 	 = ClientJoinSizesEnum.LABELCOLOR_DEFAULT.getColor();
		}
		
		this.joinFrame.labelSetting(this.joinFrame.getIdErrorLabel(), color, checkMsg);
	}
	
	//pw ��ȿ�� �� ���ռ� �˻�
	public void pwSuitabilityCheck() {
		char[] pwChar = this.joinFrame.getPwdTextField().getPassword();
		this.pw = new String(pwChar, 0, pwChar.length);
		String checkMsg = null;
		Color color 	= ClientJoinSizesEnum.LABELCOLOR_ERROR.getColor();
		
		if(!this.pw.equals(this.rePw)) {
			this.joinFrame.labelSetting(this.joinFrame.getRePwdErrorLabel(), color, "joinPW����ġ");
		}
		
		if(pw.length() < 6 || pw.length() > 16) {
			checkMsg = "joinPW����";
		
		} else if(pw.equals(id)) {
			checkMsg = "joinPW���̵�";
		
		} else if(!RegexCheck.passwdRegexCheck(pw)) {
			checkMsg = "joinPW���ռ�";
			
		} else {
			checkMsg = "join����";
			color 	 = ClientJoinSizesEnum.LABELCOLOR_DEFAULT.getColor();
		}
		this.joinFrame.labelSetting(this.joinFrame.getPwdErrorLabel(), color, checkMsg);
		
	}
	
	//pw���Է� �κ� ��ȿ�� �� ���ռ� �˻�
	public void rePwSuitabilityCheck() {
		char[] rePwChar = this.joinFrame.getRePwdField().getPassword();
		this.rePw = new String(rePwChar, 0, rePwChar.length);
		String checkMsg = null;
		Color color 	= null;
		
		if(this.rePw.equals(this.pw)) {
			checkMsg = "join����";
			color	 = ClientJoinSizesEnum.LABELCOLOR_DEFAULT.getColor();
		} else {
			checkMsg = "joinPW����ġ";
			color	 = ClientJoinSizesEnum.LABELCOLOR_ERROR.getColor();
		}
		this.joinFrame.labelSetting(this.joinFrame.getRePwdErrorLabel(), color, checkMsg);
	}
	
	//�̸� ��ȿ�� �� ���ռ� �˻�
	public void nameSuitabilityCheck() {
		this.name = this.joinFrame.getNameTextField().getText();
		String checkMsg = null;
		Color color 	= null;
		
		if(this.name.length() < 2) {
			checkMsg = "joinName����";
			color 	 = ClientJoinSizesEnum.LABELCOLOR_ERROR.getColor();
		} else if(!RegexCheck.nameRegecCheck(this.name)) {
			checkMsg = "joinName���ռ�";
			color	 = ClientJoinSizesEnum.LABELCOLOR_ERROR.getColor();
		} else {
			checkMsg = "join����";
			color	 = ClientJoinSizesEnum.LABELCOLOR_DEFAULT.getColor();
		}
		this.joinFrame.labelSetting(this.joinFrame.getNameErrorLabel(), color, checkMsg);
	}
	
	//email ��ȿ�� �� ���ռ� �˻�
	public boolean emailAddrSuitabilityCheck() {
		this.emailAddr = this.joinFrame.getEmailAddrTextField().getText();
		String checkMsg = null;
		Color color 	= null;
		boolean result = false;
		
		if(!RegexCheck.emailDomainRegexCheck(this.emailAddr)) {
			checkMsg = "joinMail���ռ�";
			color 	 = ClientJoinSizesEnum.LABELCOLOR_ERROR.getColor();
		} else if(this.joinFrame.getEmailIDTextField().getText().length() == 0) {
			checkMsg = "joinMail���̵���Է�";
			color 	 = ClientJoinSizesEnum.LABELCOLOR_ERROR.getColor();
		} else {
			checkMsg = "join����";
			color 	 = ClientJoinSizesEnum.LABELCOLOR_DEFAULT.getColor();
			this.totalEmail = new StringBuffer();
			this.totalEmail.append(this.emailID);
			this.totalEmail.append("@");
			this.totalEmail.append(this.emailAddr);
			result = true;
			
		}
		this.joinFrame.labelSetting(this.joinFrame.getEmailErrorLabel(), color, checkMsg);
		
		return result;
	}
	
	//email id ��ȿ�� �� ���ռ� �˻�
	public boolean emailIDSuitabilityCheck() {
		boolean result = true;
		if(this.joinFrame.getEmailAddrTextField().getText().length() == 0) {
			this.joinFrame.labelSetting(this.joinFrame.getEmailErrorLabel(), ClientJoinSizesEnum.LABELCOLOR_ERROR.getColor(), "joinMail�����ι��Է�");
			result = false;
		}
		
		return result;
	}

	//email ���� �޺��ڽ� �׼�
	public void emailAddrChoiceResult(Object object) {
		if(object.toString().equals("�����Է�")) {
			this.joinFrame.getEmailAddrTextField().setEditable(true);
		} else {
			this.joinFrame.getEmailAddrTextField().setEditable(false);
			this.emailAddr = object.toString();
			this.joinFrame.getEmailAddrTextField().setText(this.emailAddr);
			this.emailAddrSuitabilityCheck();
		}
	}

	//���� ��ư ������ ��
	public void confirmAction() {
		System.out.println("������ȣ Ŭ��!!");
		if(this.emailAddrSuitabilityCheck() && this.emailIDSuitabilityCheck()) {
			//������ȣ ����
			this.confirmNumber = String.valueOf(new Random().nextInt(900000) + 100000);
			//�̸��Ϲ߼�
			new SendEmail(this.confirmNumber, this.totalEmail.toString());
			//�ð��󺧺����ֱ�
			this.joinFrame.getEmailTimeLabel().setVisible(true);
			//���Ϲ߼� �޼��� �����ֱ�
			this.joinFrame.labelSetting(this.joinFrame.getEmailErrorLabel(), Color.blue, "joinMail�߼�");
			//�ð� �����ִ� ������ ����
			new Thread() {
				@Override
				public void run() {
					StringBuffer time = new StringBuffer();
					Color color = ClientJoinSizesEnum.LABELCOLOR_ERROR.getColor();
					
					for(int i = 3; i >= 0; --i) {
						for(int j = (i >= 3) ? 0 : 59; j >= 0; j-- ) {
							time.delete(0, time.length());
							time.append(i);
							time.append(" : ");
							time.append(j < 10 ? "0" + j : j);
							
							joinFrame.getEmailTimeLabel().setText(time.toString());
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					joinFrame.labelSetting(joinFrame.getEmailErrorLabel(), color, "joinMail�ð��ʰ�");
					joinFrame.getEmailTimeLabel().setVisible(false);
					
					if(!confirmNumber.equals(joinFrame.getEmailConfTextField().getText())) {
						confirmNumber = null;
					};
				}
			}.start();
		}
	}
	
	//�̸��� ������ȣ �Է� �ؽ�Ʈ�ʵ� 
	public void emailConfirm() {
		String inputNum = this.joinFrame.getEmailConfTextField().getText();
		if(this.confirmNumber.equals(inputNum)) {
			this.joinFrame.labelSetting(this.joinFrame.getEmailErrorLabel(), ClientJoinSizesEnum.LABELCOLOR_DEFAULT.getColor(), "joinMail������ġ");
			this.joinFrame.getEmailTimeLabel().setVisible(false);
			this.joinFrame.getEmailConfTextField().setEditable(false);
			this.joinFrame.getConfirmButton().setEnabled(false);
		} else {
			this.joinFrame.labelSetting(this.joinFrame.getEmailErrorLabel(), ClientJoinSizesEnum.LABELCOLOR_ERROR.getColor(), "jointMail��������ġ");
		}
	}
	
	//tel �߰���ȣ üũ
	public void telMidTextFieldLengthLimit() {
		String telMid = this.joinFrame.getTelMidTextField().getText();
		if(telMid.length() == 4) {
			this.telMidNum = telMid;
		} else if(telMid.length() > 4) {
			this.joinFrame.getTelMidTextField().setText(this.telMidNum);
		}
	}
	
	//tel ����ȣ üũ
	public void telLastTextFieldLengthLimit() {
		String telLast = this.joinFrame.getTelLastNumTextField().getText();
		if(telLast.length() == 4) {
			this.telLastNum = telLast;
		} else if(telLast.length() > 4) {
			this.joinFrame.getTelLastNumTextField().setText(this.telLastNum);
		}
	}

	
	//ȸ������ ��ư ������ ��
	public void joinAction() {
		Color color = ClientJoinSizesEnum.LABELCOLOR_ERROR.getColor();
		String msg = "join�ʼ�";
		
		int errCount = 0;
		
		//���̵� ������ ��
		if(this.id == null) {
			System.out.println("���̵𰡰���");
			this.joinFrame.labelSetting(this.joinFrame.getIdErrorLabel(), color, msg);
			errCount++;
		}
		
		//�н����尡 ������ ��
		if(this.pw == null) {
			System.out.println("�н����尡����");
			this.joinFrame.labelSetting(this.joinFrame.getPwdErrorLabel(), color, msg);
			errCount++;
		}
		
		//rePw�� ������ ��
		if(this.rePw == null) {
			System.out.println("���н����尡����");
			this.joinFrame.labelSetting(this.joinFrame.getRePwdErrorLabel(), color, msg);
			errCount++;
		}
		
		//�̸��� ������ ��
		if(this.name == null) {
			System.out.println("�̸��� ����");
			this.joinFrame.labelSetting(this.joinFrame.getNameErrorLabel(), color, msg);
			errCount++;
		}
		
		//������ �Է��� �ȵǾ��� �� TODO
		if(this.gender == 0) {
			System.out.println("����");
			this.joinFrame.labelSetting(this.joinFrame.getGenderErrorLabel(), color, msg);
			errCount++;
		}
		
		//�̸��� ���̵� �ּҰ� �Է� �ȵǾ��� ��
		if(this.emailID == null || this.emailAddr == null) {
			System.out.println("�̸��� �Է¾ȵ�");
			this.joinFrame.labelSetting(this.joinFrame.getEmailErrorLabel(), color, msg);
			errCount++;
		}
		
		//��ȭ��ȣ�� �չ�ȣ, �޹�ȣ �� �ϳ��� �ԷµǾ��� ��
		if(!(this.telFrontNum == null && this.telMidNum == null && this.telLastNum == null)) {
			if((this.telMidNum != null && this.telLastNum == null) || (this.telMidNum == null && this.telLastNum != null) || this.telFrontNum.equals("����")) {
				System.out.println("��ȭ��ȣ �Է¿���");
				this.joinFrame.labelSetting(this.joinFrame.getTelErrorLabel(), color, "joinTel���ռ�");
				errCount++;
			}
		}
		
		//������ȣ�� ���� �ʾ��� ��
		if(this.confirmNumber == null) {
			System.out.println("������ȣ");
			this.joinFrame.labelSetting(this.joinFrame.getEmailErrorLabel(), color, "joinMail������");
			errCount++;
		}
		
		System.out.println(errCount);
		
		if(errCount == 0) {
			StringBuffer totalBirth = new StringBuffer();
			totalBirth.append(this.birthYear);
			totalBirth.append("�� ");
			totalBirth.append(this.birthMonth);
			totalBirth.append("�� ");
			totalBirth.append(this.birthDate);
			totalBirth.append("��");
		
			StringBuffer totalTel = new StringBuffer();
			totalTel.append(this.telFrontNum);
			totalTel.append(this.telFrontNum == null ? null : "-");
			totalTel.append(this.telMidNum);
			totalTel.append(this.telMidNum == null ? null : "-");
			totalTel.append(this.telLastNum);
			
			UserPersonalInfoDTO personalDTO = new UserPersonalInfoDTO(UserPositionEnum.POSITION_JOIN);
			personalDTO.setUserAction(UserActionEnum.USER_JOIN_JOINACTION);
			personalDTO.setUserBirth(totalBirth.toString());
			personalDTO.setUserEmail(totalEmail.toString());
			personalDTO.setUserGender(this.gender);
			personalDTO.setUserID(this.id);
			personalDTO.setUserName(this.name);
			personalDTO.setUserPasswd(this.pw);
			personalDTO.setUserPhoneNumber(this.telLastNum);
			
			try {
				this.loginPanel.getBasicFrame().getClientOS().writeObject(personalDTO);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println(this.toString());
		}
	}
	
	@Override
	public String toString() {
		return "JoinAction [id=" + id + ", pw=" + pw + ", rePw=" + rePw + ", name=" + name + ", gender=" + gender
				+ ", birthYear=" + birthYear + ", birthMonth=" + birthMonth + ", birthDate=" + birthDate + ", emailID="
				+ emailID + ", emailAddr=" + emailAddr + ", telFrontNum=" + telFrontNum + ", telMidNum=" + telMidNum
				+ ", telLastNum=" + telLastNum + "]";
	}
	
	
}
