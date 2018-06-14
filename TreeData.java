package userInterface;

import javax.swing.JFrame;

public abstract class TreeData extends JFrame {
	private TreeData[] child=new TreeData[10];
	private TreeData parent;
	private TreeData sibling;
	private int level;
	private int childNum; //자식 노드의 개수
	private int orderNum; // 자신의 부모 아래에서 현재 레벨(sibling과 자신)이 몇 번째로 나왔는지(1번째부터 시작)
	private boolean isDragged;
	protected String data;
	TreeData next;
	
	
	public abstract int getX();
	abstract void setX(int x);
	public abstract int getY();
	abstract void setY(int y);
	public abstract int getWidth();
	abstract void setWidth(int width);
	public abstract int getHeight();
	abstract void setHeight(int height);
	abstract int getColor();
	abstract void setColor(int color);
	abstract String HexColor(int color);
	
	public TreeData() {
		this.data = null;
		this.child[0] = null;
		this.parent = null;
		this.sibling = null;
		this.level = 0;
		this.childNum = 0;
		this.orderNum = 0;
		this.next = null;
		this.isDragged=false;
	}
	public void setChild(TreeData newData,int i) {
		this.child[i] = newData;
	}
	public TreeData getChild(int i) {
		return child[i];
	}
	public void setParent(TreeData newData) {
		this.parent = newData;
	}
	public TreeData getParent() {
		return parent;
	}
	public void setSibling(TreeData newData) {
		this.sibling = newData;
	}
	public TreeData getSibling() {
		return sibling;
	}
	public void setlevel(int newlevel) {
		this.level = newlevel;
	}
	public int getlevel() {
		return level;
	}
	public void setChildNum(int childNum) {
		this.childNum = childNum;
	}
	public int getChildNum() {
		return childNum;
	}
	public void setOrderNum(int newOrderNum) {
		this.orderNum = newOrderNum;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setData(String newData) {
		this.data = newData;
	}
	public String getData() {
		return data;
	}
	
}