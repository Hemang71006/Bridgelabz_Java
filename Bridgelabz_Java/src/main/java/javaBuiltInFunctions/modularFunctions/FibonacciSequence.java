package javaBuiltInFunctions.modularFunctions;

import java.util.Scanner;

/**
 * Problem 4: Fibonacci Sequence Generator
 * Generate Fibonacci sequence for the given number of terms.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class FibonacciSequence {

    // Generate and print Fibonacci sequence
    public static void generateFibonacci(int terms) {

        int first = 0;
        int second = 1;

        for (int i = 1; i <= terms; i++) {

            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take number of terms
        System.out.print("Enter number of terms: ");
        int terms = scanner.nextInt();

        // Generate Fibonacci sequence
        System.out.println("Fibonacci Sequence:");
        generateFibonacci(terms);

        scanner.close();
    }
}
