package javaExceptions.exceptionHandlingBasics;

import java.util.Scanner;

/**
 * Problem Statement:
 * Retrieve an element from an integer array using an index entered
 * by the user. Handle ArrayIndexOutOfBoundsException for an invalid
 * index and NullPointerException if the array is null.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */
public class MultipleCatchExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create an array containing sample integer values.
        int[] numbers = {10, 20, 30, 40, 50};

        try {
            // Ask the user which array index to access.
            System.out.print("Enter an index (0-4): ");
            int index = scanner.nextInt();

            // Access and print the selected element.
            System.out.println(
                    "Value at index " + index + ": " + numbers[index]);

        } catch (ArrayIndexOutOfBoundsException e) {

            // Handle an index outside the valid array range.
            System.out.println("Invalid index!");

        } catch (NullPointerException e) {

            // Handle the case where the array reference is null.
            System.out.println("Array is not initialized!");

        } finally {
            scanner.close();
        }
    }
}
