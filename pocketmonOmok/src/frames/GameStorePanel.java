package frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import enums.frames.GameStoreEnum;
import enums.frames.WaitingRoomSizesEnum;


public class GameStorePanel extends JPanel {
	private JPanel userMoneyPanel;
	private JPanel itemChoicePanel;
	private JPanel outPanel;
	private JPanel linePanel;
	private Image backGround;
	
	public GameStorePanel() throws IOException {
		
		this.setLayout(null);
		
		backGround = ImageIO.read(new File("resources/signUp/backg.png")).getScaledInstance(
				GameStoreEnum.GAME_STORE_PANEL_WIDTH.getSize(),
				GameStoreEnum.GAME_STORE_PANEL_HEIGHT.getSize(),
                Image.SCALE_SMOOTH);

		this.add(new JLabel(new ImageIcon(backGround)));
		
		this.setVisible(true);	
		this.setOpaque(false);
		
		this.userMoneyPanel   = new JPanel();
		this.outPanel         = new JPanel();
		this.linePanel		  = new JPanel();
		
		this.setUserPanel();
		this.setItemPanel();
		this.setOutPanel();
	}
	
	//����� ���� �ݾ�, �����ϱ� 
	public void setUserPanel() throws IOException {
		this.userMoneyPanel.setBounds(GameStoreEnum.STORE_USER_MONEY_PANEL_REC.getRectangle());
		this.userMoneyPanel.setLayout(null);
		//this.userMoneyPanel.setBackground(Color.black);
		
		JTextField userMoney = new JTextField("������ �ݾ�");
		userMoney.setBounds(GameStoreEnum.STORE_USER_MONEY_REC.getRectangle());
		userMoney.setFont(GameStoreEnum.LABELFONT_DEFAULT.getFont());
		userMoney.setBorder(GameStoreEnum.LABEL_DEFAULT.getEmptyBorder());
		//userMoney.setBackground(Color.red);
		
		JButton userConfirm = new JButton() {	
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			try {
				g.drawImage(ImageIO.read(
					new File("resources/store/charge.png")), 
					0, 
					0, 
					GameStoreEnum.STORE_USER_CONFIRM_BUTTON_REC.getRectangle().width,
					GameStoreEnum.STORE_USER_CONFIRM_BUTTON_REC.getRectangle().height,
					this);
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		};
		userConfirm.setBounds(GameStoreEnum.STORE_USER_CONFIRM_BUTTON_REC.getRectangle());
		userConfirm.setIconTextGap(userConfirm.getIconTextGap() - 15);
		this.userMoneyPanel.add(userConfirm);
		this.userMoneyPanel.add(userMoney);
		this.add(this.userMoneyPanel);		
		userMoneyPanel.setOpaque(false);
	}
//========================================================================================================
	
	//������ ���� ���� , ������ ��ġ
	public void setItemPanel() {
		this.itemChoicePanel = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/store/skinpink.png")),
							0,
							0,
							GameStoreEnum.GAME_STORE_PANEL_WIDTH.getSize(), 
							GameStoreEnum.GAME_STORE_PANEL_HEIGHT.getSize(), 
							this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		this.itemChoicePanel.setBounds(
				GameStoreEnum.GAME_STORE_PANEL_POSITION_X.getSize(), 
				GameStoreEnum.GAME_STORE_PANEL_POSITION_Y.getSize(), 
				GameStoreEnum.GAME_STORE_PANEL_WIDTH.getSize(), 
				GameStoreEnum.GAME_STORE_PANEL_HEIGHT.getSize()
		);
		
		itemChoicePanel.setOpaque(false);
		this.itemChoicePanel.setLayout(null);
		this.itemChoicePanel.setBounds(GameStoreEnum.STORE_ITEM_CHOICE_PANEL_REC.getRectangle());

		
		//�����ϱ� ������ ������ �� ��ġ ��Ʈ
		JLabel userOwnInterrptItem = new JLabel("1/99");
		userOwnInterrptItem.setBounds(GameStoreEnum.STORE_USER_OWN_INTERRUPT_ITEM_REC.getRectangle());
		userOwnInterrptItem.setFont(GameStoreEnum.LABELFONT_DEFAULT.getFont());
		userOwnInterrptItem.setBackground(Color.red);
		userOwnInterrptItem.setOpaque(false);
		
		//�����ϱ� ������ ��ġ
				JButton userOwnInterrptItemButton = new JButton() {
					@Override
					protected void paintComponent(Graphics g) {
						super.paintComponent(g);
						try {
							g.drawImage(ImageIO.read(
								new File("resources/store/re_interrupt.png")), 
								0, 
								0, 
								GameStoreEnum.STORE_USER_OWN_INTERRUPT_ITEM_BUTTON_REC.getRectangle().width,
								GameStoreEnum.STORE_USER_OWN_INTERRUPT_ITEM_BUTTON_REC.getRectangle().height,
								this);
						}catch (IOException e) {
							e.printStackTrace();
						}		
					}
				};	
				userOwnInterrptItemButton.setBounds(GameStoreEnum.STORE_USER_OWN_INTERRUPT_ITEM_BUTTON_REC.getRectangle());
				userOwnInterrptItemButton.setIconTextGap(userOwnInterrptItemButton.getIconTextGap() - 15);
				userOwnInterrptItemButton.setFocusPainted(false);
				userOwnInterrptItemButton.setBorderPainted(false);
				userOwnInterrptItemButton.setContentAreaFilled(false);
		
//---------------------------------------------------------------------------------------------		
		//������ ������ ������ ��
		JLabel userOwnReturnItem = new JLabel("2/99");
		userOwnReturnItem.setBounds(GameStoreEnum.STORE_USER_OWN_RETURN_ITEM_REC.getRectangle());
		userOwnReturnItem.setFont(GameStoreEnum.LABELFONT_DEFAULT.getFont());
		userOwnReturnItem.setOpaque(false);
		
	

		//������ ������ 
		JButton userOwnReturnItemButton = new JButton() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/store/return.png")), 
						0, 
						0, 
						GameStoreEnum.STORE_USER_OWN_RETURN_ITEM_BUTTON_REC.getRectangle().width,
						GameStoreEnum.STORE_USER_OWN_RETURN_ITEM_BUTTON_REC.getRectangle().height,
						this);
				} catch (IOException e) {
					e.printStackTrace();
				}		
			}
		};	
		userOwnReturnItemButton.setBounds(GameStoreEnum.STORE_USER_OWN_RETURN_ITEM_BUTTON_REC.getRectangle());
		userOwnReturnItemButton.setIconTextGap(userOwnReturnItemButton.getIconTextGap() - 15);
		userOwnReturnItemButton.setFocusPainted(false);
		userOwnReturnItemButton.setBorderPainted(false);
		userOwnReturnItemButton.setContentAreaFilled(false);


//---------------------------------------------------------------------------------------------------------------
		//�ð� �ø��� ������ ������ ��
				JLabel userOwnTimeExtionItem = new JLabel("0/99");
				userOwnTimeExtionItem.setBounds(GameStoreEnum.STORE_USER_OWN_TIMEEXTION_ITEM_REC.getRectangle());
				userOwnTimeExtionItem.setFont(GameStoreEnum.LABELFONT_DEFAULT.getFont());
				userOwnTimeExtionItem.setOpaque(false);
				
		//�ð� ���� ������ 
				JButton userOwnTimeExtionItemButton = new JButton() {
					@Override
					protected void paintComponent(Graphics g) {
						super.paintComponent(g);
						try {
							g.drawImage(ImageIO.read(
								new File("resources/store/timeExtension.png")), 
								0, 
								0, 
								GameStoreEnum.STORE_USER_OWN_TIMEEXTION_ITEM_BUtton_REC.getRectangle().width,
								GameStoreEnum.STORE_USER_OWN_RETURN_ITEM_BUTTON_REC.getRectangle().height,
								this);
						} catch (IOException e) {
							e.printStackTrace();
						}		
					}
				};	
				userOwnTimeExtionItemButton.setBounds(GameStoreEnum.STORE_USER_OWN_TIMEEXTION_ITEM_BUtton_REC.getRectangle());
				userOwnTimeExtionItemButton.setIconTextGap(userOwnTimeExtionItemButton.getIconTextGap() - 15);
				userOwnTimeExtionItemButton.setFocusPainted(false);
				userOwnTimeExtionItemButton.setBorderPainted(false);
				userOwnTimeExtionItemButton.setContentAreaFilled(false);
//-----------------------------------------------------------------------------------------------------------------------				
	//��Ų �̱�
				JLabel userSkinCatch = new JLabel("��Ų�̱�");
				userSkinCatch.setBounds(GameStoreEnum.STORE_USER_SKIN_CATCH_LABEL_REC.getRectangle());
				userSkinCatch.setFont(GameStoreEnum.LABELFONT_DEFAULT.getFont());
				userSkinCatch.setOpaque(false);
				
				JButton userSkinCatchButton = new JButton() {
					@Override
					protected void paintComponent(Graphics g) {
						super.paintComponent(g);
						try {
							g.drawImage(ImageIO.read(
								new File("resources/store/ball2.png")), 
								0, 
								0, 
								GameStoreEnum.STORE_USER_OWN_TIMEEXTION_ITEM_BUtton_REC.getRectangle().width,
								GameStoreEnum.STORE_USER_OWN_RETURN_ITEM_BUTTON_REC.getRectangle().height,
								this);
						} catch (IOException e) {
							e.printStackTrace();
						}		
					}
				};	
				userSkinCatchButton.setBounds(GameStoreEnum.STORE_USER_SKIN_CATCH_BUTTON_REC.getRectangle());
				userSkinCatchButton.setIconTextGap(userSkinCatchButton.getIconTextGap() - 15);
				userSkinCatchButton.setFocusPainted(false);
				userSkinCatchButton.setBorderPainted(false);
				userSkinCatchButton.setContentAreaFilled(false);
				
//---------------------------------------------------------------------------------------------------------
				
		
		//���� �гο� �߰�
		this.add(this.itemChoicePanel);
		this.itemChoicePanel.add(linePanel);
		
		this.itemChoicePanel.add(userOwnInterrptItem);
		this.itemChoicePanel.add(userOwnReturnItem);
		this.itemChoicePanel.add(userOwnTimeExtionItem);
		this.itemChoicePanel.add(userSkinCatch);
		//��ư�� �гο� �߰�	
		this.itemChoicePanel.add(userOwnInterrptItemButton);
		this.itemChoicePanel.add(userOwnReturnItemButton);
		this.itemChoicePanel.add(userOwnTimeExtionItemButton);
		this.itemChoicePanel.add(userSkinCatchButton);
		
		//�г��� ��ü �гο� �߰�
		
	//	itemChoicePanel.setOpaque(false);
		
}

	
//========================================================================================================
	// ������ ��ư
	public void setOutPanel() {
		this.outPanel.setLayout(null);
		this.outPanel.setBounds(GameStoreEnum.STORE_OUT_PANEL_REC.getRectangle());
		//this.outPanel.setBackground(Color.PINK);
		
		JButton OutButton = new JButton() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/store/backButton.png")), 
						0, 
						0, 
						GameStoreEnum.STORE_OUT_BUTTON_REC.getRectangle().width,
						GameStoreEnum.STORE_OUT_BUTTON_REC.getRectangle().height,
						this);
				} catch (IOException e) {
					e.printStackTrace();
				}		
			}
		};	
		OutButton.setBounds(GameStoreEnum.STORE_OUT_BUTTON_REC.getRectangle());
		OutButton.setIconTextGap(OutButton.getIconTextGap() - 15);
		OutButton.setFocusPainted(false);
		OutButton.setBorderPainted(false);
		OutButton.setContentAreaFilled(false);
		
		this.outPanel.add(OutButton);
		this.add(this.outPanel);
		outPanel.setOpaque(false);
	}
	
}
