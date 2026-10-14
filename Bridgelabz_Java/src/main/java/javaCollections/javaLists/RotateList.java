
package javaCollections.javaLists;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 3 (Collections - List Interface)
 * Rotate the elements of a list to the left by a given number of positions.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */
public class RotateList {

    public static void rotateList(List<Integer> list, int positions) {
        // Return if the list is empty
        if (list.isEmpty()) {
            return;
        }

        // Handle rotations greater than the list size
        int size = list.size();
        positions = positions % size;

        // Store elements in their rotated order
        List<Integer> rotated = new ArrayList<>();

        // Add elements from the rotation position to the end
        for (int i = positions; i < size; i++) {
            rotated.add(list.get(i));
        }

        // Add the remaining elements from the beginning
        for (int i = 0; i < positions; i++) {
            rotated.add(list.get(i));
        }

        // Copy the rotated elements back into the original list
        for (int i = 0; i < size; i++) {
            list.set(i, rotated.get(i));
        }
    }

    public static void main(String[] args) {
        // Create a list of numbers
        List<Integer> numbers =
                new ArrayList<>(List.of(10, 20, 30, 40, 50));

        // Rotate the list two positions to the left
        rotateList(numbers, 2);

        // Display the rotated list
        System.out.println("Rotated list: " + numbers);
    }
}

