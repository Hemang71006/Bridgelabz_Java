package javaExceptions.exceptionHandlingBasics;

import java.util.Scanner;

/**
 * Problem Statement:
 * Read two integers and perform division. Handle ArithmeticException
 * for division by zero and ensure "Operation completed" is printed
 * using the finally block.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */
public class FinallyBlockExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            // Read the two numbers.
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            // Perform division; zero denominator throws ArithmeticException.
            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {

            // Handle division by zero.
            System.out.println("Cannot divide by zero!");

        } finally {

            // This block runs whether an exception occurs or not.
            System.out.println("Operation completed");
            scanner.close();
        }
    }
}
