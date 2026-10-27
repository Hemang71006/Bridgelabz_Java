package javaDesignPatterns;

/**
 * Problem: Create a Color interface with Red and Blue implementations.
 * Create an abstract Shape holding a Color reference, then implement
 * Circle and Square so shapes can use different colors at runtime.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class BridgePatternExample {

    // Define the common color behavior.
    interface Color {
        void applyColor();
    }

    // Implement the red color.
    static class Red implements Color {
        // Apply red color.
        public void applyColor() {
            System.out.println("Color: Red");
        }
    }

    // Implement the blue color.
    static class Blue implements Color {
        // Apply blue color.
        public void applyColor() {
            System.out.println("Color: Blue");
        }
    }

    // Define a shape that uses a separate color implementation.
    abstract static class Shape {
        protected Color color;

        // Connect a shape to its chosen color.
        public Shape(Color color) {
            this.color = color;
        }

        // Require each shape to draw itself.
        abstract void draw();
    }

    // Implement a circle shape.
    static class Circle extends Shape {
        // Pass the selected color to the parent class.
        public Circle(Color color) {
            super(color);
        }

        // Draw a circle using the selected color.
        public void draw() {
            System.out.print("Circle - ");
            color.applyColor();
        }
    }

    // Implement a square shape.
    static class Square extends Shape {
        // Pass the selected color to the parent class.
        public Square(Color color) {
            super(color);
        }

        // Draw a square using the selected color.
        public void draw() {
            System.out.print("Square - ");
            color.applyColor();
        }
    }

    // Test the Bridge pattern.
    public static void main(String[] args) {
        // Create a red circle.
        Shape redCircle = new Circle(new Red());

        // Create a blue square.
        Shape blueSquare = new Square(new Blue());

        // Draw both shapes with their selected colors.
        redCircle.draw();
        blueSquare.draw();
    }
}
