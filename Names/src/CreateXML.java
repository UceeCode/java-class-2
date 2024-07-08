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


public class CreateXML {
    public static void main(String[] args) {
        try{
            //create a documentfactorybuilder
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            //create a new document
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("root");
            Element Names = document.createElement("Names");
            Element name1 = document.createElement("FirstPerson");
            Element name2 = document.createElement("SecondName");

            name1.appendChild(document.createTextNode("Uchenna"));
            name2.appendChild(document.createTextNode("Franklin"));

            document.appendChild(root);
            root.appendChild(Names);
            Names.appendChild(name1);
            Names.appendChild(name2);

            //transform the dom obj to xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            //create an xml file
            File file = new File("Names.xml");
            FileWriter fileWriter = new FileWriter(file);
            StreamResult result = new StreamResult(fileWriter);
            transformer.transform(source, result);
            System.out.println("XML FILE CREATED");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}