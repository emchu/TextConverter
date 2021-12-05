import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class ToXMLConverter {

    public void saveToXML(ArrayList<Sentence> sortedSentencesList) {
        String rootTag = "text";
        String sentenceTag = "sentence";
        String wordTag = "word";

        Document dom;
        Element sentenceElement;
        Element wordElement;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();
            Element rootElement = dom.createElement(rootTag);

            for (Sentence sentence : sortedSentencesList) {
                sentenceElement = dom.createElement(sentenceTag);
                rootElement.appendChild(sentenceElement);
                ArrayList<String> sortedWords = sentence.getWords();

                for (String word : sortedWords) {
                    wordElement = dom.createElement(wordTag);
                    wordElement.appendChild(dom.createTextNode(word));

                    sentenceElement.appendChild(wordElement);
                }

            }
            dom.appendChild(rootElement);

            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty(OutputKeys.STANDALONE, "yes");
                tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                tr.transform(new DOMSource(dom),
                        new StreamResult(new FileOutputStream("XML file.xml")));

            } catch (TransformerException | IOException te) {
                System.out.println(te.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }
}
