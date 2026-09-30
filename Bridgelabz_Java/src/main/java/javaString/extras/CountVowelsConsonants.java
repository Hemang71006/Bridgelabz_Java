package javaString.extras;

/**
 * Problem 1 - Count Vowels and Consonants
 * Write a Java program to count the number of vowels
 * and consonants in a given string.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */
public class CountVowelsConsonants {

    public static void main(String[] args) {

        String str = "Hello World";

        int vowels = 0;
        int consonants = 0;

        // Check each character
        for (int i = 0; i < str.length(); i++) {

            char ch = Character.toLowerCase(str.charAt(i));

            // Check whether character is a letter
            if (ch >= 'a' && ch <= 'z') {

                // Check for vowels
                if (ch == 'a' || ch == 'e' ||
                        ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("String      : " + str);
        System.out.println("Vowels      : " + vowels);
        System.out.println("Consonants  : " + consonants);
    }
}
