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
		if(ret != JFileChooser.APPROVE_OPTION) {// ����ڰ� â�� ������ �ݰų�, ��� ��ư�� ���� ���
			return;
		}
		returnPath = fileChooser.getSelectedFile().getPath();
	}
	public String PathReturn() {
		return returnPath;
	}

}
