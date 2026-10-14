
package javaCollections.javaSets;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem 3 (Collections - Set Interface)
 * Find elements present in either set but not in both.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */
public class SymmetricDifference {

    public static void main(String[] args) {
        // Create two sets
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 4, 5));

        // Add all elements from both sets
        Set<Integer> difference = new HashSet<>(set1);
        difference.addAll(set2);

        // Remove elements common to both sets
        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2);
        difference.removeAll(common);

        // Display the symmetric difference
        System.out.println("Symmetric difference: " + difference);
    }
}

