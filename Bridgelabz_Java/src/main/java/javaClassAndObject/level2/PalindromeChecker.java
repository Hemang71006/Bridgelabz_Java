package javaClassandObject.level2;

/**
 * Problem 3 (GCR — Java Class and Object Level 2 Assignment)
 * Create a PalindromeChecker class with an attribute text.
 * Add methods to check if the text is a palindrome and display
 * the result.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class PalindromeChecker {

    // Text attribute
    private String text;

    // Constructor to initialize text
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check whether text is a palindrome
    public boolean isPalindrome() {
        int left = 0;
        int right = text.length() - 1;

        // Compare characters from both ends
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Method to display palindrome result
    public void displayResult() {
        System.out.println("Text: " + text);
        System.out.println("Is Palindrome: " + isPalindrome());
    }

    public static void main(String[] args) {

        // Create a PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker("madam");

        // Display result
        checker.displayResult();
    }
}
