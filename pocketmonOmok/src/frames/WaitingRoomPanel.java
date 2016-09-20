package frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import enums.WaitingRoomSizesEnum;

public class WaitingRoomPanel extends JPanel implements ActionListener {	
	private JPanel background;
	
	private JScrollPane waitingRoomListScroll;
	private JLabel waitingRoomInfo;
	private JLabel[] infoLabel;
	
	private JList<String> waitingRoomList;
	private Vector<String> waitingRoomListVector;
	//TODO
	private JTable waitingRoomTable;
	private JPanel waitingRoomListBackground;
	
	private JButton gamestartButton;
	private JButton createRoomButton;
	
	private JTextArea chattingOutput;
	private JTextField chattingInput;
	private JButton sendMessage;
	
	private JList<String> playerList;
	private JPanel playerListBackgrounnd;
	
	private JPanel myInfo;
	private JPanel myInfoImage;
	private JLabel userID;
	private JLabel score;
	private JLabel winningRate;
	private JLabel point;
	private JLabel level;
	private JButton correct;
	
	private Map<String,ImageIcon> imageMap;

	
	public WaitingRoomPanel() throws IOException {
		//==========================������ ����Ʈ==========================
		String[] player = {"yjyj","hello","wowwowwow","OOOOOOOOOOOOOOO","1","2","3","4","5","6","7","8","9","10"};
		imageMap = createImage(player);
		this.playerList = new JList(player);
		playerList.setCellRenderer(new PlayerRenderer());
			
		this.waitingRoomListVector = new Vector<String>();
		String[] infoStr = new String[] {
				"OX", "NO", "TITLE", "MASTER", "NUMBER"
		};
		
		this.infoLabel = new JLabel[5];
		for(int i = 0, size = infoStr.length; i < size; i++) {
			this.infoLabel[i] = new JLabel(infoStr[i]);
			this.infoLabel[i].setBounds(WaitingRoomSizesEnum.WAITINGROOM_INFO_LABEL_RECTS.getRect()[i]);
			this.infoLabel[i].setFont(new Font("a��������", Font.BOLD, 18));
			this.infoLabel[i].setForeground(Color.white);
			this.add(infoLabel[i]);
		}
		//==========================���� ����Ʈ==========================
		
		Font font = new Font("a��������",Font.BOLD,15);
		WaitingRoomListTable roomListModel = new WaitingRoomListTable();
		
		DefaultListCellRenderer defaultrenderer = new DefaultListCellRenderer();
		defaultrenderer.setHorizontalTextPosition(SwingConstants.CENTER);//��� �������ش���� �ޥF�� ����.
		
		DefaultTableModel defaultTableModel = new DefaultTableModel(roomListModel.getWaitingRoomListData(), roomListModel.getWaitingRoomListColumn());
		this.waitingRoomTable = new JTable(defaultTableModel) {
			@Override
			public Class getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};
		
		this.waitingRoomTable.setBounds(WaitingRoomSizesEnum.WAITING_ROOM_LIST_POSITION_X.getSize(), 
									WaitingRoomSizesEnum.WAITING_ROOM_LIST_POSITION_Y.getSize(), 
									WaitingRoomSizesEnum.WAITING_ROOM_LIST_SIZE_WIDTH.getSize(),
									WaitingRoomSizesEnum.WAITING_ROOM_LIST_SIZE_HEIGHT.getSize());
		
			
		this.waitingRoomList = new JList<>(this.waitingRoomListVector);
		
		//this.setPreferredSize(new Dimension(WaitingRoomSizesEnum.WAITING_ROOM_LIST_SIZE_WIDTH.getSize(),
		//									WaitingRoomSizesEnum.WAITING_ROOM_LIST_SIZE_HEIGHT.getSize()));
		//this.setPreferredScrollableViewportSize(new Dimension(60, 40)); //�����ϴ����𸣰����¤ФФФФФФФФФФФФФФФФФФФФФФФФФ�
		
		
		this.waitingRoomTable.setFont(font);
		this.waitingRoomTable.setShowGrid(false);//���ڼ��� �׸����ΰ�
		this.waitingRoomTable.setShowHorizontalLines(false);//������ �׸����ΰ�
		this.waitingRoomTable.setShowVerticalLines(false);//�������� �׸����ΰ�
		
		this.waitingRoomTable.getColumn("OX").setPreferredWidth(10);
		this.waitingRoomTable.getColumn("NO").setPreferredWidth(10);
		this.waitingRoomTable.getColumn("TITLE").setPreferredWidth(100);
		this.waitingRoomTable.getColumn("MASTER").setPreferredWidth(50);
		this.waitingRoomTable.getColumn("NUMBER").setPreferredWidth(50);
		this.waitingRoomTable.setRowHeight(80);
		
		this.waitingRoomListScroll = new JScrollPane(waitingRoomTable);
		
	
		//==========================ä�ù�&������==========================
		
		this.chattingOutput = new JTextArea();
		this.chattingInput  = new JTextField();
		this.sendMessage    = new JButton();
						
		this.gamestartButton  = new JButton();
		this.createRoomButton = new JButton();
			
		this.userID 	 = new JLabel("ID");
		this.score 		 = new JLabel("����");
		this.winningRate = new JLabel("�·�");
		this.point 		 = new JLabel("����");
		this.level 		 = new JLabel(".LV");
		this.correct 	 = new JButton();
		
		this.roomListPosition();
			
	}



	/***************************������ ����Ʈ Ŭ����***************************/
	public class PlayerRenderer extends DefaultListCellRenderer {
		Font font = new Font("a��������", Font.BOLD, 15);
		
		public Component getListCellRendererComponent(
				JList player, Object value, int index,
				boolean isSelected, boolean cellHasFocus) {
			JLabel label = (JLabel) super.getListCellRendererComponent(
                    player, value, index, isSelected, cellHasFocus);
            label.setIcon(imageMap.get((String) value));
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setOpaque(false);
            label.setFont(font);
            return label;
		}
	}
	/***************************������ ����Ʈ ��***************************/
	private Map<String, ImageIcon> createImage(String[] player) throws IOException {
	    Map<String, ImageIcon> map = new HashMap<>();
	    try{
	    	map.put("yjyj", new ImageIcon(ImageIO.read(
            		new File("resources/user/userbegining.png")).getScaledInstance(
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_WIDTH.getSize(),
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING)));
	    	map.put("hello", new ImageIcon(ImageIO.read(
            		new File("resources/user/userhero.png")).getScaledInstance(
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_WIDTH.getSize(),
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING)));
	    	map.put("wowwowwow", new ImageIcon(ImageIO.read(
            		new File("resources/user/usertop.png")).getScaledInstance(
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_WIDTH.getSize(),
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING)));
	    	map.put("OOOOOOOOOOOOOOO", new ImageIcon(ImageIO.read(
            		new File("resources/user/usermorehigh.png")).getScaledInstance(
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_WIDTH.getSize(),
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING)));
	    	map.put("1", new ImageIcon(ImageIO.read(
            		new File("resources/user/usermorehigh.png")).getScaledInstance(
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_WIDTH.getSize(),
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING)));
	    	map.put("2", new ImageIcon(ImageIO.read(
            		new File("resources/user/usermorehigh.png")).getScaledInstance(
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_WIDTH.getSize(),
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING)));
	    	map.put("3", new ImageIcon(ImageIO.read(
            		new File("resources/user/usermorehigh.png")).getScaledInstance(
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_WIDTH.getSize(),
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING)));
	    	map.put("4", new ImageIcon(ImageIO.read(
            		new File("resources/user/usermorehigh.png")).getScaledInstance(
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_WIDTH.getSize(),
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING)));
	    	map.put("5", new ImageIcon(ImageIO.read(
            		new File("resources/user/usermorehigh.png")).getScaledInstance(
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_WIDTH.getSize(),
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING)));
	    	map.put("6", new ImageIcon(ImageIO.read(
            		new File("resources/user/usermorehigh.png")).getScaledInstance(
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_WIDTH.getSize(),
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING)));
	    	map.put("7", new ImageIcon(ImageIO.read(
            		new File("resources/user/usermorehigh.png")).getScaledInstance(
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_WIDTH.getSize(),
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING)));
	    	map.put("8", new ImageIcon(ImageIO.read(
            		new File("resources/user/usermorehigh.png")).getScaledInstance(
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_WIDTH.getSize(),
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING)));
	    	map.put("9", new ImageIcon(ImageIO.read(
            		new File("resources/user/usermorehigh.png")).getScaledInstance(
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_WIDTH.getSize(),
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING)));
	    	map.put("10", new ImageIcon(ImageIO.read(
            		new File("resources/user/usermorehigh.png")).getScaledInstance(
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_WIDTH.getSize(),
    					WaitingRoomSizesEnum.LEVEL_ICON_SIZE_HEIGHT.getSize(),
    					Image.SCALE_AREA_AVERAGING)));
	    	

	    } catch (Exception e){
	    	e.printStackTrace();
	    }    
	    return map;
	}

	/***************************���� ��ġ***************************/
	public void roomListPosition() throws IOException {

		//�渮��Ʈ ��ġ�� ũ�⸦ ������
		this.waitingRoomList.setBounds(
				WaitingRoomSizesEnum.WAITING_ROOM_LIST_POSITION_X.getSize(),
				WaitingRoomSizesEnum.WAITING_ROOM_LIST_POSITION_Y.getSize(),
				WaitingRoomSizesEnum.WAITING_ROOM_LIST_SIZE_WIDTH.getSize(),
				WaitingRoomSizesEnum.WAITING_ROOM_LIST_SIZE_HEIGHT.getSize()
		);	
		
		//�� ����Ʈ�� ��� �̹����� �ҷ��� JPanel ����
		this.waitingRoomListBackground = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/waitingroom/waitingRoomList.png")),
							0,
							0,
							WaitingRoomSizesEnum.WAITING_ROOM_LIST_SIZE_BACKGROUND_WIDTH.getSize(), 
							WaitingRoomSizesEnum.WAITING_ROOM_LIST_SIZE_BACKGROUND_HEIGHT.getSize(), 
							this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		//�渮��Ʈ ��� �̹����� ������
		this.waitingRoomListBackground.setBounds(
				WaitingRoomSizesEnum.WAITING_ROOM_LIST_BACKGROUND_POSITION_X.getSize(), 
				WaitingRoomSizesEnum.WAITING_ROOM_LIST_BACKGROUND_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.WAITING_ROOM_LIST_SIZE_BACKGROUND_WIDTH.getSize(), 
				WaitingRoomSizesEnum.WAITING_ROOM_LIST_SIZE_BACKGROUND_HEIGHT.getSize()
		);
		
		waitingRoomList.setOpaque(false);
		waitingRoomListBackground.setOpaque(false);
		
		/******************************************************************************/
		//ä�� �Է�â�� ��ġ�� ũ�⸦ ������
		this.chattingOutput.setBounds(
				WaitingRoomSizesEnum.CHATTING_OUTPUT_POSITION_X.getSize(),
				WaitingRoomSizesEnum.CHATTING_OUTPUT_POSITION_Y.getSize(),
				WaitingRoomSizesEnum.CHATTING_OUTPUT_SIZE_WIDTH.getSize(),
				WaitingRoomSizesEnum.CHATTING_OUTPUT_SIZE_HEIGHT.getSize()
		);
		//ä�� ���â�� ��ġ�� ũ�⸦ ������
		this.chattingInput.setBounds(
				WaitingRoomSizesEnum.CHATTING_INPUT_POSITION_X.getSize(),
				WaitingRoomSizesEnum.CHATTING_INPUT_POSITION_Y.getSize(),
				WaitingRoomSizesEnum.CHATTING_INPUT_SIZE_WIDTH.getSize(),
				WaitingRoomSizesEnum.CHATTING_INPUT_SIZE_HEIGHT.getSize()	
		);
		//�޼��� ��ư ��ġ�� ũ�⸦ ������
		this.sendMessage.setBounds(
				WaitingRoomSizesEnum.SEND_MESSAGE_BUTTON_POSITION_X.getSize(),
				WaitingRoomSizesEnum.SEND_MESSAGE_BUTTON_POSITION_Y.getSize(),
				WaitingRoomSizesEnum.SEND_MESSAGE_BUTTON_WIDTH.getSize(),
				WaitingRoomSizesEnum.SEND_MESSAGE_BUTTON_HEIGHT.getSize()
		);
		//�޽��� ��ư�� �̹����� �ҷ���
		this.sendMessage.setIcon(
				new ImageIcon(ImageIO.read(
					new File("resources/waitingroom/send.png")).getScaledInstance(
						WaitingRoomSizesEnum.SEND_MESSAGE_BUTTON_WIDTH.getSize(),
						WaitingRoomSizesEnum.SEND_MESSAGE_BUTTON_HEIGHT.getSize(),
						Image.SCALE_AREA_AVERAGING))
		);
		
		/******************************************************************************/
		//���ӽ��� ��ư ��ġ�� ũ�⸦ ������
		this.gamestartButton.setBounds(
				WaitingRoomSizesEnum.GAMESTART_JBUTTON_POSITION_X.getSize(), 
				WaitingRoomSizesEnum.GAMESTART_JBUTTON_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.GAMESTART_JBUTTON_WIDTH.getSize(),
				WaitingRoomSizesEnum.GAMESTART_JBUTTON_HEIGHT.getSize()
		);
		//���ӽ��� ��ư�� �̹����� �ҷ���
		this.gamestartButton.setIcon(
			new ImageIcon(ImageIO.read(
				new File("resources/waitingroom/_gamestart.jpg")).getScaledInstance(
					WaitingRoomSizesEnum.GAMESTART_JBUTTON_WIDTH.getSize(),
					WaitingRoomSizesEnum.GAMESTART_JBUTTON_HEIGHT.getSize(),
					Image.SCALE_AREA_AVERAGING))
		);
		/******************************************************************************/
		//����� ��ư ��ġ�� ũ�⸦ ������
		this.createRoomButton.setBounds(
				WaitingRoomSizesEnum.CREATEROOM_JBUTTON_POSITION_X.getSize(), 
				WaitingRoomSizesEnum.CREATEROOM_JBUTTON_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.CREATEROOM_JBUTTON_WIDTH.getSize(),
				WaitingRoomSizesEnum.CREATEROOM_JBUTTON_HEIGHT.getSize()
		);
		//����� ��ư�� �̹����� �ҷ���
		this.createRoomButton.setIcon(
				new ImageIcon(ImageIO.read(
					new File("resources/waitingroom/_createRoom.jpg")).getScaledInstance(
						WaitingRoomSizesEnum.CREATEROOM_JBUTTON_WIDTH.getSize() ,
						WaitingRoomSizesEnum.CREATEROOM_JBUTTON_HEIGHT.getSize(),
						Image.SCALE_AREA_AVERAGING))
		);
		/******************************************************************************/
		//���� �������� �÷��̾� ����Ʈ�� ũ��� ��ġ
		this.playerList.setBounds(
				WaitingRoomSizesEnum.PLAYERS_LIST_POSITION_X.getSize(),
				WaitingRoomSizesEnum.PLAYERS_LIST_POSITION_Y.getSize(),
				WaitingRoomSizesEnum.PLAYERS_LIST_WIDTH.getSize(),
				WaitingRoomSizesEnum.PLAYERS_LIST_HEIGHT.getSize()		
		);
		//���� �������� �÷��̾� ��� �̹����� �ҷ��� JPanel ����
		this.playerListBackgrounnd = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/waitingroom/waitingRoomInfo.png")),
							0,
							0,
							WaitingRoomSizesEnum.PLAYERS_LIST_BACKGROUND_WIDTH.getSize(), 
							WaitingRoomSizesEnum.PLAYERS_LIST_BACKGROUND_HEIGHT.getSize(), 
							this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		//���� �������� �÷��̾� ��� �̹��� ũ��� ��ġ
		this.playerListBackgrounnd.setBounds(
				WaitingRoomSizesEnum.PLAYERS_LIST_BACKGROUND_POSITION_X.getSize(),
				WaitingRoomSizesEnum.PLAYERS_LIST_BACKGROUND_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.PLAYERS_LIST_BACKGROUND_WIDTH.getSize(),
				WaitingRoomSizesEnum.PLAYERS_LIST_BACKGROUND_HEIGHT.getSize()
		);
		playerList.setOpaque(false);
		playerListBackgrounnd.setOpaque(false);
		
		/******************************************************************************/
		//���̵�
		this.userID.setBounds(
				WaitingRoomSizesEnum.MY_INFO_USERID_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_USERID_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_USERID_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_USERID_HEIGHT.getSize()
		);
		//����
		this.score.setBounds(
				WaitingRoomSizesEnum.MY_INFO_SCORE_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_SCORE_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_SCORE_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_SCORE_HEIGHT.getSize()
		);
		
		//�·�
		this.winningRate.setBounds(
				WaitingRoomSizesEnum.MY_INFO_WINNINGRATE_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_WINNINGRATE_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_WINNINGRATE_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_WINNINGRATE_HEIGHT.getSize()
		);
		
		//����
		this.point.setBounds(
				WaitingRoomSizesEnum.MY_INFO_POINT_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_POINT_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_POINT_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_POINT_HEIGHT.getSize()
		);
		
		//���
		this.level.setBounds(
				WaitingRoomSizesEnum.MY_INFO_LEVEL_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_LEVEL_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_LEVEL_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_LEVEL_HEIGHT.getSize()
		);
		
		//����
		this.correct.setBounds(
				WaitingRoomSizesEnum.MY_INFO_CORRECT_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_CORRECT_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_CORRECT_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_CORRECT_HEIGHT.getSize()
		);
		//���� ��ư�� �̹����� �ҷ���
		this.correct.setIcon(
				new ImageIcon(ImageIO.read(
					new File("resources/waitingroom/correct.png")).getScaledInstance(
						WaitingRoomSizesEnum.MY_INFO_CORRECT_WIDTH.getSize() ,
						WaitingRoomSizesEnum.MY_INFO_CORRECT_HEIGHT.getSize(),
						Image.SCALE_AREA_AVERAGING))
		);


		//������ �̹��� Ʋ
		this.myInfoImage = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/waitingroom/imageframe.png")),
							0,
							0,
							WaitingRoomSizesEnum.MY_INFO_IMAGE_WIDTH.getSize(), 
							WaitingRoomSizesEnum.MY_INFO_IMAGE_HEIGHT.getSize(), 
							this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		this.myInfoImage.setBounds(
				WaitingRoomSizesEnum.MY_INFO_IMAGE_POSITION_X.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_IMAGE_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_IMAGE_WIDTH.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_IMAGE_HEIGHT.getSize()

		);
		myInfoImage.setOpaque(false);
		
		//���� ����â�� ��� �̹����� �ҷ��� JPanel ����
		this.myInfo = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(
						new File("resources/waitingroom/waitingRoomInfo.png")),
							0,
							0,
							WaitingRoomSizesEnum.MY_INFO_WIDTH.getSize(), 
							WaitingRoomSizesEnum.MY_INFO_HEIGHT.getSize(), 
							this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		//���� ����â�� ��ġ�� ũ�⸦ �ҷ���
		this.myInfo.setBounds(
				WaitingRoomSizesEnum.MY_INFO_POSITION_X.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_WIDTH.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_HEIGHT.getSize()
		);
		
		myInfo.setOpaque(false);
		
		/******************************************************************************/
	
		//���ӽ��� ��ư�׵θ� ȿ���� ������
		this.gamestartButton.setBorderPainted(false);
		this.gamestartButton.setContentAreaFilled(false);
		this.gamestartButton.setFocusPainted(false);
		//���ӽ��� ��ư�̹��� ©���°� �̹��� �����̵����� �ذ�����
		this.gamestartButton.setIconTextGap(this.createRoomButton.getIconTextGap() - 15);
		
		//����� ��ư�׵θ� ȿ���� ������
		this.createRoomButton.setBorderPainted(false);
		this.createRoomButton.setContentAreaFilled(false);
		this.createRoomButton.setFocusPainted(false);
		//����� ��ư�̹��� ©���°� �̹��� �����̵����� �ذ�����
		this.createRoomButton.setIconTextGap(this.createRoomButton.getIconTextGap() - 15);
		
		//�޽��� ������ ��ư�׵θ� ȿ���� ������
		this.sendMessage.setBorderPainted(false);
		this.sendMessage.setContentAreaFilled(false);
		this.sendMessage.setFocusPainted(false);
		
		//���� ��ư �׵θ� ȿ���� ������
		this.correct.setBorderPainted(false);
		this.correct.setContentAreaFilled(false);
		this.correct.setFocusPainted(false);
		
		//������ ��Ʈ
		this.userID.setFont(new Font("a��������", Font.BOLD, 18));
		this.score.setFont(new Font("a��������", Font.BOLD, 16));
		this.winningRate.setFont(new Font("a��������", Font.BOLD, 16));
		this.point.setFont(new Font("a��������", Font.BOLD, 16));
		this.level.setFont(new Font("a��������", Font.BOLD, 18));
		
		
		
		this.setLayout(null);
		
		this.waitingRoomListBackground.add(new JScrollPane(waitingRoomTable));
		
		this.add(waitingRoomList);
		this.add(waitingRoomListBackground);
		this.add(chattingOutput);
		this.add(chattingInput);
		this.add(sendMessage);
		this.add(gamestartButton);
		this.add(createRoomButton);
		this.add(playerList);
		this.add(playerListBackgrounnd);
		this.add(myInfoImage);
		this.add(userID);
		this.add(score);
		this.add(winningRate);
		this.add(point);
		this.add(level);
		this.add(correct);
		this.add(myInfo);
		this.add(waitingRoomListScroll);
		

	}
	
	private void waitingRoomInfoFont(Font font) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			
	}
	
}