package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import userInterface.TreeStructure;
import userInterface.NodeLocation;
import userInterface.TreeData;

public class MouseEventListener extends NodeLocation implements MouseListener,MouseMotionListener  {
	static JLabel la;
	static JPanel MindMapPane;
	static JTextField NameValue;
	static JTextField XValue;
	static JTextField YValue;
	static JTextField WidthValue;
	static JTextField HeightValue;
	static JTextField ColorValue;
	JLabel colortempLabel=new JLabel();
	int clicknum=0;
	JLabel tempclickedLabel=new JLabel();
	JLabel clickedLabel;
	private final int ARR_SIZE = 4;

	
	
	public MouseEventListener(JPanel MindMapPane, JTextField NameValue, JTextField XValue, JTextField YValue, JTextField WidthValue,JTextField HeightValue, JTextField ColorValue) {
		// TODO Auto-generated constructor stub
		this.MindMapPane=MindMapPane;
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
		
		if(clicknum==0) {
			tempclickedLabel.setText(la.getText());
			tempclickedLabel.setBackground(la.getBackground());
			tempclickedLabel.setBounds(la.getX(), la.getY(), la.getWidth(), la.getHeight());
			la.setBackground(Color.CYAN);
			clickedLabel=la;
			clicknum=+1;
			clickedLabel.setBackground(tempclickedLabel.getBackground());
		}
		else {
			clickedLabel.setBackground(tempclickedLabel.getBackground());
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		la =(JLabel)e.getSource();
		colortempLabel.setBackground(la.getBackground());

		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		la =(JLabel)e.getSource();
		colortempLabel.setBackground(la.getBackground());
		la.setBackground(Color.CYAN);
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
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		clickedLabel.setBackground(tempclickedLabel.getBackground());
		la.setBackground(colortempLabel.getBackground());
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
		MindMapPane.repaint();
	}
	
	
	public static void Change() {
		la.setBounds((Integer.parseInt(XValue.getText())),(Integer.parseInt(YValue.getText())),(Integer.parseInt(WidthValue.getText())),(Integer.parseInt(HeightValue.getText()))); 
		ColorValue.setText(String.valueOf(la.getBackground()));
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//드래그 모드인 경우에만 사각형 이동시킴
		
		la =(JLabel)e.getSource();	
		la.setBounds(e.getX(), e.getY(), la.getWidth(), la.getHeight());
		NameValue.setText(la.getText().replaceAll("\t",""));
		XValue.setText(String.valueOf(la.getX())); // 마우스 클릭 좌표 x
		YValue.setText(String.valueOf(la.getY())); // 마우스 클릭 좌표 y
		WidthValue.setText(String.valueOf(la.getWidth()));
		HeightValue.setText(String.valueOf(la.getHeight()));String hexColorR = Integer.toHexString(la.getBackground().getRed());
		String hexColorG = Integer.toHexString(la.getBackground().getGreen());
		String hexColorB = Integer.toHexString(la.getBackground().getBlue());
		String hexColor = "0x" + hexColorR + hexColorG + hexColorB;
		ColorValue.setText(String.valueOf(hexColor));
		MindMapPane.repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	public void drawArrow(Graphics g1, int x1, int y1, int x2, int y2) {
        Graphics2D g = (Graphics2D) g1.create();

        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx*dx + dy*dy);
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g.transform(at);

        // Draw horizontal arrow starting in (0, 0)
        g.drawLine(0, 0, len, 0);
        g.fillPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
                      new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
    }


}