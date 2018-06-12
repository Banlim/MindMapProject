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
		
	
		if (cmd.equals("����") || btn.equals("applyTool")) {
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
					TextAreaDataCount[i] = TextAreaData[i].lastIndexOf('\t')+1; // �� ����� '\t'�� ������ �迭�� ����, ���߿� level�� ����
					
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
		
	
			 else if(cmd.equals("���� �����") || btn.equals("newTool")) { // ���θ���⸦ ������ ��
				if(Text.getText() != null) {
					Text.setText(" ");
					MindMapPane.removeAll();
					MindMapPane.repaint();
				}

			 }	
		
			else if(cmd.equals("����") || btn.equals("openTool")) { // ���� ������ ��
				openFilePath ofp = new openFilePath();
				String openPath = ofp.PathReturn();
				new XMLOpenStructure(openPath, Text, MindMapPane);
			}
		
			else if(cmd.equals("�ٸ� �̸����� ����") || btn.equals("saveAsTool")) { // �ٸ� �̸����� ���� ������ ��
				saveFilePath fp = new saveFilePath();
				String path = fp.PathReturn();
				new XMLSaveStructure(treeData, path, count);
				
			}
			 
			
			else if(cmd.equals("����") || btn.equals("saveTool")) { // ���� ������ ��
		
				new XMLSaveStructure(treeData, "saving", count);
				JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�.", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
					
			else if(cmd.equals("����") || btn.equals("changeTool")) { // ���� ������ ��
				
			
			}
		
			else if(cmd.equals("�ݱ�") || btn.equals("closeTool")){
				System.exit(0);
								
			}
		}
	}
				
