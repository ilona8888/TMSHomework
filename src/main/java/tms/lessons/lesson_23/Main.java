package tms.lessons.lesson_23;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File fileInput = new File("src/main/resources/lesson_23/file.xml");

        MyFileManagerDOM myFileManager = new MyFileManagerDOM(fileInput);
        //Sonnet sonnet = myFileManager.findSonnet();
        Sonnet sonnet = myFileManager.parse(fileInput);
        myFileManager.createOutputFileWithName(sonnet);
        myFileManager.writePoemToFile(sonnet.getLinesOfPoem());

    }
}
