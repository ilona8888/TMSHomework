package tms.lessons.lesson_23;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileManagerDOM implements SonnetParser {

    @Override
    public Sonnet parse(File file) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        Node sonnetNode = document.getElementsByTagName("sonnet").item(0);
        Element sonnet = (Element) sonnetNode;

        //look for author
        Element authorElement = (Element) sonnet.getElementsByTagName("author").item(0);
        Author author = new Author(
                authorElement.getElementsByTagName("lastName").item(0).getTextContent(),
                authorElement.getElementsByTagName("firstName").item(0).getTextContent(),
                authorElement.getElementsByTagName("nationality").item(0).getTextContent(),
                authorElement.getElementsByTagName("yearOfBirth").item(0).getTextContent(),
                authorElement.getElementsByTagName("yearOfDeath").item(0).getTextContent()

        );

        //look for title
        String title = sonnet.getElementsByTagName("title").item(0).getTextContent();

        //look for linesOfPoem
        List<String> linesOfPoem = new ArrayList<>();
        NodeList items = document.getElementsByTagName("line");
        for (int i = 0; i < items.getLength(); i++) {
            Node node = items.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                linesOfPoem.add(node.getTextContent());

            }
        }

        return new Sonnet(author, title, linesOfPoem);
    }
}
