package tms.lessons.lesson_23;

public class Author {
    private String lastName;
    private String firstName;
    private String nationality;
    private String yearOfBirth;
    private String yearOfDeath;

    public Author(String lastName, String firstName, String nationality, String yearOfBirth, String yearOfDeath) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.nationality = nationality;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
