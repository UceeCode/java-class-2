import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XMLDocumentCreator {

    public static void main(String[] args) {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder b = null;

        try {
            b = f.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document doc = b.newDocument();
        Element root = doc.createElement("students");
        Element student = doc.createElement("student");
        Element firstname = doc.createElement("firstname");
        Element lastname = doc.createElement("lastname");
        Element email = doc.createElement("email");
        Element marks = doc.createElement("marks");

        Text t1 = doc.createTextNode("Nkwocha");
        Text t2 = doc.createTextNode("Uchenna");
        Text t3 = doc.createTextNode("Uche@gmail.com");
        Text t4 = doc.createTextNode("200");

        firstname.appendChild(t1);
        lastname.appendChild(t2);
        email.appendChild(t3);
        marks.appendChild(t4);

        student.appendChild(firstname);
        student.appendChild(lastname);
        student.appendChild(email);
        student.appendChild(marks);

        root.appendChild(student);
        doc.appendChild(root);

        try {
            // Specify the file path (Desktop directory + filename)
            String filePath = System.getProperty("user.home") + "/Desktop/Aptech.xml";
            File xmlFile = new File(filePath);

            // Use Transformer to transform the XML document to a file
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.setOutputProperty("indent", "yes");
            t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(xmlFile)));

            System.out.println("XML file created successfully at: " + filePath);
        } catch (TransformerException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
