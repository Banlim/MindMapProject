package userInterface;

import userInterface.TreeData;

//import java.awt.Color;

class NodeLocation extends TreeData { // �� ��忡 ���� ���� Ŭ����
	private int x;
	private int y;
	private int width;
	private int height;
	private int color;
	
	
	public NodeLocation() {
		super();
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.color = 0;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public String HexColor(int color) {
		String hexColor = Integer.toHexString(color & 0xffffff);
		if(hexColor.length() < 6) {
			hexColor = "000000".substring(0, 6 - hexColor.length()) + hexColor;
		}
		return "0x" + hexColor;
		
	}

}
