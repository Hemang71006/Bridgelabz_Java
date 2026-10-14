package javaCollections.javaMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 2 (Collections - Invert a Map)
 * Reverse the keys and values of a map.
 * Store duplicate values in a list.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */

public class InvertMap {

    public static void main(String[] args) {

        Map<String, Integer> original = new HashMap<>();

        original.put("A", 1);
        original.put("B", 2);
        original.put("C", 1);

        Map<Integer, ArrayList<String>> inverted = new HashMap<>();

        // Reverse keys and values
        for (Map.Entry<String, Integer> entry : original.entrySet()) {

            Integer value = entry.getValue();
            String key = entry.getKey();

            // Add keys sharing the same value to a list
            inverted.computeIfAbsent(value, k -> new ArrayList<>())
                    .add(key);
        }

        System.out.println("Original Map: " + original);
        System.out.println("Inverted Map: " + inverted);
    }
}
