package userInteface;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MapSaveListener implements ActionListener {
	private JPanel MindMapPane;
	private JTextArea Text;
	private ImageIcon Image;
	private TreeData[] treeData;
	private JFileChooser fileSave;
	
	public MapSaveListener(JPanel MindMapPane, JTextArea TextArea, ImageIcon Image, TreeData[] treeData) {
		this.MindMapPane = MindMapPane;
		this.Text = TextArea;
		this.Image = Image;
		this.treeData = treeData;
		
		fileSave = new JFileChooser();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//FileNameExtensionFilter filter = new FileNameExtensionFilter("XML & json", ".xml", ".json");
		
		String cmd = e.getActionCommand();
		JButton btn = (JButton)e.getSource();
		
		if (cmd.equals("저장") || btn.getIcon() == Image) {
			//fileSave.setFileFilter(filter);
			//int ret = fileSave.showSaveDialog(null);
			//if(ret != JFileChooser.APPROVE_OPTION) {// 사용자가 창을 강제로 닫거나, 취소 버튼을 누른 경우
			//	return;
			//}
			// 사용자가 저장 버튼을 누른 경우
			//else {
				//String filePath = fileSave.getSelectedFile().getPath();
				
				//XMLstructure xmlStruc = new XMLstructure(treeData);
				//File fi = fileSave.getSelectedFile();
				//xmlStruc.XMLsave();
				try {
					//FileWriter fs = new FileWriter(fi.getPath() + ".xml");
					//FileOutputStream fs = new FileOutputStream(fi.getPath() + ".xml");
					//if(!fi.exists())
						//fi.createNewFile();
					
					
					//String xmlString = xmlStruc.getResult().getWriter().toString().trim();
				//	byte[] contentInBytes = xmlString.getBytes();
					
					//fs.write(contentInBytes);
					//fs.flush();
					//fs.close();
				ReturnFilePath filePath = new ReturnFilePath();
				if(filePath != null) {
					XMLstructure xml = new XMLstructure(treeData);
					xml.XMLsave(filePath.PathReturn());
				}
					
				}
				catch(Exception e2) {
					
				}
			}
		}
	}


