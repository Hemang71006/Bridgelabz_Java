package javaCollections.javaMaps;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 3 (Collections - Find the Key with Highest Value)
 * Find the key associated with the maximum value.
 *
 * Author : Hemang
 * Date   : 13-10-2026
 */

public class HighestValueKey {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        String highestKey = null;
        int highestValue = Integer.MIN_VALUE;

        // Find the maximum value
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() > highestValue) {
                highestValue = entry.getValue();
                highestKey = entry.getKey();
            }
        }

        System.out.println("Map: " + map);
        System.out.println("Key with Highest Value: " + highestKey);
        System.out.println("Highest Value: " + highestValue);
    }
}
