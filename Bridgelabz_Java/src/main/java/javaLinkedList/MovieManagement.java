package javaLinkedList;

/**
 * Problem 2 (GCR — Doubly Linked List: Movie Management System)
 * Implement a movie management system using a doubly linked list.
 * Each node stores Movie Title, Director, Year of Release, and Rating.
 * Implement adding, removing, searching, displaying, and updating movie records.
 *
 * Author : Hemang
 * Date : 06-10-2026
 */

class MovieNode {
    String title;
    String director;
    int year;
    double rating;

    MovieNode next;
    MovieNode prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

public class MovieManagement {

    MovieNode head;
    MovieNode tail;

    // Add movie at beginning
    void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add movie at end
    void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Add movie at a specific position
    void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode current = head;

        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid position");
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);

        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }

        current.next = newNode;
    }

    // Remove movie by title
    void removeByTitle(String title) {
        MovieNode current = head;

        while (current != null) {
            if (current.title.equals(title)) {

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

    // Search movie by director
    void searchByDirector(String director) {
        MovieNode current = head;

        while (current != null) {
            if (current.director.equals(director)) {
                System.out.println("Movie found: " + current.title);
            }

            current = current.next;
        }
    }

    // Search movie by rating
    void searchByRating(double rating) {
        MovieNode current = head;

        while (current != null) {
            if (current.rating == rating) {
                System.out.println("Movie found: " + current.title);
            }

            current = current.next;
        }
    }

    // Display movies in forward order
    void displayForward() {
        MovieNode current = head;

        while (current != null) {
            System.out.println(current.title + " " + current.rating);
            current = current.next;
        }
    }

    // Display movies in reverse order
    void displayReverse() {
        MovieNode current = tail;

        while (current != null) {
            System.out.println(current.title + " " + current.rating);
            current = current.prev;
        }
    }

    // Update rating by movie title
    void updateRating(String title, double newRating) {
        MovieNode current = head;

        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                return;
            }

            current = current.next;
        }
    }

    public static void main(String[] args) {

        MovieManagement list = new MovieManagement();

        list.addAtBeginning("Avatar", "James Cameron", 2009, 8.0);
        list.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        list.addAtPosition(2, "Interstellar", "Christopher Nolan", 2014, 8.7);

        System.out.println("Forward:");
        list.displayForward();

        System.out.println("Reverse:");
        list.displayReverse();

        list.searchByDirector("Christopher Nolan");

        list.searchByRating(8.8);

        list.updateRating("Avatar", 8.5);

        list.removeByTitle("Inception");
    }
}
