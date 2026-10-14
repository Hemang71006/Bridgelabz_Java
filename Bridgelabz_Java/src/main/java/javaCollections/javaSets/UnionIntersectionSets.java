
package javaCollections.javaSets;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem 2 (Collections - Set Interface)
 * Find the union and intersection of two sets.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */
public class UnionIntersectionSets {

    public static void main(String[] args) {
        // Create two sets
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 4, 5));

        // Create a copy of the first set for the union
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        // Create a copy of the first set for the intersection
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // Display the results
        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }
}

