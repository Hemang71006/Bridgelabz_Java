package javaBuiltInFunctions.dateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Problem 3: Date Formatting
 * Display the current date in different formats.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class DateFormatting {

    public static void main(String[] args) {

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Create formatters
        DateTimeFormatter format1 =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter format2 =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        DateTimeFormatter format3 =
                DateTimeFormatter.ofPattern("EEE");

        DateTimeFormatter format4 =
                DateTimeFormatter.ofPattern("MMM dd, yyyy");

        // Display date in different formats
        System.out.println("Format 1: " + currentDate.format(format1));
        System.out.println("Format 2: " + currentDate.format(format2));
        System.out.println("Format 3: " + currentDate.format(format3));
        System.out.println("Format 4: " + currentDate.format(format4));
    }
}
