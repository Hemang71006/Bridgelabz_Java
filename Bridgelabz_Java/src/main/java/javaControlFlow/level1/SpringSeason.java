package javaControlFlow.level1;

import java.util.Scanner;

/**
 * Problem 7 (GCR — Control Flow Assignment)
 * Write a program SpringSeason that takes month and day
 * and prints "Its a Spring Season" otherwise "Not a Spring Season".
 *
 * Author : Hemang
 * Date : 21-09-2026
 */
public class SpringSeason {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take month and day from the user
        System.out.print("Enter month: ");
        int month = input.nextInt();

        System.out.print("Enter day: ");
        int day = input.nextInt();

        // Check whether the date is in Spring Season
        boolean isSpring = (month == 3 && day >= 20) ||
                (month == 4) ||
                (month == 5) ||
                (month == 6 && day <= 20);

        // Display the result
        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }

        input.close();
    }
}
