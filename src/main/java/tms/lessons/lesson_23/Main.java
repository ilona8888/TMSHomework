package tms.lessons.lesson_23;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

    private File fileInput = new File("src/main/resources/lesson_23/file.xml");
    private static File outputFile;
    public static void main(String[] args) throws Exception {
        File fileInput = new File("src/main/resources/lesson_23/file.xml");

         //without using interface

//        MyFileManagerDOM myFileManager = new MyFileManagerDOM();
//        Sonnet sonnet = myFileManager.parse(fileInput);
//        createOutputFileWithName(sonnet);
//        writePoemToFile(sonnet.getLinesOfPoem());

//        MyFileManagerSax myFileManagerSax = new MyFileManagerSax();
//        Sonnet sonnet = myFileManagerSax.parse(fileInput);
//        createOutputFileWithName(sonnet);
//        writePoemToFile(sonnet.getLinesOfPoem());

        //using interface
        SonnetParser parser = new MyFileManagerSax(); //or SonnetParser parser = new MyFileManagerDOM();
        Sonnet sonnet = parser.parse(fileInput);
        createOutputFileWithName(sonnet);
        writePoemToFile(sonnet.getLinesOfPoem());



    }

    public static void createOutputFileWithName(Sonnet sonnet) throws IOException {

        outputFile = new File(String.format("src/main/resources/lesson_23/%s_%s_%s.txt",
                sonnet.getAuthor().getFirstName(),
                sonnet.getAuthor().getLastName(),
                sonnet.getTitle()));
        outputFile.createNewFile();
    }

    public static void writePoemToFile(List<String> linesOfPoem) throws IOException {
        if (outputFile != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (String line : linesOfPoem) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }
    }
}
