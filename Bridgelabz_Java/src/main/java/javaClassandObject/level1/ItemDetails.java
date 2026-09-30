package javaClassandObject.level1;

/**
 * Problem 4 (GCR — Java Class and Object Level 1 Assignment)
 * Create an Item class with attributes itemCode, itemName, and price.
 * Add a method to display item details and calculate the total cost
 * for a given quantity.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class ItemDetails {

    // Item attributes
    private int itemCode;
    private String itemName;
    private double price;

    // Constructor to initialize item details
    public ItemDetails(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to display item details
    public void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Item Price: " + price);
    }

    // Method to calculate total cost
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {

        // Create an Item object
        ItemDetails item = new ItemDetails(101, "Keyboard", 1200);

        // Define quantity
        int quantity = 3;

        // Display item details
        item.displayDetails();

        // Display total cost
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + item.calculateTotalCost(quantity));
    }
}
