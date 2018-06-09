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
				Element parentElement = null;
				Element previousElement = null;
				
		
				if(treeData[i].getlevel() == 0) {
					childElement = (doc).createElement("root");
					NodeElement.appendChild(childElement);
					
				}
				
				
				else { // 현재 노드와 이전 노드의 level이 같을 때
					childElement = doc.createElement("child" + treeData[i].getlevel());
					//Node rootChild = NodeElement.getFirstChild();
					
					NodeElement.appendChild(childElement);
					
					
					/*NodeList PreviousElementName = NodeElement.getElementsByTagName("child" + treeData[i].getlevel());
					for(int j = 0; j < PreviousElementName.getLength(); j++) {
						if(PreviousElementName.item(j).getFirstChild().getNodeValue().equals(treeData[i-1].getData()))
							previousElement = (Element) PreviousElementName.item(j);
					}*/
					//parentElement = (Element) previousElement.getParentNode();
					//NodeList ParentElementName = rootElement.getElementsByTagName("child" + (treeData[i].getlevel() - 1));
					//parentElement = ParentElementName.item(0);
					//String parentElementName = childElement.getElementsByTagName("child" + treeData[i-1].getlevel());
					//parentElement.appendChild(childElement);
						
				}
				/*else if(treeData[i].getlevel() + 1 == treeData[i-1].getlevel()) { //현재 노드가 이전 노드의 자식일 때
					childElement = doc.createElement("child" + treeData[i].getlevel());
					NodeElement.appendChild(childElement);
					/*NodeList PreviousElementName = NodeElement.getElementsByTagName("child" + treeData[i-1].getlevel());
					for(int j = 0; j < PreviousElementName.getLength(); j++) {
						if(PreviousElementName.item(j).getFirstChild().getNodeValue().equals(treeData[i-1].getData()))
							previousElement = (Element) PreviousElementName.item(j);
					}*/
					//parentElement = childElement.get
					//parentElement.appendChild(childElement);
					
				/*}
					
				else {// 이전 노드와 현재 노드가 상관 없을 때
					childElement = doc.createElement("child" + treeData[i].getlevel());
					for(int j = 0; j < i; j++) {
						TreeData temp = treeData[j];
						if(temp.getlevel() == treeData[i].getlevel()) {
							parentElement = (Element) childElement.getPreviousSibling().getParentNode();
							//parentElement.appendChild(childElement);
						}
					}
				}*/
					
								
					
				//childElement = doc.createElement("Child"+ newData.getlevel());
				//NodeElement.appendChild(childElement);
					
				//NodeElement.appendChild(childElement);
				
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
				
				Element LevelElement = doc.createElement("level");
				LevelElement.appendChild(doc.createElement("" + treeData[i].getlevel()));
				childElement.appendChild(LevelElement);
				
				i++;
				
			//	parentElement.appendChild(childElement);
				//previousElement = childElement;
				
				/*if(newData.getChild() != null) {
					newData = newData.getChild();
				}
				else if(newData.getSibling() != null) {
					newData = newData.getSibling();
				}
				else {
					while(true) {
						newData = newData.getParent();
						if(newData.getSibling() != null) {
							newData = newData.getSibling();
							break;
						}
					}
				}*/
					
				
				
			
				
		
					
				
				/*else if(treeData[i].getlevel() == treeData[i-1].getlevel() + 1) { //현재 노드가 이전 노드의 자식일 때
					Element childElement = doc.createElement("child" + treeData[i].getlevel());
					Element parentElement = (Element) childElement.getParentNode();
					parentElement.appendChild(childElement);
					parentElement.appendChild(doc.createTextNode(treeData[i].getData()));
					parentElement.appendChild(doc.createTextNode("X : " + treeData[i].getX()));
					parentElement.appendChild(doc.createTextNode("Y : " + treeData[i].getY()));
					parentElement.appendChild(doc.createTextNode("Width : " + treeData[i].getWidth()));
					parentElement.appendChild(doc.createTextNode("Height : " + treeData[i].getHeight()));
				}
				/*else { // 이전 노드랑 현재 노드랑 딱히 관련이 없을 때
					for(int j = 0; j < i; j++) {
						Element tempElement = (Element) doc.getLastChild();
						if(treeData[i].getlevel() == tempElement.get) {
							Element childElement = doc.createElement("child" + treeData[i].getlevel());
							tempElement = 
						}
						tempElement = (Element) tempElement.getParentNode();
						
					}
				}*/
				//last = newData;
				//newData = newData.next;
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
