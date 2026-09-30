package javaBuiltInFunctions.modularFunctions;

import java.util.Scanner;

/**
 * Problem 2: Maximum of Three Numbers
 * Find the maximum among three integers using functions.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class MaximumOfThree {

    // Take an integer input
    public static int getNumber(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    // Find the maximum of three numbers
    public static int findMaximum(int first, int second, int third) {

        int maximum = first;

        if (second > maximum) {
            maximum = second;
        }

        if (third > maximum) {
            maximum = third;
        }

        return maximum;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take three numbers
        int first = getNumber(scanner, "Enter first number: ");
        int second = getNumber(scanner, "Enter second number: ");
        int third = getNumber(scanner, "Enter third number: ");

        // Find maximum
        int maximum = findMaximum(first, second, third);

        // Display result
        System.out.println("Maximum number: " + maximum);

        scanner.close();
    }
}
