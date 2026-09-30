package javaBuiltInFunctions.modularFunctions;

import java.util.Scanner;

/**
 * Problem 9: Basic Calculator
 * Perform basic arithmetic operations using separate functions.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class BasicCalculator {

    // Perform addition
    public static double add(double first, double second) {
        return first + second;
    }

    // Perform subtraction
    public static double subtract(double first, double second) {
        return first - second;
    }

    // Perform multiplication
    public static double multiply(double first, double second) {
        return first * second;
    }

    // Perform division
    public static double divide(double first, double second) {

        if (second == 0) {
            System.out.println("Division by zero is not allowed.");
            return 0;
        }

        return first / second;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take two numbers
        System.out.print("Enter first number: ");
        double first = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double second = scanner.nextDouble();

        // Display arithmetic results
        System.out.println("Addition: " + add(first, second));
        System.out.println("Subtraction: " + subtract(first, second));
        System.out.println("Multiplication: " + multiply(first, second));
        System.out.println("Division: " + divide(first, second));

        scanner.close();
    }
}
