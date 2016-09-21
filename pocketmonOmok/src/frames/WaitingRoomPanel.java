package frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import enums.frames.WaitingRoomSizesEnum;

public class WaitingRoomPanel extends JPanel implements ActionListener {	
	private JPanel background;
	
	private JScrollPane waitingRoomListScroll;
	private JTable waitingRoomTable;
	private JPanel waitingRoomListBackground;
	
	private JButton gamestartButton;
	private JButton createRoomButton;
	
	private JTextArea chattingOutput;
	private JTextField chattingInput;
	private JButton sendMessage;
	
	private JList<String> playerList;
	private JPanel playerListBackground;
	private JScrollPane playerListScroll;
	
	private JPanel myInfo;
	private JPanel myInfoImage;
	private JLabel userID;
	private JLabel userIDText;
	private JLabel score;
	private JLabel scoreText;
	private JLabel winningRate;
	private JLabel winningRateText;
	private JLabel point;
	private JLabel pointText;
	private JLabel level;
	private JLabel levelText;
	private JButton correct;
	
	private Map<String,ImageIcon> imageMap;

	public WaitingRoomPanel() throws IOException {
		//==========================접속자 리스트==========================
		String[] player = {"yjyj","hello","wowwowwow","OOOOOOOOOOOOOOO","1","2","3","4","5","6","7","8","9","10"};
		imageMap = createImage(player);
		this.playerList = new JList(player);
		playerList.setCellRenderer(new PlayerRenderer());
		
		this.playerListScroll = new JScrollPane();
		this.playerListScroll.setViewportView(this.playerList);

		
		this.playerListScroll.setOpaque(false);
		this.playerListScroll.getViewport().setOpaque(false);
		this.playerList.setOpaque(false);
		
		//==========================대기방 리스트==========================
		
		Font font = new Font("a으라차차",Font.BOLD,15);
		WaitingRoomListTable roomListModel = new WaitingRoomListTable();

//		//대기실 List내용 가운데정렬
//		DefaultListCellRenderer defaultrenderer = new DefaultListCellRenderer();//정렬을 위해 생성
//		defaultrenderer.setHorizontalTextPosition(SwingConstants.CENTER);       //가운데로 정렬
//		TableColumnModel centerArray = waitingRoomTable.getColumnModel();		//가운데정렬할 ColumnModel을 가져옴	
//		for (int i = 0; i < centerArray.getColumnCount(); i++) {     			//반복문으로 가운데정렬
//			centerArray.getColumn(i).setCellRenderer(defaultrenderer);
//		}

		
		DefaultTableModel defaultTableModel = new DefaultTableModel(roomListModel.getWaitingRoomListData(), roomListModel.getWaitingRoomListColumn());
		this.waitingRoomTable = new JTable(defaultTableModel) {
			@Override
			public Class getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
			@Override
			//테이블 수정 금지
			public boolean isCellEditable(int row, int column){
			    return false;
			}
		};
		
		this.waitingRoomTable.getTableHeader().setFont(new Font("a으라차차", Font.BOLD, 20));//방타이틀글꼴
		this.waitingRoomTable.setFont(font);
		this.waitingRoomTable.setForeground(Color.WHITE);
		this.waitingRoomTable.setShowVerticalLines(false);                               //수직선을 그릴것인가
		this.waitingRoomTable.getTableHeader().setReorderingAllowed(false);              //이동불가
		this.waitingRoomTable.getTableHeader().setResizingAllowed(false);                //크기 조절 불가
		this.waitingRoomTable.setOpaque(false);
		this.waitingRoomTable.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.waitingRoomTable.setBackground(new Color(0, 0, 0, 0));
		
		this.waitingRoomTable.getColumn("OX").setPreferredWidth(2);
		this.waitingRoomTable.getColumn("NO").setPreferredWidth(2);
		this.waitingRoomTable.getColumn("TITLE").setPreferredWidth(300);
		this.waitingRoomTable.getColumn("MASTER").setPreferredWidth(150);
		this.waitingRoomTable.getColumn("NUM").setPreferredWidth(20);
		this.waitingRoomTable.setRowHeight(50);
		

		//==========================채팅방&내정보==========================
		
		this.chattingOutput = new JTextArea();
		this.chattingInput  = new JTextField();
		this.sendMessage    = new JButton();
						
		this.gamestartButton  = new JButton();
		this.createRoomButton = new JButton();
			
		this.userID 	 	 = new JLabel("ID");
		this.userIDText  	 = new JLabel("여기에아이디가들어가요label");
		this.score 		 	 = new JLabel("전적");
		this.scoreText   	 = new JLabel("12345");
		this.winningRate 	 = new JLabel("승률");
		this.winningRateText = new JLabel("123123");
		this.point 		 	 = new JLabel("승점");
		this.pointText       = new JLabel("3333333");
		this.level 		 	 = new JLabel(".LV");
		this.levelText       = new JLabel();
		this.correct 	 	 = new JButton();
		
		this.roomListPosition();
			
	}


	/***************************접속자 리스트 클래스***************************/
	public class PlayerRenderer extends DefaultListCellRenderer {
		

		Font font = new Font("a으라차차", Font.BOLD, 15);
		
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
	
	/***************************접속자 리스트 맵***************************/
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

	/***************************대기실 위치***************************/
	public void roomListPosition() throws IOException {
		
	
		//방 리스트의 배경 이미지를 불러올 JPanel 생성
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
		
		
		//방리스트 배경 이미지를 가져옴
		this.waitingRoomListBackground.setBounds(
				WaitingRoomSizesEnum.WAITING_ROOM_LIST_BACKGROUND_POSITION_X.getSize(), 
				WaitingRoomSizesEnum.WAITING_ROOM_LIST_BACKGROUND_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.WAITING_ROOM_LIST_SIZE_BACKGROUND_WIDTH.getSize(), 
				WaitingRoomSizesEnum.WAITING_ROOM_LIST_SIZE_BACKGROUND_HEIGHT.getSize()
		);
		
		this.waitingRoomListScroll = new JScrollPane(this.waitingRoomTable);
		this.waitingRoomListScroll.setViewportView(this.waitingRoomTable);
		
		//방리스트 위치와 크기를 가져옴
				this.waitingRoomListScroll.setBounds(
						0,0,
						WaitingRoomSizesEnum.WAITING_ROOM_LIST_SIZE_WIDTH.getSize(),
						WaitingRoomSizesEnum.WAITING_ROOM_LIST_SIZE_HEIGHT.getSize()
				);	
	
		this.waitingRoomListBackground.setLayout(null);
		this.waitingRoomListBackground.setOpaque(false);

		this.waitingRoomListScroll.setOpaque(false);
		this.waitingRoomListScroll.getViewport().setOpaque(false);
		
		/******************************************************************************/
		//채팅 입력창의 위치와 크기를 가져옴
		this.chattingOutput.setBounds(
				WaitingRoomSizesEnum.CHATTING_OUTPUT_POSITION_X.getSize(),
				WaitingRoomSizesEnum.CHATTING_OUTPUT_POSITION_Y.getSize(),
				WaitingRoomSizesEnum.CHATTING_OUTPUT_SIZE_WIDTH.getSize(),
				WaitingRoomSizesEnum.CHATTING_OUTPUT_SIZE_HEIGHT.getSize()
		);
		//채팅 출력창의 위치와 크기를 가져옴
		this.chattingInput.setBounds(
				WaitingRoomSizesEnum.CHATTING_INPUT_POSITION_X.getSize(),
				WaitingRoomSizesEnum.CHATTING_INPUT_POSITION_Y.getSize(),
				WaitingRoomSizesEnum.CHATTING_INPUT_SIZE_WIDTH.getSize(),
				WaitingRoomSizesEnum.CHATTING_INPUT_SIZE_HEIGHT.getSize()	
		);
		//메세지 버튼 위치와 크기를 가져옴
		this.sendMessage.setBounds(
				WaitingRoomSizesEnum.SEND_MESSAGE_BUTTON_POSITION_X.getSize(),
				WaitingRoomSizesEnum.SEND_MESSAGE_BUTTON_POSITION_Y.getSize(),
				WaitingRoomSizesEnum.SEND_MESSAGE_BUTTON_WIDTH.getSize(),
				WaitingRoomSizesEnum.SEND_MESSAGE_BUTTON_HEIGHT.getSize()
		);
		//메시지 버튼의 이미지를 불러옴
		this.sendMessage.setIcon(
				new ImageIcon(ImageIO.read(
					new File("resources/waitingroom/send.png")).getScaledInstance(
						WaitingRoomSizesEnum.SEND_MESSAGE_BUTTON_WIDTH.getSize(),
						WaitingRoomSizesEnum.SEND_MESSAGE_BUTTON_HEIGHT.getSize(),
						Image.SCALE_AREA_AVERAGING))
		);
		
		/******************************************************************************/
		//게임시작 버튼 위치와 크기를 가져옴
		this.gamestartButton.setBounds(
				WaitingRoomSizesEnum.GAMESTART_JBUTTON_POSITION_X.getSize(), 
				WaitingRoomSizesEnum.GAMESTART_JBUTTON_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.GAMESTART_JBUTTON_WIDTH.getSize(),
				WaitingRoomSizesEnum.GAMESTART_JBUTTON_HEIGHT.getSize()
		);
		//게임시작 버튼의 이미지를 불러옴
		this.gamestartButton.setIcon(
			new ImageIcon(ImageIO.read(
				new File("resources/waitingroom/_gamestart.jpg")).getScaledInstance(
					WaitingRoomSizesEnum.GAMESTART_JBUTTON_WIDTH.getSize(),
					WaitingRoomSizesEnum.GAMESTART_JBUTTON_HEIGHT.getSize(),
					Image.SCALE_AREA_AVERAGING))
		);
		/******************************************************************************/
		//방생성 버튼 위치와 크기를 가져옴
		this.createRoomButton.setBounds(
				WaitingRoomSizesEnum.CREATEROOM_JBUTTON_POSITION_X.getSize(), 
				WaitingRoomSizesEnum.CREATEROOM_JBUTTON_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.CREATEROOM_JBUTTON_WIDTH.getSize(),
				WaitingRoomSizesEnum.CREATEROOM_JBUTTON_HEIGHT.getSize()
		);
		//방생성 버튼의 이미지를 불러옴
		this.createRoomButton.setIcon(
				new ImageIcon(ImageIO.read(
					new File("resources/waitingroom/_createRoom.jpg")).getScaledInstance(
						WaitingRoomSizesEnum.CREATEROOM_JBUTTON_WIDTH.getSize() ,
						WaitingRoomSizesEnum.CREATEROOM_JBUTTON_HEIGHT.getSize(),
						Image.SCALE_AREA_AVERAGING))
		);
		/******************************************************************************/
		
		this.playerListScroll.setBounds(
				WaitingRoomSizesEnum.PLAYERS_LIST_POSITION_X.getSize(),
				WaitingRoomSizesEnum.PLAYERS_LIST_POSITION_Y.getSize(),				
				WaitingRoomSizesEnum.PLAYERS_LIST_WIDTH.getSize(),
				WaitingRoomSizesEnum.PLAYERS_LIST_HEIGHT.getSize()		
		);
				
		//현재 접속중인 플래이어 배경 이미지를 불러올 JPanel 생성
		this.playerListBackground = new JPanel() {	
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
		
		this.playerListBackground.setLayout(null);

		
		//현재 접속중인 플래이어 배경 이미지 크기와 위치
		this.playerListBackground.setBounds(
				WaitingRoomSizesEnum.PLAYERS_LIST_BACKGROUND_POSITION_X.getSize(),
				WaitingRoomSizesEnum.PLAYERS_LIST_BACKGROUND_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.PLAYERS_LIST_BACKGROUND_WIDTH.getSize(),
				WaitingRoomSizesEnum.PLAYERS_LIST_BACKGROUND_HEIGHT.getSize()
		);
		
		this.playerListBackground.setOpaque(false);
		
		/******************************************************************************/

		//아이디, 아이디 텍스트
		this.userID.setBounds(
				WaitingRoomSizesEnum.MY_INFO_USERID_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_USERID_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_USERID_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_USERID_HEIGHT.getSize()
		);
		this.userIDText.setBounds(
				WaitingRoomSizesEnum.MY_INFO_USERID_TEXT_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_USERID_TEXT_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_USERID_TEXT_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_USERID_TEXT_HEIGHT.getSize()
		);
		//전적, 전적 텍스트
		this.score.setBounds(
				WaitingRoomSizesEnum.MY_INFO_SCORE_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_SCORE_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_SCORE_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_SCORE_HEIGHT.getSize()
		);
		this.scoreText.setBounds(
				WaitingRoomSizesEnum.MY_INFO_SCORE_TEXT_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_SCORE_TEXT_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_SCORE_TEXT_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_SCORE_TEXT_HEIGHT.getSize()
		);
		
		//승률, 승률 텍스트
		this.winningRate.setBounds(
				WaitingRoomSizesEnum.MY_INFO_WINNINGRATE_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_WINNINGRATE_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_WINNINGRATE_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_WINNINGRATE_HEIGHT.getSize()
		);
		this.winningRateText.setBounds(
				WaitingRoomSizesEnum.MY_INFO_WINNINGRATE_TEXT_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_WINNINGRATE_TEXT_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_WINNINGRATE_TEXT_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_WINNINGRATE_TEXT_HEIGHT.getSize()
		);
		
		
		//승점, 승점 텍스트
		this.point.setBounds(
				WaitingRoomSizesEnum.MY_INFO_POINT_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_POINT_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_POINT_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_POINT_HEIGHT.getSize()
		);
		this.pointText.setBounds(
				WaitingRoomSizesEnum.MY_INFO_POINT_TEXT_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_POINT_TEXT_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_POINT_TEXT_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_POINT_TEXT_HEIGHT.getSize()
		);
		
		
		//등급, 등급 텍스트 이미지
		this.level.setBounds(
				WaitingRoomSizesEnum.MY_INFO_LEVEL_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_LEVEL_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_LEVEL_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_LEVEL_HEIGHT.getSize()
		);
		this.levelText.setBounds(
				WaitingRoomSizesEnum.MY_INFO_LEVEL_TEXT_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_LEVEL_TEXT_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_LEVEL_TEXT_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_LEVEL_TEXT_HEIGHT.getSize()
		);
		this.levelText.setIcon(
				new ImageIcon(ImageIO.read(
					new File("resources/user/usermediumgrade.png")).getScaledInstance(
						WaitingRoomSizesEnum.MY_INFO_LEVEL_TEXT_WIDTH.getSize() ,
						WaitingRoomSizesEnum.MY_INFO_LEVEL_TEXT_HEIGHT.getSize(),
						Image.SCALE_AREA_AVERAGING))
		);
		
		//수정
		this.correct.setBounds(
				WaitingRoomSizesEnum.MY_INFO_CORRECT_POSITION_X.getSize(),
				WaitingRoomSizesEnum.MY_INFO_CORRECT_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_CORRECT_WIDTH.getSize(),
				WaitingRoomSizesEnum.MY_INFO_CORRECT_HEIGHT.getSize()
		);
		//수정 버튼의 이미지를 불러옴
		this.correct.setIcon(
				new ImageIcon(ImageIO.read(
					new File("resources/waitingroom/correct.png")).getScaledInstance(
						WaitingRoomSizesEnum.MY_INFO_CORRECT_WIDTH.getSize() ,
						WaitingRoomSizesEnum.MY_INFO_CORRECT_HEIGHT.getSize(),
						Image.SCALE_AREA_AVERAGING))
		);


		//내정보 이미지 틀
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
		
		//나의 정보창의 배경 이미지를 불러올 JPanel 생성
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
		
		//나의 정보창의 위치와 크기를 불러옴
		this.myInfo.setBounds(
				WaitingRoomSizesEnum.MY_INFO_POSITION_X.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_POSITION_Y.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_WIDTH.getSize(), 
				WaitingRoomSizesEnum.MY_INFO_HEIGHT.getSize()
		);
		
		myInfo.setOpaque(false);
		
		/******************************************************************************/
	
		//게임시작 버튼테두리 효과를 없애줌
		this.gamestartButton.setBorderPainted(false);
		this.gamestartButton.setContentAreaFilled(false);
		this.gamestartButton.setFocusPainted(false);
		//게임시작 버튼이미지 짤리는걸 이미지 간격이동으로 해결해줌
		this.gamestartButton.setIconTextGap(this.createRoomButton.getIconTextGap() - 15);
		
		//방생성 버튼테두리 효과를 없애줌
		this.createRoomButton.setBorderPainted(false);
		this.createRoomButton.setContentAreaFilled(false);
		this.createRoomButton.setFocusPainted(false);
		//방생성 버튼이미지 짤리는걸 이미지 간격이동으로 해결해줌
		this.createRoomButton.setIconTextGap(this.createRoomButton.getIconTextGap() - 15);
		
		//메시지 보내는 버튼테두리 효과를 없애줌
		this.sendMessage.setBorderPainted(false);
		this.sendMessage.setContentAreaFilled(false);
		this.sendMessage.setFocusPainted(false);
		
		//수정 버튼 테두리 효과를 없애줌
		this.correct.setBorderPainted(false);
		this.correct.setContentAreaFilled(false);
		this.correct.setFocusPainted(false);
		
		//방정보 폰트
		this.userID.setFont(new Font("a으라차차", Font.BOLD, 18));
		this.score.setFont(new Font("a으라차차", Font.BOLD, 16));
		this.winningRate.setFont(new Font("a으라차차", Font.BOLD, 16));
		this.point.setFont(new Font("a으라차차", Font.BOLD, 16));
		this.level.setFont(new Font("a으라차차", Font.BOLD, 18));
		
		
		
		this.setLayout(null);

		this.waitingRoomListBackground.add(waitingRoomListScroll);
		this.add(waitingRoomListBackground);
		this.add(chattingOutput);
		this.add(chattingInput);
		this.add(sendMessage);
		this.add(gamestartButton);
		this.add(createRoomButton);
		this.playerListBackground.add(playerListScroll);
		this.add(playerListBackground);
		this.add(myInfoImage);
		this.add(userID);
		this.add(userIDText);
		this.add(score);
		this.add(scoreText);
		this.add(winningRate);
		this.add(winningRateText);
		this.add(point);
		this.add(pointText);
		this.add(level);
		this.add(levelText);
		this.add(correct);
		this.add(myInfo);
		
		
	}
	
	private void waitingRoomInfoFont(Font font) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			
	}
}