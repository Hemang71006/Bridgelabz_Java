package javaSearchingAlgorithms.stringBuilder;

import java.util.HashSet;

/**
 * Problem 2 (Remove Duplicates from a String Using StringBuilder)
 * Remove duplicate characters while maintaining their original order.
 *
 * Author : Hemang
 * Date : 09-10-2026
 */

public class RemoveDuplicateCharacters {

    public static String removeDuplicates(String input) {

        StringBuilder result = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        // Visit each character in the input
        for (int i = 0; i < input.length(); i++) {

            char current = input.charAt(i);

            // Append only characters not seen before
            if (!seen.contains(current)) {
                result.append(current);
                seen.add(current);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String input = "programming";

        System.out.println("Original String: " + input);
        System.out.println("After Removing Duplicates: "
                + removeDuplicates(input));
    }
}
