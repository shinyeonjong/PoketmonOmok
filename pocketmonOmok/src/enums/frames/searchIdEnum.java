package enums.frames;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Size;

public enum searchIdEnum {
	Screen_SIZE(Toolkit.getDefaultToolkit().getScreenSize()),
	
	SEARCHFRAME_SIZE_WIDTH((int)(Screen_SIZE.getDimension().getWidth() * 0.25)),
	SEARCHFRAME_SIZE_HEIGHT((int)(SEARCHFRAME_SIZE_WIDTH.getSize() * 0.7)),	
	SEARCHFRAME_POSITION_X((int)((Screen_SIZE.getDimension().getWidth() / 2) - (SEARCHFRAME_SIZE_WIDTH.getSize() / 2 ))),
	SEARCHFRAME_POSITION_Y((int)((Screen_SIZE.getDimension().getHeight() / 2) - (SEARCHFRAME_SIZE_HEIGHT.getSize() / 2))),
	
	
//�̸�, �̸��� ���̺�
	SEARCH_ID_LABEL(new Rectangle(
			(int)(SEARCHFRAME_POSITION_X.getSize() / 100 * 5),
			(int)(SEARCHFRAME_POSITION_Y.getSize() / 100 * 20),
			(int)(SEARCHFRAME_SIZE_WIDTH.getSize() / 100 * 16),
			(int)(SEARCHFRAME_SIZE_HEIGHT.getSize() / 100 * 10)
			)),
	SEARCH_EMAIL_LABEL(new Rectangle(
			
			(int)(SEARCHFRAME_POSITION_X.getSize() / 100 * 5),
			(int)(SEARCHFRAME_POSITION_Y.getSize() / 100 * 42),
			(int)(SEARCHFRAME_SIZE_WIDTH.getSize() / 100 * 16),
			(int)(SEARCHFRAME_SIZE_HEIGHT.getSize() / 100 * 10)
			)),
// ���� ���̺�
	SEARCH_ERROR_LABEL(new Rectangle(
			
			(int)(SEARCHFRAME_POSITION_X.getSize() / 100 * 20),
			(int)(SEARCHFRAME_POSITION_Y.getSize() / 100 * 54),
			(int)(SEARCHFRAME_SIZE_WIDTH.getSize() / 100 * 50),
			(int)(SEARCHFRAME_SIZE_HEIGHT.getSize() / 100 * 13)
			)),
// �̸�, �̸��� �ؽ�Ʈ �ʵ�
	SEARCH_ID_TEXTFIELD(new Rectangle(
			(int)(SEARCHFRAME_POSITION_X.getSize() / 100 * 20),
			(int)(SEARCHFRAME_POSITION_Y.getSize() / 100 * 22),
			(int)(SEARCHFRAME_SIZE_WIDTH.getSize() / 100 * 50),
			(int)(SEARCHFRAME_SIZE_HEIGHT.getSize() / 100 * 10)
			)),
	SEARCH_EMAIL_TEXTFIELD(new Rectangle(
			(int)(SEARCHFRAME_POSITION_X.getSize() / 100 * 20),
			(int)(SEARCHFRAME_POSITION_Y.getSize() / 100 * 42),
			(int)(SEARCHFRAME_SIZE_WIDTH.getSize() / 100 * 50),
			(int)(SEARCHFRAME_SIZE_HEIGHT.getSize() / 100 * 10)
			)),
	
	//��ư ����
	SEARCH_CONFIRM_BUTTON(new Rectangle(
			(int)(SEARCHFRAME_POSITION_X.getSize() / 100 * 25),
			(int)(SEARCHFRAME_POSITION_Y.getSize() / 100 * 75),
			(int)(SEARCHFRAME_SIZE_WIDTH.getSize() / 100 * 30),
			(int)(SEARCHFRAME_SIZE_HEIGHT.getSize() / 100 * 20)
			)),
	
	//�Ϲ� ��Ʈ
	LABELFONT_DEFAULT(new Font("a��������",Font.BOLD,15)),
	//���� �޼��� ��Ʈ
	LABELFONT_ERROR(new Font("a��������",Font.BOLD,20)),
	//�ؽ�Ʈ �׵θ� ���ֱ�
	LABEL_DEFAULT(new EmptyBorder(0,0,0,0)),	
	
	//���� �޼�������
		LABELCOLOR_ERROR(Color.red),
	// �Ϲݻ���
		LABELCOLOR_DEFAULT(Color.green);
	
	private Dimension dimension;
	private int size;
	private Color color;
	private Font font;
	private EmptyBorder border;
	private Rectangle rec;
	
	
	private searchIdEnum(Rectangle rec) {
		this.rec = rec;
	}
	private searchIdEnum(Dimension dimension) {
		this.dimension = dimension;
	}
	
	private searchIdEnum(int size) {
		this.size = size;
	}
	private searchIdEnum(Color color) {
		this.color = color;
	}
	private searchIdEnum(Font font) {
		this.font = font;
	}
	private searchIdEnum(EmptyBorder border) {
		this.border = border;
	}
	public Rectangle getRectangle() {
		return rec;
	}
	public Dimension getDimension() {
		return dimension;
	}
	public int getSize() {
		return size;
	}
	public Color getColor() {
		return color;
	}
	public Font getFont() {
		return font;
	}
	public EmptyBorder getBorder() {
		return border;
	}
	
	

}
