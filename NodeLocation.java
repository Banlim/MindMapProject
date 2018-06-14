package userInterface;

import userInterface.TreeData;

//import java.awt.Color;

public class NodeLocation extends TreeData { // 한 노드에 대한 정보 클래스
	private int x;
	private int y;
	private int width;
	private int height;
	private int color;
	private String hexColorRGB;
	
	public NodeLocation() {
		super();
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.color = 0;
		this.hexColorRGB = null;
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
	public void setHexColor(String Color) {
		this.hexColorRGB = Color;
	}
	public String getHexColor() {
		return hexColorRGB;
	}
	
	public String HexColor(int color) {
		String hexColor = Integer.toHexString(color & 0xffffff);
		if(hexColor.length() < 6) {
			hexColor = "000000".substring(0, 6 - hexColor.length()) + hexColor;
		}
		return "0x" + hexColor;
	}
	private int Convert2DecColor(char hexColor) { // 16진수에서 10진수로 변환하는 함수
	
			switch(hexColor) {
			case 'a' :
				return 10; 
			case 'b' :
				return 11;
			case 'c' :
				return 12;
			case 'd' :
				return 13;
			case 'e' :
				return 14; 
			case 'f' :
				return 15;
			case '0' : 
				return 0; 
			case '1' :
				return 1; 
			case '2' :
				return 2;
			case '3' :
				return 3; 
			case '4' :
				return 4; 
			case '5' :
				return 5; 
			case '6' :
				return 6; 
			case '7' :
				return 7; 
			case '8' :
				return 8; 
			case '9' :
				return 9;
			}
		return 0;
	}
	public int decColor(String hexColor) {
		int decColor = Convert2DecColor(hexColor.charAt(7));
		
		for(int i = 6; i >= 2; i--)
			decColor = Convert2DecColor(hexColor.charAt(i)) * 16 + decColor;
		
		return decColor;
	}
	}
		
	


	


