import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlReaderUsingDom {
    public static void main(String[] args) {
        try {
            File XMLfile = new File(System.getProperty("user.home") + "/Desktop/StudentS.xml");
            DocumentBuilderFactory xmlFactor = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = xmlFactor.newDocumentBuilder();
            Document doc = documentBuilder.parse(XMLfile);
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nlist = doc.getElementsByTagName("student");
            System.out.println(".........................");
            for (int temp = 0; temp < nlist.getLength(); temp++) {
                Node nNode = nlist.item(temp);
                System.out.println("\nCurrent Element: " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElements = (Element) nNode;
                    System.out.println("First name of student: " + eElements.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last name of student: " + eElements.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Email of student: " + eElements.getElementsByTagName("email").item(0).getTextContent());
                    System.out.println("Marks of student: " + eElements.getElementsByTagName("marks").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
