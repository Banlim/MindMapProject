package userInteface;

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


public class XMLstructure  {
	
	//private TreeData newData;
	private TreeData[] treeData;
	private StreamResult result;
	private String xmlString;
	private String returnPath;
	
	public XMLstructure(TreeData[] treeData) {
		this.treeData = treeData;
		this.returnPath = "saving.xml";
		//XMLsave();
		
	}
	public XMLstructure(TreeData[] treeData, String returnPath) {
		//this.newData = newData;
		this.treeData = treeData;
		this.returnPath = returnPath + ".xml";
		//treeData = MapApplyListener.getTreeData();
		
	}
	
		
		
	
	
	public void XMLsave() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;
			docBuilder = docFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = docBuilder.newDocument();
			
			
			
			int i = 0;
			
			Element NodeElement = doc.createElement("Node");
			doc.appendChild(NodeElement);
			
		//	TreeData newData = treeData[0];
			//TreeData last = null;
			
			while(i < treeData.length) {
				Element childElement;
				//Element parentElement = null;
				//Element previousElement = null;
				
		
				if(treeData[i].getlevel() == 0) {
					childElement = (doc).createElement("root");
					NodeElement.appendChild(childElement);
					
				}
				
				
				else { // 현재 노드와 이전 노드의 level이 같을 때
					childElement = doc.createElement("child" + treeData[i].getlevel());
					//Node rootChild = NodeElement.getFirstChild();
					
					NodeElement.appendChild(childElement);
				}
			
				
				Element DataElement = doc.createElement("Data");
				DataElement.appendChild(doc.createTextNode(treeData[i].getData()));
				childElement.appendChild(DataElement);
					
				Element XElement = doc.createElement("X");
				XElement.appendChild(doc.createTextNode("" + treeData[i].getX()));
				childElement.appendChild(XElement);
					
				Element YElement = doc.createElement("Y");
				YElement.appendChild(doc.createTextNode("" + treeData[i].getY()));
				childElement.appendChild(YElement);
					
				Element WidthElement = doc.createElement("Width");
				WidthElement.appendChild(doc.createTextNode("" + treeData[i].getWidth()));
				childElement.appendChild(WidthElement);
					
				Element HeightElement = doc.createElement("Height");
				HeightElement.appendChild(doc.createTextNode("" + treeData[i].getHeight()));
				childElement.appendChild(HeightElement);
					
				Element ColorElement = doc.createElement("Color");
				ColorElement.appendChild(doc.createTextNode("" + treeData[i].getColor()));
				childElement.appendChild(ColorElement);
				
				//Element LevelElement = doc.createElement("level");
				//LevelElement.appendChild(doc.createElement("" + treeData[i].getlevel()));
				//childElement.appendChild(LevelElement);
				
				
				i++;
				
		
			}
				
	
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer trans = tff.newTransformer();
			
			trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			trans.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource doms = new DOMSource(doc);
			
			//FileOutputStream fop = null;
			File file;
			
			file = new File(returnPath);
			//fop = new FileOutputStream(file);
			
			//result = new StreamResult(new StringWriter());
			result = new StreamResult(file);
			trans.transform(doms, result);
			
			
			/*
			FileOutputStream fop = null;
			File file;
			
			file = new File(returnPath);
			fop = new FileOutputStream(file);
			
			if(!file.exists()) {
				file.createNewFile();
			}
				
			
			xmlString = result.getWriter().toString();
			byte[] contentInBytes = new byte[xmlString.getBytes().length];
			contentInBytes = xmlString.getBytes();
			
			fop.write(contentInBytes);
			fop.flush();
			fop.close();*/
			
		}
		
			
		
		
		//return result.getWriter().toString().trim();
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		//catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		
		

	public StreamResult getResult() {
		return result;
	}
	
	public String getXMLString() {
		return xmlString;
	}
	
	
	
	

}
