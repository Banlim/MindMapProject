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
		
		fileChooser.setDialogTitle("����");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		int ret = fileChooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {// ����ڰ� â�� ������ �ݰų�, ��� ��ư�� ���� ���
			JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.", "���", JOptionPane.WARNING_MESSAGE);
			return;
		}
		returnOpenPath = fileChooser.getSelectedFile().getPath();
		
	
	}
	public String PathReturn() {
		return returnOpenPath;
	}

}
