package javaClassandObject.level2;

/**
 * Problem 4 (GCR — Java Class and Object Level 2 Assignment)
 * Create a MovieTicket class with attributes movieName, seatNumber,
 * and price.
 * Add methods to book a ticket by assigning a seat and updating
 * the price, and to display ticket details.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class MovieTicket {

    // Movie ticket attributes
    private String movieName;
    private String seatNumber;
    private double price;

    // Constructor to initialize movie ticket details
    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = "Not Assigned";
        this.price = 0;
    }

    // Method to book a ticket
    public void bookTicket(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
    }

    // Method to display ticket details
    public void displayDetails() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Ticket Price: " + price);
    }

    public static void main(String[] args) {

        // Create a MovieTicket object
        MovieTicket ticket = new MovieTicket("Avengers");

        // Book the ticket
        ticket.bookTicket("A12", 250);

        // Display ticket details
        ticket.displayDetails();
    }
}
