public class Article extends Reading {
//    wage, and magazine name, number of pages.
    private double wage;
    private String magazineName;
    private int noOfPages;

    public Article(int number, String authorFirstName, String authorLastName, String title, double wage, String magazineName, int noOfPages) {
        super(number, authorFirstName, authorLastName, title);
        this.wage = wage;
        this.magazineName = magazineName;
        this.noOfPages = noOfPages;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getMagazineName() {
        return magazineName;
    }

    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    @Override
    public String toString() {
        return "Article{" +
                "number=" + super.getNumber() +
                ", author='" + super.getAuthorFirstName() + " " + super.getAuthorLastName() + '\'' +
                ", title='" + super.getTitle() + '\'' +
                ", wage='" + wage + '\'' +
                ", magazineName='" + magazineName + '\'' +
                ", noOfPages=" + noOfPages +
                '}';
    }

    // method for calculating the income of the author
    public double getAuthorIncome(){
        // 10% of the wage * number of pages
        return (wage * 0.1) * noOfPages;
    }
}
