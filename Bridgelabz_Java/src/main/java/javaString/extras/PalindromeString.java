package javaString.extras;

/**
 * Problem 3 - Palindrome String Check
 * Write a Java program to check if a given string is
 * a palindrome.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */
public class PalindromeString {

    public static void main(String[] args) {

        String str = "madam";

        boolean isPalindrome = true;

        int left = 0;
        int right = str.length() - 1;

        // Compare characters from both ends
        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                isPalindrome = false;
                break;
            }

            left++;
            right--;
        }

        System.out.println("String : " + str);

        if (isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}
