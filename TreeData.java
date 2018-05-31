package userInteface;

public class TreeData {
	private TreeData child;
	private TreeData parent;
	private TreeData sibling;
	private int height;
	private String data;
	
	public TreeData() {
		this.data = data;
		this.child = child;
		this.parent = parent;
		this.sibling = sibling;
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
	public void setHeight(int newHeight) {
		this.height = newHeight;
	}
	public int getHeight() {
		return height;
	}
	public String getData() {
		return data;
	}

}
