package javaCollections.javaQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 2 (Collections - Generate Binary Numbers)
 * Generate the first N binary numbers using a queue.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */

public class GenerateBinaryNumbers {

    public static void generate(int n) {

        Queue<String> queue = new LinkedList<>();

        // Start with the first binary number
        queue.add("1");

        for (int i = 0; i < n; i++) {

            // Remove the front binary number
            String current = queue.remove();

            System.out.print(current + " ");

            // Generate the next two binary numbers
            queue.add(current + "0");
            queue.add(current + "1");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println("First " + n + " Binary Numbers:");

        generate(n);
    }
}
