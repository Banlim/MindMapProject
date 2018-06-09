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



public class ButtonEventListener implements ActionListener {
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
		JButton btn = (JButton)e.getSource();
		
		int k = 0;
		
		if (cmd.equals("����") || btn.getIcon() == Image) {
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
					TextAreaDataCount[i] = TextAreaData[i].lastIndexOf('\t')+1; // �� ����� '\t'�� ������ �迭�� ����, ���߿� level�� ����
					
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
					
						//XMLstructure XMLstr = new XMLstructure(newData);//XML�������� �����ϱ� ���� �̸� save �س���
						//XMLstr.XMLsave();
						treeData[k] = newData; // XML�� �����ϱ� ���� TreeData Ÿ���� �迭 ���� �� ����
						//new MapSaveListener(newData);
						newData = newData.next;
						k++;
					}
				
					
				}
			}
			
			else if(cmd.equals("���� �����") || btn.getIcon() == Image) { // ���θ���⸦ ������ ��
				if(Text.getText() != null) {
					Text.setText(" ");
					MindMapPane.removeAll();
					MindMapPane.repaint();
				}
				
				
			}
			
			else if(cmd.equals("����") || btn.getIcon() == Image) { // ���� ������ ��
				
			}
		
			else if(cmd.equals("�ٸ� �̸����� ����") || btn.getIcon() == Image) { // �ٸ� �̸����� ���� ������ ��
				ReturnFilePath fp = new ReturnFilePath();
				String path = fp.PathReturn();
				XMLstructure xmlstr = new XMLstructure(treeData, path);
				xmlstr.XMLsave();
			}
			
			if(cmd.equals("����") || btn.getIcon() == Image) { // ���� ������ ��
				//FileOutputStream fop = null;
				//File file;
				//ReturnFilePath fp = new ReturnFilePath();
				//String path = fp.PathReturn();
				XMLstructure xmlstr = new XMLstructure(treeData);
				xmlstr.XMLsave();
				JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�.", "Message", JOptionPane.INFORMATION_MESSAGE);
				
				
				
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
			}
			
						
			else if(cmd.equals("����") || btn.getIcon() == Image) { // ���� ������ ��
				
			}
			else {
				
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
