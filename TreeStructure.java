package userInteface;

import java.awt.Color;

import javax.swing.JLabel;

public class TreeStructure {
	TreeData start = null;
	private TreeData last = null;
	private TreeData node = null;
	private Color[] labelColor = {Color.PINK, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.MAGENTA};
	
	public TreeStructure(String [] TextAreaData) {
		for(int i = 0; i < TextAreaData.length; i++) {
			node = new TreeData(TextAreaData[i]);
			if((TextAreaData[0].charAt(0) != '\t') && start == null) {//root 일 때
				start = node;
				start.setHeight(0);
				last = start;
			}
			else {
					
					if(last.getData().lastIndexOf('\t') == node.getData().lastIndexOf('\t')) { //앞의 노드와 지금 현재 노드가 같은 계층일 때
						last.setSibling(node);
						node.setParent(last.getParent());
						node.setHeight(last.getHeight());
					}
					if(last.getData().lastIndexOf('\t') + 1 == node.getData().lastIndexOf('\t')) { // 앞의 노드가 현재 노드의 parent 일 때
						node.setParent(last);
						last.setChild(node);
						node.setHeight(last.getHeight()+1);
					}
					if(last.getData().lastIndexOf('\t') == node.getData().lastIndexOf('\t') + 1) {// 앞의 노드가 현재 노드의 parent의 sibling 일 때
						last.getParent().setSibling(node);
						node.setHeight(last.getParent().getHeight());
						node.setParent(last.getParent().getParent());
					}
				}
			last.next = node;
			last = node;
			
			}
		}
	
	public JLabel nodeLabel(TreeData node) { // 이제 구체적인 위치를 조정하면 될듯.
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
