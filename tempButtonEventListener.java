package userInteface;


import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



public class tempButtonEventListener implements ActionListener {
	private JPanel MindMapPane;
	private JTextArea Text;
	private ImageIcon Image;
	private String[] TextAreaData;
	private int[] TextAreaDataCount;
	//private Color[] labelColor = {Color.PINK, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.MAGENTA};
	private StringBuffer sb;
	private String str;
	private StringTokenizer st;
	private TreeStructure TS;
	private TreeData newData;
	
	private TreeData[] treeData;
	
	private String xmlString;
	
	
	public ButtonEventListener(JPanel MindMapPane, JTextArea TextArea, ImageIcon Image) {
		this.MindMapPane = MindMapPane;
		this.Text = TextArea;
		this.Image = Image;
		//this.treeData = treeData;
		
	}
	//public MapApplyListener(TreeData newData) {
	//	this.newData = newData;
	//}
	public void actionPerformed(ActionEvent e) {
		//String Text = (String)e.getSource();
		//String Text = TextArea.getText();
		String cmd = e.getActionCommand();
		//ImageIcon image = (ImageIcon)e.getSource();
		//JMenuItem btn = (JMenuItem)e.getSource();
		
		int k = 0;
		
		switch(cmd) {
		case "적용":
			System.out.println("적용");
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
				TS = new TreeStructure(TextAreaData, TextAreaDataCount);
				newData = TS.getStart();
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
						//new MapSaveListener(newData);
						newData = newData.next;
						k++;
					}
				
					
				}
			break;
		case "새로 만들기":
				System.out.println("새로만들기");
				if(Text.getText() != null) {
					Text.setText(" ");
					MindMapPane.removeAll();
					MindMapPane.repaint();
				}
				break;
		case "열기":
				System.out.println("열기");
				break;
		case "다른 이름으로 저장":
				ReturnFilePath fp = new ReturnFilePath();
				String path = fp.PathReturn();
				XMLstructure xmlstr = new XMLstructure(treeData, path);
				xmlstr.XMLsave();

				System.out.println("다른이름");
			break;
		case "저장":
				System.out.println("저장");
				//FileOutputStream fop = null;
				//File file;
				//ReturnFilePath fp = new ReturnFilePath();
				//String path = fp.PathReturn();
				XMLstructure xmlstr1 = new XMLstructure(treeData);
				xmlstr1.XMLsave();
				JOptionPane.showMessageDialog(null, "저장되었습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
				
				
				
				/*try {
					file = new File(path);
					fop = new FileOutputStream(file);
					
					if(!file.exists()) {
						file.createNewFile();
					}
					
					byte[] contentInBytes = xmlstr.getXMLString().getBytes();
					
					fop.write(contentInBytes);
					fop.flush();
					fop.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				*/
			break;
			
		case "변경":	

				System.out.println("변경");
			break;
		case "닫기":
				System.exit(0);
				System.out.println("종료");
			break;
			
			default:
				break;
				
		}
	}
	public TreeData[] getTreeData() {
		return treeData;
	}
	//public TreeData getNewData() {
		//return newData;
	//}
	
		
	}
//}