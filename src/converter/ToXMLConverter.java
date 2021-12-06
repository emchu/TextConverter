package converter;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ToXMLConverter {

    public void saveToXML(List<Sentence> sortedSentencesList, Optional<String> path) {
        String rootTag = "text";
        String sentenceTag = "sentence";
        String wordTag = "word";
        String pathString = path.orElse("");

        Document dom;
        Element sentenceElement;
        Element wordElement;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();
            dom.setXmlStandalone(true);
            Element rootElement = dom.createElement(rootTag);

            for (Sentence sentence : sortedSentencesList) {
                sentenceElement = dom.createElement(sentenceTag);
                rootElement.appendChild(sentenceElement);
                List<String> sortedWords = sentence.getWords();

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
                        new StreamResult(new FileOutputStream(pathString + "XMLfile.xml")));

            } catch (TransformerException | IOException te) {
                System.out.println(te.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }
}
