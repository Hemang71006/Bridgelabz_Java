package javaExceptions.exceptionHandlingBasics;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Problem Statement:
 * Read two numbers and divide them. Handle ArithmeticException
 * when the denominator is zero and InputMismatchException when
 * the user enters a non-numeric value.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */
public class UncheckedExceptionExample {

    public static void main(String[] args) {

        // Scanner reads input from the keyboard.
        Scanner scanner = new Scanner(System.in);

        try {
            // Read the numerator and denominator.
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            // Division by zero causes ArithmeticException.
            int result = numerator / denominator;

            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {

            // Handle division by zero.
            System.out.println("Cannot divide by zero!");

        } catch (InputMismatchException e) {

            // Handle non-integer input.
            System.out.println("Please enter valid integers.");

        } finally {

            // Close the Scanner after processing.
            scanner.close();
        }
    }
}
