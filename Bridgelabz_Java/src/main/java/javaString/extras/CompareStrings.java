package javaString.extras;

/**
 * Problem 8 - Compare Two Strings
 * Write a Java program to compare two strings lexicographically
 * without using built-in compare methods.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */
public class CompareStrings {

    public static void main(String[] args) {

        String str1 = "apple";
        String str2 = "banana";

        int minLength;

        // Find the length to compare
        if (str1.length() < str2.length()) {
            minLength = str1.length();
        } else {
            minLength = str2.length();
        }

        int result = 0;

        // Compare characters one by one
        for (int i = 0; i < minLength; i++) {

            if (str1.charAt(i) < str2.charAt(i)) {
                result = -1;
                break;
            }

            if (str1.charAt(i) > str2.charAt(i)) {
                result = 1;
                break;
            }
        }

        // If common part is same, compare lengths
        if (result == 0) {

            if (str1.length() < str2.length()) {
                result = -1;
            } else if (str1.length() > str2.length()) {
                result = 1;
            }
        }

        // Display result
        if (result < 0) {
            System.out.println("\"" + str1 +
                    "\" comes before \"" + str2 +
                    "\" in lexicographical order");
        } else if (result > 0) {
            System.out.println("\"" + str1 +
                    "\" comes after \"" + str2 +
                    "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal");
        }
    }
}
