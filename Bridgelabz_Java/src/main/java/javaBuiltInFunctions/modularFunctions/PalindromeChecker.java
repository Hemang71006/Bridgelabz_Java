package javaBuiltInFunctions.modularFunctions;

import java.util.Scanner;

/**
 * Problem 5: Palindrome Checker
 * Check whether a string is a palindrome using functions.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class PalindromeChecker {

    // Take string input
    public static String getInput(Scanner scanner) {
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }

    // Check whether the string is a palindrome
    public static boolean isPalindrome(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Display the result
    public static void displayResult(String text, boolean result) {

        if (result) {
            System.out.println(text + " is a palindrome.");
        } else {
            System.out.println(text + " is not a palindrome.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Get input
        String text = getInput(scanner);

        // Check palindrome
        boolean result = isPalindrome(text);

        // Display result
        displayResult(text, result);

        scanner.close();
    }
}
