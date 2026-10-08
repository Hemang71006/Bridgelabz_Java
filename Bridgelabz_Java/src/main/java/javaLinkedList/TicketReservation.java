package javaLinkedList;

/**
 * Problem 9 (GCR — Circular Linked List: Online Ticket Reservation System)
 * Design an online ticket reservation system using a circular linked list.
 * Each node stores Ticket ID, Customer Name, Movie Name, Seat Number,
 * and Booking Time.
 * Implement adding, removing, displaying, searching, and counting tickets.
 *
 * Author : Hemang
 * Date : 06-10-2026
 */

class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;

    TicketNode next;

    TicketNode(int ticketId, String customerName, String movieName,
               int seatNumber, String bookingTime) {

        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}

public class TicketReservation {

    TicketNode head;

    // Add ticket at the end
    void addTicket(int ticketId, String customerName, String movieName,
                   int seatNumber, String bookingTime) {

        TicketNode newNode =
                new TicketNode(
                        ticketId,
                        customerName,
                        movieName,
                        seatNumber,
                        bookingTime
                );

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        TicketNode current = head;

        while (current.next != head) {
            current = current.next;
        }

        current.next = newNode;
        newNode.next = head;
    }

    // Remove ticket by ID
    void removeTicket(int ticketId) {
        if (head == null) {
            return;
        }

        TicketNode current = head;
        TicketNode previous = null;

        do {
            if (current.ticketId == ticketId) {

                if (current == head) {
                    TicketNode last = head;

                    while (last.next != head) {
                        last = last.next;
                    }

                    if (head.next == head) {
                        head = null;
                    } else {
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    previous.next = current.next;
                }

                return;
            }

            previous = current;
            current = current.next;

        } while (current != head);
    }

    // Display all tickets
    void display() {
        if (head == null) {
            return;
        }

        TicketNode current = head;

        do {
            System.out.println(
                    current.ticketId + " " +
                            current.customerName + " " +
                            current.movieName + " Seat: " +
                            current.seatNumber
            );

            current = current.next;

        } while (current != head);
    }

    // Search by customer name
    void searchByCustomer(String customerName) {
        if (head == null) {
            return;
        }

        TicketNode current = head;

        do {
            if (current.customerName.equals(customerName)) {
                System.out.println(
                        "Ticket found: " + current.ticketId
                );
            }

            current = current.next;

        } while (current != head);
    }

    // Search by movie name
    void searchByMovie(String movieName) {
        if (head == null) {
            return;
        }

        TicketNode current = head;

        do {
            if (current.movieName.equals(movieName)) {
                System.out.println(
                        "Ticket found: " + current.ticketId
                );
            }

            current = current.next;

        } while (current != head);
    }

    // Count tickets
    int countTickets() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        TicketNode current = head;

        do {
            count++;
            current = current.next;
        } while (current != head);

        return count;
    }

    public static void main(String[] args) {

        TicketReservation tickets =
                new TicketReservation();

        tickets.addTicket(
                101, "Hemang", "Avengers",
                10, "10:00 AM"
        );

        tickets.addTicket(
                102, "Rahul", "Avengers",
                11, "10:05 AM"
        );

        tickets.addTicket(
                103, "Aman", "Batman",
                12, "10:10 AM"
        );

        System.out.println("Tickets:");
        tickets.display();

        tickets.searchByCustomer("Hemang");
        tickets.searchByMovie("Avengers");

        System.out.println(
                "Total Tickets: " + tickets.countTickets()
        );

        tickets.removeTicket(102);
    }
}
