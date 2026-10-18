
package javaCollections.javaLists;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Problem 4 (Collections - List Interface)
 * Remove duplicate elements while preserving the original order.
 *
 * Author : Hemang
 * Date   : 13-10-2026
 */
public class RemoveDuplicatesPreservingOrder {

    public static List<Integer> removeDuplicates(List<Integer> list) {
        // Use LinkedHashSet to remove duplicates and preserve order
        LinkedHashSet<Integer> uniqueElements = new LinkedHashSet<>(list);

        // Convert the set back into a list
        return new ArrayList<>(uniqueElements);
    }

    public static void main(String[] args) {
        // Create a list containing duplicate elements
        List<Integer> numbers =
                new ArrayList<>(List.of(3, 1, 2, 2, 3, 4));

        // Display the original list
        System.out.println("Original list: " + numbers);

        // Remove duplicates and display the result
        System.out.println("After removing duplicates: "
                + removeDuplicates(numbers));
    }
}

