package javaMethods.level3;

import java.util.Scanner;

/**
 * Problem 6 (GCR — Java Methods Level 3 Assignment)
 * Find factors of a number and use them to calculate
 * different factor properties and number classifications.
 *
 * Author : Hemang
 * Date : 23-09-2026
 */
public class FactorNumberChecker {

    // Method to find factors and store them in an array
    public static int[] findFactors(int number) {

        // First loop counts factors
        int count = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Create array using factor count
        int[] factors = new int[count];

        // Second loop stores factors
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    // Method to find greatest factor
    public static int findGreatestFactor(int[] factors) {
        return factors[factors.length - 1];
    }

    // Method to find sum of factors
    public static int findSumOfFactors(int[] factors) {
        int sum = 0;

        for (int factor : factors) {
            sum += factor;
        }

        return sum;
    }

    // Method to find product of factors
    public static long findProductOfFactors(int[] factors) {
        long product = 1;

        for (int factor : factors) {
            product *= factor;
        }

        return product;
    }

    // Method to find product of cubes of factors
    public static double findProductOfCubes(int[] factors) {
        double product = 1;

        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }

        return product;
    }

    // Method to check perfect number
    public static boolean isPerfectNumber(int number) {
        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    // Method to check abundant number
    public static boolean isAbundantNumber(int number) {
        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum > number;
    }

    // Method to check deficient number
    public static boolean isDeficientNumber(int number) {
        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum < number;
    }

    // Method to find factorial of a digit
    public static int factorial(int digit) {
        int result = 1;

        for (int i = 1; i <= digit; i++) {
            result *= i;
        }

        return result;
    }

    // Method to check strong number
    public static boolean isStrongNumber(int number) {
        int sum = 0;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;

            sum += factorial(digit);

            temp /= 10;
        }

        return sum == number;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take number input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Find factors
        int[] factors = findFactors(number);

        // Display factors
        System.out.print("Factors: ");

        for (int factor : factors) {
            System.out.print(factor + " ");
        }

        // Calculate factor properties
        System.out.println("\nGreatest Factor: "
                + findGreatestFactor(factors));

        System.out.println("Sum of Factors: "
                + findSumOfFactors(factors));

        System.out.println("Product of Factors: "
                + findProductOfFactors(factors));

        System.out.println("Product of Cubes: "
                + findProductOfCubes(factors));

        // Check number classifications
        System.out.println("Perfect Number: "
                + isPerfectNumber(number));

        System.out.println("Abundant Number: "
                + isAbundantNumber(number));

        System.out.println("Deficient Number: "
                + isDeficientNumber(number));

        System.out.println("Strong Number: "
                + isStrongNumber(number));

        input.close();
    }
}
