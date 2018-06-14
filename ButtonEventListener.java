package userInterface;


import java.util.StringTokenizer;


import javax.swing.AbstractButton;

import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import userInterface.NodeLocation;
import userInterface.TreeStructure;
import userInterface.TreeData;


public class ButtonEventListener implements ActionListener {
	private JPanel MindMapPane;
	private JTextArea Text;
	private Image Image;
	private String[] TextAreaData;
	private int[] TextAreaDataCount;
	//private Color[] labelColor = {Color.PINK, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.MAGENTA};
	private StringBuffer sb;
	private String str;
	private StringTokenizer st;
	private TreeStructure TS;
	private TreeData newData;
	private static int count;
	private int opennum = 0;
	private String openstr;
	
	private TreeStructure TreeStruc;
	private TreeData node;
	
	JLabel la;
	static JTextField NameValue;
	static JTextField XValue;
	static JTextField YValue;
	static JTextField WidthValue;
	static JTextField HeightValue;
	static JTextField ColorValue;

	
	private static TreeData[] treeData;

	
	
	
	public ButtonEventListener(JPanel MindMapPane, JTextArea TextArea, Image Image) {
		this.MindMapPane = MindMapPane;
		this.Text = TextArea;
		this.Image = Image;

	}

	
	public void actionPerformed(ActionEvent e) {

		AbstractButton bn = (AbstractButton)e.getSource();
		String btn = bn.getName();
		this.command( btn);
	}
	
	private void command( String btn) {
		

		int k = 0;
		int z = 0;
		
	
		if (btn.equals("apply")) {
			if(Text.getText() != "") {
				MindMapPane.removeAll();
				MindMapPane.repaint();
				
				
				sb = new StringBuffer(Text.getText());
				str = sb.toString();
				st = new StringTokenizer(str, "\n");
				count = st.countTokens();
				
				TextAreaData = new String[count];
				TextAreaDataCount = new int[count];
				
					
				for (int i = 0; i < count; i++) {
					TextAreaData[i] = st.nextToken();
					
					TextAreaDataCount[i] = TextAreaData[i].lastIndexOf('\t')+1; // 각 노드의 '\t'의 개수를 배열로 저장, 나중에 level로 쓰임
					
				}
				TS = new TreeStructure(TextAreaData, TextAreaDataCount);
							
				treeData = new TreeData[count];
				
				newData = TS.getStart();
				
		
				while(k < count) {
						MindMapPane.add(TS.nodeLabel(newData));
						
						treeData[k] = new NodeLocation();
						treeData[k] = newData;
					
						k++;
						newData = newData.next;
					}
				}
		}
		
	
			 else if(btn.equals("new")) { // 새로만들기를 눌렀을 때
				if(opennum == 0) {
					
					Text.setText(" ");
					MindMapPane.removeAll();
					MindMapPane.repaint();
				}
				else {
					Text.setText(openstr);
					MindMapPane.removeAll();
					MindMapPane.repaint();
				}

			 }	
		
			else if(btn.equals("open")) { // 열기 눌렀을 때
				opennum += 1;
				MindMapPane.removeAll();
				MindMapPane.repaint();
				openFilePath ofp = new openFilePath();
				String openPath = ofp.PathReturn();
				XMLOpenStructure open = new XMLOpenStructure(openPath, Text);
				TreeStruc = new TreeStructure(open.getTextTree(), open.getlevelArr());
				node = TreeStruc.getStart();
				
				int x[] = new int[open.labelCount()];
				x = open.getXArr();
				
				int y[] = new int[open.labelCount()];
				y = open.getYArr();
				
				int w[] = new int[open.labelCount()];
				w = open.getWArr();
				
				int h[] = new int[open.labelCount()];
				h = open.getHArr();
				
				int color[] = new int[open.labelCount()];
				color = open.getCArr();
				
				
			
				while(z < x.length) {
					JLabel lb = new JLabel(node.getData());
					node.setX(x[z]);
					node.setY(y[z]);
					node.setWidth(w[z]);
					node.setHeight(h[z]);
					node.setColor(color[z]);
					
					lb.setSize(node.getWidth(), node.getHeight());
					lb.setLocation(node.getX(), node.getY());
					lb.setBackground(new Color(node.getColor()));
					lb.setOpaque(true);
					lb.setVisible(true);
					
					MindMapPane.add(lb);
					node = node.next;
					z++;
				}
				
			}
		
			else if(btn.equals("saveAs")) { // 다른 이름으로 저장 눌렀을 때
				saveFilePath fp = new saveFilePath();
				String path = fp.PathReturn();
				new XMLSaveStructure(treeData, path, count);
				
			}
			 
			
			else if( btn.equals("save")) { // 저장 눌렀을 때
		
				new XMLSaveStructure(treeData, "saving", count);
				JOptionPane.showMessageDialog(null, "저장되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
					
			else if(btn.equals("change")) { // 변경 눌렀을 때
				MouseEventListener.Change();
	
			}
		
			else if(btn.equals("close")){
				int result = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "닫기 Message", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION || result == JOptionPane.NO_OPTION) {
					return;
				}
				else {
				System.exit(0);
				}
								
			}
		}
	}
				
