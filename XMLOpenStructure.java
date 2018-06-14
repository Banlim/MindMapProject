package userInterface;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dkdk.TreeStructure;

public class XMLOpenStructure {
	
	private String openFilePath;
	private String textFinal;
	private JTextArea TextArea;
	private StringBuffer text = new StringBuffer();
	private String[] textTree;
	private StringTokenizer stz;
	
	private JLabel[] laArr;
	private JLabel label = new JLabel();
	
	private int[] level;
	private int[] x;
	private int[] y;
	private int[] width;
	private int[] height;
	private int[] color;
	private TreeData node;
	private TreeStructure TreeStruc;
	
	
	private Element DataItem;
	private Node Value;
	private Node X;
	private Node Y;
	private Node Width;
	private Node Height;
	private Node Color;
	private Node Level;
	
	private int count;
	private int a = 0;
	private int c = 0;
	private int k = 0;
	

	
	public XMLOpenStructure(String openFilePath, JTextArea TextArea) {
		this.openFilePath = openFilePath;
		this.TextArea = TextArea;
		OpenXML();
	}
	
	private void OpenXML() {
		
		try {
		File XMLfile = new File(openFilePath);
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(XMLfile);
		doc.getDocumentElement().normalize();
		
		Element Node = doc.getDocumentElement();
		NodeList nodelist = Node.getElementsByTagName("Data"); // Data 노드 리스트
		
	
	
		level = new int[nodelist.getLength()];
		x = new int[nodelist.getLength()];
		y = new int[nodelist.getLength()];
		width = new int[nodelist.getLength()];
		height = new int[nodelist.getLength()];
		color = new int[nodelist.getLength()];
		
		for (int i = 0; i < nodelist.getLength(); i++) {
			
			DataItem = (Element) nodelist.item(i);
			
			NodeList ValueList = DataItem.getElementsByTagName("Value");
			NodeList XList = DataItem.getElementsByTagName("X");
			NodeList YList = DataItem.getElementsByTagName("Y");
			NodeList WList = DataItem.getElementsByTagName("Width");
			NodeList HList = DataItem.getElementsByTagName("Height");
			NodeList ColorList = DataItem.getElementsByTagName("Color");
			NodeList LevelList = DataItem.getElementsByTagName("Level");
			
			Node ValueItem = ValueList.item(0);
			Value = ValueItem.getFirstChild();
			
			Node XItem = XList.item(0);
			X = XItem.getFirstChild();
			
			Node YItem = YList.item(0);
			Y = YItem.getFirstChild();
			
			Node WItem = WList.item(0);
			Width = WItem.getFirstChild();
			
			Node HItem = HList.item(0);
			Height = HItem.getFirstChild();
			
			Node ColorItem = ColorList.item(0);
			Color = ColorItem.getFirstChild();
			
			Node LevelItem = LevelList.item(0);
			Level = LevelItem.getFirstChild();
			
			
			x[i] = Integer.parseInt(X.getNodeValue());
			y[i] = Integer.parseInt(Y.getNodeValue());
			width[i] = Integer.parseInt(Width.getNodeValue());
			height[i] = Integer.parseInt(Height.getNodeValue());
			color[i] = Integer.parseInt(Color.getNodeValue());
			level[i] = Integer.parseInt(Level.getNodeValue());
			
			String ValueName = Value.getNodeValue();
			
			
			text = text.append(ValueName+ "\n");
		
		}
		textFinal = text.toString();
		TextArea.setText(textFinal);
		stz = new StringTokenizer(textFinal, "\n");
		textTree = new String[stz.countTokens()];
		
		
		
		while(a < nodelist.getLength()) {
			textTree[a] = stz.nextToken();
		
			a++;
		}
	
		count = stz.countTokens();
		
	} 
	
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public JLabel[] getNodeLabel() {
		return laArr;
	}
	public int labelCount() {
		return count;
	}
	public String[] getTextTree() {
		return textTree;
	}
	public int[] getlevelArr() {
		return level;
	}
	public int[] getXArr() {
		return x;
	}
	public int[] getYArr() {
		return y;
	}
	public int[] getWArr() {
		return width;
	}
	public int[] getHArr() {
		return height;
	}
	public int[] getCArr() {
		return color;
	}

}
