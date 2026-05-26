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

    public Sonnet() {
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

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLinesOfPoem(List<String> linesOfPoem) {
        this.linesOfPoem = linesOfPoem;
    }
}
