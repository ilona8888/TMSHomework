package tms.lessons.lesson_23;

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class MyFileManagerSax extends DefaultHandler implements SonnetParser {

    @Override
    public Sonnet parse(File file) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = saxParserFactory.newSAXParser();

        SonnetHandler handler = new SonnetHandler();
        parser.parse(file, handler);
        return handler.getSonnet();
    }
}
