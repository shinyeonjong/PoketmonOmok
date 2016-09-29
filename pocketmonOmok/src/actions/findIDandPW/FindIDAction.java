package actions.findIDandPW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;

import javax.swing.JButton;

import frames.searchFrames.SearchIdFrame;

public class FindIDAction extends MouseAdapter implements ActionListener {
	private SearchIdFrame searchIdFrame;
	
	private String id;
	private String email;
	
	
	public FindIDAction(SearchIdFrame searchIdFrame){
		this.searchIdFrame = searchIdFrame;	
		try {
			this.searchIdFrame.getBasicFrame().getClientOS().defaultWriteObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//��ҹ�ư, Ȯ�ι�ư
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String resetButton = ((JButton)e.getSource()).getText();
		if(resetButton.equals("backButton")) {
			this.searchIdFrame.doCancleButton();
		}
		String confirmButton = ((JButton)e.getSource()).getText();
		if(confirmButton.equals("confirmButton")) {
			this.searchIdFrame.doConfirmButton();
		}
		
	//id ��ȿ�� �� ���ռ� �˻�
	//public void idSuitabilityCheck() {}	
		
		
		
	}
}
