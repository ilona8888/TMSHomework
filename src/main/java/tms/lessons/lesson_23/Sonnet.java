package tms.lessons.lesson_23;

import java.util.List;

public class Sonnet {
    private Author author;

    private String title;
    private List<String> linesOfPoem;


    public Sonnet(Author author, String title, List<String> linesOfPoem) {
        this.author = author;
        this.title = title;
        this.linesOfPoem = linesOfPoem;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getLinesOfPoem() {
        return linesOfPoem;
    }
}
