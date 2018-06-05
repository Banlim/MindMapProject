package userInteface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JFileChooser fileSave;
	
	public MapSaveListener(JPanel MindMapPane, JTextArea TextArea, ImageIcon Image) {
		this.MindMapPane = MindMapPane;
		this.Text = TextArea;
		this.Image = Image;
		
		fileSave = new JFileChooser();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML & json", "XML","json");
		
		String cmd = e.getActionCommand();
		JButton btn = (JButton)e.getSource();
		if (cmd.equals("저장") || btn.getIcon() == Image) {
			fileSave.setFileFilter(filter);
			int ret = fileSave.showSaveDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) {// 사용자가 창을 강제로 닫거나, 취소 버튼을 누른 경우
				return;
			}
			// 사용자가 저장 버튼을 누른 경우
			String filePath = fileSave.getSelectedFile().getPath();
			
		}
	}

}
