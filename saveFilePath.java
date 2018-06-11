package userInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class saveFilePath {
	private JFileChooser fileChooser;
	private String returnPath;
	private FileOutputStream fs;
	
	public saveFilePath() {
		fileChooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Save","xml");
		fileChooser.setFileFilter(filter);
		
		fileChooser.setDialogTitle("다른 이름으로 저장");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		int ret = fileChooser.showSaveDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {// 사용자가 창을 강제로 닫거나, 취소 버튼을 누른 경우
			return;
		}
		returnPath = fileChooser.getSelectedFile().getPath();
		
	
	}
	public String PathReturn() {
		return returnPath;
	}


}
