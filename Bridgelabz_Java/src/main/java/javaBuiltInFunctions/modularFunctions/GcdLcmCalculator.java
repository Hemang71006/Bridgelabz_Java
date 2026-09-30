package javaBuiltInFunctions.modularFunctions;

import java.util.Scanner;

/**
 * Problem 7: GCD and LCM Calculator
 * Calculate GCD and LCM using separate functions.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class GcdLcmCalculator {

    // Calculate GCD using Euclidean algorithm
    public static int calculateGCD(int first, int second) {

        while (second != 0) {
            int remainder = first % second;
            first = second;
            second = remainder;
        }

        return Math.abs(first);
    }

    // Calculate LCM using GCD
    public static int calculateLCM(int first, int second) {

        int gcd = calculateGCD(first, second);

        return Math.abs(first * second) / gcd;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take two numbers
        System.out.print("Enter first number: ");
        int first = scanner.nextInt();

        System.out.print("Enter second number: ");
        int second = scanner.nextInt();

        // Calculate GCD and LCM
        int gcd = calculateGCD(first, second);
        int lcm = calculateLCM(first, second);

        // Display results
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);

        scanner.close();
    }
}
