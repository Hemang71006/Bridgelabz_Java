package javaString.extras;

/**
 * Problem 7 - Toggle Case of Characters
 * Write a Java program to toggle the case of each character
 * in a given string.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */
public class ToggleCase {

    public static void main(String[] args) {

        String str = "Hello World";

        String result = "";

        // Check each character
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Convert uppercase to lowercase
            if (ch >= 'A' && ch <= 'Z') {
                result = result + (char) (ch + 32);
            }

            // Convert lowercase to uppercase
            else if (ch >= 'a' && ch <= 'z') {
                result = result + (char) (ch - 32);
            }

            // Keep spaces and other characters unchanged
            else {
                result = result + ch;
            }
        }

        System.out.println("Original String : " + str);
        System.out.println("Toggled String  : " + result);
    }
}
