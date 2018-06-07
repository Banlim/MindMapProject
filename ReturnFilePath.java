package userInteface;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReturnFilePath {
	private JFileChooser fileChooser;
	private String returnPath;
	
	public ReturnFilePath() {
		fileChooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Save", "xml");
		fileChooser.setFileFilter(filter);
		
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
