package javaMethods.level3;

import java.util.Scanner;

/**
 * Problem 9 (GCR — Java Methods Level 3 Assignment)
 * Find the Euclidean distance between two points and
 * find the equation of the line using the slope and y-intercept.
 *
 * Author : Hemang
 * Date : 23-09-2026
 */
public class DistanceAndLine {

    // Method to find Euclidean distance between two points
    public static double findDistance(
            double x1, double y1,
            double x2, double y2) {

        // Calculate difference between x coordinates
        double xDifference = x2 - x1;

        // Calculate difference between y coordinates
        double yDifference = y2 - y1;

        // Calculate Euclidean distance
        return Math.sqrt(
                Math.pow(xDifference, 2)
                        + Math.pow(yDifference, 2)
        );
    }

    // Method to find slope and y-intercept
    public static double[] findLineEquation(
            double x1, double y1,
            double x2, double y2) {

        // Calculate slope
        double slope = (y2 - y1) / (x2 - x1);

        // Calculate y-intercept
        double intercept = y1 - slope * x1;

        // Return slope and y-intercept
        return new double[]{slope, intercept};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take coordinates of first point
        System.out.print("Enter x1: ");
        double x1 = input.nextDouble();

        System.out.print("Enter y1: ");
        double y1 = input.nextDouble();

        // Take coordinates of second point
        System.out.print("Enter x2: ");
        double x2 = input.nextDouble();

        System.out.print("Enter y2: ");
        double y2 = input.nextDouble();

        // Calculate Euclidean distance
        double distance = findDistance(x1, y1, x2, y2);

        // Calculate slope and y-intercept
        double[] line = findLineEquation(
                x1, y1, x2, y2);

        // Display distance
        System.out.println("Euclidean Distance: " + distance);

        // Display slope
        System.out.println("Slope: " + line[0]);

        // Display y-intercept
        System.out.println("Y-Intercept: " + line[1]);

        // Display equation
        System.out.println(
                "Equation of Line: y = "
                        + line[0] + "x + " + line[1]);

        input.close();
    }
}
