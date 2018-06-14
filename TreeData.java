package userInterface;

import userInterface.TreeData;

public abstract class TreeData {
	private TreeData[] child = new TreeData[10];
	private TreeData parent;
	private TreeData sibling;
	private int level;
	//private int orderLevel; // 현재 레벨이 몇 번째로 나왔는지?
	private int childNum;
	private int orderNum;
	protected String data;
	TreeData next;
	
	abstract int getX();
	abstract void setX(int x);
	abstract int getY();
	abstract void setY(int y);
	abstract int getWidth();
	abstract void setWidth(int width);
	abstract int getHeight();
	abstract void setHeight(int height);
	abstract int getColor();
	abstract void setColor(int color);
	abstract String HexColor(int color);
	abstract int decColor(String hexColor);
	abstract String getHexColor();
	abstract void setHexColor(String Color);
	
	public TreeData() {
		this.data = null;
		this.child[0] = null;
		this.parent = null;
		this.sibling = null;
		this.level = 0;
		this.childNum = 0;
		this.orderNum = 0;
		this.next = null;
	}
	public void setChild(TreeData newData, int i) {
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
	public void setData(String newData) {
		this.data = newData;
	}
	public String getData() {
		return data;
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
	
}