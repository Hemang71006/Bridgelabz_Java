package javaClassandObject.level1;

/**
 * Problem 3 (GCR — Java Class and Object Level 1 Assignment)
 * Create a Book class with attributes title, author, and price.
 * Add a method to display the book details.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class BookDetails {

    // Book attributes
    private String title;
    private String author;
    private double price;

    // Constructor to initialize book details
    public BookDetails(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Book Author: " + author);
        System.out.println("Book Price: " + price);
    }

    public static void main(String[] args) {

        // Create a Book object
        BookDetails book = new BookDetails(
                "The Alchemist",
                "Paulo Coelho",
                399
        );

        // Display book details
        book.displayDetails();
    }
}
