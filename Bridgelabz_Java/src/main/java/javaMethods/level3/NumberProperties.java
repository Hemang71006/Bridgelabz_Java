package javaMethods.level3;

import java.util.Scanner;

/**
 * Problem 5 (GCR — Java Methods Level 3 Assignment)
 * Check whether a number is prime, neon, spy,
 * automorphic, or buzz.
 *
 * Author : Hemang
 * Date : 23-09-2026
 */
public class NumberProperties {

    // Method to check prime number
    public static boolean isPrime(int number) {

        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Method to check Neon number
    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int sum = 0;

        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }

        return sum == number;
    }

    // Method to check Spy number
    public static boolean isSpyNumber(int number) {
        int sum = 0;
        int product = 1;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;

            sum += digit;
            product *= digit;

            temp /= 10;
        }

        return sum == product;
    }

    // Method to check Automorphic number
    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        int temp = number;

        while (temp > 0) {

            if (square % 10 != temp % 10) {
                return false;
            }

            square /= 10;
            temp /= 10;
        }

        return true;
    }

    // Method to check Buzz number
    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take number input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Check all properties
        System.out.println("Prime Number: " + isPrime(number));
        System.out.println("Neon Number: " + isNeonNumber(number));
        System.out.println("Spy Number: " + isSpyNumber(number));
        System.out.println("Automorphic Number: "
                + isAutomorphicNumber(number));
        System.out.println("Buzz Number: " + isBuzzNumber(number));

        input.close();
    }
}
