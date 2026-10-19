package javaExceptions.exceptionHandlingBasics;

import java.util.Scanner;

/**
 * Problem Statement:
 * Create a custom InvalidAgeException. The validateAge() method
 * throws it when the user's age is below 18. Handle the exception
 * in main() and display an appropriate message.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */

// Custom checked exception created by the programmer.
class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}

public class InvalidAgeExceptionExample {

    // Validate the age and throw a custom exception if it is below 18.
    public static void validateAge(int age) throws InvalidAgeException {

        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            // Get the user's age.
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            // Call the age-validation method.
            validateAge(age);

            // This line runs only if the age is valid.
            System.out.println("Access granted!");

        } catch (InvalidAgeException e) {

            // Display the custom exception's message.
            System.out.println(e.getMessage());

        } finally {
            scanner.close();
        }
    }
}
