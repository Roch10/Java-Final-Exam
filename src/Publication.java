import java.util.ArrayList;
import java.util.Scanner;

public class Publication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // creating an array list which can contain both books and articles
        ArrayList<Reading> readings = new ArrayList<>();
        // fillData(readings);
        // let the user enter their data
        do {
            readingFromUser(readings);
            System.out.println("Do you want to add more? (Y/N)");
        } while (scanner.next().toUpperCase().charAt(0)=='Y');

        System.out.println("*******************************************");

        // 1. the user enter the last name of an author and print out the details of all their publications either a book or an article
        System.out.println("Enter an author's last name:");
        String lName = scanner.next();
        listAuthorPublication(readings,lName);

        // 2. Using a recursive method, find the total income for all authors.
        printAuthorIncome(readings);

        // 3. Enter a publication number, find it then if it's a book print the publisher, if an article print the magazine name
        System.out.println("Enter a publication number:");
        int number = scanner.nextInt();
        findByNumber(readings, number);

        // 4. Print out the first and last name of any author who has an article with more than 20 pages.
        System.out.println("*******************************************");
        System.out.println("The authors who have article of more than 20 pages are: ");
        for(Reading r: readings) {
            if(r instanceof Article && ((Article) r).getNoOfPages() > 20){
                System.out.println(r.getName());
            }
        }
        System.out.println("*******************************************");

    }

    public static void fillData(ArrayList<Reading> readings){
        readings.add(new Book(1, "Roch", "b", "T1", 12.2, "p1", 3));
        readings.add(new Book(2, "af1", "al1", "T2", 10.2, "p2", 4));
        readings.add(new Book(3, "Roch", "b", "T3", 5.4, "p3", 3));
        readings.add(new Book(4, "af1", "al1", "T4", 15.3, "p1", 2));
        readings.add(new Article(5, "Roch", "b", "T5", 2.3, "m1", 10));
        readings.add(new Article(6, "af1", "al1", "T6", 5.3, "m1", 15));
        readings.add(new Article(7, "af1", "al1", "T7", 7.3, "m2", 24));
        readings.add(new Article(8, "af2", "al2", "T8", 1.3, "m1", 30));
    }

    // method to get data from user
    public static void readingFromUser(ArrayList<Reading> readings){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the type you want to add: (1/2)");
        System.out.println("1. Book");
        System.out.println("2. Article");
        int choice = scanner.nextInt();

        System.out.println("Enter number:");
        int number = scanner.nextInt();
        System.out.println("Enter title:");
        String title = scanner.next();
        System.out.println("Enter author name");
        String authorFirstName = scanner.next();
        String authorLastName = scanner.next();

        switch (choice){
            case 1:
                System.out.println("Enter price:");
                double price = scanner.nextDouble();
                System.out.println("Enter publisher:");
                String publisher = scanner.next();
                System.out.println("Enter number of copies:");
                int noOfCopies = scanner.nextInt();
                readings.add(new Book(number, authorFirstName, authorLastName, title, price, publisher, noOfCopies));
                break;
            case 2:
                System.out.println("Enter wage:");
                double wage = scanner.nextDouble();
                System.out.println("Enter magazine name:");
                String magazineName = scanner.next();
                System.out.println("Enter number of pages:");
                int noOfPages = scanner.nextInt();
                readings.add(new Article(number, authorFirstName, authorLastName, title, wage, magazineName, noOfPages));
                break;
        }
    }

    // method to get the list of publications by a specific author
    public static void listAuthorPublication(ArrayList<Reading> readings, String lName){
        System.out.println("The list of publications written by " + lName + " are as follows:");
        for (Reading r : readings) {
            if(r.getAuthorLastName().toUpperCase().equals(lName.toUpperCase())){
                if(r instanceof Article)
                    System.out.println(((Article) r).toString());
                else
                    System.out.println(((Book) r).toString());
            }
        }
        System.out.println("*******************************************");
    }

    public static void printAuthorIncome(ArrayList<Reading> readings) {
        ArrayList<String> authorList = new ArrayList<>(); // arrayList to store unique author names
        // to find and store unique author names
        for(Reading r: readings) {
            if(!authorList.contains(r.getAuthorLastName())){
                authorList.add(r.getAuthorLastName());
            }
        }

        System.out.println("Total Income of all authors are are follows:");
        for(String author: authorList) {
            System.out.println(author + " = " + getIncome(readings, readings.size()-1, author));
        }
        System.out.println("*******************************************");

    }

    // recursive method to find the total income for all authors
    public static double getIncome(ArrayList<Reading> readings, int index, String lName) {
        if(index >= 0) {
            if(readings.get(index).getAuthorLastName().toUpperCase().equals(lName.toUpperCase())){
                if(readings.get(index) instanceof Article)
                    return ((Article) readings.get(index)).getAuthorIncome() + getIncome(readings,index-1,lName);
                else
                    return ((Book) readings.get(index)).getAuthorIncome()+ getIncome(readings,index-1,lName);
            } else {
                return getIncome(readings,index-1,lName);
            }
        }
        return 0;
    }

    // method to find publication by number and print required output
    public static void findByNumber(ArrayList<Reading> readings, int number) {
        for(Reading r: readings){
            if(r.getNumber() == number){
                if(r instanceof Article)
                    System.out.println( "The magazine where this article was published is " + ((Article) r).getMagazineName());
                else
                    System.out.println( "The publisher that published this book is " + ((Book) r).getPublisher());
            }
        }
    }
}
