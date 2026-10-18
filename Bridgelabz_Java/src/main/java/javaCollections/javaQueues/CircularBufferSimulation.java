package javaCollections.javaQueues;

/**
 * Problem 5 (Collections - Circular Buffer Simulation)
 * Implement a fixed-size buffer that overwrites the oldest
 * element when the buffer is full.
 *
 * Author : Hemang
 * Date   : 13-10-2026
 */

public class CircularBufferSimulation {

    int[] buffer;
    int front = 0;
    int size = 0;

    // Create a buffer of the given capacity
    CircularBufferSimulation(int capacity) {
        buffer = new int[capacity];
    }

    // Insert an element into the circular buffer
    void add(int value) {

        // Calculate the next position
        int position = (front + size) % buffer.length;

        if (size == buffer.length) {

            // Overwrite the oldest element
            buffer[front] = value;

            // Move front to the next oldest element
            front = (front + 1) % buffer.length;

        } else {

            // Insert into the available position
            buffer[position] = value;
            size++;
        }
    }

    // Display elements from oldest to newest
    void display() {

        System.out.print("Buffer: [");

        for (int i = 0; i < size; i++) {

            int index = (front + i) % buffer.length;

            System.out.print(buffer[index]);

            if (i < size - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        CircularBufferSimulation buffer =
                new CircularBufferSimulation(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);

        System.out.println("Before Overwriting:");
        buffer.display();

        buffer.add(4);

        System.out.println("After Inserting 4:");
        buffer.display();
    }
}
