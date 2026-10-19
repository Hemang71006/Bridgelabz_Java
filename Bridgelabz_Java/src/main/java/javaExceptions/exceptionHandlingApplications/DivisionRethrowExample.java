package javaExceptions.exceptionHandlingApplications;

/**
 * Problem Statement:
 * Implement performDivision(numerator, denominator), which performs
 * division and throws ArithmeticException if denominator is zero.
 * Implement calculate(), which catches and rethrows the exception
 * with additional context. Handle it in main().
 *
 * Author: Hemang
 * Date: 17-10-2026
 */
public class DivisionRethrowExample {

    // Perform division and throw an exception for a zero denominator.
    public static int performDivision(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator is zero");
        }

        return numerator / denominator;
    }

    // Catch the original exception and rethrow it with more context.
    public static int calculate(int numerator, int denominator) {
        try {
            return performDivision(numerator, denominator);

        } catch (ArithmeticException e) {

            // Include the operands to make the error more informative.
            throw new ArithmeticException(
                    "Could not divide " + numerator + " by " + denominator);
        }
    }

    public static void main(String[] args) {
        try {
            // Try dividing by zero to demonstrate exception handling.
            int result = calculate(10, 0);
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {

            // Handle the rethrown exception in main.
            System.out.println("Division error: " + e.getMessage());
        }
    }
}

