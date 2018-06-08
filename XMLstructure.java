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


public class XMLstructure  {
	
	//private TreeData newData;
	private TreeData[] treeData;
	private StreamResult result;
	private String xmlString;
	private String returnPath;
	
	public XMLstructure(TreeData[] treeData) {
		this.treeData = treeData;
		this.returnPath = "saving.xml";
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
			
			while(i < treeData.length) {
		
				if(treeData[i].getlevel() == 0) {
					Element rootElement = (doc).createElement("root");
					((Node) doc).appendChild(rootElement);
					
					Element DataElement = doc.createElement("Data");
					DataElement.appendChild(doc.createTextNode(treeData[i].getData()));
					rootElement.appendChild(DataElement);
					
					Element XElement = doc.createElement("X");
					XElement.appendChild(doc.createTextNode("" + treeData[i].getX()));
					rootElement.appendChild(XElement);
					
					Element YElement = doc.createElement("Y");
					YElement.appendChild(doc.createTextNode("" + treeData[i].getY()));
					rootElement.appendChild(YElement);
					
					Element WidthElement = doc.createElement("Width");
					WidthElement.appendChild(doc.createTextNode("" + treeData[i].getWidth()));
					rootElement.appendChild(WidthElement);
					
					Element HeightElement = doc.createElement("Height");
					HeightElement.appendChild(doc.createTextNode("" + treeData[i].getHeight()));
					rootElement.appendChild(HeightElement);
					
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
				
				//newData = newData.next;
				i++;
			
				
			}
			
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer trans = tff.newTransformer();
			
			trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			trans.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource doms = new DOMSource(doc);
			result = new StreamResult(new StringWriter());
			trans.transform(doms, result);
			
			
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
			fop.close();
			
		}
		
		//return result.getWriter().toString().trim();
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
