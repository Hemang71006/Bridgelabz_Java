package javaCollections.javaMaps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 1 (Collections - Word Frequency Counter)
 * Read a text file and count the frequency of each word.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */

public class WordFrequencyCounter {

    public static void main(String[] args) {

        // Read text from the file
        try {
            String text = Files.readString(Path.of("Bridgelabz_Java/src/main/java/javaCollections/sample.txt"));

            // Convert to lowercase and remove punctuation
            text = text.toLowerCase().replaceAll("[^a-z0-9\\s]", "");

            String[] words = text.trim().split("\\s+");

            Map<String, Integer> frequency = new HashMap<>();

            // Count each word
            for (String word : words) {
                if (!word.isEmpty()) {
                    frequency.put(word,
                            frequency.getOrDefault(word, 0) + 1);
                }
            }

            System.out.println("Word Frequencies: " + frequency);

        } catch (IOException e) {
            System.out.println("Error reading sample.txt");
        }
    }
}
