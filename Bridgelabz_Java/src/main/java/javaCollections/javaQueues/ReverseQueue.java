package javaCollections.javaQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 1 (Collections - Reverse a Queue)
 * Reverse the elements of a queue using queue operations.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */

public class ReverseQueue {

    public static void reverse(Queue<Integer> queue) {

        // Stop when the queue becomes empty
        if (queue.isEmpty()) {
            return;
        }

        // Remove the front element
        int value = queue.remove();

        // Reverse the remaining queue
        reverse(queue);

        // Add the removed element at the rear
        queue.add(value);
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);

        reverse(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}
