import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;

public class SchoolXml {

    public static void main(String[] args) {
        try {
            //create a documentbuilderfactory
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            //create a new document
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("School");
            Element schoolname = document.createElement("SchoolName");
            Element schoolage = document.createElement("schoolAge");
            Element schooaddress = document.createElement("schoolAddress");

            schoolname.appendChild(document.createTextNode("Aptech Computer Education"));
            schoolage.appendChild(document.createTextNode("17 years"));
            schooaddress.appendChild(document.createTextNode("No 1 Teslim Balogun Street"));

            document.appendChild(root);
            root.appendChild(schoolname);
            root.appendChild(schoolage);
            root.appendChild(schooaddress);

            //transform this dom object to an xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            //create an xml file
            File file = new File("School.xml");
            FileWriter fileWriter = new FileWriter(file);
            StreamResult result = new StreamResult(fileWriter);
            transformer.transform(source, result);
            System.out.println("XML FILE CREATED SUCESSFULLY!!!");


        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
