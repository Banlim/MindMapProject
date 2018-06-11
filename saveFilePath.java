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
		
		fileChooser.setDialogTitle("�ٸ� �̸����� ����");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
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
