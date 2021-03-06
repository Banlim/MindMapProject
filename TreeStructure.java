package userInterface;




import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import userInterface.NodeLocation;
import userInterface.TreeData;


public class TreeStructure {
	private TreeData start = null;
	private TreeData last = null;
	private TreeData node = null;
	private TreeData temp = null;
	private TreeData lastData = null;
	private Color[] labelColor = {Color.PINK, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.white};
	private JPanel MindMapPane;

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
	
	private int[] X1 = {140, 220, 330, 440, 520};
	private int[] Y1 = {160, 220, 330, 440, 500};
	private int[] X2 = {40,120,200,280,360,440,520,600};
	private int[] Y2 = {40,120,200,280,360,440,520,600};

	
	private String[] TextAreaData;
	private int[] TextAreaDataCount;

	//private MouseEventListener LableMouseEventListener = new MouseEventListener(MouseEventListener.NameValue,MouseEventListener.XValue,MouseEventListener.YValue,MouseEventListener.WidthValue,MouseEventListener.HeightValue,MouseEventListener.ColorValue);
	
	public TreeStructure(String [] textArea, int [] TextAreaDataCount) {
		this.TextAreaData = textArea;
		this.TextAreaDataCount = TextAreaDataCount;
		treeData = new TreeData[textArea.length];
		
		for(int i = 0; i < textArea.length; i++) {
			node = new NodeLocation();
			node.setData(textArea[i]);
			if((textArea[0].charAt(0) != '\t') && start == null) {//root 일 때
				node.setlevel(0);
				start = node;
				last = start;
			}
			else {
				
				
					if(last.getData().lastIndexOf('\t')+1 == TextAreaDataCount[i]) { //앞의 노드와 지금 현재 노드가 같은 계층일 때
						last.setSibling(node);
						node.setParent(last.getParent());
						node.setlevel(TextAreaDataCount[i]);
						node.getParent().setChildNum(node.getParent().getChildNum()+1);
						node.setOrderNum(last.getOrderNum()+1);
						
					}
				
					else if(last.getData().lastIndexOf('\t') + 2 == TextAreaDataCount[i]) { // 앞의 노드가 현재 노드의 parent 일 때
						node.setParent(last);
						last.setChild(node,0);
						node.setlevel(TextAreaDataCount[i]);
						last.setChildNum(last.getChildNum()+1);
						node.setOrderNum(1);
					}
					else { // 앞의 노드와 현재 노드와 상관 없을 때
						for(int j = 0; j < i; j++) {
							temp = last;
							if(TextAreaDataCount[i] == TextAreaDataCount[j]) {
								
								node.setlevel(TextAreaDataCount[i]);
								node.setParent(temp.getParent());
								//node.getParent().setChild(node);
								node.getParent().setChild(node,node.getParent().getChildNum()+1);
								node.getParent().setChildNum(node.getParent().getChildNum()+1);
								node.getParent().setOrderNum(node.getParent().getChildNum());
								node.setSibling(temp);
								
								temp = null;
								break;
							}
							temp = temp.getParent();
						}
						
					}
			
					switch(node.getlevel()) {
					case 1 : // 레벨이 1일 때
						node.setOrderNum(level1);
						level1++;
						break;
					case 2 : 
						node.setOrderNum(level2);
						level2++;
						break;
					case 3 : 
						node.setOrderNum(level3);
						level3++;
						break;
					case 4 :
						node.setOrderNum(level4);
						level4++;
						break;
					case 5 :
						node.setOrderNum(level5);
						level5++;
						break;
					case 6 :
						node.setOrderNum(level6);
						level6++;
						break;
					default :
						break;
					}
					
					
					treeData[i] = node;
					last.next = node;
					last = node;
				}
			
			}
		
		}

	public TreeData getStart() {
		return start;
	}
	
	public JLabel nodeLabel(TreeData node) { // 이제 구체적인 위치를 조정하면 될듯. 
		
		JLabel la = new JLabel(node.getData());
		la.addMouseListener(new MouseEventListener(MouseEventListener.MindMapPane,MouseEventListener.NameValue,MouseEventListener.XValue,MouseEventListener.YValue,MouseEventListener.WidthValue,MouseEventListener.HeightValue,MouseEventListener.ColorValue));
		la.addMouseMotionListener(new MouseEventListener(MouseEventListener.MindMapPane,MouseEventListener.NameValue,MouseEventListener.XValue,MouseEventListener.YValue,MouseEventListener.WidthValue,MouseEventListener.HeightValue,MouseEventListener.ColorValue));
		la.setHorizontalAlignment(SwingConstants.CENTER);
		la.setVerticalTextPosition(SwingConstants.CENTER);
		
		
		if(node.getlevel() == 0) { // root 일 때 위치와 넓이, 색깔
			node.setX(320);
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
				switch(node.getOrderNum()) {
			  /*
			   	private int[] X1 = {140, 220, 330, 440, 520};
			    private int[] Y1 = {160, 220, 330, 440, 500};
				private int[] X2 = {40,120,200,280,360,440,520,600};
				private int[] Y2 = {40,120,200,280,360,440,520,600};
			   														*/

				case 1 :
						k = 2;
						l = 2;
					

					break;
				case 2 :
						k = 2;
						l = 4;
					
					
					break;
				case 3 :
					k = 4;
					l = 4;
					
					
					break;
				case 4 :
					k = 4;
					l = 2;
					
					
					break;
				case 5 : 
					k = 3;
					l = 1;
					
					
					break;
				case 6 :
					k = 1;
					l = 3;
					
					
					break;
				case 7 : 
					k = 3;
					l = 5;
					
					
					break;
				case 8 :
					k = 5;
					l = 3;
					
					
					
					break;
				default :
					break;
					
				}
				node.setX(X1[k-1]);
				node.setY(Y1[l-1]);
				node.setWidth(60);
				node.setHeight(50);
				node.setColor(labelColor[node.getlevel()%5].getRGB());
				
			}
			else if(node.getlevel() == 2) {
				switch(node.getOrderNum()) {
				case 1 :
					if(node.getParent().getX()<X1[2]&&node.getParent().getY()<Y1[2]) {  // 2사분면
						k = 3;
						l = 2;
						
					}
					
					else if(node.getParent().getX()<X1[2]&&node.getParent().getY()>Y1[2]) { // 3사분면
						k=3;
						l=5;
						
					}
					
					else if(node.getParent().getX()>X1[2]&&node.getParent().getY()>Y1[2]) { // 4사분면
						k=3;
						l=5;
						
						
					}
					
					else if(node.getParent().getX()>X1[2]&&node.getParent().getY()<Y1[2]) { // 1사분면
	
	
					}
					
					else if(node.getParent().getX()<X1[2]&&node.getParent().getY()>Y1[2]) { // 3사분면
						
						
					}
					
					else if(node.getParent().getX()==X1[2]) { // 루트 위아래
						
						
					}

					else if(node.getParent().getY()==Y1[2]) { // 루트 양옆
						
						
					}
					
					break;
				case 2 :
					if(node.getX()<X1[2]&&node.getY()<Y1[2]) {  // 2사분면
						k = 2;
						l = 2;
						
					}
					
					else if(node.getX()<X1[2]&&node.getY()>Y1[2]) { // 3사분면
						k=3;
						l=7;
						
						
					}
					
					else if(node.getX()>X1[2]&&node.getY()>Y1[2]) { // 4사분면
						
						
					}
					
					else if(node.getX()>X1[2]&&node.getY()<Y1[2]) { // 1사분면
	
	
					}
					
					else if(node.getParent().getX()==X1[2]) { // 루트 위아래
						
						
					}

					else if(node.getParent().getY()==Y1[2]) { // 루트 양옆
						
						
					}
					
					
					break;
				case 3 :
					if(node.getX()<X1[2]&&node.getY()<Y1[2]) {  // 2사분면
						k = 2;
						l = 1;
						
					}
					
					else if(node.getX()<X1[2]&&node.getY()>Y1[2]) { // 3사분면
						k=4;
						l=7;
						
					}
					
					else if(node.getX()>X1[2]&&node.getY()>Y1[2]) { // 4사분면
						
						
					}
					
					else if(node.getX()>X1[2]&&node.getY()<Y1[2]) { // 1사분면
	
	
					}

					else if(node.getParent().getX()==X1[2]) { // 루트 위아래
						
						
					}

					else if(node.getParent().getY()==Y1[2]) { // 루트 양옆
						
						
					}
					
					break;
				default :
					break;
					
				}
			}
			else if(node.getlevel() == 3) {
				
			}
			
			
			la.setSize(node.getWidth(), node.getHeight());
			la.setBackground(new Color(node.getColor()));
			la.setLocation(node.getX(), node.getY());
			
		
			la.setVisible(true);
			la.setOpaque(true);
			
		
		}
		return la;
	}
	public JLabel openLabel(TreeData node) {
		
		JLabel lb = new JLabel(node.getData());
			
		//lb.setText(node.getData());
		lb.setSize(node.getWidth(), node.getHeight());
		lb.setLocation(node.getX(), node.getY());
		lb.setBackground(new Color(node.getColor()));
		lb.setVisible(true);
		lb.setOpaque(true);
	
		
		
		return lb; 
	}
	void print(TreeData node) {
		System.out.println("Data : " + node.getData());
		System.out.println("X : " + node.getX());
		System.out.println("Y : " + node.getY());
		System.out.println("Width : " + node.getWidth());
		System.out.println("Height : " + node.getHeight());
		System.out.println("level : " + node.getlevel());
		System.out.println("Color : " + node.getColor());
		System.out.println("OrderNum : " + node.getOrderNum());
		System.out.println("k : " + k + " , l : " + l);
		System.out.println();
	}
	public TreeData[] getTreeData() {
		return treeData;
	}

	
}
