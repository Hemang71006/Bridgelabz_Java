package javaBuiltInFunctions.dateTime;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Problem 2: Date Arithmetic
 * Perform different date arithmetic operations using LocalDate.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class DateArithmetic {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take the date as input
        System.out.print("Enter date (yyyy-MM-dd): ");
        String input = scanner.nextLine();

        // Convert String to LocalDate
        LocalDate date = LocalDate.parse(input);

        // Perform date arithmetic
        LocalDate after7Days = date.plusDays(7);
        LocalDate after1Month = date.plusMonths(1);
        LocalDate after2Years = date.plusYears(2);
        LocalDate before3Weeks = date.minusWeeks(3);

        // Display results
        System.out.println("Original Date: " + date);
        System.out.println("After 7 Days: " + after7Days);
        System.out.println("After 1 Month: " + after1Month);
        System.out.println("After 2 Years: " + after2Years);
        System.out.println("Before 3 Weeks: " + before3Weeks);

        scanner.close();
    }
}
