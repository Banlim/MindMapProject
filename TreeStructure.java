package userInteface;



import java.awt.Color;

import javax.swing.JLabel;

public class TreeStructure {
	private TreeData start = null;
	private TreeData last = null;
	private TreeData node = null;
	private TreeData temp = null;
	private Color[] labelColor = {Color.PINK, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.MAGENTA};
	
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
					last.next = node;
					last = node;
				}
			//nodeLabel(node);
			
			
			}
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
			node.setX(270);
			node.setY(280);
			node.setWidth(80);
			node.setHeight(60);
			
			node.setColor(labelColor[node.getData().lastIndexOf('\t')%5+1].getRGB());
			// �Ӽ����ο� �� ������ ����
			
			
			
			la.setSize(node.getWidth(), node.getHeight());
			la.setBackground(Color.BLUE);
			la.setLocation(node.getX(), node.getY());
			la.setVisible(true);
			la.setOpaque(true);//������
			
			//return la;
			
			}
		else {
			if(node.getlevel() == 1) {
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
			la.setOpaque(true);
		}
			
			/*System.out.println(node.getX());
			System.out.println(node.getY());
			System.out.println(node.getWidth());
			System.out.println(node.getHeight());
			System.out.println(node.getData());
			//System.out.println(node.getColor());*/
		
		return la;
	}
	void print(TreeData node) {
		System.out.println(node.getX());
		System.out.println(node.getY());
		System.out.println(node.getWidth());
		System.out.println(node.getHeight());
		System.out.println(node.getData());
		System.out.println(node.getlevel());
	}
}
