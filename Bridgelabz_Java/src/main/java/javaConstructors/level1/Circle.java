package javaConstructors.level1;

/**
 * Problem 2 (GCR — Java Constructors Level 1 Assignment)
 * Write a Circle class with a radius attribute.
 * Use constructor chaining to initialize radius with default
 * and user-provided values.
 *
 * Author : Hemang
 * Date : 29-09-2026
 */
public class Circle {

    // Instance variable
    double radius;

    // Default constructor
    Circle() {
        this(1.0);
    }

    // Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Display radius
    void displayRadius() {
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args) {

        // Default constructor
        Circle circle1 = new Circle();

        // Parameterized constructor
        Circle circle2 = new Circle(5.0);

        System.out.println("Default Constructor:");
        circle1.displayRadius();

        System.out.println("\nParameterized Constructor:");
        circle2.displayRadius();
    }
}
