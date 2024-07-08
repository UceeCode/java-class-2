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

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CreateDetailsXml {
    public static void main(String[] args) {
            try{
                //create a documentfactorybuilder
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

                //create a new document
                Document document = documentBuilder.newDocument();

                Element root = document.createElement("root");
                Element details = document.createElement("MyDetails");
                Element Firstname = document.createElement("FirstName");
                Element Lastname = document.createElement("Lastname");
                Element Age = document.createElement("Age");
                Element Address = document.createElement("Address");
                Element school = document.createElement("School");

                Firstname.appendChild(document.createTextNode("Nkwocha"));
                Lastname.appendChild(document.createTextNode("Franklin"));
                Age.appendChild(document.createTextNode("18 Years"));
                Address.appendChild(document.createTextNode("NO 9 MAJEKODUNMI STREET"));
                school.appendChild(document.createTextNode("Aptech Computer Education"));

                document.appendChild(root);
                root.appendChild(details);
                details.appendChild(Firstname);
                details.appendChild(Lastname);
                details.appendChild(Age);
                details.appendChild(Address);
                details.appendChild(school);


                //transform the dom object to xml file

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(document);

                //create an xml file
                File file = new File("MyDetails.xml");
                FileWriter fileWriter = new FileWriter(file);
                StreamResult result = new StreamResult(fileWriter);
                transformer.transform(source, result);
                System.out.println("My details XML file created");
            }catch (Exception e) {
                e.printStackTrace();
            }
    }
}