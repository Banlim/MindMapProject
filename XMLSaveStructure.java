package userInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.annotation.Documented;

//import javax.lang.model.element.Element;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLSaveStructure  {
	
	private TreeData[] treeData;
	private StreamResult result;
	private String xmlString;
	private String returnPath;
	private int count;
	
	

	public XMLSaveStructure(TreeData[] tree, String returnPath, int count) {
		
		this.treeData = tree;
		this.returnPath = returnPath + ".xml";
		this.count = count;
		XMLsave();
		
	}

	private void XMLsave() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;
			docBuilder = docFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = docBuilder.newDocument();
			System.out.println("РќДо!");
			System.out.println(treeData[0].getX());
			System.out.println(treeData[0].getColor());
			System.out.println(treeData[0].HexColor(treeData[0].getColor()));
			System.out.println(treeData[0].decColor(treeData[0].HexColor(treeData[0].getColor())));
		
			Element NodeElement = doc.createElement("Node");
			doc.appendChild(NodeElement);


				for(int i = 0; i < treeData.length; i++) {
				
				Element DataElement = doc.createElement("Data");
				NodeElement.appendChild(DataElement);
			
				
				Node ValueElement = doc.createElement("Value");
				ValueElement.appendChild(doc.createTextNode(treeData[i].getData()));
				DataElement.appendChild(ValueElement);
					
				Node XElement = doc.createElement("X");
				XElement.appendChild(doc.createTextNode("" + treeData[i].getX()));
				DataElement.appendChild(XElement);
					
				Element YElement = doc.createElement("Y");
				YElement.appendChild(doc.createTextNode("" + treeData[i].getY()));
				DataElement.appendChild(YElement);
					
				Element WidthElement = doc.createElement("Width");
				WidthElement.appendChild(doc.createTextNode("" + treeData[i].getWidth()));
				DataElement.appendChild(WidthElement);
					
				Element HeightElement = doc.createElement("Height");
				HeightElement.appendChild(doc.createTextNode("" + treeData[i].getHeight()));
				DataElement.appendChild(HeightElement);
				
				Element ColorElement = doc.createElement("Color");
				ColorElement.appendChild(doc.createTextNode("" + treeData[i].getColor()));
				DataElement.appendChild(ColorElement);
				
				Element LevelElement = doc.createElement("Level");
				LevelElement.appendChild(doc.createTextNode("" + treeData[i].getlevel()));
				DataElement.appendChild(LevelElement);
			
		
			}
				
	
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer trans = tff.newTransformer();
			
			trans.setOutputProperty(OutputKeys.ENCODING, "euc-KR");
			trans.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource doms = new DOMSource(doc);
			
			File file;
			
			file = new File(returnPath);
		
			result = new StreamResult(file);
			trans.transform(doms, result);
		
			
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}

		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}