package javaExceptions.exceptionHandlingApplications;

/**
 * Problem Statement:
 * Demonstrate transaction processing that catches an exception
 * and rethrows a custom exception containing additional transaction
 * context, such as the transaction ID and amount.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */

// Custom checked exception representing a transaction failure.
class TransactionProcessingException extends Exception {

    public TransactionProcessingException(String message, Throwable cause) {
        // Preserve the original cause inside the custom exception.
        super(message, cause);
    }
}

public class TransactionContextExample {

    // Simulate a transaction operation that can fail.
    public void processTransaction(String transactionId, double amount)
            throws TransactionProcessingException {

        try {
            // Reject a zero amount to simulate a processing failure.
            if (amount <= 0) {
                throw new IllegalArgumentException(
                        "Transaction amount must be greater than zero");
            }

            System.out.println("Transaction processed: " + transactionId);

        } catch (IllegalArgumentException e) {

            // Rethrow with transaction-specific details and preserve the cause.
            throw new TransactionProcessingException(
                    "Transaction " + transactionId
                            + " failed for amount " + amount,
                    e);
        }
    }

    public static void main(String[] args) {
        TransactionContextExample processor =
                new TransactionContextExample();

        try {
            // Use an invalid amount to demonstrate contextual rethrowing.
            processor.processTransaction("TXN-101", 0);

        } catch (TransactionProcessingException e) {

            // Print the added transaction context.
            System.out.println(e.getMessage());

            // Print the original exception's reason.
            System.out.println("Cause: " + e.getCause().getMessage());
        }
    }
}
