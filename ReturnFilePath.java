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
		
		//fileChooser.setDialogTitle("�ٸ� �̸����� ����");
		//fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		int ret = fileChooser.showSaveDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {// ����ڰ� â�� ������ �ݰų�, ��� ��ư�� ���� ���
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
