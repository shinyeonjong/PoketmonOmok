package frames.serchFrames;


import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import actions.findIDandPW.FindIDAction;
import enums.frames.CorrectEnum;
import enums.frames.LoginFrameSizesEnum;
import enums.frames.SearchIdEnum;
import enums.frames.SearchPwdEnum;
import enums.frames.SearchRePwdEnum;
import frames.BasicFrame;
import frames.LoginPanel;
import frames.joinFrames.JoinFrame;
import frames.waitingRoom.WaitingRoomPanel;


public class SearchIdFrame extends JFrame  {
	
	private SearchIdPanel searchIdPanel;
	private SearchIdResultPanel searchIdResultPanel;
	private Image backGround;
	private CardLayout cardLayout;
	private BasicFrame basicFrame;
	private FindIDAction findIDAction;
	
	public SearchIdFrame(BasicFrame basicFrame) throws IOException {
		this.basicFrame = basicFrame;
		
		this.backGround = ImageIO.read(new File("resources/background/popup.png")).getScaledInstance(
				SearchPwdEnum.SEARCH_PWD_FRAME_WIDTH.getSize(),
				SearchPwdEnum.SEARCH_PWD_FRAME_HEIGHT.getSize(),
                Image.SCALE_SMOOTH);
		this.setContentPane(new JLabel(new ImageIcon(backGround)));
		
		//������ ȭ�� ��� ��ġ ����
		this.setBounds(
				SearchRePwdEnum.SEARCH_REPWD_FRAME_POSITION_X.getSize(),
				SearchRePwdEnum.SEARCH_REPWD_FRAME_POSITION_Y.getSize(),
				SearchRePwdEnum.SEARCH_REPWD_FRAME_WIDTH.getSize(),
				SearchRePwdEnum.SEARCH_REPWD_FRAME_HEIGHT.getSize()
		);
		
		//���̵� ã�� �г�
		this.searchIdPanel = new SearchIdPanel(this) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponents(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/background/popup.png")),
							0,
							0,
							SearchRePwdEnum.SEARCH_REPWD_FRAME_WIDTH.getSize(),
							SearchRePwdEnum.SEARCH_REPWD_FRAME_HEIGHT.getSize(),
							this);		
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		
		//���̵� ã�� ���â �г�
		this.searchIdResultPanel = new SearchIdResultPanel(this) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponents(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/background/popup.png")),
							0,
							0,
							SearchRePwdEnum.SEARCH_REPWD_FRAME_WIDTH.getSize(),
							SearchRePwdEnum.SEARCH_REPWD_FRAME_HEIGHT.getSize(),
							this);		
				}catch (IOException e) {
					e.printStackTrace();
				}
			}};
			
		this.searchIdPanel = new SearchIdPanel(this);
		this.searchIdPanel.setOpaque(false);
		this.cardLayout = new CardLayout();
		this.add("searchIdPanel",this.searchIdPanel);
		this.setLayout(this.cardLayout);
		this.setTitle("IDã��");
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);

	}
	
	public void doCancleButton(){
		
		//��������
		this.setVisible(false);
		//�׸��� �α���â�� ���
		this.basicFrame.setVisible(true);
		
	}
	
	public void doConfirmButton(){	
		//��������
		this.setVisible(false);
		//�׸��� Ȯ�ΰ��â�� ���
		this.searchIdResultPanel.setVisible(true);
		
	}

	public SearchIdPanel getSearchIdPanel() {
		return searchIdPanel;
	}
	
	public SearchIdResultPanel getSearchIdResultPanel() {
		return searchIdResultPanel;
	}
	public BasicFrame getBasicFrame() {
		return basicFrame;
	}
	public FindIDAction getFindIDAction() {
		return findIDAction;
	}
	
	

}
