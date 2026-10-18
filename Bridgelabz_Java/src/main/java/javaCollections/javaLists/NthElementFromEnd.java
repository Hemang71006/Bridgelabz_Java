
package javaCollections.javaLists;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Problem 5 (Collections - List Interface)
 * Find the Nth element from the end without calculating list size.
 *
 * Author : Hemang
 * Date   : 13-10-2026
 */
public class NthElementFromEnd {

    public static String findNthFromEnd(
            LinkedList<String> list, int n) {

        // Validate the position
        if (n <= 0) {
            throw new IllegalArgumentException(
                    "N must be greater than zero.");
        }

        // Create two iterators starting at the beginning
        ListIterator<String> first = list.listIterator();
        ListIterator<String> second = list.listIterator();

        // Move the first iterator N positions ahead
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                throw new IllegalArgumentException(
                        "N is greater than the list length.");
            }
            first.next();
        }

        // Move both iterators until the first reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        // The second iterator now points to the Nth element from the end
        return second.next();
    }

    public static void main(String[] args) {
        // Create a linked list of letters
        LinkedList<String> letters =
                new LinkedList<>(List.of("A", "B", "C", "D", "E"));

        // Specify the required position from the end
        int n = 2;

        // Display the list and the required element
        System.out.println("List: " + letters);
        System.out.println(n + "nd element from the end: "
                + findNthFromEnd(letters, n));
    }
}

