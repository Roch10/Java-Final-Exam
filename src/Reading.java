public class Reading {
    private int number;
    private String authorFirstName;
    private String authorLastName;
    private String title;

    public Reading(int number, String authorFirstName, String authorLastName, String title) {
        this.number = number;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "number='" + number + '\'' +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getName(){
        return authorFirstName + " " + authorLastName;
    }
}
