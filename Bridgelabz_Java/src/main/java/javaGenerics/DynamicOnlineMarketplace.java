package javaGenerics;

/*
 * Problem Statement:
 * Build a generic product catalog for an online marketplace that supports
 * different product categories, such as Books, Clothing, and Gadgets.
 *
 * Use a generic Product<T> class with a bounded type parameter and a
 * generic method to apply discounts while maintaining type safety.
 *
 * Author: Hemang
 * Date: 14-10-2026
 */

// Abstract parent class for marketplace product categories.
abstract class ProductCategory {

    // Each category provides its own name.
    public abstract String getName();
}

// Represents the Books category.
class BookCategory extends ProductCategory {
    public String getName() {
        return "Books";
    }
}

// Represents the Clothing category.
class ClothingCategory extends ProductCategory {
    public String getName() {
        return "Clothing";
    }
}

// Represents the Gadgets category.
class GadgetCategory extends ProductCategory {
    public String getName() {
        return "Gadgets";
    }
}

// Generic Product class restricted to ProductCategory types.
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    // Initializes the product's name, price, and category.
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Returns the current product price.
    public double getPrice() {
        return price;
    }

    // Updates the product price after applying a discount.
    public void setPrice(double price) {
        this.price = price;
    }

    // Returns the product name.
    public String getName() {
        return name;
    }

    // Returns the product's category.
    public T getCategory() {
        return category;
    }
}

// Marketplace operations for products of different categories.
class Marketplace {

    // Generic method applies a discount to any valid product category.
    public <T extends ProductCategory> void applyDiscount(
            Product<T> product, double percentage) {

        // Calculate the discounted price.
        double newPrice = product.getPrice()
                - (product.getPrice() * percentage / 100);

        // Store the updated price in the product.
        product.setPrice(newPrice);

        // Display product details and its discounted price.
        System.out.println(product.getName()
                + " (" + product.getCategory().getName()
                + ") price after discount: Rs." + newPrice);
    }
}

// Main class demonstrates discounting products in different categories.
public class DynamicOnlineMarketplace {
    public static void main(String[] args) {

        // Create a book product with its category.
        Product<BookCategory> book =
                new Product<>("Java Book", 500, new BookCategory());

        // Create a clothing product with its category.
        Product<ClothingCategory> shirt =
                new Product<>("Shirt", 1000, new ClothingCategory());

        // Create a gadget product with its category.
        Product<GadgetCategory> phone =
                new Product<>("Headphones", 2000, new GadgetCategory());

        // Create the marketplace to apply product discounts.
        Marketplace marketplace = new Marketplace();

        // Apply a 10% discount to the book.
        marketplace.applyDiscount(book, 10);

        // Apply a 20% discount to the shirt.
        marketplace.applyDiscount(shirt, 20);

        // Apply a 15% discount to the headphones.
        marketplace.applyDiscount(phone, 15);
    }
}