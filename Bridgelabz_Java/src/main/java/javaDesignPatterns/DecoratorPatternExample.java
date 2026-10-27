package javaDesignPatterns;

/**
 * Problem: Create a Coffee interface with cost(), implement SimpleCoffee,
 * and create CoffeeDecorator, MilkDecorator, and SugarDecorator.
 * Wrap coffee objects dynamically to add features and cost.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class DecoratorPatternExample {

    // Define the common coffee behavior.
    interface Coffee {
        double cost();
        String description();
    }

    // Provide the basic coffee implementation.
    static class SimpleCoffee implements Coffee {
        // Return the basic coffee price.
        public double cost() {
            return 50.0;
        }

        // Return the basic coffee description.
        public String description() {
            return "Simple Coffee";
        }
    }

    // Create a base decorator that wraps another coffee.
    abstract static class CoffeeDecorator implements Coffee {
        protected Coffee coffee;

        // Store the coffee being decorated.
        public CoffeeDecorator(Coffee coffee) {
            this.coffee = coffee;
        }
    }

    // Add milk to the coffee.
    static class MilkDecorator extends CoffeeDecorator {
        // Receive the coffee to decorate.
        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        // Add the milk price to the original coffee price.
        public double cost() {
            return coffee.cost() + 10.0;
        }

        // Add milk to the coffee description.
        public String description() {
            return coffee.description() + ", Milk";
        }
    }

    // Add sugar to the coffee.
    static class SugarDecorator extends CoffeeDecorator {
        // Receive the coffee to decorate.
        public SugarDecorator(Coffee coffee) {
            super(coffee);
        }

        // Add the sugar price to the original coffee price.
        public double cost() {
            return coffee.cost() + 5.0;
        }

        // Add sugar to the coffee description.
        public String description() {
            return coffee.description() + ", Sugar";
        }
    }

    // Test the Decorator pattern.
    public static void main(String[] args) {
        // Create basic coffee.
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.description() + " = Rs. " + coffee.cost());

        // Add milk to the coffee.
        coffee = new MilkDecorator(coffee);

        // Add sugar to the coffee with milk.
        coffee = new SugarDecorator(coffee);

        // Display the final coffee and its total cost.
        System.out.println(coffee.description() + " = Rs. " + coffee.cost());
    }
}
