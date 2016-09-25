package actions.findIDandPW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import datasDTO.UserPersonalInfoDTO;
import enums.etc.UserPositionEnum;
import enums.frames.SearchIdEnum;
import frames.LoginPanel;
import frames.serchFrames.SearchIdFrame;

public class FindIDAction extends MouseAdapter implements ActionListener {
	private LoginPanel loginPanel;
	private SearchIdFrame searchIdFrame;
	
	public FindIDAction(SearchIdFrame searchIdFrame){
		this.searchIdFrame = searchIdFrame;	
	}
	
	//id, email �Է¶� �� �ϳ��� ����־ ���� �޼��� ���
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	//Ȯ�ι�ư�� ��������
	@Override
	public void mouseClicked(MouseEvent e){
		
	}
	
	//ForgotID ��ư �������� 
	public void findIDAction() {
		
		try {
			this.loginPanel.getBasicFrame().getClientOS().defaultWriteObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
		
}
