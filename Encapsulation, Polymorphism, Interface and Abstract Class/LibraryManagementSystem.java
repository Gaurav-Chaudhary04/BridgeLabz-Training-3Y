// LibraryManagementSystem.java
import java.util.*;

abstract class LibraryItem {
    private final String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        if (itemId == null || itemId.isBlank()) throw new IllegalArgumentException("Invalid ID");
        this.itemId = itemId;
        setTitle(title);
        setAuthor(author);
    }

    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title required");
        this.title = title;
    }
    public void setAuthor(String author) { this.author = (author == null ? "Unknown" : author); }

    public abstract int getLoanDuration(); // days
    public void getItemDetails() {
        System.out.printf("ID: %s | Title: %s | Author: %s | Loan days: %d%n",
                itemId, title, author, getLoanDuration());
    }
}

interface Reservable {
    boolean reserveItem(String borrowerId);
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean reserved = false;
    public Book(String id, String title, String author) { super(id, title, author); }
    @Override public int getLoanDuration() { return 21; }
    @Override public boolean reserveItem(String borrowerId) { return !reserved && (reserved = true); }
    @Override public boolean checkAvailability() { return !reserved; }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean reserved = false;
    public Magazine(String id, String title) { super(id, title, "Various"); }
    @Override public int getLoanDuration() { return 7; }
    @Override public boolean reserveItem(String borrowerId) { return !reserved && (reserved = true); }
    @Override public boolean checkAvailability() { return !reserved; }
}

class DVD extends LibraryItem implements Reservable {
    private boolean reserved = false;
    public DVD(String id, String title) { super(id, title, "Studio"); }
    @Override public int getLoanDuration() { return 5; }
    @Override public boolean reserveItem(String borrowerId) { return !reserved && (reserved = true); }
    @Override public boolean checkAvailability() { return !reserved; }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = Arrays.asList(
            new Book("B001","Effective Java","Joshua Bloch"),
            new Magazine("M001","Tech Monthly"),
            new DVD("D001","Inception")
        );

        for (LibraryItem it : items) {
            it.getItemDetails();
            if (it instanceof Reservable) {
                Reservable r = (Reservable) it;
                System.out.println("Available: " + r.checkAvailability());
                r.reserveItem("U100");
                System.out.println("Reserved now? " + !r.checkAvailability());
            }
            System.out.println("---");
        }
    }
}