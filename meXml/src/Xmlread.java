import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Xmlread {
    public static void main(String[] args) {
        try {
            File file = new File(System.getProperty("user.home") + "/Documents/XmlRead/ME.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document doc = documentBuilder.parse(file);

            NodeList root = doc.getElementsByTagName("mydetails");

            for (int i = 0; i < root.getLength(); i++){
                Node nlist = root.item(i);

                if (nlist.getNodeType() == Node.ELEMENT_NODE){
                    Element e = (Element) nlist;

                    System.out.println("Firstname: " + e.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Lastname: " + e.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Age: " + e.getElementsByTagName("age").item(0).getTextContent());
                    System.out.println("School: " + e.getElementsByTagName("school").item(0).getTextContent());
                    System.out.println("Address: " + e.getElementsByTagName("address").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
