package javaString.extras;

/**
 * Problem 10 - Remove a Specific Character from a String
 * Write a Java program to remove all occurrences of a specific
 * character from a string.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */
public class RemoveSpecificCharacter {

    public static void main(String[] args) {

        String str = "Hello World";
        char characterToRemove = 'l';

        String result = "";

        // Check every character
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Add character if it is not the character to remove
            if (ch != characterToRemove) {
                result = result + ch;
            }
        }

        System.out.println("String: \"" + str + "\"");
        System.out.println("Character to Remove: '" +
                characterToRemove + "'");
        System.out.println("Modified String: \"" + result + "\"");
    }
}
