package javaClassandObject.level1;

/**
 * Problem 2 (GCR — Java Class and Object Level 1 Assignment)
 * Create a Circle class with an attribute radius.
 * Add methods to calculate and display the area and circumference.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class Circle {

    // Circle attribute
    private double radius;

    // Constructor to initialize radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display circle details
    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }

    public static void main(String[] args) {

        // Create a Circle object
        Circle circle = new Circle(5);

        // Display circle details
        circle.displayDetails();
    }
}
