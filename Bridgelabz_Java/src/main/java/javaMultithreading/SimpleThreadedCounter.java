package javaMultithreading;

import java.util.Scanner;

/**
 * Problem 1: Simple Threaded Counter
 * Count from 1 to a user-provided limit using multiple threads.
 * Coordinate the threads to print numbers in the correct order
 * and handle invalid input and interruptions.
 *
 * Author : Hemang
 * Date   : 23-10-2026
 */

public class SimpleThreadedCounter {

    // Maintain the next number that must be printed.
    static class Counter {
        private int nextNumber = 1;
        private final int limit;

        // Initialize the counting limit.
        public Counter(int limit) {
            this.limit = limit;
        }

        // Print a number only when it is its turn.
        public synchronized void printNumber(int number) {
            // Wait until this number is the next expected number.
            while (number != nextNumber) {
                try {
                    wait();
                } catch (InterruptedException exception) {
                    // Restore the interrupt status if waiting is interrupted.
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            // Print the number in the correct order.
            System.out.println(Thread.currentThread().getName() + " : " + number);

            // Allow the next number to be printed.
            nextNumber++;

            // Notify all waiting threads about the updated counter.
            notifyAll();
        }
    }

    // Assign a portion of the counting range to each thread.
    static class CountingTask implements Runnable {
        private final Counter counter;
        private final int threadNumber;
        private final int threadCount;
        private final int limit;

        // Initialize the thread's counting assignment.
        public CountingTask(Counter counter, int threadNumber,
                            int threadCount, int limit) {
            this.counter = counter;
            this.threadNumber = threadNumber;
            this.threadCount = threadCount;
            this.limit = limit;
        }

        // Count the numbers assigned to this thread.
        @Override
        public void run() {
            // Each thread handles every third number in its assigned sequence.
            for (int number = threadNumber; number <= limit; number += threadCount) {
                // Stop if this thread has been interrupted.
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }

                // Print the number when its turn arrives.
                counter.printNumber(number);
            }
        }
    }

    // Start the counter program.
    public static void main(String[] args) {
        // Create a scanner to read user input.
        try (Scanner scanner = new Scanner(System.in)) {
            // Ask the user for the counting limit.
            System.out.print("Enter counting limit: ");

            // Validate that the input is an integer.
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                return;
            }

            // Read the requested limit.
            int limit = scanner.nextInt();

            // Reject non-positive counting limits.
            if (limit < 1) {
                System.out.println("Limit must be greater than zero.");
                return;
            }

            // Use three threads to share the counting work.
            int threadCount = 3;

            // Create the shared counter.
            Counter counter = new Counter(limit);

            // Create and start each counting thread.
            Thread[] threads = new Thread[threadCount];

            for (int i = 0; i < threadCount; i++) {
                threads[i] = new Thread(
                        new CountingTask(counter, i + 1, threadCount, limit),
                        "Thread-" + (i + 1)
                );

                // Start the thread's counting task.
                threads[i].start();
            }

            // Wait for all counting threads to finish.
            try {
                for (Thread thread : threads) {
                    thread.join();
                }
            } catch (InterruptedException exception) {
                // Interrupt the counting threads if the main thread is interrupted.
                for (Thread thread : threads) {
                    thread.interrupt();
                }

                // Restore the main thread's interrupt status.
                Thread.currentThread().interrupt();
                System.out.println("Counting interrupted.");
            }
        }
    }
}