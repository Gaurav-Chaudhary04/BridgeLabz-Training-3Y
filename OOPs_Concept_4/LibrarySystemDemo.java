package OOPs_Concept_4;

// Book.java

class Book {
    // Static variable for the library name, shared across all books
    static String libraryName;

    // Final variable ensures ISBN cannot be changed once set
    final String isbn;

    // Instance variables
    String title;
    String author;

    // Constructor using 'this' to initialize instance variables
    public Book(String title, String author, String isbn) {
        // 'this' disambiguates between instance variables and parameters
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Instance method to display book details
    public void displayDetails() {
        System.out.println("--- Book Details ---");
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("ISBN: " + this.isbn);
        System.out.println("--------------------");
    }

    // Static method to display the shared library name
    public static void displayLibraryName() {
        System.out.println("All books belong to: " + libraryName);
    }
}

// Main class to run the program
public class LibrarySystemDemo {
    public static void main(String[] args) {
        // Set the static library name
        Book.libraryName = "City Central Library";
        Book.displayLibraryName();

        // Create book instances
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");

        // Use 'instanceof' to verify object type
        Object objToCheck = book1;

        System.out.println("\nVerifying object of type: " + objToCheck.getClass().getName());
        if (objToCheck instanceof Book) {
            System.out.println("The object is an instance of Book. Printing details...");
            Book b = (Book) objToCheck;
            b.displayDetails();
        } else {
            System.out.println("The object is not an instance of Book.");
        }
    }
}