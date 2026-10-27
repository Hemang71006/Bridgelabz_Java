package javaMultithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Problem 2: Producer-Consumer with Shared Resource
 * Create a producer that generates integer tasks and a consumer
 * that processes them using a shared queue. Coordinate both threads
 * safely and handle interruptions.
 *
 * Author : Hemang
 * Date   : 23-10-2026
 */

public class ProducerConsumerExample {

    // Define the special value used to signal that production has ended.
    private static final int STOP_SIGNAL = -1;

    // Represent the producer that generates integer tasks.
    static class Producer implements Runnable {
        private final BlockingQueue<Integer> queue;
        private final int taskCount;

        // Initialize the shared queue and number of tasks.
        public Producer(BlockingQueue<Integer> queue, int taskCount) {
            this.queue = queue;
            this.taskCount = taskCount;
        }

        // Generate tasks and place them in the shared queue.
        @Override
        public void run() {
            try {
                // Produce integer tasks from 1 to the specified count.
                for (int task = 1; task <= taskCount; task++) {
                    // Add the task to the queue, waiting if it is full.
                    queue.put(task);

                    // Display the produced task.
                    System.out.println("Produced task: " + task);
                }

                // Add the stop signal after all tasks are produced.
                queue.put(STOP_SIGNAL);
            } catch (InterruptedException exception) {
                // Restore the interrupt status if production is interrupted.
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted.");
            }
        }
    }

    // Represent the consumer that processes integer tasks.
    static class Consumer implements Runnable {
        private final BlockingQueue<Integer> queue;

        // Initialize the shared queue.
        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        // Remove and process tasks until the stop signal arrives.
        @Override
        public void run() {
            try {
                while (true) {
                    // Take a task, waiting if the queue is empty.
                    int task = queue.take();

                    // Stop consuming when the producer signals completion.
                    if (task == STOP_SIGNAL) {
                        System.out.println("Consumer finished processing.");
                        break;
                    }

                    // Display the consumed task.
                    System.out.println("Consumed task: " + task);
                }
            } catch (InterruptedException exception) {
                // Restore the interrupt status if consumption is interrupted.
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted.");
            }
        }
    }

    // Start the producer-consumer program.
    public static void main(String[] args) {
        // Create a bounded queue that can hold three tasks at a time.
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        // Create the producer and consumer threads.
        Thread producer = new Thread(new Producer(queue, 5), "Producer");
        Thread consumer = new Thread(new Consumer(queue), "Consumer");

        // Start both threads so they can work concurrently.
        producer.start();
        consumer.start();

        // Wait for both threads to complete.
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException exception) {
            // Interrupt both threads if the main thread is interrupted.
            producer.interrupt();
            consumer.interrupt();

            // Restore the main thread's interrupt status.
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");
        }

        // Confirm that the program has finished.
        System.out.println("Producer-consumer program completed.");
    }
}