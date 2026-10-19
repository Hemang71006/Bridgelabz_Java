package javaExceptions.exceptionHandlingBasics;

import java.util.Scanner;

/**
 * Problem Statement:
 * Read an array index and a divisor. Access the selected array
 * element and divide it by the divisor. Use nested try-catch blocks
 * to handle an invalid array index and division by zero.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */
public class NestedTryCatchExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create an array of sample numbers.
        int[] numbers = {10, 20, 30, 40, 50};

        try {
            // Ask the user which array index to access.
            System.out.print("Enter array index (0-4): ");
            int index = scanner.nextInt();

            // Accessing the array is protected by the outer try block.
            int value = numbers[index];

            try {
                // Ask for a divisor after retrieving the array value.
                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();

                // Division by zero causes ArithmeticException.
                int result = value / divisor;
                System.out.println("Division result: " + result);

            } catch (ArithmeticException e) {

                // Handle division by zero in the inner catch.
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {

            // Handle invalid array index in the outer catch.
            System.out.println("Invalid array index!");

        } finally {
            scanner.close();
        }
    }
}