package frames;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import enums.WaitingRoomSizesEnum;

class WaitingRoomListTable {
	
	private ImageIcon ox;
	private String[] waitingRoomListColumn;
	private Object[][] waitingRoomListData;
	
	public WaitingRoomListTable () throws IOException{
			
		this.ox=new ImageIcon(ImageIO.read(
					new File("resources/user/userbegining.png")).getScaledInstance(
						WaitingRoomSizesEnum.ROOMLIST_STATUS_SIZE_WIDTH.getSize() ,
						WaitingRoomSizesEnum.ROOMLIST_STATUS_SIZW_HEIGHT.getSize(),
						Image.SCALE_AREA_AVERAGING)
		);
		
		this.waitingRoomListColumn = new String[] {"OX","NO","TITLE","MASTER","NUM"};
		this.waitingRoomListData= new Object[][] {
				{ox,"1","�������̾󸶳���������𸣰ڳ׿�","1234567890101112","(1/2)"},
				{ox,"1","�Ȥ��������̾󸶳���������𸣰ڳ׿�g44g?","dus","(1/2)"},
				{ox,"1","�Ȥ����ϼ���?","duswhd","(2/2)"},
				{ox,"1","�Ȥ����ϼ���?","duswhd","(1/2)"},
				{ox,"1","�Ȥ����ϼ���?","duswhd","(1/2)"},
				{ox,"1","�Ȥ����ϼ���?","duswhd","(1/2)"},
				{ox,"1","�Ȥ����ϼ���?","duswhd","(1/2)"},
				{ox,"1","�Ȥ����ϼ���?","duswhd","(1/2)"},
				{ox,"1","�Ȥ����ϼ���?","duswhd","(1/2)"},
				{ox,"1","�Ȥ����ϼ���?","duswhd","(1/2)"},
				{ox,"1","�Ȥ����ϼ���?","duswhd","(1/2)"},
				{ox,"1","�Ȥ����ϼ���?","duswhd","(1/2)"},
				{ox,"1","�Ȥ����ϼ���?","duswhd","(1/2)"},
				{ox,"1","�Ȥ����ϼ���?","duswhd","(1/2)"}
		};	
	
	}
	
	public ImageIcon getOx() {
		return ox;
	}
	
	public String[] getWaitingRoomListColumn() {
		return waitingRoomListColumn;
	}
	
	public Object[][] getWaitingRoomListData() {
		return waitingRoomListData;
	}
}
