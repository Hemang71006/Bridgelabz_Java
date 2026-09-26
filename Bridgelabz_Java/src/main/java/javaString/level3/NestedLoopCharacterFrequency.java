package javaString.level3;

import java.util.Scanner;

/**
 * Problem 6 (GCR — Java String Level 3 Assignment)
 * Find the frequency of characters in a string using nested loops
 * and display the result.
 *
 * Author : Hemang
 * Date : 25-09-2026
 */
public class NestedLoopCharacterFrequency {

    // Find character frequency using nested loops
    public static String[] findFrequency(String text) {
        // Convert text into character array
        char[] characters = text.toCharArray();

        // Create frequency array
        int[] frequency = new int[characters.length];

        // Find frequency using nested loops
        for (int i = 0; i < characters.length; i++) {

            // Skip duplicate characters already processed
            if (characters[i] == '0') {
                continue;
            }

            // Initialize frequency to 1
            frequency[i] = 1;

            // Check remaining characters for duplicates
            for (int j = i + 1; j < characters.length; j++) {
                if (characters[i] == characters[j]) {
                    frequency[i]++;
                    characters[j] = '0';
                }
            }
        }

        // Count characters with valid frequency
        int count = 0;

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '0') {
                count++;
            }
        }

        // Create result array
        String[] result = new String[count];
        int index = 0;

        // Store characters and frequencies
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '0') {
                result[index] =
                        characters[i] + " : " + frequency[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take string input
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        // Find character frequency
        String[] result = findFrequency(text);

        // Display result
        System.out.println("Character Frequencies:");

        for (String item : result) {
            System.out.println(item);
        }

        input.close();
    }
}
