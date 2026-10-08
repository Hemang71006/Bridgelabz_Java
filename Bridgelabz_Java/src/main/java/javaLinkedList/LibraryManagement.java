package javaLinkedList;

/**
 * Problem 5 (GCR — Doubly Linked List: Library Management System)
 * Design a library management system using a doubly linked list.
 * Each node stores Book Title, Author, Genre, Book ID, and Availability Status.
 * Implement adding, removing, searching, updating, displaying,
 * and counting books.
 *
 * Author : Hemang
 * Date : 06-10-2026
 */

class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean available;

    BookNode next;
    BookNode prev;

    BookNode(String title, String author, String genre, int bookId, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = available;
    }
}

public class LibraryManagement {

    BookNode head;
    BookNode tail;

    // Add book at the end
    void addBook(String title, String author, String genre,
                 int bookId, boolean available) {

        BookNode newNode =
                new BookNode(title, author, genre, bookId, available);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Remove book by ID
    void removeBook(int bookId) {
        BookNode current = head;

        while (current != null) {
            if (current.bookId == bookId) {

                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                return;
            }

            current = current.next;
        }
    }

    // Search book by title
    void searchByTitle(String title) {
        BookNode current = head;

        while (current != null) {
            if (current.title.equals(title)) {
                System.out.println("Book found: " + current.title);
                return;
            }

            current = current.next;
        }

        System.out.println("Book not found");
    }

    // Search book by author
    void searchByAuthor(String author) {
        BookNode current = head;

        while (current != null) {
            if (current.author.equals(author)) {
                System.out.println("Book found: " + current.title);
            }

            current = current.next;
        }
    }

    // Update availability
    void updateAvailability(int bookId, boolean available) {
        BookNode current = head;

        while (current != null) {
            if (current.bookId == bookId) {
                current.available = available;
                return;
            }

            current = current.next;
        }
    }

    // Display forward
    void displayForward() {
        BookNode current = head;

        while (current != null) {
            System.out.println(
                    current.bookId + " " +
                            current.title + " " +
                            current.available
            );

            current = current.next;
        }
    }

    // Display reverse
    void displayReverse() {
        BookNode current = tail;

        while (current != null) {
            System.out.println(
                    current.bookId + " " +
                            current.title + " " +
                            current.available
            );

            current = current.prev;
        }
    }

    // Count books
    int countBooks() {
        int count = 0;
        BookNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public static void main(String[] args) {

        LibraryManagement library = new LibraryManagement();

        library.addBook("Java", "James", "Programming", 101, true);
        library.addBook("Python", "Guido", "Programming", 102, false);
        library.addBook("C++", "Bjarne", "Programming", 103, true);

        System.out.println("Forward:");
        library.displayForward();

        System.out.println("Reverse:");
        library.displayReverse();

        library.searchByTitle("Java");
        library.searchByAuthor("Guido");

        library.updateAvailability(102, true);

        System.out.println("Total Books: " + library.countBooks());

        library.removeBook(103);
    }
}
