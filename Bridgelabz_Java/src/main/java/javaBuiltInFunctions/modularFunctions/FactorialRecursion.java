package javaBuiltInFunctions.modularFunctions;

import java.util.Scanner;

/**
 * Problem 6: Factorial Using Recursion
 * Calculate factorial using a recursive function.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class FactorialRecursion {

    // Calculate factorial recursively
    public static long calculateFactorial(int number) {

        // Base case
        if (number == 0 || number == 1) {
            return 1;
        }

        // Recursive call
        return number * calculateFactorial(number - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take number as input
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Calculate factorial
        long factorial = calculateFactorial(number);

        // Display result
        System.out.println("Factorial of " + number + " = " + factorial);

        scanner.close();
    }
}
