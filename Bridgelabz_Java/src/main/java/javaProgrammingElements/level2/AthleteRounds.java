package javaProgrammingElements.level2;

import java.util.Scanner;

/**
 * Problem 9 (GCR — Java Programming Elements Assignment)
 * Calculate the number of rounds an athlete must run to complete
 * 5 km around a triangular park.
 *
 * Author : Hemang
 * Date : 19-09-2026
 */
public class AthleteRounds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take the three sides of the triangular park
        System.out.print("Enter side 1 in meters: ");
        double side1 = input.nextDouble();

        System.out.print("Enter side 2 in meters: ");
        double side2 = input.nextDouble();

        System.out.print("Enter side 3 in meters: ");
        double side3 = input.nextDouble();

        // Calculate the perimeter
        double perimeter = side1 + side2 + side3;

        // Set total distance as 5 km in meters
        double totalDistance = 5000;

        // Calculate the number of rounds
        double rounds = totalDistance / perimeter;

        // Display the result
        System.out.println("The total number of rounds the athlete will run is "
                + rounds + " to complete 5 km");

        input.close();
    }
}
