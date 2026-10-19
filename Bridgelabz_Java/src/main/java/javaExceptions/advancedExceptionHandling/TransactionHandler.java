package javaExceptions.advancedExceptionHandling;

/**
 * Problem Statement:
 * Process a transaction that may throw different exception types.
 * Catch an invalid-transaction exception and rethrow it as a general
 * transaction exception with additional context.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */

// General checked exception for transaction failures.
class TransactionException extends Exception {

    // Constructor for a message-only exception.
    public TransactionException(String message) {
        super(message);
    }

    // Constructor that also preserves the original cause.
    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Specific exception for invalid transaction amounts.
class InvalidTransactionException extends TransactionException {

    // Pass the specific error message to the parent exception.
    public InvalidTransactionException(String message) {
        super(message);
    }
}

public class TransactionHandler {

    // Validate the transaction and throw an appropriate exception.
    public void processTransaction(double amount)
            throws TransactionException {

        // A negative amount is an invalid transaction.
        if (amount < 0) {
            throw new InvalidTransactionException(
                    "Negative amount: " + amount);
        }

        // A zero amount is also rejected.
        if (amount == 0) {
            throw new TransactionException("Zero amount is not allowed");
        }

        // Print confirmation for a valid transaction.
        System.out.println("Transaction processed: " + amount);
    }

    // Add context and rethrow the specific exception as a general one.
    public void handleTransaction(double amount)
            throws TransactionException {

        try {
            // Attempt to process the transaction.
            processTransaction(amount);

        } catch (InvalidTransactionException e) {
            // Rethrow with extra context and preserve the original cause.
            throw new TransactionException(
                    "Failed processing transaction: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {

        // Create the handler.
        TransactionHandler handler = new TransactionHandler();

        try {
            // Negative amount triggers the custom exception path.
            handler.handleTransaction(-100);

        } catch (TransactionException e) {
            // Handle the contextual exception in main.
            System.out.println("Transaction error: " + e.getMessage());

            // Print the original exception's message.
            System.out.println("Original cause: "
                    + e.getCause().getMessage());
        }
    }
}
