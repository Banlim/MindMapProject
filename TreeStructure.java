package userInterface;



import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class TreeStructure {
	private TreeData start = null;
	private TreeData last = null;
	private TreeData node = null;
	private TreeData temp = null;
	private TreeData lastData = null;
	private Color[] labelColor = {Color.PINK, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.white};
	
	private TreeData[] treeData;	
	private int k = 2;
	private int l = 2;
	private int a = 0;
	
	private int level1 = 1;
	private int level2 = 1;
	private int level3 = 1;
	private int level4 = 1;
	private int level5 = 1;
	private int level6 = 1;
	
	private int[] X1 = {30, 100, 170, 250, 320, 390, 470, 540, 610};
	private int[] Y1 = {30, 90, 160, 250, 400, 480, 540, 600};
	
	
	private String[] TextAreaData;
	private int[] TextAreaDataCount;
//	private int[] NodeChildCount;
	
	public TreeStructure(String[] textArea, int [] TextAreaDataCount) {
		this.TextAreaData = textArea;
		this.TextAreaDataCount = TextAreaDataCount;
		treeData = new TreeData[textArea.length];
		//TreeStructureSetting();
	//}
		
	//boolean TreeStructureSetting() {	
		for(int i = 0; i < textArea.length; i++) {
			node = new NodeLocation();
			node.setData(textArea[i]);
			if((textArea[0].charAt(0) != '\t') && start == null) {//root 일 때
				//start = new NodeLocation();
				node.setlevel(0);
				start = node;
				//start.setlevel(0);
				last = start;
			}
			else {
				
					
					if(last.getData().lastIndexOf('\t')+1 == TextAreaDataCount[i]) { //앞의 노드와 지금 현재 노드가 같은 계층일 때
						last.setSibling(node);
						node.setParent(last.getParent());
						node.setlevel(TextAreaDataCount[i]);
						//NodeChildCount[i] = NodeChildCount[i];
					}
					else if(last.getData().lastIndexOf('\t') + 2 == TextAreaDataCount[i]) { // 앞의 노드가 현재 노드의 parent 일 때
						node.setParent(last);
						last.setChild(node);
						node.setlevel(TextAreaDataCount[i]);
					}
					else { // 앞의 노드와 현재 노드와 상관 없을 때
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
					case 1 : // 레벨이 1일 때
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
					
					treeData[i] = node;
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
	
	public JLabel nodeLabel(TreeData node) { // 이제 구체적인 위치를 조정하면 될듯. 
		// nodeLabel 만의 클래스를 만들어서 관리하는게 나을 것 같다.
		//JLabel[] nodelabel = new JLabel[node.length];
		//for(int i = 0; i < node.length; i++) {
		JLabel la = new JLabel(node.getData());
		
		//int childCount = node.getParent().
		
		if(node.getlevel() == 0) { // root 일 때 위치와 넓이, 색깔
			node.setX(330);
			node.setY(330);
			node.setWidth(80);
			node.setHeight(50);
			
			node.setColor(labelColor[node.getlevel() % 5].getRGB());
			// 속성페인에 들어갈 변수들 설정
			
			
			
			la.setSize(node.getWidth(), node.getHeight());
			la.setBackground(new Color(node.getColor()));
			la.setLocation(node.getX(), node.getY());
			la.setVisible(true);
			la.setOpaque(true);//불투명도
		}
			
	
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
		return la;
	}
	
	public JLabel openLabel(TreeData node, int x, int y, int width, int height, int color) {
		JLabel la = new JLabel(node.getData());
		
		node.setX(x);
		node.setY(y);
		node.setWidth(width);
		node.setHeight(height);
		node.setColor(color);
		
		la.setSize(node.getWidth(), node.getHeight());
		la.setLocation(node.getX(), node.getY());
		la.setBackground(new Color(color));
		
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
	public TreeData[] getTreeData() {
		return treeData;
	}
}
