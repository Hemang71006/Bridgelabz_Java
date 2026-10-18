
package javaCollections.javaSets;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem 5 (Collections - Set Interface)
 * Check whether one set is a subset of another.
 *
 * Author : Hemang
 * Date   : 13-10-2026
 */
public class FindSubsets {

    public static void main(String[] args) {
        // Create the smaller set and the larger set
        Set<Integer> set1 = new HashSet<>(Set.of(2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(1, 2, 3, 4));

        // Check whether set2 contains every element of set1
        boolean isSubset = set2.containsAll(set1);

        // Display the result
        System.out.println("Is set1 a subset of set2: " + isSubset);
    }
}

