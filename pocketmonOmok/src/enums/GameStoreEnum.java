package enums;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.border.EmptyBorder;

public enum GameStoreEnum {
Screen_SIZE(Toolkit.getDefaultToolkit().getScreenSize()),
	
	GAME_STORE_PANEL_WIDTH((int)(Screen_SIZE.getDimension().getWidth() * 0.25)),
	GAME_STORE_PANEL_HEIGHT((int)(GAME_STORE_PANEL_WIDTH.getSize() * 1.2)),	
	GAME_STORE_PANEL_POSITION_X((int)((Screen_SIZE.getDimension().getWidth() / 2) - (GAME_STORE_PANEL_WIDTH.getSize() / 2 ))),
	GAME_STORE_PANEL_POSITION_Y((int)((Screen_SIZE.getDimension().getHeight() / 2) - (GAME_STORE_PANEL_HEIGHT.getSize() / 2))),
	
//-----------------------------------------------------------------------------------------------------
	
	//userMoneyPanel �г�ũ��
		STORE_USER_MONEY_PANEL_REC(new Rectangle(
				(int)(GAME_STORE_PANEL_POSITION_X.getSize() / 100 * 3),
				(int)(GAME_STORE_PANEL_POSITION_Y.getSize() / 100 * 15),
				(int)(GAME_STORE_PANEL_WIDTH.getSize() / 100 * 100),
				(int)(GAME_STORE_PANEL_HEIGHT.getSize() / 100 * 10)
				)),
	//����� ���� �ݾ� 
		STORE_USER_MONEY_REC(new Rectangle(
				(int)(GAME_STORE_PANEL_POSITION_X.getSize() / 100 * 1),
				(int)(GAME_STORE_PANEL_POSITION_Y.getSize() / 100 * 3),
				(int)(GAME_STORE_PANEL_WIDTH.getSize() / 100 * 55),
				(int)(GAME_STORE_PANEL_HEIGHT.getSize() / 100 * 8)
				)),
	// ���� ��ư
		STORE_USER_CONFIRM_BUTTON_REC(new Rectangle(
				(int)(GAME_STORE_PANEL_POSITION_X.getSize() / 100 * 43),
				(int)(GAME_STORE_PANEL_POSITION_Y.getSize() / 100 * 3),
				(int)(GAME_STORE_PANEL_WIDTH.getSize() / 100 * 20),
				(int)(GAME_STORE_PANEL_HEIGHT.getSize() / 100 * 8)
				)),
//--------------------------------------------------------------------------------------
		
		//ItemChoicePanel ũ��
		STORE_ITEM_CHOICE_PANEL_REC(new Rectangle(
				(int)(GAME_STORE_PANEL_POSITION_X.getSize() / 100 * 3),
				(int)(GAME_STORE_PANEL_POSITION_Y.getSize() / 100 * 80),
				(int)(GAME_STORE_PANEL_WIDTH.getSize() / 100 * 100),
				(int)(GAME_STORE_PANEL_HEIGHT.getSize() / 100 * 60)
				)),
		//�����ϱ� ��������
		STORE_USER_OWN_INTERRUPT_ITEM_REC(new Rectangle(
				(int)(GAME_STORE_PANEL_POSITION_X.getSize() / 100 * 10),
				(int)(GAME_STORE_PANEL_POSITION_Y.getSize() / 100 * 100),
				(int)(GAME_STORE_PANEL_WIDTH.getSize() / 100 * 15),
				(int)(GAME_STORE_PANEL_HEIGHT.getSize() / 100 * 5)
				)),
		
		//�����ϱ� ������ ��ġ
				STORE_USER_OWN_INTERRUPT_ITEM_BUTTON_REC(new Rectangle(
						(int)(GAME_STORE_PANEL_POSITION_X.getSize() / 100 * 3),
						(int)(GAME_STORE_PANEL_POSITION_Y.getSize() / 100 * 5),
						(int)(GAME_STORE_PANEL_WIDTH.getSize() / 100 * 41),
						(int)(GAME_STORE_PANEL_HEIGHT.getSize() / 100 * 23)
						)),
		
		//������ ������ ���� ���� X,Y,����,����
		STORE_USER_OWN_RETURN_ITEM_REC(new Rectangle(
				(int)(GAME_STORE_PANEL_POSITION_X.getSize() / 100 * 10),
				(int)(GAME_STORE_PANEL_POSITION_Y.getSize() / 100 * 216),
				(int)(GAME_STORE_PANEL_WIDTH.getSize() / 100 * 15),
				(int)(GAME_STORE_PANEL_HEIGHT.getSize() / 100 * 5)
				)),
		
		//������ ������ X,Y,����,����
				STORE_USER_OWN_RETURN_ITEM_BUTTON_REC(new Rectangle(
						(int)(GAME_STORE_PANEL_POSITION_X.getSize() / 100 * 3),
						(int)(GAME_STORE_PANEL_POSITION_Y.getSize() / 100 * 122),
						(int)(GAME_STORE_PANEL_WIDTH.getSize() / 100 * 41),
						(int)(GAME_STORE_PANEL_HEIGHT.getSize() / 100 * 23)
						)),
		//�ð��ø��� ������ ��������
		STORE_USER_OWN_TIMEEXTION_ITEM_REC(new Rectangle(
				(int)(GAME_STORE_PANEL_POSITION_X.getSize() / 100 * 40),
				(int)(GAME_STORE_PANEL_POSITION_Y.getSize() / 100 * 100),
				(int)(GAME_STORE_PANEL_WIDTH.getSize() / 100 * 15),
				(int)(GAME_STORE_PANEL_HEIGHT.getSize() / 100 * 5)
				)),
		
		//�ð��ø��� ������ ��������
		STORE_USER_OWN_TIMEEXTION_ITEM_BUtton_REC(new Rectangle(
				(int)(GAME_STORE_PANEL_POSITION_X.getSize() / 100 * 33),
				(int)(GAME_STORE_PANEL_POSITION_Y.getSize() / 100 * 5),
				(int)(GAME_STORE_PANEL_WIDTH.getSize() / 100 * 41),
				(int)(GAME_STORE_PANEL_HEIGHT.getSize() / 100 * 23)
				)),
				
		
		
		
//-----------------------------------------------------------------------------------
		//������ �г�
		STORE_OUT_PANEL_REC(new Rectangle(
				(int)(GAME_STORE_PANEL_POSITION_X.getSize() / 100 * 50),
				(int)(GAME_STORE_PANEL_POSITION_Y.getSize() / 100 * 330),
				(int)(GAME_STORE_PANEL_WIDTH.getSize() / 100 * 23),
				(int)(GAME_STORE_PANEL_HEIGHT.getSize() / 100 * 10)
				)),
		
		//������ ������ 
		STORE_OUT_BUTTON_REC(new Rectangle(
				(int)(GAME_STORE_PANEL_POSITION_X.getSize() / 100 * 1),
				(int)(GAME_STORE_PANEL_POSITION_Y.getSize() / 100 * 1),
				(int)(GAME_STORE_PANEL_WIDTH.getSize() / 100 * 20),
				(int)(GAME_STORE_PANEL_HEIGHT.getSize() / 100 * 8)
				)),
		
		
		//�Ϲ� ��Ʈ
		LABELFONT_DEFAULT(new Font("a��������",Font.BOLD,17)),
		// �Ϲݻ���
		LABELCOLOR_DEFAULT(Color.gray),
		//�ؽ�Ʈ �׵θ� ���ֱ�
		LABEL_DEFAULT(new EmptyBorder(0,0,0,0));
	
	
	private Dimension dimension;
	private int size;
	private Font font;
	private Color color;
	private Rectangle rec;
	private EmptyBorder emptyBorder;
	
	private GameStoreEnum(Dimension dimension) {
		this.dimension = dimension;
	}
	private GameStoreEnum(int size) {
		this.size = size;
	}
	private GameStoreEnum(Font font) {
		this.font = font;
	}
	private GameStoreEnum(Color color) {
		this.color = color;
	}
	private GameStoreEnum(Rectangle rec) {
		this.rec = rec;
	}
	private GameStoreEnum(EmptyBorder emptyBorder) {
		this.emptyBorder = emptyBorder;
	}
	public EmptyBorder getEmptyBorder() {
		return emptyBorder;
	}
	public Rectangle getRectangle() {
		return rec;
	}
	public Color getColor() {
		return color;
	}
	public Font getFont() {
		return font;
	}
	private Dimension getDimension() {
		return dimension;
	}
	public int getSize() {
		return size;
	}
	
	

}
