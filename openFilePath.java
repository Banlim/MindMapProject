package userInterface;

import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class openFilePath {
	
	private JFileChooser fileChooser;
	private String returnOpenPath;
	private FileOutputStream fs;
	
	public openFilePath() {
		fileChooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Open", "xml");
		fileChooser.setFileFilter(filter);
		
		fileChooser.setDialogTitle("열기");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		int ret = fileChooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {// 사용자가 창을 강제로 닫거나, 취소 버튼을 누른 경우
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		returnOpenPath = fileChooser.getSelectedFile().getPath();
		
	
	}
	public String PathReturn() {
		return returnOpenPath;
	}

}
