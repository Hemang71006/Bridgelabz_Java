package javaExceptions.exceptionHandlingApplications;

import java.io.IOException;

/**
 * Problem Statement:
 * Create a method that demonstrates both a checked exception
 * (IOException) and an unchecked exception (IllegalArgumentException).
 * Handle both exception types in main().
 *
 * Author: Hemang
 * Date: 17-10-2026
 */
public class CheckedUncheckedExample {

    // This method can throw a checked or unchecked exception.
    public static void processData(int value) throws IOException {

        // Throw a checked exception when the value is negative.
        if (value < 0) {
            throw new IOException("Unable to process negative data");
        }

        // Throw an unchecked exception when the value is zero.
        if (value == 0) {
            throw new IllegalArgumentException("Value cannot be zero");
        }

        // Process the value normally when it is positive.
        System.out.println("Data processed: " + value);
    }

    public static void main(String[] args) {

        // Handle the checked IOException.
        try {
            processData(-5);
        } catch (IOException e) {
            System.out.println("Checked exception: " + e.getMessage());
        }

        // Handle the unchecked exception and the checked exception declared by processData().
        try {
            processData(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Unchecked exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Checked exception: " + e.getMessage());
        }

        // Demonstrate successful processing.
        try {
            processData(10);
        } catch (IOException e) {
            System.out.println("Checked exception: " + e.getMessage());
        }
    }
}