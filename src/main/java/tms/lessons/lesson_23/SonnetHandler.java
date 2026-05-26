package tms.lessons.lesson_23;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SonnetHandler extends DefaultHandler {

    private String lastElementName;

    // поля автора
    private String firstName;
    private String lastName;
    private String nationality;
    private String yearOfBirth;
    private String yearOfDeath;

    // поля сонета
    private String title;
    private List<String> lines = new ArrayList<>();

    private Author author;
    private Sonnet sonnet;

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElementName = qName;

        if (qName.equals("sonnet")) {
            sonnet = new Sonnet();
        }

        if (qName.equals("author")) {
            author = new Author();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        //set content from tag
        String content = new String(ch, start, length);

        content = content.replace("\n", "").trim();

        if (!content.isEmpty()) {
            switch (lastElementName) {
                case "firstName" -> firstName = content;
                case "lastName" -> lastName = content;
                case "nationality" -> nationality = content;
                case "yearOfBirth" -> yearOfBirth = content;
                case "yearOfDeath" -> yearOfDeath = content;

                case "title" -> title = content;

                case "line" -> lines.add(content);
            }
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("author")) {
            author.setFirstName(firstName);
            author.setLastName(lastName);
            author.setNationality(nationality);
            author.setYearOfBirth(yearOfBirth);
            author.setYearOfDeath(yearOfDeath);

            sonnet.setAuthor(author);

            firstName = lastName = nationality = yearOfBirth = yearOfDeath = null;

        }

            if (qName.equals("title")) {
                sonnet.setTitle(title);
                title = null;
            }

            if (qName.equals("lines")) {
                sonnet.setLinesOfPoem(lines);
            }
        }


    public Sonnet getSonnet() {
        return sonnet;
    }
}
