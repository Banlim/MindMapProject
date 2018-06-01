package userInteface;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;



public class MindMapInterface extends JFrame{
	private ImageIcon newToolImage = new ImageIcon("ToolBarIcon\\newIcon.jpg");
	private ImageIcon openToolImage = new ImageIcon("ToolBarIcon\\openIcon.jpg");
	private ImageIcon saveToolImage = new ImageIcon("ToolBarIcon\\saveIcon.jpg");
	private ImageIcon saveAsToolImage = new ImageIcon("ToolBarIcon\\saveAsIcon.jpg");
	private ImageIcon applyToolImage = new ImageIcon("ToolBarIcon\\applyIcon.jpg");
	private ImageIcon changeToolImage = new ImageIcon("ToolBarIcon\\changeIcon.jpg");
	
	static final int LayoutWidth=900;
	static final int LayoutHeight=600;
	
	private Container contentPane;
	
	
		
	protected JPanel TextEditorPane = new JPanel(new BorderLayout());
	protected JPanel MindMapPane = new JPanel(null);
	protected JPanel AttributePane = new JPanel(new BorderLayout());
	
	private JSplitPane jsp2;
	private JSplitPane jsp1;
	
	public MindMapInterface() {
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
		
		jsp1.setDividerLocation(650);
		jsp2.setDividerLocation(200);
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
		
		JButton newTool = new JButton(newToolImage);
		newTool.setToolTipText("새로 만들기");
		toolBar.add(newTool);
		newTool.setPreferredSize(new Dimension(20, 20));
		newTool.setBorderPainted(false);
		toolBar.addSeparator();
		
		JButton openTool = new JButton(openToolImage);
		openTool.setToolTipText("열기");
		toolBar.add(openTool);
		openTool.setPreferredSize(new Dimension(20, 20));
		openTool.setBorderPainted(false);
		toolBar.addSeparator();
		
		JButton saveTool = new JButton(saveToolImage);
		saveTool.setToolTipText("저장");
		toolBar.add(saveTool);
		saveTool.setPreferredSize(new Dimension(20, 20));
		saveTool.setBorderPainted(false);
		toolBar.addSeparator();
		
		JButton saveAsTool = new JButton(saveAsToolImage);
		saveAsTool.setToolTipText("다른 이름으로 저장");
		toolBar.add(saveAsTool);
		saveAsTool.setPreferredSize(new Dimension(20, 20));
		saveAsTool.setBorderPainted(false);
		toolBar.addSeparator();
		
		JButton applyTool = new JButton(applyToolImage);
		applyTool.setToolTipText("적용");
		toolBar.add(applyTool);
		applyTool.setPreferredSize(new Dimension(20, 20));
		applyTool.setBorderPainted(false);
		toolBar.addSeparator();
		
		JButton changeTool = new JButton(changeToolImage);
		changeTool.setToolTipText("변경");
		toolBar.add(changeTool);
		changeTool.setPreferredSize(new Dimension(20, 20));
		changeTool.setBorderPainted(false);
		
		contentPane.add(toolBar, BorderLayout.NORTH);
		
	}
	
	public void SetAttributePane() {
		
		JLabel name=new JLabel("Attribute Pane");
		AttributePane.add(name, BorderLayout.NORTH);
		
		JPanel middlePanel= new JPanel();
		GridLayout grd = new GridLayout(6,2);
		grd.setVgap(20);
		
		middlePanel.setLayout(grd);
		
		JLabel NameNode=new JLabel("	TEXT:");
		middlePanel.add(NameNode);
		JTextField NameValue= new JTextField();
		NameValue.setEditable(false);
		middlePanel.add(NameValue);
		NameValue.setSize(60, 20);
		
		JLabel XNode=new JLabel("	X:");
		middlePanel.add(XNode);
		JTextField XValue= new JTextField();
		middlePanel.add(XValue);
		XValue.setSize(60, 20);
		
		JLabel YNode=new JLabel(	"Y:");
		middlePanel.add(YNode);
		JTextField YValue= new JTextField();
		middlePanel.add(YValue);
		YValue.setSize(60, 20);
		
		JLabel WidthNode=new JLabel("	W:");
		middlePanel.add(WidthNode);
		JTextField WidthValue= new JTextField();
		middlePanel.add(WidthValue);
		WidthValue.setSize(60, 20);
		
		JLabel HeightNode=new JLabel("	H:");
		middlePanel.add(HeightNode);
		JTextField HeightValue= new JTextField();
		middlePanel.add(HeightValue);
		HeightValue.setSize(60, 20);
		
		JLabel ColorNode=new JLabel("	Color:");
		middlePanel.add(ColorNode);
		JTextField ColorValue= new JTextField();
		middlePanel.add(ColorValue);
		ColorValue.setSize(60, 20);
		
		AttributePane.add(middlePanel, BorderLayout.CENTER);
		JButton ChangeNode=new JButton("변경");
		AttributePane.add(ChangeNode,BorderLayout.SOUTH);
		
		contentPane.add(AttributePane);
		
		}
	
	public void SetTextEditorPane() {
		JLabel name= new JLabel("Text Editor Pane");
		TextEditorPane.add(name, BorderLayout.NORTH);
		JButton ChangeNode= new JButton("적용");
		TextEditorPane.add(ChangeNode, BorderLayout.SOUTH);
		JTextArea TextArea = new JTextArea();
		JScrollPane TextScrollPane= new JScrollPane(TextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		TextEditorPane.add(TextScrollPane);
		ChangeNode.addActionListener(new MapApplyListener(MindMapPane, TextArea));
		contentPane.add(TextEditorPane);
	}
	
	
	public void MindMapPane(){
		JScrollPane MapScrollPane= new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JLabel name=new JLabel("Mind Map Pane");
		name.setLocation(MindMapPane.getX(), MindMapPane.getY());
		MindMapPane.add(name);
		MindMapPane.add(MapScrollPane);
		contentPane.add(MindMapPane);
	}

	public static void main(String[] args) {
		new MindMapInterface();
	}

}
