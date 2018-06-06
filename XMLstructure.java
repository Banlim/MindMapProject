package userInteface;

//import javax.lang.model.element.Element;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class XMLstructure {
	
	private TreeData newData;
	private TreeData[] treeData;
	
	public XMLstructure(TreeData newData, TreeData[] treeData) {
		this.newData = newData;
		this.treeData = treeData;
	}
	
	public void XMLsave() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			org.w3c.dom.Document doc = docBuilder.newDocument();
			
			int i = 0;
			
			while(i < treeData.length) {
		
				if(treeData[i].getlevel() == 0) {
					Element rootElement = (doc).createElement("root");
					((Node) doc).appendChild(rootElement);
					rootElement.appendChild(doc.createTextNode(newData.getData()));
					rootElement.appendChild(doc.createTextNode("X : " + newData.getX()));
					rootElement.appendChild(doc.createTextNode("Y : " + newData.getY()));
					rootElement.appendChild(doc.createTextNode("Width : " + newData.getWidth()));
					rootElement.appendChild(doc.createTextNode("Height : " + newData.getHeight()));
				}
				else if(treeData[i].getlevel() == treeData[i-1].getlevel()) { // 현재 노드랑 이전 노드의 level이 같을 때(sibling)
					Element childElement = doc.createElement("child" + treeData[i].getlevel() );
					doc.getParentNode().appendChild(childElement);
					
				}
			
				
			}
		}
		catch(Exception e) {
			
		}
		
	}
	
	
	
	

}
