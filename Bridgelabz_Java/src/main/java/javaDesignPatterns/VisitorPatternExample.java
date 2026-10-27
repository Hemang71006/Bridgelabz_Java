package javaDesignPatterns;

/**
 * Problem: Create an Item interface, Book and Electronics classes,
 * a Visitor interface, and a PriceCalculatorVisitor. Each item
 * accepts the visitor to calculate its price.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class VisitorPatternExample {

    // Define the operation for accepting a visitor.
    interface Item {
        double accept(Visitor visitor);
    }

    // Define operations for each supported item type.
    interface Visitor {
        double visit(Book book);
        double visit(Electronics electronics);
    }

    // Represent a book with a fixed price.
    static class Book implements Item {
        private String name;
        private double price;

        // Initialize the book details.
        public Book(String name, double price) {
            this.name = name;
            this.price = price;
        }

        // Return the book's name.
        public String getName() {
            return name;
        }

        // Return the book's price.
        public double getPrice() {
            return price;
        }

        // Let the visitor perform an operation on this book.
        public double accept(Visitor visitor) {
            return visitor.visit(this);
        }
    }

    // Represent an electronic item with a fixed price.
    static class Electronics implements Item {
        private String name;
        private double price;

        // Initialize the electronic item details.
        public Electronics(String name, double price) {
            this.name = name;
            this.price = price;
        }

        // Return the electronic item's name.
        public String getName() {
            return name;
        }

        // Return the electronic item's price.
        public double getPrice() {
            return price;
        }

        // Let the visitor perform an operation on this item.
        public double accept(Visitor visitor) {
            return visitor.visit(this);
        }
    }

    // Calculate prices for different types of items.
    static class PriceCalculatorVisitor implements Visitor {
        // Calculate the final book price with a 10% discount.
        public double visit(Book book) {
            double finalPrice = book.getPrice() * 0.90;
            System.out.println(book.getName() + " price after discount: Rs. " + finalPrice);
            return finalPrice;
        }

        // Calculate the final electronics price with a 5% discount.
        public double visit(Electronics electronics) {
            double finalPrice = electronics.getPrice() * 0.95;
            System.out.println(electronics.getName() + " price after discount: Rs. " + finalPrice);
            return finalPrice;
        }
    }

    // Test the Visitor pattern.
    public static void main(String[] args) {
        // Create the items.
        Item book = new Book("Java Book", 500);
        Item laptop = new Electronics("Laptop", 50000);

        // Create the price calculator visitor.
        Visitor priceCalculator = new PriceCalculatorVisitor();

        // Calculate the prices by visiting each item.
        double bookPrice = book.accept(priceCalculator);
        double laptopPrice = laptop.accept(priceCalculator);

        // Display the combined final price.
        System.out.println("Total price: Rs. " + (bookPrice + laptopPrice));
    }
}
