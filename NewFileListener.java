package userInteface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class NewFileListener implements ActionListener {
	private JPanel MindMapPane;
	private JTextArea TextArea;
	private ImageIcon Image;
	private Color[] labelColor = {Color.PINK, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.MAGENTA};

	public NewFileListener (JPanel MindMapPane,JTextArea TextArea, ImageIcon Image) {
		this.TextArea = TextArea;
		this.Image = Image;
		this.MindMapPane= MindMapPane;
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		JButton btn = (JButton)e.getSource();
		if (cmd.equals("º¯°æ") || btn.getIcon() == Image) {
			if(TextArea.getText() != null) {
				TextArea.setText(" ");
				MindMapPane.removeAll();
				//MindMapPane.repaint();			
			}
		}
	}
}