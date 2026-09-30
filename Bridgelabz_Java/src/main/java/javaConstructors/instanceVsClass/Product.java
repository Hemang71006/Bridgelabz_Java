package javaConstructors.instanceVsClass;

/**
 * Problem 1 (GCR — Instance vs. Class Variables and Methods)
 * Create a Product class with instance variables productName and price,
 * and a class variable totalProducts shared among all products.
 *
 * Author : Hemang
 * Date : 29-09-2026
 */
public class Product {

    // Instance variables
    String productName;
    double price;

    // Class variable shared by all Product objects
    static int totalProducts = 0;

    // Constructor
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;

        // Increase total product count whenever an object is created
        totalProducts++;
    }

    // Instance method
    void displayProductDetails() {
        System.out.println("Product Name : " + productName);
        System.out.println("Price        : " + price);
    }

    // Class method
    static void displayTotalProducts() {
        System.out.println("Total Products : " + totalProducts);
    }

    public static void main(String[] args) {

        // Create Product objects
        Product product1 = new Product("Laptop", 50000);
        Product product2 = new Product("Mouse", 1000);
        Product product3 = new Product("Keyboard", 2000);

        // Display individual product details
        product1.displayProductDetails();
        System.out.println();

        product2.displayProductDetails();
        System.out.println();

        product3.displayProductDetails();
        System.out.println();

        // Display total number of products
        Product.displayTotalProducts();
    }
}
