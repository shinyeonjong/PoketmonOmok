package frames.serchFrames;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import enums.frames.searchPwdEnum;
import enums.frames.searchRePwdEnum;


@SuppressWarnings("serial")
public class SearchPwdFrame extends JFrame implements Serializable {
	
	private CardLayout cardLayout;
	private SearchPwdPanel searchPwdPanel;
	private SearchRePwdPanel searchRePwdPanel;
	private SearchChangePanel searchChangePanel;
	private Image backGround;
	
	public SearchPwdFrame() throws IOException {
		
		backGround = ImageIO.read(new File("resources/background/popup.png")).getScaledInstance(
				searchPwdEnum.SEARCH_PWD_FRAME_WIDTH.getSize(),
				searchPwdEnum.SEARCH_PWD_FRAME_HEIGHT.getSize(),
                Image.SCALE_SMOOTH);
		
		this.setContentPane(new JLabel(new ImageIcon(backGround))); 
		
		//������ ȭ�� ��� ��ġ ����
		this.setBounds(
		searchRePwdEnum.SEARCH_REPWD_FRAME_POSITION_X.getSize(),
		searchRePwdEnum.SEARCH_REPWD_FRAME_POSITION_Y.getSize(),
		searchRePwdEnum.SEARCH_REPWD_FRAME_WIDTH.getSize(),
		searchRePwdEnum.SEARCH_REPWD_FRAME_HEIGHT.getSize()
		);
		
		//��й�ȣ ã�� ������
		this.searchPwdPanel = new SearchPwdPanel(this) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponents(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/background/popup.png")),
							0,
							0,
							searchRePwdEnum.SEARCH_REPWD_FRAME_WIDTH.getSize(),
							searchRePwdEnum.SEARCH_REPWD_FRAME_HEIGHT.getSize(),
							this);		
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		this.searchPwdPanel.setOpaque(false);
		this.cardLayout = new CardLayout();
		
		//��й�ȣ ���Է� ������
		this.searchRePwdPanel = new SearchRePwdPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponents(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/background/popup.png")),
							0,
							0,
							searchRePwdEnum.SEARCH_REPWD_FRAME_WIDTH.getSize(),
							searchRePwdEnum.SEARCH_REPWD_FRAME_HEIGHT.getSize(),
							this);		
				}catch (IOException e) {
					e.printStackTrace();
				}
			}};
		//this.setLayout(null);
		
//		this.newSearchChangePanel();
		this.add("searchPwdPanel",this.searchPwdPanel);
		this.searchPwdPanel.setOpaque(false);
//		this.add("searchRePwdPanel", this.searchRePwdPanel);
//		this.searchRePwdPanel.setOpaque(false);
//		this.add("searchChangeConfirmPanel", this.searchChangePanel);
//		this.searchChangePanel.setOpaque(false);

		this.setLayout(this.cardLayout);
		this.setTitle("PWã��");
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		
	}
	//��й�ȣ ���� Ȯ�� ������
	public void newSearchChangePanel() throws IOException {
		
		this.searchChangePanel = new SearchChangePanel() {	
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/signUp/backg.png")),
							0,
							0,
							searchRePwdEnum.SEARCH_REPWD_FRAME_WIDTH.getSize(),
							searchRePwdEnum.SEARCH_REPWD_FRAME_HEIGHT.getSize(),
							this);		
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
	}

}
