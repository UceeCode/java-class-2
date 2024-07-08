//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import java.io.File;
//import java.io.FileWriter;
//
//public class CreateXml {
//
//    public static void main(String[] args) {
//        try{
//            //create a documentbuilderfactory
//            DocumentBuilderFactory documentBuilderF = DocumentBuilderFactory.newInstance();
//            DocumentBuilder documentB = documentBuilderF.newDocumentBuilder();
//
//            //create a new document
//            Document document = documentB.newDocument();
//
//            //create a root element and child
//            Element root = document.createElement("root");
//            Element details = document.createElement("details");
//            Element firstname = document.createElement("firstname");
//            Element lastname = document.createElement("lastname");
//
//            //appending to element
//            firstname.appendChild(document.createTextNode("Nkwocha"));
//            lastname.appendChild(document.createTextNode("Franklin"));
//
//            document.appendChild(root);
//            root.appendChild(details);
//            details.appendChild(firstname);
//            details.appendChild(lastname);
//
//
//            //Transform the dom object to xml file
//
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource source = new DOMSource(document);
//
//
//            //create an xml file
//            File file = new File("Details.xml");
//            FileWriter fileWriter = new FileWriter(file);
//            StreamResult result = new StreamResult(fileWriter);
//            transformer.transform(source, result);
//            System.out.println("Xml file created");
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}