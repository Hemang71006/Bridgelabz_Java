package javaClassandObject.level2;

/**
 * Problem 5 (GCR — Java Class and Object Level 2 Assignment)
 * Create a CartItem class with attributes itemName, price, and quantity.
 * Add methods to add an item to the cart, remove an item from the cart,
 * and display the total cost.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class CartItem {

    // Cart item attributes
    private String itemName;
    private double price;
    private int quantity;

    // Constructor to initialize cart item details
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to add an item to the cart
    public void addItem(int quantity) {
        this.quantity += quantity;
    }

    // Method to remove an item from the cart
    public void removeItem(int quantity) {
        if (quantity <= this.quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("Cannot remove more items than available.");
        }
    }

    // Method to display total cost
    public void displayTotalCost() {
        double totalCost = price * quantity;

        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + totalCost);
    }

    public static void main(String[] args) {

        // Create a CartItem object
        CartItem item = new CartItem("Laptop", 50000, 1);

        // Add an item
        item.addItem(2);

        // Remove an item
        item.removeItem(1);

        // Display total cost
        item.displayTotalCost();
    }
}
