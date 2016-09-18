package enums;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Size;

public enum searchPwdEnum {
	Screen_SIZE(Toolkit.getDefaultToolkit().getScreenSize()),
	
	SEARCH_PWD_FRAME_WIDTH((int)(Screen_SIZE.getDimension().getWidth() * 0.25)),
	SEARCH_PWD_FRAME_HEIGHT((int)(SEARCH_PWD_FRAME_WIDTH.getSize() * 0.9)),	
	SEARCH_PWD_FRAME_POSITION_X((int)((Screen_SIZE.getDimension().getWidth() / 2) - (SEARCH_PWD_FRAME_WIDTH.getSize() / 2 ))),
	SEARCH_PWD_FRAME_POSITION_Y((int)((Screen_SIZE.getDimension().getHeight() / 2) - (SEARCH_PWD_FRAME_HEIGHT.getSize() / 2))),
	
//�̸�, �̸��� ���̺�
	SEARCH_ID_LABEL(new Rectangle(
			(int)(SEARCH_PWD_FRAME_POSITION_X.getSize() / 100 * 7),
			(int)(SEARCH_PWD_FRAME_POSITION_Y.getSize() / 100 * 15),
			(int)(SEARCH_PWD_FRAME_WIDTH.getSize() / 100 * 16),
			(int)(SEARCH_PWD_FRAME_HEIGHT.getSize() / 100 * 8)
			)),
	SEARCH_EMAIL_LABEL(new Rectangle(
			
			(int)(SEARCH_PWD_FRAME_POSITION_X.getSize() / 100 * 7),
			(int)(SEARCH_PWD_FRAME_POSITION_Y.getSize() / 100 * 37),
			(int)(SEARCH_PWD_FRAME_WIDTH.getSize() / 100 * 16),
			(int)(SEARCH_PWD_FRAME_HEIGHT.getSize() / 100 * 8)
			)),
//// ���� ���̺�
	SEARCH_ERROR_LABEL(new Rectangle(
			
			(int)(SEARCH_PWD_FRAME_POSITION_X.getSize() / 100 * 15),
			(int)(SEARCH_PWD_FRAME_POSITION_Y.getSize() / 100 * 75),
			(int)(SEARCH_PWD_FRAME_WIDTH.getSize() / 100 * 80),
			(int)(SEARCH_PWD_FRAME_HEIGHT.getSize() / 100 * 13)
			)),
////���� ���̺�
//	
//// �̸� �ؽ�Ʈ �ʵ� x,y, ���� ���� 
	SEARCH_ID_TEXTFIELD(new Rectangle(
			(int)(SEARCH_PWD_FRAME_POSITION_X.getSize() / 100 * 22),
			(int)(SEARCH_PWD_FRAME_POSITION_Y.getSize() / 100 * 15),
			(int)(SEARCH_PWD_FRAME_WIDTH.getSize() / 100 * 50),
			(int)(SEARCH_PWD_FRAME_HEIGHT.getSize() / 100 * 8)
			)),
	// �̸��� �ؽ�Ʈ �ʵ� x,y, ���� ���� 
	SEARCH_EMAIL_TEXTFIELD(new Rectangle(
			(int)(SEARCH_PWD_FRAME_POSITION_X.getSize() / 100 * 22),
			(int)(SEARCH_PWD_FRAME_POSITION_Y.getSize() / 100 * 37),
			(int)(SEARCH_PWD_FRAME_WIDTH.getSize() / 100 * 50),
			(int)(SEARCH_PWD_FRAME_HEIGHT.getSize() / 100 * 8)
			)),
	// ����  �ؽ�Ʈ �ʵ� x,y, ���� ���� 
	SEARCH_CONFIRM_TEXTFIELD(new Rectangle(
			(int)(SEARCH_PWD_FRAME_POSITION_X.getSize() / 100 * 22),
			(int)(SEARCH_PWD_FRAME_POSITION_Y.getSize() / 100 * 59),
			(int)(SEARCH_PWD_FRAME_WIDTH.getSize() / 100 * 35),
			(int)(SEARCH_PWD_FRAME_HEIGHT.getSize() / 100 * 8)
			)),
	// �ش� ������ ������ �´��� �ƴ����� ���� ��� �ؽ�Ʈ �ʵ�   x,y, ���� ���� 
	SEARCH_ANSWER_LABEL(new Rectangle(
			(int)(SEARCH_PWD_FRAME_POSITION_X.getSize() / 100 * 7),
			(int)(SEARCH_PWD_FRAME_POSITION_Y.getSize() / 100 * 95),
			(int)(SEARCH_PWD_FRAME_WIDTH.getSize() / 100 * 90),
			(int)(SEARCH_PWD_FRAME_HEIGHT.getSize() / 100 * 15)
			)),
	//3�� ���ѽð� ���̺�  x,y, ���� ���� 
	SEARCH_Time_LABEL(new Rectangle(
			(int)(SEARCH_PWD_FRAME_POSITION_X.getSize() / 100 * 45),
			(int)(SEARCH_PWD_FRAME_POSITION_Y.getSize() / 100 * 55),
			(int)(SEARCH_PWD_FRAME_WIDTH.getSize() / 100 * 15),
			(int)(SEARCH_PWD_FRAME_HEIGHT.getSize() / 100 * 15)
			)),
	
//	//����Ȯ�� ��ư�� ����
	SEARCH_CONFIRM_BUTTON(new Rectangle(
			(int)(SEARCH_PWD_FRAME_POSITION_X.getSize() / 100 * 7),
			(int)(SEARCH_PWD_FRAME_POSITION_Y.getSize() / 100 * 59),
			(int)(SEARCH_PWD_FRAME_WIDTH.getSize() / 100 * 16),
			(int)(SEARCH_PWD_FRAME_HEIGHT.getSize() / 100 * 8)
			)),

	//�Ϲ� ��Ʈ
	LABELFONT_DEFAULT(new Font("a��������",Font.BOLD,16)),
	//���� �޼��� ��Ʈ
	LABELFONT_ERROR(new Font("a��������",Font.BOLD,18)),
	//�ؽ�Ʈ �׵θ� ���ֱ�
	LABEL_DEFAULT(new EmptyBorder(0,0,0,0)),	
	
	//���� �޼�������
		LABELCOLOR_ERROR(Color.red),
	// �Ϲݻ���
		LABELCOLOR_DEFAULT(Color.BLUE);
	
	private Dimension dimension;
	private int size;
	private Color color;
	private Font font;
	private EmptyBorder border;
	private Rectangle rec;
	
	
	private searchPwdEnum(Rectangle rec) {
		this.rec = rec;
	}
	private searchPwdEnum(Dimension dimension) {
		this.dimension = dimension;
	}
	
	private searchPwdEnum(int size) {
		this.size = size;
	}
	private searchPwdEnum(Color color) {
		this.color = color;
	}
	private searchPwdEnum(Font font) {
		this.font = font;
	}
	private searchPwdEnum(EmptyBorder border) {
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
