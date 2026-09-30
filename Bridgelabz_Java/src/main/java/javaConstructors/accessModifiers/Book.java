package javaConstructors.accessModifiers;

/**
 * Problem 2 (GCR — Access Modifiers)
 * Create a Book class with:
 * ISBN (public), title (protected), and author (private).
 * Set and get the author name.
 * Create a subclass EBook to access ISBN and title.
 *
 * Author : Hemang
 * Date : 29-09-2026
 */
public class Book {

    // Public variable
    public String ISBN;

    // Protected variable
    protected String title;

    // Private variable
    private String author;

    // Constructor
    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public method to set private author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Public method to get private author
    public String getAuthor() {
        return author;
    }

    public static void main(String[] args) {

        // Create EBook object
        EBook ebook = new EBook(
                "978-0135166307",
                "Effective Java",
                "Joshua Bloch"
        );

        // Display details
        ebook.displayBookDetails();

        // Modify private author using setter
        ebook.setAuthor("James Gosling");

        // Access private author using getter
        System.out.println("\nUpdated Author: " + ebook.getAuthor());
    }
}

// Subclass
class EBook extends Book {

    EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    // Access public ISBN and protected title
    void displayBookDetails() {
        System.out.println("ISBN   : " + ISBN);
        System.out.println("Title  : " + title);
        System.out.println("Author : " + getAuthor());
    }
}
