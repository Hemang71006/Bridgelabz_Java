package javaConstructors.level1;

/**
 * Problem 1 (GCR — Java Constructors Level 1 Assignment)
 * Create a Book class with attributes title, author, and price.
 * Provide both default and parameterized constructors.
 *
 * Author : Hemang
 * Date : 29-09-2026
 */
public class Book {

    // Instance variables
    String title;
    String author;
    double price;

    // Default constructor
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Display book details
    void displayBookDetails() {
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : " + price);
    }

    public static void main(String[] args) {

        // Create object using default constructor
        Book book1 = new Book();

        // Create object using parameterized constructor
        Book book2 = new Book("Java Programming", "James Gosling", 599.0);

        System.out.println("Default Constructor:");
        book1.displayBookDetails();

        System.out.println("\nParameterized Constructor:");
        book2.displayBookDetails();
    }
}
