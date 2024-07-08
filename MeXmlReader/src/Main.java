import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class Main {
    public static void main(String[] args) {
        try {
            //import xmlfile from the file path
            File Xmlfile = new File(System.getProperty("user.home") + "/Documents/XmlRead/ME.xml");

            //create xml document builder factory
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            //parse an xml file into document object
            Document doc = documentBuilder.parse(Xmlfile);

            //get nodelist of mydetails element
            NodeList nlist = doc.getElementsByTagName("mydetails");

            //iterate through mydetails element
            for (int temp = 0; temp < nlist.getLength(); temp++){
                Node nNode = nlist.item(temp);

                //check if node is an element
                if (nNode.getNodeType() == Node.ELEMENT_NODE){
                    //cast node to element
                    Element e = (Element) nNode;

                    //print information
                    System.out.println("Firstname" + " = " + e.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Lastname" + " = " + e.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Age" + " = " + e.getElementsByTagName("age").item(0).getTextContent());
                    System.out.println("School" + " = " + e.getElementsByTagName("school").item(0).getTextContent());
                    System.out.println("Address" + " = " + e.getElementsByTagName("address").item(0).getTextContent());
                }
            }


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}