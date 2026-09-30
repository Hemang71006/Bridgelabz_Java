package javaBuiltInFunctions.dateTime;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Problem 4: Date Comparison
 * Compare two dates using LocalDate.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class DateComparison {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take two dates as input
        System.out.print("Enter first date (yyyy-MM-dd): ");
        LocalDate firstDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter second date (yyyy-MM-dd): ");
        LocalDate secondDate = LocalDate.parse(scanner.nextLine());

        // Compare the two dates
        if (firstDate.isBefore(secondDate)) {
            System.out.println("First date is before the second date.");
        } else if (firstDate.isAfter(secondDate)) {
            System.out.println("First date is after the second date.");
        } else if (firstDate.isEqual(secondDate)) {
            System.out.println("Both dates are the same.");
        }

        scanner.close();
    }
}
