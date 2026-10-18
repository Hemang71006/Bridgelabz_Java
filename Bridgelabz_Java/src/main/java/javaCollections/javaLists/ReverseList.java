
package javaCollections.javaLists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem 1 (Collections - List Interface)
 * Reverse a List without using built-in reverse methods.
 * Implement it for both ArrayList and LinkedList.
 *
 * Author : Hemang
 * Date   : 13-10-2026
 */
public class ReverseList {

    public static void reverseList(List<Integer> list) {
        // Initialize pointers at both ends of the list
        int left = 0;
        int right = list.size() - 1;

        // Swap elements until the pointers meet
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // Create ArrayList and LinkedList with the same elements
        List<Integer> arrayList =
                new ArrayList<>(List.of(1, 2, 3, 4, 5));

        List<Integer> linkedList =
                new LinkedList<>(List.of(1, 2, 3, 4, 5));

        // Reverse both lists
        reverseList(arrayList);
        reverseList(linkedList);

        // Display the reversed lists
        System.out.println("ArrayList reversed: " + arrayList);
        System.out.println("LinkedList reversed: " + linkedList);
    }
}
