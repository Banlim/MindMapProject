package userInteface;


import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MapApplyListener implements ActionListener {
	private JPanel MindMapPane;
	private JTextArea Text;
	private ImageIcon Image;
	private String[] TextAreaData;
	private int[] TextAreaDataCount;
	//private Color[] labelColor = {Color.PINK, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.MAGENTA};
	private StringBuffer sb;
	private String str;
	private StringTokenizer st;
	
	private TreeData[] treeData;
	
	
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
		
		if (cmd.equals("적용") || btn.getIcon() == Image) {
			if(Text.getText() != "") {
				MindMapPane.removeAll();
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
					TextAreaDataCount[i] = TextAreaData[i].lastIndexOf('\t')+1; // 각 노드의 '\t'의 개수를 배열로 저장, 나중에 level로 쓰임
					
				}
				TreeStructure TS = new TreeStructure(TextAreaData, TextAreaDataCount);
				TreeData newData = TS.getStart();
				treeData = new TreeData[count];
				//XMLstructure XMLstr = new XMLstructure(newData);
				//TreeData newData = TS.start;
				
				while(k < count) {
					
						MindMapPane.add(TS.nodeLabel(newData));
						TS.print(newData);
						/*System.out.println(TextAreaData[k]);
						System.out.println(TextAreaDataCount[k]);
						//System.out.println(newData.getlevel());
						//System.out.println(newData.getData());
						System.out.println(newData.getX());
						System.out.println(newData.getY());
						System.out.println(newData.getWidth());
						System.out.println(newData.getHeight());*/
					
						//XMLstructure XMLstr = new XMLstructure(newData);//XML형식으로 저장하기 위해 미리 save 해놓음
						//XMLstr.XMLsave();
						treeData[k] = newData; // XML을 구현하기 위해 TreeData 타입의 배열 생성 및 저장
						newData = newData.next;
						k++;
					}
				
						//MindMapPane.add(TS.nodeLabel());
					
				//		k++;
				}
			else {
				
			}
				
			}		
		}
		
	}
//}
