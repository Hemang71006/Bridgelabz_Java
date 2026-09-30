package javaConstructors.level1;

/**
 * Problem 5 (GCR — Java Constructors Level 1 Assignment)
 * Create a Book class with attributes title, author, price,
 * and availability.
 * Implement a method to borrow a book.
 *
 * Author : Hemang
 * Date : 29-09-2026
 */
public class LibraryBook {

    // Instance variables
    String title;
    String author;
    double price;
    boolean availability;

    // Parameterized constructor
    LibraryBook(String title, String author, double price,
                boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    // Borrow the book
    void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    // Display book details
    void displayBookDetails() {
        System.out.println("Title        : " + title);
        System.out.println("Author       : " + author);
        System.out.println("Price        : " + price);
        System.out.println("Availability  : " + availability);
    }

    public static void main(String[] args) {

        // Create library book
        LibraryBook book = new LibraryBook(
                "Java Programming",
                "James Gosling",
                599.0,
                true
        );

        System.out.println("Before Borrowing:");
        book.displayBookDetails();

        System.out.println("\nBorrowing Book:");
        book.borrowBook();

        System.out.println("\nAfter Borrowing:");
        book.displayBookDetails();
    }
}
