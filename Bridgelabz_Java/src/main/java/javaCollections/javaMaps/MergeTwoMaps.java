package javaCollections.javaMaps;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 4 (Collections - Merge Two Maps)
 * Merge two maps and add values for duplicate keys.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */

public class MergeTwoMaps {

    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        map1.put("A", 1);
        map1.put("B", 2);

        map2.put("B", 3);
        map2.put("C", 4);

        // Start with all entries from the first map
        Map<String, Integer> merged = new HashMap<>(map1);

        // Add values when a key already exists
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            merged.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        System.out.println("Map 1: " + map1);
        System.out.println("Map 2: " + map2);
        System.out.println("Merged Map: " + merged);
    }
}
