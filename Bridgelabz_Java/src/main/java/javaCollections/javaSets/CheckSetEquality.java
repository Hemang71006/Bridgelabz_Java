
package javaCollections.javaSets;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem 1 (Collections - Set Interface)
 * Check whether two sets contain the same elements.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */
public class CheckSetEquality {

    public static void main(String[] args) {
        // Create two sets with the same elements in different orders
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 2, 1));

        // Compare the sets without considering order
        System.out.println("Are sets equal: " + set1.equals(set2));
    }
}

