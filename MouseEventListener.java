package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import userInterface.TreeStructure;
import userInterface.NodeLocation;
import userInterface.TreeData;

public class MouseEventListener extends NodeLocation implements MouseListener {
	static JLabel la;
	static JTextField NameValue;
	static JTextField XValue;
	static JTextField YValue;
	static JTextField WidthValue;
	static JTextField HeightValue;
	static JTextField ColorValue;
	
	
	
	public MouseEventListener(JTextField NameValue, JTextField XValue, JTextField YValue, JTextField WidthValue,JTextField HeightValue, JTextField ColorValue) {
		// TODO Auto-generated constructor stub
		this.NameValue=NameValue;
		this.XValue=XValue;
		this.YValue=YValue;
		this.WidthValue=WidthValue;
		this.HeightValue=HeightValue;
		this.ColorValue=ColorValue;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		la =(JLabel)e.getSource();
		NameValue.setText(la.getText().replaceAll("\t",""));
		XValue.setText(String.valueOf(la.getX())); // 마우스 클릭 좌표 x
		YValue.setText(String.valueOf(la.getY())); // 마우스 클릭 좌표 y
		WidthValue.setText(String.valueOf(la.getWidth()));
		HeightValue.setText(String.valueOf(la.getHeight()));
		String hexColorR = Integer.toHexString(la.getBackground().getRed());
		String hexColorG = Integer.toHexString(la.getBackground().getGreen());
		String hexColorB = Integer.toHexString(la.getBackground().getBlue());
		String hexColor = "0x" + hexColorR + hexColorG + hexColorB;
		ColorValue.setText(String.valueOf(hexColor));
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		if(obj instanceof JLabel){
			la = (JLabel)obj;
		}
		if(obj instanceof JPanel){
			if(la != null){
				la.setLocation(e.getX(),e.getY());
				la = null;
				}
			}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void Change() {
		la.setBounds((Integer.parseInt(XValue.getText())),(Integer.parseInt(YValue.getText())),(Integer.parseInt(WidthValue.getText())),(Integer.parseInt(HeightValue.getText()))); 
		
		ColorValue.setText(String.valueOf(la.getBackground()));
		
	}
}