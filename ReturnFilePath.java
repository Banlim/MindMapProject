package userInteface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReturnFilePath {
	private JFileChooser fileChooser;
	private String returnPath;
	private FileOutputStream fs;
	
	public ReturnFilePath() {
		fileChooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Save",".xml");
		fileChooser.setFileFilter(filter);
		
		//fileChooser.setDialogTitle("다른 이름으로 저장");
		//fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		int ret = fileChooser.showSaveDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {// 사용자가 창을 강제로 닫거나, 취소 버튼을 누른 경우
			return;
		}
		returnPath = fileChooser.getSelectedFile().getPath();
		
		/*try {
			fs = new FileOutputStream(new File(returnPath + ".xml"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	public String PathReturn() {
		return returnPath;
	}
	/*public FileOutputStream getFOS() {
		return fs;
	}*/
	

}
