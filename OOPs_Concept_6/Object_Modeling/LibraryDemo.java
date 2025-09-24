package OOPs_Concept_6.Object_Modeling;

import java.util.*;

/**
 * LibraryDemo: Library aggregates Book (Book can exist independently).
 *
 * Compile: javac LibraryDemo.java
 * Run:     java LibraryDemo
 */
public class LibraryDemo {
    public static void main(String[] args) {
        Book b1 = new Book("Clean Code", "Robert C. Martin");
        Book b2 = new Book("Effective Java", "Joshua Bloch");
        Book b3 = new Book("Design Patterns", "GoF");

        Library lib = new Library("City Library");
        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);

        System.out.println("Library contents:");
        lib.listBooks();

        // Remove a book
        lib.removeBook(b2);
        System.out.println("\\nAfter removing Effective Java:");
        lib.listBooks();

        // Books still exist independently
        System.out.println("\\nStandalone book object: " + b2);
    }
}

/* Supporting classes */
class Book {
    private String title;
    private String author;
    public Book(String title, String author){ this.title = title; this.author = author; }
    public String getTitle(){ return title; }
    public String getAuthor(){ return author; }
    @Override
    public String toString(){ return title + " by " + author; }
}

class Library {
    private String name;
    private List<Book> books = new ArrayList<>();
    public Library(String name){ this.name = name; }
    public void addBook(Book b){ books.add(b); }
    public void removeBook(Book b){ books.remove(b); }
    public void listBooks(){
        System.out.println(name + " contains:");
        if(books.isEmpty()) System.out.println("  (no books)");
        for(Book b : books) System.out.println("  " + b);
    }
}
