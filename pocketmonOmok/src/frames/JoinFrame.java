package frames;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import actions.join.JoinAction;
import enums.JoinSizesEnum;

@SuppressWarnings("serial")
public class JoinFrame extends JFrame {
	
	private JLabel idLabel;
	private JLabel idErrorLabel;
	
	private JLabel pwLabel;
	private JLabel rePwLabel;
	private JLabel pwdErrorLabel;
	private JLabel rePwdErrorLabel;
	
	private JLabel nameLabel;
	private JLabel nameErrorLabel;
	
	private JLabel genderLabel;
	
	private JRadioButton genderManRadio;
	private JRadioButton genderWomanRadio;
	private ButtonGroup genderButtonGroup;
	private JLabel genderErrorLabel;

	private JLabel birthLabel;
	private JComboBox<Integer> yearChoice;
	private JComboBox<Integer> monthChoice;
	private JComboBox<Integer> dateChoice;
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel dateLabel;
	
	private JLabel emailLabel;
	private JLabel emailErrorLabel;
	
	private JLabel telLabel;
	private JLabel telHyphen1Label;
	private JLabel telHyphen2Label;
	private JLabel atLabel;
	
	private JTextField idTextField;
	private JTextField pwdTextField;
	private JTextField rePwdTextField;
	private JTextField nameTextField;
	
	private JTextField yearTextField;
	private JTextField monthTextField;
	private JTextField dateTextField;
	
	private JTextField emailIDTextField;
	private JTextField emailAddrTextField;
	private JTextField emailConfirmTextField;
	private JComboBox<String> emailAddrChoice;

	
	private JComboBox<String> telFrontNumChoice; //전화번호 02,010..
	private JTextField telMiddleNumTextField;
	private JTextField telBackNumTextField;	
	
	private JButton joinButton; //회원가입 버튼
	private JButton resetButton; //취소버튼
	private JButton confirmButton; //인증 버큰
	
	
//생년월일 콤보 박스
	private Calendar rightNow = Calendar.getInstance();
	private int nowyear       = rightNow.get(Calendar.YEAR);
	private int nowmonth 	  = rightNow.get(Calendar.MONTH);
	private int nowdate 	  = rightNow.get(Calendar.DATE);

	//배경	
	private Image reimage;
	
	private LoginPanel loginPanel;
	private JoinAction joinAction;

	public JoinFrame(LoginPanel loginPanel) {
//모든 레이블 
		this.idLabel		  = new JLabel("아이디"); 
	
		this.pwLabel    	  = new JLabel("비밀번호");
		this.rePwLabel  	  = new JLabel("비밀번호재입력");
		this.nameLabel   	  = new JLabel("이름");
		this.genderLabel 	  = new JLabel("성별");
		this.birthLabel  	  = new JLabel("생년월일");
		this.emailLabel  	  = new JLabel("이메일");
		this.telLabel    	  = new JLabel("전화번호");
	
		this.telHyphen1Label  = new JLabel("-");
		this.telHyphen2Label  = new JLabel("-");		
		this.atLabel      	  = new JLabel("@");
		
		
		this.yearLabel    	  = new JLabel("년");
		this.monthLabel   	  = new JLabel("월");
		this.dateLabel    	  = new JLabel("일");
		
// 에러 레이블
		
		String idErrMsg 	  = "특수문자 입력불가,6~15자 이외 글자수";
		String pwErrMsg 	  = ",6~16글자수";
		String repwErrMsg 	  = "pw불일치시";
		String nameErrMsg 	  = "한글만 가능, 2자 이상";
		String genderErrMsg   = "미선택시 - 필수 입력";
		String emailErrMsg 	  = "인증번호 틀렸을시";
		
		this.idErrorLabel	  = new JLabel(idErrMsg);
		this.idErrorLabel.setForeground(JoinSizesEnum.LABELCOLOR_ERROR.getColor());
		
		this.pwdErrorLabel	  = new JLabel(pwErrMsg);
		this.pwdErrorLabel.setForeground(JoinSizesEnum.LABELCOLOR_ERROR.getColor());
		
		this.rePwdErrorLabel  = new JLabel(repwErrMsg);
		this.rePwdErrorLabel.setForeground(JoinSizesEnum.LABELCOLOR_ERROR.getColor());
		
		this.nameErrorLabel   = new JLabel(nameErrMsg);
		this.nameErrorLabel.setForeground(JoinSizesEnum.LABELCOLOR_ERROR.getColor());
		
		this.genderErrorLabel = new JLabel(genderErrMsg);
		this.genderErrorLabel.setForeground(JoinSizesEnum.LABELCOLOR_ERROR.getColor());
		
		this.emailErrorLabel  = new JLabel(emailErrMsg);
		this.emailErrorLabel.setForeground(JoinSizesEnum.LABELCOLOR_ERROR.getColor());

			
// 모든 텍스트 필드
		this.idTextField	  = new JTextField(10);
		this.pwdTextField	  = new JTextField(10);
		this.rePwdTextField	  = new JTextField(10);
		this.nameTextField	  = new JTextField(10);
		this.yearTextField	  = new JTextField(4);
		this.monthTextField	  = new JTextField(2);
		this.dateTextField	  = new JTextField(2);

		this.emailIDTextField	   = new JTextField(10); 
		this.emailAddrTextField	   = new JTextField(10);
		this.telMiddleNumTextField = new JTextField(4);
		this.telBackNumTextField   = new JTextField(4);
		this.emailConfirmTextField = new JTextField(6);

		
// 이메일 전화번호 콤보 박스
		this.emailAddrChoice   = new JComboBox<>();
		this.confirmButton     = new JButton();

		this.emailAddrChoice.addItem("직접입력");
		this.emailAddrChoice.addItem("naver.com");
		this.emailAddrChoice.addItem("hanmail.net");
		this.emailAddrChoice.addItem("nate.com");
		this.emailAddrChoice.addItem("gmail.com");
		 
		
		this.telFrontNumChoice = new JComboBox<>();
		this.telFrontNumChoice.addItem("02");
		this.telFrontNumChoice.addItem("010");
		this.telFrontNumChoice.addItem("011");
		this.telFrontNumChoice.addItem("09");
	
		this.addWindowListener(
			new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					System.out.println("여기 오긴 오니 ??");
					loginPanel.getBasicFrame().setVisible(true);
					setVisible(false);
					dispose();
				}
			});
		// TODO 윈도우리스너 등록
//		this.joinAction = new JoinAction(this.loginPanel, this);
//		this.addWindowListener(this.joinAction);
		
		//생일콤보 박스
		this.yearChoice = new JComboBox<>();
		
		for(int i = 1900; i <= 2016; i++) {
			yearChoice.addItem(i);
		}
		
		this.monthChoice = new JComboBox<>();
		for(int j = 1; j <= 12; j++) {
			monthChoice.addItem(j);
		}
		
		this.dateChoice = new JComboBox<>();
		for(int k = 1; k <= 31; k++) {
			dateChoice.addItem(k);
		}
		
// 성별 여자남자 라디오 박스
		this.genderButtonGroup = new ButtonGroup();
		this.genderWomanRadio = new JRadioButton("여자");
		this.genderManRadio   = new JRadioButton("남자");

		ButtonGroup genderGroup = new ButtonGroup(); 
		
		genderGroup.add(genderManRadio);
		genderGroup.add(genderWomanRadio);
		
		this.add(genderManRadio);
		this.add(genderWomanRadio);
		
//회원가입, 취소 버튼	
		joinButton  = new JButton("회원가입");
		resetButton = new JButton("취소");
		
		
		this.add(resetButton);
		this.add(joinButton);
		
		confirmButton = new JButton("인증");
		this.add(confirmButton);
		


//전체 프레임 크기 출력
		
		//배경이미지 모니터의 해상도에 따라 조절되게 설정
	    try {
			reimage = ImageIO.read(
				new File("resources/signUp/back.png")).getScaledInstance(
					JoinSizesEnum.JOINFRAME_SIZE_WIDTH.getSize(),
					JoinSizesEnum.JOINFRMAE_SIZE_HEIGHT.getSize(),
					Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}

	    this.setContentPane(new JLabel(new ImageIcon(reimage)));
		
		this.setBounds(
				JoinSizesEnum.JOINFRMAE_POSITION_X.getSize(),
				JoinSizesEnum.JOINFRMAE_POSITION_Y.getSize(),
				JoinSizesEnum.JOINFRAME_SIZE_WIDTH.getSize(),
				JoinSizesEnum.JOINFRMAE_SIZE_HEIGHT.getSize()
		);
		//TODO 로그인패널 추가
		this.loginPanel = loginPanel;
//레이블 
		this.setLabelPosition();
//덱스트 필드
		this.setTextFieldPosition();
//이메일 생일 전화번호 콤보 박스
		this.setChoicePosition();
//성별 그룹 묶음
		this.setButtonGroup();
		this.setButtonPosItion();
//에러 메세지
		this.setErrorPosition();
		
		
		this.setLayout(null);
	    this.setTitle("회원가입");
	    this.setVisible(true);
	    this.setResizable(true);
	}
	
	//모든 레이블 위치 -- > 순서대로
	public void setLabelPosition() {
		
		
		this.idLabel.setBounds(
				JoinSizesEnum.JOIN_ID_POSITION_X.getSize(),
				JoinSizesEnum.JOIN_ID_POSITION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		this.pwLabel.setBounds(
				JoinSizesEnum.JOIN_PWD_POSITION_X.getSize(),
				JoinSizesEnum.JOIN_PWD_POSITION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		this.rePwLabel.setBounds(
				JoinSizesEnum.JOIN_REPWD_POSITION_X.getSize(),
				JoinSizesEnum.JOIN_REPWD_POSITION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		this.nameLabel.setBounds(
				JoinSizesEnum.JOIN_NAME_POSITION_X.getSize(),
				JoinSizesEnum.JOIN_NAME_POSITION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
	
		this.genderLabel.setBounds(
				JoinSizesEnum.JOIN_GENDER_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_GENDER_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		this.birthLabel.setBounds(
				JoinSizesEnum.JOIN_BIRTH_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_BIRTH_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		this.yearLabel.setBounds(
				JoinSizesEnum.JOIN_YEAR_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_YEAR_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		this.monthLabel.setBounds(
				JoinSizesEnum.JOIN_MONTH_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_MONTH_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		this.dateLabel.setBounds(
				JoinSizesEnum.JOIN_DATE_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_DATE_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		
		this.emailLabel.setBounds(
				JoinSizesEnum.JOIN_EMAIL_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_EMAIL_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		this.telLabel.setBounds(
				JoinSizesEnum.JOIN_TEL_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_TEL_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		
		this.telHyphen1Label.setBounds(
				JoinSizesEnum.JOIN_HYPHEN1_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_HYPHEN1_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		
		this.telHyphen2Label.setBounds(
				JoinSizesEnum.JOIN_HYPHEN2_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_HYPHEN2_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		this.atLabel.setBounds(
				JoinSizesEnum.JOIN_AT_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_AT_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
				
		
		this.add(idLabel);
		this.add(pwLabel);
		this.add(rePwLabel);
		this.add(nameLabel);
		this.add(genderLabel);
		this.add(birthLabel);
		
		this.add(yearLabel);
		this.add(monthLabel);
		this.add(dateLabel);
	
		this.add(emailLabel);
		this.add(telLabel);
		this.add(telHyphen1Label);
		this.add(telHyphen2Label);
		this.add(atLabel);
		
		
	}
	
	public void setTextFieldPosition() {
		
		this.idTextField.setBounds(
				JoinSizesEnum.JOIN_IDT_POSITION_X.getSize(),
				JoinSizesEnum.JOIN_IDT_POSITION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		this.pwdTextField.setBounds(
				JoinSizesEnum.JOIN_PWDT_POSITION_X.getSize(),
				JoinSizesEnum.JOIN_PWDT_POSITION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		this.rePwdTextField.setBounds(
				JoinSizesEnum.JOIN_REPWDT_POSITION_X.getSize(),
				JoinSizesEnum.JOIN_REPWDT_POSITION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
		this.nameTextField.setBounds(
				JoinSizesEnum.JOIN_NAMET_POSITION_X.getSize(),
				JoinSizesEnum.JOIN_NAMET_POSITION_Y.getSize(),
				JoinSizesEnum.SIZE_LABEL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_LABEL_HEIGHT.getSize()
		);
	
		this.emailIDTextField.setBounds(
				JoinSizesEnum.JOIN_EMAILT_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_EMAILT_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_EMAIL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_EMAIL_HEIGHT.getSize()
		);
		
		this.emailAddrTextField.setBounds(
				JoinSizesEnum.JOIN_EMAILADRT_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_EMAILADRT_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_EMAIL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_EMAIL_HEIGHT.getSize()
		);
		
		this.emailConfirmTextField.setBounds(
				JoinSizesEnum.JOIN_CONFIRMT_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_CONFIRMT_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_EMAIL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_EMAIL_HEIGHT.getSize()
		);
		
		this.telMiddleNumTextField.setBounds(
				JoinSizesEnum.JOIN_TELT_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_TELT_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_TEXT_WIDTH.getSize(),
				JoinSizesEnum.SIZE_TEXT_HEIGHT.getSize()
		);
		
		this.telBackNumTextField.setBounds(
				JoinSizesEnum.JOIN_TELT2_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_TELT2_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_TEXT_WIDTH.getSize(),
				JoinSizesEnum.SIZE_TEXT_HEIGHT.getSize()
		);
		
		
		
		this.add(idTextField);
		this.add(pwdTextField); this.add(rePwdTextField);
		this.add(nameTextField); 
		
		this.add(yearTextField); this.add(monthTextField); this.add(dateTextField);
		this.add(emailIDTextField); this.add(emailAddrTextField); this.add(emailConfirmTextField);
		this.add(telMiddleNumTextField); this.add(telBackNumTextField);

	}
	
// 이메일 핸드폰 콤보 박스 출력
	public void setChoicePosition() {
		this.emailAddrChoice.setBounds(
				JoinSizesEnum.JOIN_EMAILCHOICE_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_EMAILCHOICE_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_JOIN_WIDTH.getSize(),
				JoinSizesEnum.SIZE_JOIN_HEIGHT.getSize()
		);
		this.telFrontNumChoice.setBounds(
				JoinSizesEnum.JOIN_NUMCHOICE_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_NUMCHOICE_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_EMAIL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_EMAIL_HEIGHT.getSize()
		);
		
		this.yearChoice.setBounds(
				JoinSizesEnum.JOIN_YEARCHOICE_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_YEARCHOICE_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_EMAIL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_EMAIL_HEIGHT.getSize()
		);
		
		this.monthChoice.setBounds(
				JoinSizesEnum.JOIN_MONTHCHOICE_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_MONTHCHOICE_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_EMAIL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_EMAIL_HEIGHT.getSize()
		);
		
		this.dateChoice.setBounds(
				JoinSizesEnum.JOIN_DATECHOICE_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_DATECHOICE_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_EMAIL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_EMAIL_HEIGHT.getSize()
		);
		
		this.add(emailAddrChoice);
		this.add(telFrontNumChoice);
		
		this.add(yearChoice);
		this.add(monthChoice);
		this.add(dateChoice);
	}
	
	//여자 남자 라디오 뱍스
	public void setButtonGroup() {
		this.genderManRadio.setBounds(
				JoinSizesEnum.GENDER_MAN_POSITION_X.getSize(),
				JoinSizesEnum.GENDER_MAN_POSITION_Y.getSize(),
				JoinSizesEnum.SIZE_EMAIL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_EMAIL_HEIGHT.getSize()
		);
		this.genderWomanRadio.setBounds(
				JoinSizesEnum.GENDER_WOMAN_POSITION_X.getSize(),
				JoinSizesEnum.GENDER_WOMAN_POSITION_Y.getSize(),
				JoinSizesEnum.SIZE_EMAIL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_EMAIL_HEIGHT.getSize()
		);
				
		this.add(this.genderManRadio);
		this.add(this.genderWomanRadio);
		
	}
	
	// 이메일인증, 회원가입, 취소 버튼
	public void setButtonPosItion() {
		this.resetButton.setBounds(
				JoinSizesEnum.JOIN_RESET_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_RESET_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_JOIN_WIDTH.getSize(),
				JoinSizesEnum.SIZE_JOIN_HEIGHT.getSize()
		);
		this.joinButton.setBounds(
				JoinSizesEnum.JOIN_JOIN_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_JOIN_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_JOIN_WIDTH.getSize(),
				JoinSizesEnum.SIZE_JOIN_HEIGHT.getSize()
		);
		this.confirmButton.setBounds(
				JoinSizesEnum.JOIN_CONFIRM_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_CONFIRM_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_EMAIL_WIDTH.getSize(),
				JoinSizesEnum.SIZE_EMAIL_HEIGHT.getSize()
		);
				
		this.add(resetButton);
		this.add(joinButton);
		this.add(confirmButton);
		
	}
	
	//에러 메세지 출력
	public void setErrorPosition() {
		this.idErrorLabel.setBounds(
				JoinSizesEnum.JOIN_IDERROR_POSITION_X.getSize(),
				JoinSizesEnum.JOIN_IDERROR_POSITION_Y.getSize(),
				JoinSizesEnum.SIZE_ERROR_WIDTH.getSize(),
				JoinSizesEnum.SIZE_ERROR_HEIGHT.getSize()
		);
		this.pwdErrorLabel.setBounds(
				JoinSizesEnum.JOIN_PWDERROR_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_PWDERROR_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_ERROR_WIDTH.getSize(),
				JoinSizesEnum.SIZE_ERROR_HEIGHT.getSize()
		);
		this.rePwdErrorLabel.setBounds(
				JoinSizesEnum.JOIN_REPWDERROR_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_REPWDERROR_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_ERROR_WIDTH.getSize(),
				JoinSizesEnum.SIZE_ERROR_HEIGHT.getSize()
		);
		this.nameErrorLabel.setBounds(
				JoinSizesEnum.JOIN_NAMEERROR_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_NAMEERROR_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_ERROR_WIDTH.getSize(),
				JoinSizesEnum.SIZE_ERROR_HEIGHT.getSize()
		);
		this.genderErrorLabel.setBounds(
				JoinSizesEnum.JOIN_GENDERERROR_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_GENDERERROR_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_ERROR_WIDTH.getSize(),
				JoinSizesEnum.SIZE_ERROR_HEIGHT.getSize()
		);
		this.emailErrorLabel.setBounds(
				JoinSizesEnum.JOIN_EMAILERROR_POSITTION_X.getSize(),
				JoinSizesEnum.JOIN_EMAILERROR_POSITTION_Y.getSize(),
				JoinSizesEnum.SIZE_ERROR_WIDTH.getSize(),
				JoinSizesEnum.SIZE_ERROR_HEIGHT.getSize()
		);

		this.add(idErrorLabel);
		this.add(pwdErrorLabel);
		this.add(rePwdErrorLabel);
		this.add(nameErrorLabel);
		this.add(genderErrorLabel);
		this.add(emailErrorLabel);
		
	}
}