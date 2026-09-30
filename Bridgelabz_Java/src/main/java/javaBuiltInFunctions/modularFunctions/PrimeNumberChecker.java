package javaBuiltInFunctions.modularFunctions;

import java.util.Scanner;

/**
 * Problem 3: Prime Number Checker
 * Check whether a number is prime using a separate function.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class PrimeNumberChecker {

    // Check whether the number is prime
    public static boolean isPrime(int number) {

        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {

            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take number as input
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Check and display result
        if (isPrime(number)) {
            System.out.println(number + " is a Prime Number.");
        } else {
            System.out.println(number + " is not a Prime Number.");
        }

        scanner.close();
    }
}
