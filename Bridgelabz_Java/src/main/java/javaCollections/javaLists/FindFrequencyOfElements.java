
package javaCollections.javaLists;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem 2 (Collections - List Interface)
 * Count the frequency of each element in a list of strings.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */
public class FindFrequencyOfElements {

    public static Map<String, Integer> findFrequency(List<String> list) {
        // Create a map to store each element and its frequency
        Map<String, Integer> frequency = new LinkedHashMap<>();

        // Count each element in the list
        for (String element : list) {
            frequency.put(element, frequency.getOrDefault(element, 0) + 1);
        }

        // Return the frequency map
        return frequency;
    }

    public static void main(String[] args) {
        // Create a list containing duplicate fruits
        List<String> fruits = new ArrayList<>(
                List.of("apple", "banana", "apple", "orange"));

        // Display the frequency of each fruit
        System.out.println("Frequencies: " + findFrequency(fruits));
    }
}

