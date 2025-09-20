package OOPs_Concept_5.Single_Inheritance;

// Single Inheritance: Library Management (Book -> Author)
class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
}

class Author extends Book {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    void displayInfo() {
        System.out.println("Book: " + title + " (" + publicationYear + ")");
        System.out.println("Author: " + name + " - " + bio);
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        Author a = new Author("Java Programming", 2023, "James Gosling", "Creator of Java");
        a.displayInfo();
    }
}
