package javaExceptions.advancedExceptionHandling;

import java.io.Closeable;
import java.io.IOException;

/**
 * Problem Statement:
 * Manage a database connection and a transaction as two resources.
 * Use try-with-resources so both resources are closed even if an
 * exception occurs during the operation.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */

// Represents a database connection that must be closed.
class DatabaseConnection implements Closeable {

    // Simulate opening the database connection.
    public void open() {
        System.out.println("Database connection opened.");
    }

    // Called automatically when try-with-resources ends.
    @Override
    public void close() throws IOException {
        System.out.println("Database connection closed.");
    }
}

// Represents a transaction that must be closed.
class Transaction implements Closeable {

    // Simulate starting a transaction.
    public void start() {
        System.out.println("Transaction started.");
    }

    // Called automatically when try-with-resources ends.
    @Override
    public void close() throws IOException {
        System.out.println("Transaction ended.");
    }
}

public class DatabaseManager {

    // Manage both resources safely.
    public void manageDatabase() {

        // Both resources are automatically closed after this try block.
        try (DatabaseConnection connection = new DatabaseConnection();
             Transaction transaction = new Transaction()) {

            // Open the connection and start the transaction.
            connection.open();
            transaction.start();

            // Simulate an operation failure.
            throw new IOException("Simulated operation error");

        } catch (IOException e) {
            // Handle the operation or resource-closing exception.
            System.out.println("Exception during database operation: "
                    + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // Create the manager and perform the operation.
        DatabaseManager manager = new DatabaseManager();
        manager.manageDatabase();
    }
}
