import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class Readprofile {
    public static void main(String[] args) {
        try{
            File file = new File(System.getProperty("user.home") + "/Documents/MYPROFILE/Myprofile.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document doc = documentBuilder.parse(file);

            NodeList root = doc.getElementsByTagName("myprofile");

            for (int temp = 0; temp< root.getLength(); temp++){
                Node nlist = root.item(temp);

                if (nlist.getNodeType() == Node.ELEMENT_NODE){
                    Element e = (Element) nlist;

                    System.out.println("Firstname = " + e.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Middlename = " + e.getElementsByTagName("middlename").item(0).getTextContent());
                    System.out.println("Lastname = " + e.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Age = " + e.getElementsByTagName("age").item(0).getTextContent());
                    System.out.println("Gender = " + e.getElementsByTagName("gender").item(0).getTextContent());
                    System.out.println("Course = " + e.getElementsByTagName("course").item(0).getTextContent());
                    System.out.println("Semester1 = " + e.getElementsByTagName("semester1").item(0).getTextContent());
                    System.out.println("Semester2 = " + e.getElementsByTagName("semester2").item(0).getTextContent());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}