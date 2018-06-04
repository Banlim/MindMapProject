package userInteface;

public abstract class TreeData {
	private TreeData child;
	private TreeData parent;
	private TreeData sibling;
	private int level;
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
	
	public TreeData() {
		this.data = null;
		this.child = null;
		this.parent = null;
		this.sibling = null;
		this.level = 0;
		this.next = null;
	}
	public void setChild(TreeData newData) {
		this.child = newData;
	}
	public TreeData getChild() {
		return child;
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
	
}