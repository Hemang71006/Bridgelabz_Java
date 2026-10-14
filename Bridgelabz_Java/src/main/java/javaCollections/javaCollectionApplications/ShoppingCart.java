package javaCollections.javaCollectionApplications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Problem 2 (Collections - Shopping Cart)
 * Store product prices using HashMap, maintain insertion order
 * using LinkedHashMap, and sort products by price using TreeMap.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */

public class ShoppingCart {

    public static void main(String[] args) {

        // Store product prices
        Map<String, Double> prices = new HashMap<>();

        prices.put("Laptop", 50000.0);
        prices.put("Mouse", 500.0);
        prices.put("Keyboard", 1500.0);
        prices.put("Monitor", 50000.0);

        // Maintain the order in which products are added
        Map<String, Double> cart = new LinkedHashMap<>();

        cart.put("Laptop", prices.get("Laptop"));
        cart.put("Mouse", prices.get("Mouse"));
        cart.put("Keyboard", prices.get("Keyboard"));
        cart.put("Monitor", prices.get("Monitor"));

        System.out.println("Shopping Cart in Insertion Order:");

        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + ": Rs. " + entry.getValue());
        }

        // Sort products by price; keep equal-priced products together
        Map<Double, List<String>> sortedProducts = new TreeMap<>();

        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            sortedProducts.computeIfAbsent(
                    entry.getValue(), key -> new ArrayList<>()
            ).add(entry.getKey());
        }

        System.out.println("\nProducts Sorted by Price:");

        for (Map.Entry<Double, List<String>> entry : sortedProducts.entrySet()) {
            System.out.println("Rs. " + entry.getKey() + ": " + entry.getValue());
        }

        // Calculate the total cart price
        double total = 0;

        for (double price : cart.values()) {
            total += price;
        }

        System.out.println("\nTotal Cart Price: Rs. " + total);
    }
}
