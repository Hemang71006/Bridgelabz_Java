package javaString.extras;

/**
 * Problem 4 - Remove Duplicates from a String
 * Write a Java program to remove all duplicate characters
 * from a given string and return the modified string.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

        String str = "programming";

        String result = "";

        // Check each character
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Add character only if it is not already present
            if (result.indexOf(ch) == -1) {
                result = result + ch;
            }
        }

        System.out.println("Original String : " + str);
        System.out.println("Without Duplicates : " + result);
    }
}
