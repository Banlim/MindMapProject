package userInteface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.lang.annotation.Documented;

//import javax.lang.model.element.Element;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class XMLstructure {
	
	//private TreeData newData;
	private TreeData[] treeData;
	private StreamResult result;
	
	public XMLstructure( TreeData[] treeData) {
		//this.newData = newData;
		this.treeData = treeData;
		//treeData = MapApplyListener.getTreeData();
	}
	
	public void XMLsave(String returnPath) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = docBuilder.newDocument();
			
			
			
			int i = 0;
			
			while(i < treeData.length) {
		
				if(treeData[i].getlevel() == 0) {
					Element rootElement = (doc).createElement("root");
					((Node) doc).appendChild(rootElement);
					rootElement.appendChild(doc.createTextNode(treeData[i].getData()));
					rootElement.appendChild(doc.createTextNode("X : " + treeData[i].getX()));
					rootElement.appendChild(doc.createTextNode("Y : " + treeData[i].getY()));
					rootElement.appendChild(doc.createTextNode("Width : " + treeData[i].getWidth()));
					rootElement.appendChild(doc.createTextNode("Height : " + treeData[i].getHeight()));
				}
				else if(treeData[i].getlevel() == treeData[i-1].getlevel()) { // 현재 노드랑 이전 노드의 level이 같을 때(sibling)
					Element childElement = doc.createElement("child" + treeData[i].getlevel() );
					Element parentElement = (Element) childElement.getPreviousSibling().getParentNode();
					parentElement.appendChild(childElement);
					parentElement.appendChild(doc.createTextNode(treeData[i].getData()));
					parentElement.appendChild(doc.createTextNode("X : " + treeData[i].getX()));
					parentElement.appendChild(doc.createTextNode("Y : " + treeData[i].getY()));
					parentElement.appendChild(doc.createTextNode("Width : " + treeData[i].getWidth()));
					parentElement.appendChild(doc.createTextNode("Height : " + treeData[i].getHeight()));				
				}
				else if(treeData[i].getlevel() == treeData[i-1].getlevel() + 1) { //현재 노드가 이전 노드의 자식일 때
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
			
				
			}
			
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer trans = tff.newTransformer();
			
			trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			trans.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource doms = new DOMSource(doc);
			result = new StreamResult(new FileOutputStream(new File(returnPath + ".xml")));
			trans.transform(doms, result);
			
		}
		catch(Exception e) {
			
		}
		
		
		
	}
	public StreamResult getResult() {
		return result;
	}
	
	
	
	

}
