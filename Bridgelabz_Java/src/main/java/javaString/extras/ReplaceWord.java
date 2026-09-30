package javaString.extras;

/**
 * Problem 12 - Replace a Word in a Sentence
 * Write a replace method in Java that replaces a given word
 * with another word in a sentence.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */
public class ReplaceWord {

    // Method to replace a word without using built-in replace()
    public static String replaceWord(String sentence,
                                     String oldWord,
                                     String newWord) {

        String result = "";
        int i = 0;

        // Traverse the sentence
        while (i < sentence.length()) {

            boolean match = true;

            // Check whether oldWord starts at current position
            if (i + oldWord.length() > sentence.length()) {
                match = false;
            } else {
                for (int j = 0; j < oldWord.length(); j++) {
                    if (sentence.charAt(i + j) != oldWord.charAt(j)) {
                        match = false;
                        break;
                    }
                }
            }

            // Replace oldWord if a match is found
            if (match) {
                result = result + newWord;
                i = i + oldWord.length();
            } else {
                result = result + sentence.charAt(i);
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String sentence = "I like Java";
        String oldWord = "Java";
        String newWord = "Python";

        // Call custom replace method
        String result = replaceWord(
                sentence, oldWord, newWord);

        System.out.println("Original Sentence: " + sentence);
        System.out.println("Modified Sentence: " + result);
    }
}
