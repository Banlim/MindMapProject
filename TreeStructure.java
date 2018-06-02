package userInteface;

import java.awt.Color;

import javax.swing.JLabel;

public class TreeStructure {
	TreeData start = null;
	private TreeData last = null;
	private TreeData node = null;
	private TreeData temp = null;
	private Color[] labelColor = {Color.PINK, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.MAGENTA};
	
	public TreeStructure(String [] TextAreaData, int [] TextAreaDataCount) {
		for(int i = 0; i < TextAreaData.length; i++) {
			node = new TreeData(TextAreaData[i]);
			if((TextAreaData[0].charAt(0) != '\t') && start == null) {//root �� ��
				start = node;
				start.setHeight(0);
				last = start;
			}
			else {
					
					if(last.getData().lastIndexOf('\t') == TextAreaDataCount[i]) { //���� ���� ���� ���� ��尡 ���� ������ ��
						last.setSibling(node);
						node.setParent(last.getParent());
						node.setHeight(TextAreaDataCount[i]);
					}
					else if(last.getData().lastIndexOf('\t') + 1 == TextAreaDataCount[i]) { // ���� ��尡 ���� ����� parent �� ��
						node.setParent(last);
						last.setChild(node);
						node.setHeight(TextAreaDataCount[i]);
					}
					else { // ���� ���� ���� ���� ��� ���� ��
						for(int j = 0; j < i; j++) {
							temp = last;
							if(TextAreaDataCount[i] == TextAreaDataCount[j]) {
								
								node.setHeight(TextAreaDataCount[i]);
								node.setParent(temp.getParent());
								node.setSibling(temp);
								temp = null;
								break;
							}
							temp = temp.getParent();
						}
						
					}
				}
			last.next = node;
			last = node;
			
			}
		}
	
	public JLabel nodeLabel(TreeData node) { // ���� ��ü���� ��ġ�� �����ϸ� �ɵ�.
		JLabel la = new JLabel(node.getData());
		la.setSize(60,30);
		la.setBackground(labelColor[node.getData().lastIndexOf('\t')%5 + 1]);
		int x = (int)(Math.random()*400)+50;
		int y = (int)(Math.random()*400)+50;
		la.setLocation(x, y);
		la.setOpaque(true);
		
		return la;
	}
}
