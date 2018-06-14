package userInterface;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

import dfsdfkjk.ButtonEventListener;



public class MindMapInterface extends JFrame{
	
	private ImageIcon newToolImage = new ImageIcon("ToolBarIcon\\newIcon.jpg");
	private ImageIcon openToolImage = new ImageIcon("ToolBarIcon\\openIcon.jpg");
	private ImageIcon saveToolImage = new ImageIcon("ToolBarIcon\\saveIcon.jpg");
	private ImageIcon saveAsToolImage = new ImageIcon("ToolBarIcon\\saveAsIcon.jpg");
	private ImageIcon applyToolImage = new ImageIcon("ToolBarIcon\\applyIcon.jpg");
	private ImageIcon changeToolImage = new ImageIcon("ToolBarIcon\\changeIcon.jpg");
	private ImageIcon CloseToolImage = new ImageIcon("ToolBarIcon\\CloseToolIcon.jpg");
	
	private Image newImage = newToolImage.getImage();
	private Image openImage = openToolImage.getImage();
	private Image saveImage = saveToolImage.getImage();
	private Image saveAsImage = saveAsToolImage.getImage();
	private Image applyImage = applyToolImage.getImage();
	private Image changeImage = changeToolImage.getImage();
	private Image closeImage = CloseToolImage.getImage();
	
	private Icon icon;
	
	
	
	static final int LayoutWidth=1200;
	static final int LayoutHeight=800;
	
	private Container contentPane;
	
	private JTextArea TextArea = new JTextArea();
	
	protected JPanel TextEditorPane = new JPanel(new BorderLayout());
	protected JPanel MindMapPane = new JPanel(null);
	protected JPanel AttributePane = new JPanel(new BorderLayout());

	private MouseEventListener ChangeMouseListener = new MouseEventListener(MindMapPane,MouseEventListener.NameValue,MouseEventListener.XValue,MouseEventListener.YValue,MouseEventListener.WidthValue,MouseEventListener.HeightValue,MouseEventListener.ColorValue);
	private ButtonEventListener ApplyListener = new ButtonEventListener(MindMapPane, TextArea, applyImage);
	private ButtonEventListener newFileListener = new ButtonEventListener(MindMapPane, TextArea, newImage);
	private ButtonEventListener SaveListener = new ButtonEventListener(MindMapPane, TextArea, saveImage);
	private ButtonEventListener SaveAsListener = new ButtonEventListener(MindMapPane, TextArea, saveAsImage);
	private ButtonEventListener openFileListener = new ButtonEventListener(MindMapPane, TextArea, openImage);
	private ButtonEventListener ChangeListener = new ButtonEventListener(MindMapPane, TextArea, changeImage);
	private ButtonEventListener CloseListener = new ButtonEventListener(MindMapPane, TextArea, closeImage);
	
	
	private JSplitPane jsp2;
	private JSplitPane jsp1;
	

	
	public MindMapInterface() {
		setUIFont(new javax.swing.plaf.FontUIResource("휴먼편지체", Font.BOLD, 20));
		UIManager.put("Menu.font", new Font("휴먼편지체", Font.BOLD, 20));
		UIManager.put("MenuItem.font", new Font("휴먼편지체", Font.BOLD, 18));
		UIManager.put("Label.font", new Font("휴먼편지체", Font.BOLD, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(LayoutWidth, LayoutHeight);
		contentPane = getContentPane();
		createMenu();
		createTool();
		SetTextEditorPane();
		MindMapPane();
		SetAttributePane();
		
		
		
		jsp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, TextEditorPane, MindMapPane);
		jsp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jsp2, AttributePane);
		
		jsp1.setDividerLocation(LayoutWidth*4/5);
		jsp2.setDividerLocation(LayoutWidth/5);
		this.add(jsp1);
		
		setVisible(true);
	}
	void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setSize(800, 100);
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu saveMenu = new JMenu("Save");
		JMenuItem [] fileItem = new JMenuItem[3];
		JMenuItem [] editItem = new JMenuItem[2];
		JMenuItem [] saveItem = new JMenuItem[2];
		String[] fileItemTitle = {"새로 만들기", "열기", "닫기"};
		String[] editItemTitle = {"적용", "변경"};
		String[] saveItemTitle = {"저장", "다른 이름으로 저장"};
		
		for(int i = 0; i < fileItem.length; i++) {
			fileItem[i] = new JMenuItem(fileItemTitle[i]);
			fileMenu.add(fileItem[i]);
			fileMenu.addSeparator();
		}
		for(int i = 0; i < editItem.length; i++) {
			editItem[i] = new JMenuItem(editItemTitle[i]);
			editMenu.add(editItem[i]);
			editMenu.addSeparator();
			saveItem[i] = new JMenuItem(saveItemTitle[i]);
			saveMenu.add(saveItem[i]);
			saveMenu.addSeparator();
		}
		fileItem[0].setName("new");
		fileItem[1].setName("open");
		fileItem[2].setName("close");
		editItem[0].setName("apply");
		editItem[1].setName("change");
		saveItem[0].setName("save");
		saveItem[1].setName("saveAs");
		
		fileItem[0].addActionListener(newFileListener); // 새로 만들기
		fileItem[1].addActionListener(openFileListener); // 열기
		fileItem[2].addActionListener(CloseListener); // 닫기
		editItem[0].addActionListener(ApplyListener); // 적용
		editItem[1].addActionListener(ChangeListener); // 변경
		saveItem[0].addActionListener(SaveListener); // 저장
		saveItem[1].addActionListener(SaveAsListener); // 다른 이름으로 저장
		
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(saveMenu);

		
				
		this.setJMenuBar(menuBar);
	}
	void createTool() {
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.LIGHT_GRAY);
		toolBar.setSize(800, 50);
		
		ToolTipManager TTMan = ToolTipManager.sharedInstance();
		TTMan.setInitialDelay(0);
		TTMan.setDismissDelay(1000);
		
		JButton newTool = new JButton();
		newTool.setIcon(newToolImage);
		newTool.setToolTipText("새로 만들기");
		newTool.setName("new");
		newTool.addActionListener(newFileListener);
		toolBar.add(newTool);
		newTool.setPreferredSize(new Dimension(20, 20));
		newTool.setBorderPainted(false);
		toolBar.addSeparator();
		
		JButton openTool = new JButton();
		openTool.setIcon(openToolImage);
		openTool.setToolTipText("열기");
		openTool.setName("open");
		openTool.addActionListener(openFileListener);
		toolBar.add(openTool);
		openTool.setPreferredSize(new Dimension(20, 20));
		openTool.setBorderPainted(false);
		toolBar.addSeparator();
		
		JButton saveTool = new JButton();
		saveTool.setIcon(saveToolImage);
		//saveTool.setText("저장");
		saveTool.setName("save");
		saveTool.setToolTipText("저장");
		saveTool.addActionListener(SaveListener);
		toolBar.add(saveTool);
		saveTool.setPreferredSize(new Dimension(20, 20));
		saveTool.setBorderPainted(false);
		toolBar.addSeparator();
		
		JButton saveAsTool = new JButton();
		saveAsTool.setIcon(saveAsToolImage);
		saveAsTool.setToolTipText("다른 이름으로 저장");
		saveAsTool.setName("saveAs");
		saveAsTool.addActionListener(SaveAsListener);
		toolBar.add(saveAsTool);
		saveAsTool.setPreferredSize(new Dimension(20, 20));
		saveAsTool.setBorderPainted(false);
		toolBar.addSeparator();
		
		JButton applyTool = new JButton();
		applyTool.setIcon(applyToolImage);
		applyTool.setToolTipText("적용");
		applyTool.setName("apply");
		applyTool.addActionListener(ApplyListener);
		toolBar.add(applyTool);
		applyTool.setPreferredSize(new Dimension(20, 20));
		applyTool.setBorderPainted(false);
		toolBar.addSeparator();
		
		
		JButton changeTool = new JButton();
		changeTool.setIcon(changeToolImage);
		changeTool.setToolTipText("변경");
		changeTool.setName("change");
		changeTool.addActionListener(ChangeListener);
		toolBar.add(changeTool);
		changeTool.setPreferredSize(new Dimension(20, 20));
		changeTool.setBorderPainted(false);
		toolBar.addSeparator();
		
		
		JButton closeTool = new JButton();
		closeTool.setIcon(CloseToolImage);
		closeTool.setToolTipText("닫기");
		closeTool.setName("close");
		closeTool.addActionListener(CloseListener);
		toolBar.add(closeTool);
		closeTool.setPreferredSize(new Dimension(20, 20));
		closeTool.setBorderPainted(false);
		
		
		
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		
		
	}
	
	public void SetAttributePane() {

		JLabel name=new JLabel("Attribute Pane");
		AttributePane.add(name, BorderLayout.NORTH);
		name.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		
		JPanel middlePanel= new JPanel();
		GridLayout grd = new GridLayout(6,2);
		grd.setVgap(20);
		
		middlePanel.setLayout(grd);
		
		JLabel NameNode=new JLabel("	TEXT:");
		middlePanel.add(NameNode);
		ChangeMouseListener.NameValue= new JTextField();
		ChangeMouseListener.NameValue.setEditable(false);
		middlePanel.add(ChangeMouseListener.NameValue);
		ChangeMouseListener.NameValue.setSize(60, 20);
		
		JLabel XNode=new JLabel("	X:");
		middlePanel.add(XNode);
		ChangeMouseListener.XValue= new JTextField();
		middlePanel.add(ChangeMouseListener.XValue);
		ChangeMouseListener.XValue.setSize(60, 20);
		
		JLabel YNode=new JLabel("	Y:");
		middlePanel.add(YNode);
		ChangeMouseListener. YValue= new JTextField();
		middlePanel.add(ChangeMouseListener.YValue);
		ChangeMouseListener.YValue.setSize(60, 20);
		
		JLabel WidthNode=new JLabel("	W:");
		middlePanel.add(WidthNode);
		ChangeMouseListener. WidthValue= new JTextField();
		middlePanel.add(ChangeMouseListener.WidthValue);
		ChangeMouseListener.WidthValue.setSize(60, 20);
		
		JLabel HeightNode=new JLabel("	H:");
		middlePanel.add(HeightNode);
		ChangeMouseListener. HeightValue= new JTextField();
		middlePanel.add(ChangeMouseListener.HeightValue);
		ChangeMouseListener.HeightValue.setSize(60, 20);
		
		JLabel ColorNode=new JLabel("	Color:");
		middlePanel.add(ColorNode);
		ChangeMouseListener. ColorValue= new JTextField();
		middlePanel.add(ChangeMouseListener.ColorValue);
		ChangeMouseListener.ColorValue.setSize(60, 20);
		
		AttributePane.add(middlePanel, BorderLayout.CENTER);
		JButton ChangeNode=new JButton("변경");
		ChangeNode.setName("change");
		AttributePane.add(ChangeNode,BorderLayout.SOUTH);
		ChangeNode.addActionListener(ChangeListener);
		
		contentPane.add(AttributePane);
		
		}
	
	public void SetTextEditorPane() {
		JLabel name= new JLabel("Text Editor Pane");
		name.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		TextEditorPane.add(name, BorderLayout.NORTH);
		JButton ApplyButton= new JButton("적용");
		ApplyButton.setName("apply");
		TextEditorPane.add(ApplyButton, BorderLayout.SOUTH);
		JScrollPane TextScrollPane= new JScrollPane(TextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		TextEditorPane.add(TextScrollPane);
		TextArea.setTabSize(2);
		ApplyButton.addActionListener(ApplyListener);
		contentPane.add(TextEditorPane);
		TextArea.setFont(new Font("휴먼편지체", Font.PLAIN, 20));


	}
	
	public void MindMapPane(){
		JScrollPane MapScrollPane= new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JLabel name=new JLabel("Mind Map Pane");
		name.setLocation(200,200);
		MindMapPane.add(name);
		MapScrollPane.add(MindMapPane);
		MindMapPane.setPreferredSize(new Dimension(600, 600));
		contentPane.add(MapScrollPane);

	}


	public static void setUIFont(javax.swing.plaf.FontUIResource f) {
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, f); 
				}
			}
		}
	
	
	public static void main(String[] args) {
		new MindMapInterface();
	}

}

