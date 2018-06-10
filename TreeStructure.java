package userInteface;



import java.awt.Color;

import javax.swing.JLabel;

public class TreeStructure {
	private TreeData start = null;
	private TreeData last = null;
	private TreeData node = null;
	private TreeData temp = null;
	private TreeData lastData = null;
	private Color[] labelColor = {Color.PINK, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.white};
	
	private int k = 2;
	private int l = 2;
	
	private int level1 = 1;
	private int level2 = 1;
	private int level3 = 1;
	private int level4 = 1;
	private int level5 = 1;
	private int level6 = 1;
	
	private int[] X1 = {30, 100, 170, 250, 320, 390, 470, 540, 610};
	private int[] Y1 = {30, 90, 160, 250, 400, 480, 540, 600};
	private int[] X2 = new int[3];
	private int[] Y2 = new int[3];
	private int[] X3 = {};
	private int[] Y3 = {};
	private int[] X4 = {};
	private int[] Y4 = {};
	private int[] X5 = {};
	private int[] Y5 = {};
	
	private String[] TextAreaData;
	private int[] TextAreaDataCount;
//	private int[] NodeChildCount;
	
	public TreeStructure(String [] TextAreaData, int [] TextAreaDataCount) {
		this.TextAreaData = TextAreaData;
		this.TextAreaDataCount = TextAreaDataCount;
		//TreeStructureSetting();
	//}
		
	//boolean TreeStructureSetting() {	
		for(int i = 0; i < TextAreaData.length; i++) {
			node = new NodeLocation();
			node.setData(TextAreaData[i]);
			if((TextAreaData[0].charAt(0) != '\t') && start == null) {//root �� ��
				//start = new NodeLocation();
				node.setlevel(0);
				start = node;
				//start.setlevel(0);
				last = start;
			}
			else {
				
					
					if(last.getData().lastIndexOf('\t')+1 == TextAreaDataCount[i]) { //���� ���� ���� ���� ��尡 ���� ������ ��
						last.setSibling(node);
						node.setParent(last.getParent());
						node.setlevel(TextAreaDataCount[i]);
						//NodeChildCount[i] = NodeChildCount[i];
					}
					else if(last.getData().lastIndexOf('\t') + 2 == TextAreaDataCount[i]) { // ���� ��尡 ���� ����� parent �� ��
						node.setParent(last);
						last.setChild(node);
						node.setlevel(TextAreaDataCount[i]);
					}
					else { // ���� ���� ���� ���� ��� ���� ��
						for(int j = 0; j < i; j++) {
							temp = last;
							if(TextAreaDataCount[i] == TextAreaDataCount[j]) {
								
								node.setlevel(TextAreaDataCount[i]);
								node.setParent(temp.getParent());
								node.getParent().setChild(node);
								node.setSibling(temp);
								temp = null;
								break;
							}
							temp = temp.getParent();
						}
						
					}
			
					switch(node.getlevel()) {
					case 1 : // ������ 1�� ��
						node.setOrderLevel(level1);
						level1++;
						break;
					case 2 : 
						node.setOrderLevel(level2);
						level2++;
						break;
					case 3 : 
						node.setOrderLevel(level3);
						level3++;
						break;
					case 4 :
						node.setOrderLevel(level4);
						level4++;
						break;
					case 5 :
						node.setOrderLevel(level5);
						level5++;
						break;
					case 6 :
						node.setOrderLevel(level6);
						level6++;
						break;
					default :
						break;
					}
					
					
					last.next = node;
					last = node;
				}
			//nodeLabel(node);
			
			
			}
		//for(int j = 0; j < TextAreaData.length; j++) {
			//switch()
		//}
		
		//return true;
		//this.start = start;
		//this.last = last;
		//this.node = node;
		
		}
	//public TreeData getNode() {
		//return node;
	//}
	
	public TreeData getStart() {
		return start;
	}
	
	public JLabel nodeLabel(TreeData node) { // ���� ��ü���� ��ġ�� �����ϸ� �ɵ�. 
		// nodeLabel ���� Ŭ������ ���� �����ϴ°� ���� �� ����.
		
		
		JLabel la = new JLabel(node.getData());
		
		//int childCount = node.getParent().
		
		if(node.getlevel() == 0) { // root �� �� ��ġ�� ����, ����
			node.setX(330);
			node.setY(330);
			node.setWidth(80);
			node.setHeight(50);
			
			node.setColor(labelColor[node.getlevel() % 5].getRGB());
			// �Ӽ����ο� �� ������ ����
			
			
			
			la.setSize(node.getWidth(), node.getHeight());
			la.setBackground(new Color(node.getColor()));
			la.setLocation(node.getX(), node.getY());
			la.setVisible(true);
			la.setOpaque(true);//������
			
			//return la;
			
			}
		/*else if(node.getlevel() == lastData.getlevel()) { // ���� ��尡 ���� ����� sibling�� ��
			
			node.setX(X2[k]);
			node.setY(Y2[l]);
			node.setWidth(60);
			node.setHeight(50);
			node.setColor(labelColor[node.getlevel()%5].getRGB());
			
			la.setSize(node.getWidth(), node.getHeight());
			la.setBackground(new Color(node.getColor()));
			la.setLocation(node.getX(), node.getY());
			la.setVisible(true);
			la.setOpaque(true);
					
				}
		else if(node.getlevel() == lastData.getlevel() + 1) { // ���� ��尡 ���� ����� �ڽ��� ��
			
		}
		
		else { // �ƹ� ������ ���� ��
			
		}
			/*if(node.getlevel() == 1) {
				node.setX(0);
				node.setY(0);
				node.setWidth(70);
				node.setHeight(50);
				node.setColor(labelColor[node.getData().lastIndexOf('\t')%5 + 1].getRGB());
				
				la.setSize(node.getWidth(), node.getHeight());
				la.setLocation(node.getX(), node.getY());
				la.setBackground(new Color(node.getColor()));
			
			}
			la.setSize(60, 40);
			la.setBackground(labelColor[node.getlevel()%5+1]);
			la.setLocation(400,400);
			la.setOpaque(true);*/
		
		else {
			if(node.getlevel() == 1) {
				switch(node.getOrderLevel()) {
				case 1 :
					if(l == 0) {
						k--;
						l = 3;
					}
					
					break;
				case 2 :
					k = 5;
					l = 3;
					if(l == 0) {
						k--;
						l = 3;
					}
					
					break;
				case 3 :
					k = 6;
					l = 3;
					if(l == 0) {
						k++;
						l = 3;
					}
					
					break;
				case 4 :
					k = 2;
					l = 4;
					if(l == 7) {
						k--;
						l = 7;
					}
					
					break;
				case 5 : 
					k = 3;
					l = 4;
					if(l == 7) {
						k++;
						l = 4;
					}
					
					break;
				case 6 :
					k = 6;
					l = 4;
					if(l == 7) {
						k++;
						l = 4;
					}
					
					break;
				default :
					break;
					
				}
			}
			
			node.setX(X1[k]);
			node.setY(Y1[l]);
			node.setWidth(60);
			node.setHeight(50);
			node.setColor(labelColor[node.getlevel()%5].getRGB());
			
			la.setSize(node.getWidth(), node.getHeight());
			la.setBackground(new Color(node.getColor()));
			la.setLocation(node.getX(), node.getY());
			la.setVisible(true);
			la.setOpaque(true);
			
			if(l >= 4)
				l++;
			
			l--;
		}
		
		lastData = node;
			
		return la;
	}
	void print(TreeData node) {
		System.out.println("Data : " + node.getData());
		System.out.println("X : " + node.getX());
		System.out.println("Y : " + node.getY());
		System.out.println("Width : " + node.getWidth());
		System.out.println("Height : " + node.getHeight());
		System.out.println("level : " + node.getlevel());
		System.out.println("Color : " + node.getColor());
		System.out.println("OrderLevel : " + node.getOrderLevel());
		System.out.println("k : " + k + " , l : " + l);
		System.out.println();
	}
}
