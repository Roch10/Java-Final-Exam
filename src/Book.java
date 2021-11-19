public class Book extends Reading {
    private double price;
    private String publisher;
    private  int noOfCopies;

    public Book(int number, String authorFirstName, String authorLastName, String title, double price, String publisher, int noOfCopies) {
        super(number, authorFirstName, authorLastName, title);
        this.price = price;
        this.publisher = publisher;
        this.noOfCopies = noOfCopies;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "number=" + super.getNumber() +
                ", author='" + super.getAuthorFirstName() + " " + super.getAuthorLastName() + '\'' +
                ", title='" + super.getTitle() + '\'' +
                ", price='" + price + '\'' +
                ", publisher='" + publisher + '\'' +
                ", noOfCopies=" + noOfCopies +
                '}';
    }

    // method for calculating the income of the author
    public double getAuthorIncome(){
        // price*number of copies - 20% goes to the publisher
        double totalIncome = price * noOfCopies;
        double publisherIncome = totalIncome * 0.2;
        return totalIncome - publisherIncome;
    }
}
