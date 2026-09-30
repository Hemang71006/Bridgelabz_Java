package javaString.extras;

/**
 * Problem 9 - Find the Most Frequent Character
 * Write a Java program to find the most frequent character in a string.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */
public class MostFrequentCharacter {

    public static void main(String[] args) {

        String str = "success";

        char mostFrequent = str.charAt(0);
        int maxCount = 0;

        // Check frequency of each character
        for (int i = 0; i < str.length(); i++) {

            char currentChar = str.charAt(i);
            int count = 0;

            // Count current character
            for (int j = 0; j < str.length(); j++) {

                if (str.charAt(j) == currentChar) {
                    count++;
                }
            }

            // Update most frequent character
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = currentChar;
            }
        }

        System.out.println("String : " + str);
        System.out.println("Most Frequent Character: '" +
                mostFrequent + "'");
    }
}
