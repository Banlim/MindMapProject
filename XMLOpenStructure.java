package userInterface;

import java.io.File;
import java.io.IOException;

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

public class XMLOpenStructure {
	
	private String openFilePath;
	private JTextArea TextArea;
	private StringBuffer text;
	private String[] textTree;
	private JPanel MindMapPane;
	
	private int[] Level;
	private int[] x;
	private int[] y;
	private int[] width;
	private int[] height;
	private int[] color;
	private TreeData node;
	
	private Node nodeItem;
	private Node Data;
	private Node Value;
	private Node X;
	private Node Y;
	private Node Width;
	private Node Height;
	private Node Color;
	
	private int k = 0;
	
	public XMLOpenStructure(String openFilePath, JTextArea TextArea, JPanel MindMapPane) {
		this.openFilePath = openFilePath;
		this.TextArea = TextArea;
		this.MindMapPane = MindMapPane;
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
		NodeList nodelist = Node.getElementsByTagName("child"); // child 노드 리스트
	
	
		Level = new int[nodelist.getLength()];
		x = new int[nodelist.getLength()];
		y = new int[nodelist.getLength()];
		width = new int[nodelist.getLength()];
		height = new int[nodelist.getLength()];
		color = new int[nodelist.getLength()];
		
		for (int i = 0; i < nodelist.getLength(); i++) {
			
			nodeItem = nodelist.item(i);
			Data = nodeItem.getFirstChild();
			System.out.println(Data.getFirstChild().getNodeValue());
			Value = Data.getFirstChild();
			X = Value.getNextSibling();
			Y = X.getNextSibling();
			Width = Y.getNextSibling();
			Height = Width.getNextSibling();
			Color = Height.getNextSibling();
			
			
			x[i] = Integer.parseInt(X.getNodeValue());
			y[i] = Integer.parseInt(Y.getNodeValue());
			width[i] = Integer.parseInt(Width.getNodeValue());
			height[i] = Integer.parseInt(Height.getNodeValue());
			color[i] = Integer.parseInt(Color.getNodeValue());
			
			String ValueName = Value.getNodeValue();
			System.out.println(ValueName);
			Level[i] = Integer.parseInt(Data.getLastChild().getNodeValue());
			while(true) {
				if(Level[i] == 0)
					break;
				else {
					text = text.append('\t'*Level[i]);
					Level[i] = 0;
				}
			}
			text = text.append(ValueName+ " \n");
			textTree[i] = text.toString();
			TextArea.setText(textTree[i]);
			text = null;
		}
		
		//TextArea.setText(textTree[i]);
		TreeStructure TreeStruc = new TreeStructure(textTree, Level);
		node = TreeStruc.getStart();
		while(k < nodelist.getLength()) {
			JLabel la = TreeStruc.openLabel(node, x[k], y[k], width[k], height[k], color[k]);
			MindMapPane.add(la);
			k++;
		}
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

}
