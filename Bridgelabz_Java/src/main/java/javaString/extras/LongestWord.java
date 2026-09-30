package javaString.extras;

/**
 * Problem 5 - Find the Longest Word in a Sentence
 * Write a Java program that takes a sentence as input
 * and returns the longest word in the sentence.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */
public class LongestWord {

    public static void main(String[] args) {

        String sentence = "Java programming is interesting";

        String[] words = sentence.split(" ");

        String longestWord = "";

        // Check every word
        for (String word : words) {

            // Update longest word if current word is longer
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        System.out.println("Sentence     : " + sentence);
        System.out.println("Longest Word : " + longestWord);
    }
}
