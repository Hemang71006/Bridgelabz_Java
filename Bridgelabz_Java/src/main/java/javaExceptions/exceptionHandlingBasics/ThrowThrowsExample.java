package javaExceptions.exceptionHandlingBasics;

/**
 * Problem Statement:
 * Create calculateInterest(amount, rate, years). Throw
 * IllegalArgumentException if amount or rate is negative.
 * Declare exception propagation using throws and handle it in main.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */
public class ThrowThrowsExample {

    // Calculate simple interest; throws declares that an exception may propagate.
    public static double calculateInterest(double amount, double rate, int years)
            throws IllegalArgumentException {

        // throw creates and raises an exception when input is invalid.
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException(
                    "Amount and rate must be positive");
        }

        // Simple interest formula: principal × rate × time / 100.
        return amount * rate * years / 100;
    }

    public static void main(String[] args) {

        try {
            // Call the method with valid sample values.
            double interest = calculateInterest(10000, 5, 2);
            System.out.println("Calculated interest: " + interest);

        } catch (IllegalArgumentException e) {

            // Handle invalid values passed to the method.
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}
