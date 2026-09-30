package javaString.extras;

/**
 * Problem 11 - Anagram Check
 * Write a Java program that accepts two strings and checks
 * if the two strings are anagrams of each other.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */
public class AnagramCheck {

    public static void main(String[] args) {

        String str1 = "listen";
        String str2 = "silent";

        boolean isAnagram = true;

        // Different lengths cannot be anagrams
        if (str1.length() != str2.length()) {
            isAnagram = false;
        } else {

            // Check each character of first string
            for (int i = 0; i < str1.length(); i++) {

                char currentChar = str1.charAt(i);

                int count1 = 0;
                int count2 = 0;

                // Count character in first string
                for (int j = 0; j < str1.length(); j++) {
                    if (str1.charAt(j) == currentChar) {
                        count1++;
                    }
                }

                // Count character in second string
                for (int j = 0; j < str2.length(); j++) {
                    if (str2.charAt(j) == currentChar) {
                        count2++;
                    }
                }

                // Different frequency means not anagram
                if (count1 != count2) {
                    isAnagram = false;
                    break;
                }
            }
        }

        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);

        if (isAnagram) {
            System.out.println("Strings are Anagrams");
        } else {
            System.out.println("Strings are Not Anagrams");
        }
    }
}
