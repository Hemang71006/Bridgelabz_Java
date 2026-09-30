package javaBuiltInFunctions.modularFunctions;

import java.util.Scanner;

/**
 * Problem 8: Temperature Converter
 * Convert temperature between Celsius and Fahrenheit.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class TemperatureConverter {

    // Convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take Celsius input
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();

        // Take Fahrenheit input
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();

        // Perform conversions
        double convertedFahrenheit = celsiusToFahrenheit(celsius);
        double convertedCelsius = fahrenheitToCelsius(fahrenheit);

        // Display results
        System.out.println("Celsius to Fahrenheit: " + convertedFahrenheit);
        System.out.println("Fahrenheit to Celsius: " + convertedCelsius);

        scanner.close();
    }
}
