// Problem: Library Book System with borrow method
public class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void displayDetails() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price + ", Available: " + isAvailable);
    }

    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("Java Programming", "James Gosling", 499);
        book.displayDetails();
        book.borrowBook();
        book.borrowBook();
        book.displayDetails();
    }
}
