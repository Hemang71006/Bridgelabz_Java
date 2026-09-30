package javaString.extras;

/**
 * Problem 2 - Reverse a String
 * Write a Java program to reverse a given string
 * without using any built-in reverse functions.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */
public class ReverseString {

    public static void main(String[] args) {

        String str = "Hello";

        String reversed = "";

        // Traverse string from last character to first
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }

        System.out.println("Original String : " + str);
        System.out.println("Reversed String : " + reversed);
    }
}
