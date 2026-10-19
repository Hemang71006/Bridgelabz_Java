package javaExceptions.exceptionHandlingApplications;

import java.io.IOException;

/**
 * Problem Statement:
 * Simulate managing a connection that needs cleanup. Demonstrate
 * exception handling while ensuring the connection is closed
 * even if an error occurs during the operation.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */

// Simulated connection that supports automatic resource cleanup.
class DemoConnection implements AutoCloseable {

    // Open the simulated connection.
    public void open() {
        System.out.println("Connection opened.");
    }

    // Close the connection when try-with-resources completes.
    @Override
    public void close() throws IOException {
        System.out.println("Connection closed.");
    }
}

public class ResourceCleanupExample {

    public static void main(String[] args) {

        // try-with-resources guarantees close() is called.
        try (DemoConnection connection = new DemoConnection()) {

            // Start using the connection.
            connection.open();

            // Simulate a failure while working with the connection.
            throw new IOException("Simulated connection operation failure");

        } catch (IOException e) {

            // Handle the operation's exception.
            System.out.println("Operation error: " + e.getMessage());
        }
    }
}
