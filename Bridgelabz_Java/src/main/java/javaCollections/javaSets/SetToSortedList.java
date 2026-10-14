
package javaCollections.javaSets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

/**
 * Problem 4 (Collections - Set Interface)
 * Convert a HashSet of integers into a sorted list.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */
public class SetToSortedList {

    public static void main(String[] args) {
        // Create a HashSet of integers
        Set<Integer> numbers = new HashSet<>(Set.of(5, 3, 9, 1));

        // Convert the set into a list
        List<Integer> sortedList = new ArrayList<>(numbers);

        // Sort the list in ascending order
        Collections.sort(sortedList);

        // Display the sorted list
        System.out.println("Sorted list: " + sortedList);
    }
}

