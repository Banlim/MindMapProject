package projectMindmap;
import javax.swing.*;
import java.awt.*;
//jsplitpane 적용 아직 안함
public class Layout extends JFrame {
	private Container contentPane;
	static final int LayoutWidth=500;
	static final int LayoutHight=400;
	
	public Layout() {
		setTitle("Mindmap Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		CreateMenu();
		CreateTool();
		SetTextEditorPane();
		SetAttributePane();
		MindMapPane();
		setSize(LayoutWidth,LayoutHight);
		setVisible(true);
		}
	
	public void CreateMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu Bar");
		menu.add(new JMenuItem("열기"));
		menu.add(new JMenuItem("저장"));
		menu.add(new JMenuItem("다른 이름으로 저장"));
		menu.add(new JMenuItem("닫기"));
		menu.add(new JMenuItem("적용"));
		menu.add(new JMenuItem("변경"));
		menuBar.add(menu);
		setJMenuBar(menuBar);
		}
	
	public void CreateTool() {
		JToolBar toolBar = new JToolBar();
		JButton a=new JButton("열기");
		a.setToolTipText("파일 로드");
		toolBar.add(a);
		JButton b=new JButton("저장");
		b.setToolTipText("파일 저장");
		toolBar.add(b);
		JButton c=new JButton("다른 이름으로 저장");
		c.setToolTipText("새로운 파일 생성");
		toolBar.add(c);
		JButton d=new JButton("닫기");
		d.setToolTipText("프로그램 종료");
		toolBar.add(d);
		JButton e=new JButton("적용");
		e.setToolTipText("텍스트 편집 내용 적용");
		toolBar.add(e);
		JButton f=new JButton("변경");
		f.setToolTipText("속성 페인 변경 내용 적용");
		toolBar.add(f);
		contentPane.add(toolBar,BorderLayout.NORTH);
		}
	
	public void SetAttributePane() {
		JPanel AttributePane= new JPanel();
		AttributePane.setLayout(new BorderLayout());
		JLabel name=new JLabel("Attribute Pane");
		AttributePane.add(name, BorderLayout.NORTH);
		JPanel middlePanel= new JPanel();
		middlePanel.setLayout(new GridLayout(6,2));
		JLabel NameNode=new JLabel("TEXT:");
		middlePanel.add(NameNode);
		JTextField NameValue= new JTextField();
		middlePanel.add(NameValue);
		NameValue.setSize(60, 20);
		JLabel XNode=new JLabel("X:");
		middlePanel.add(XNode);
		JTextField XValue= new JTextField();
		middlePanel.add(XValue);
		XValue.setSize(60, 20);
		JLabel YNode=new JLabel("Y:");
		middlePanel.add(YNode);
		JTextField YValue= new JTextField();
		middlePanel.add(YValue);
		YValue.setSize(60, 20);
		JLabel WidthNode=new JLabel("W:");
		middlePanel.add(WidthNode);
		JTextField WidthValue= new JTextField();
		middlePanel.add(WidthValue);
		WidthValue.setSize(60, 20);
		JLabel HeightNode=new JLabel("H:");
		middlePanel.add(HeightNode);
		JTextField HeightValue= new JTextField();
		middlePanel.add(HeightValue);
		HeightValue.setSize(60, 20);
		JLabel ColorNode=new JLabel("Color:");
		middlePanel.add(ColorNode);
		JTextField ColorValue= new JTextField();
		middlePanel.add(ColorValue);
		ColorValue.setSize(60, 20);
		AttributePane.add(middlePanel, BorderLayout.CENTER);
		JLabel ChangeNode=new JLabel("변경");
		AttributePane.add(ChangeNode,BorderLayout.SOUTH);
		JScrollPane scrollPane = new JScrollPane(AttributePane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setSize(LayoutWidth/4,LayoutHight);
		AttributePane.setSize(LayoutWidth/4,LayoutHight);
		scrollPane.setViewportView(AttributePane);
		contentPane.add(scrollPane,BorderLayout.EAST);
	}
	
	public void SetTextEditorPane() {
		JPanel TextEditorPane= new JPanel();
		TextEditorPane.setLayout(new BorderLayout());
		JLabel name= new JLabel("Text Editor Pane");
		TextEditorPane.add(name, BorderLayout.NORTH);
		JLabel ChangeNode= new JLabel("적용");
		TextEditorPane.add(ChangeNode,BorderLayout.SOUTH);
		JTextArea TextArea = new JTextArea();
		JScrollPane scrollPane= new JScrollPane(TextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setSize(LayoutWidth/4,LayoutHight);
		scrollPane.setViewportView(TextEditorPane);
		contentPane.add(scrollPane,BorderLayout.WEST);
	}
	
	public void MindMapPane() {
		JPanel MindMapPane= new JPanel();
		MindMapPane.setLayout(new BorderLayout());
		JLabel name=new JLabel("Mind Map Pane");
		MindMapPane.add(name, BorderLayout.NORTH);
		JPanel mindmapBody= new JPanel();
		MindMapPane.setSize(LayoutWidth/4,LayoutHight);
		MindMapPane.add(mindmapBody,BorderLayout.CENTER);
		JScrollPane scrollPane= new JScrollPane(MindMapPane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setSize(LayoutWidth/4,LayoutHight);
		scrollPane.setViewportView(MindMapPane);
		contentPane.add(scrollPane,BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Layout();
	}

}
