package javaString.extras;

/**
 * Problem 6 - Find Substring Occurrences
 * Write a Java program to count how many times a given substring
 * occurs in a string.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */
public class SubstringOccurrences {

    public static void main(String[] args) {

        String str = "abababa";
        String substring = "aba";

        int count = 0;

        // Check every possible starting position
        for (int i = 0; i <= str.length() - substring.length(); i++) {

            boolean found = true;

            // Compare substring characters
            for (int j = 0; j < substring.length(); j++) {

                if (str.charAt(i + j) != substring.charAt(j)) {
                    found = false;
                    break;
                }
            }

            // Increase count if substring is found
            if (found) {
                count++;
            }
        }

        System.out.println("String    : " + str);
        System.out.println("Substring : " + substring);
        System.out.println("Occurrences: " + count);
    }
}
