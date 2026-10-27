package javaDesignPatterns;

/**
 * Problem: Create a Shape interface with draw(), implement Circle
 * and Rectangle, and use a factory method to create the correct shape.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class FactoryMethodExample {

    // Define the common behavior for all shapes.
    interface Shape {
        void draw();
    }

    // Implement the Shape interface for a circle.
    static class Circle implements Shape {
        // Display the shape being drawn.
        public void draw() {
            System.out.println("Drawing Circle");
        }
    }

    // Implement the Shape interface for a rectangle.
    static class Rectangle implements Shape {
        // Display the shape being drawn.
        public void draw() {
            System.out.println("Drawing Rectangle");
        }
    }

    // Create shapes based on the requested type.
    static class ShapeFactory {
        // Return the appropriate shape object.
        static Shape getShape(String type) {
            // Check whether the requested shape is a circle.
            if (type.equalsIgnoreCase("circle")) {
                return new Circle();
            }

            // Check whether the requested shape is a rectangle.
            if (type.equalsIgnoreCase("rectangle")) {
                return new Rectangle();
            }

            // Return null when the shape type is unsupported.
            return null;
        }
    }

    // Test the Factory Method pattern.
    public static void main(String[] args) {
        // Create a circle using the factory.
        Shape circle = ShapeFactory.getShape("circle");

        // Create a rectangle using the factory.
        Shape rectangle = ShapeFactory.getShape("rectangle");

        // Draw the circle if it was created successfully.
        if (circle != null) {
            circle.draw();
        }

        // Draw the rectangle if it was created successfully.
        if (rectangle != null) {
            rectangle.draw();
        }
    }
}
