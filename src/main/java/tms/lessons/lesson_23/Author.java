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

    public Author() {
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setYearOfDeath(String yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
