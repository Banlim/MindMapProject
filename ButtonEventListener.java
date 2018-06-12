package userInterface;


import java.util.StringTokenizer;


import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Image;


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
	private static TreeStructure TS;
	private TreeData newData;
	private static int count;
	
	private static TreeData[] treeData;
	
	
	
	public ButtonEventListener(JPanel MindMapPane, JTextArea TextArea, Image Image) {
		this.MindMapPane = MindMapPane;
		this.Text = TextArea;
		this.Image = Image;
	
		
		//this.treeData = treeData;
		
	}

	
	public void actionPerformed(ActionEvent e) {

		AbstractButton bn = (AbstractButton)e.getSource();
		String btn = bn.getName();
		String cmd = e.getActionCommand();
		this.command(cmd, btn);
	}
	
	private void command(String cmd, String btn) {
		

		int k = 0;
		
	
		if (cmd.equals("적용") || btn.equals("applyTool")) {
			if(Text.getText() != "") {
				MindMapPane.removeAll();
				MindMapPane.repaint();
				
				
				
				sb = new StringBuffer(Text.getText());
				str = sb.toString();
				st = new StringTokenizer(str, "\n");
				count = st.countTokens();
				//System.out.println(count);
				TextAreaData = new String[count];
				TextAreaDataCount = new int[count];
				
					
				for (int i = 0; i < count; i++) {
					TextAreaData[i] = st.nextToken();
					/*if(i==0) {
						TextAreaDataCount[i] = 0;
						continue;
					}*/
					TextAreaDataCount[i] = TextAreaData[i].lastIndexOf('\t')+1; // 각 노드의 '\t'의 개수를 배열로 저장, 나중에 level로 쓰임
					
				}
				TS = new TreeStructure(TextAreaData, TextAreaDataCount);
							
				treeData = new TreeData[count];
				
				newData = TS.getStart();
				
				
				
				while(k < count) {
					
					
						MindMapPane.add(TS.nodeLabel(newData));
						//TS.print(newData);
				
						treeData[k] = new NodeLocation();
						treeData[k] = newData;
					
						
						k++;
						newData = newData.next;
					}
						
				
				}
			
			//System.out.println(treeData[0].getlevel());
		}
		
	
			 else if(cmd.equals("새로 만들기") || btn.equals("newTool")) { // 새로만들기를 눌렀을 때
				if(Text.getText() != null) {
					Text.setText(" ");
					MindMapPane.removeAll();
					MindMapPane.repaint();
				}

			 }	
		
			else if(cmd.equals("열기") || btn.equals("openTool")) { // 열기 눌렀을 때
				openFilePath ofp = new openFilePath();
				String openPath = ofp.PathReturn();
				new XMLOpenStructure(openPath, Text, MindMapPane);
			}
		
			else if(cmd.equals("다른 이름으로 저장") || btn.equals("saveAsTool")) { // 다른 이름으로 저장 눌렀을 때
				saveFilePath fp = new saveFilePath();
				String path = fp.PathReturn();
				new XMLSaveStructure(treeData, path, count);
				
			}
			 
			
			else if(cmd.equals("저장") || btn.equals("saveTool")) { // 저장 눌렀을 때
		
				new XMLSaveStructure(treeData, "saving", count);
				JOptionPane.showMessageDialog(null, "저장되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
					
			else if(cmd.equals("변경") || btn.equals("changeTool")) { // 변경 눌렀을 때
				
			
			}
		
			else if(cmd.equals("닫기") || btn.equals("closeTool")){
				System.exit(0);
								
			}
		}
	}
				
