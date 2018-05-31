package userInteface;

import java.awt.event.*;
import java.util.StringTokenizer;
import java.awt.*;
import javax.swing.*;

public class MapApplyListener implements ActionListener {
	private JPanel MindMapPane;
	private JTextArea TextArea;
	
	private String[] TextAreaData;
	private int[] TextAreaDataCount;
	private Color[] labelColor = {Color.BLUE, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.MAGENTA};
	private StringBuffer sb;
	private String str;
	private StringTokenizer st;
	
	
	public MapApplyListener(JPanel MindMapPane, JTextArea TextArea) {
		this.MindMapPane = MindMapPane;
		this.TextArea = TextArea;
	}
	public void actionPerformed(ActionEvent e) {
		
		JButton btn = (JButton)e.getSource();
		
		if (btn.getText().equals("Àû¿ë")) {
			if(TextArea.getText() != "") {
				MindMapPane.repaint();
				
				sb = new StringBuffer(TextArea.getText());
				str = sb.toString();
				st = new StringTokenizer(str, "\n");
				int count = st.countTokens();
				TextAreaData = new String[count];
				TextAreaDataCount = new int[count];
				
					
				for (int i = 0; i < count; i++) {
					TextAreaData[i] = st.nextToken();
					TextAreaDataCount[i] = TextAreaData[i].lastIndexOf('\t');
				}
				
				for (int i = 0; i < count; i++) {
					
					JLabel la = new JLabel(Integer.toString(i));
					JLabel lb = new JLabel(TextAreaData[i]);
					la.setSize(40,20);
					la.setLocation(500,500);
					la.setBackground(labelColor[TextAreaDataCount[i]%5+1]);
					la.setOpaque(true);
					la.setVisible(true);
					la.add(lb);
					
					MindMapPane.add(la);
				}
			}		
		}
		
	}
}
