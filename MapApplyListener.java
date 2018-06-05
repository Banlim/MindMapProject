package userInteface;

import java.awt.event.*;
import java.util.StringTokenizer;
import java.awt.*;
import javax.swing.*;

public class MapApplyListener implements ActionListener {
	private JPanel MindMapPane;
	private JTextArea Text;
	private ImageIcon Image;
	private String[] TextAreaData;
	private int[] TextAreaDataCount;
	private Color[] labelColor = {Color.PINK, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.MAGENTA};
	private StringBuffer sb;
	private String str;
	private StringTokenizer st;
	
	
	public MapApplyListener(JPanel MindMapPane, JTextArea TextArea, ImageIcon Image) {
		this.MindMapPane = MindMapPane;
		this.Text = TextArea;
		this.Image = Image;
	}
	public void actionPerformed(ActionEvent e) {
		//String Text = (String)e.getSource();
		//String Text = TextArea.getText();
		String cmd = e.getActionCommand();
		//ImageIcon image = (ImageIcon)e.getSource();
		JButton btn = (JButton)e.getSource();
		
		int k = 0;
		
		if (cmd.equals("Àû¿ë") || btn.getIcon() == Image) {
			if(Text.getText() != "") {
				MindMapPane.repaint();
				
				
				sb = new StringBuffer(Text.getText());
				str = sb.toString();
				st = new StringTokenizer(str, "\n");
				int count = st.countTokens();
				TextAreaData = new String[count];
				TextAreaDataCount = new int[count];
				
					
				for (int i = 0; i < count; i++) {
					TextAreaData[i] = st.nextToken();
					/*if(i==0) {
						TextAreaDataCount[i] = 0;
						continue;
					}*/
					TextAreaDataCount[i] = TextAreaData[i].lastIndexOf('\t')+1;
					
				}
				TreeStructure TS = new TreeStructure(TextAreaData, TextAreaDataCount);
				//TreeData newData = TS.getStart();
				TreeData newData = TS.start;
				
				while(k < count) {
					//if(TS.TreeStructureSetting()) {
						//TreeData newData = TS.start;
						MindMapPane.add(TS.nodeLabel(newData));
						//TS.print();
						System.out.println(TextAreaData[k]);
						System.out.println(TextAreaDataCount[k]);
						System.out.println(newData.getlevel());
						System.out.println(newData.getData());
						newData = newData.next;
						k++;
					}
						//MindMapPane.add(TS.nodeLabel());
					
				//		k++;
				}
				
			}		
		}
		
	}
//}
