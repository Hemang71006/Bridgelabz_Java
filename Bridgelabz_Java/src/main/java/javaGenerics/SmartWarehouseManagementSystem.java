package javaGenerics;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem Statement:
 * Develop a Smart Warehouse System that manages different types of items,
 * such as Electronics, Groceries, and Furniture.
 *
 * Use a generic Storage<T extends WarehouseItem> class to store items
 * safely and a wildcard method (List<? extends WarehouseItem>) to display
 * items from different categories.
 *
 * Author: Hemang
 * Date: 14-10-2026
 */

// Abstract base class representing a common warehouse item.
abstract class WarehouseItem {
    private String name;
    private double price;

    // Initializes the item's name and price.
    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Returns the item's name.
    public String getName() {
        return name;
    }

    // Returns the item's price.
    public double getPrice() {
        return price;
    }

    // Provides a readable representation of the warehouse item.
    @Override
    public String toString() {
        return name + " - Rs." + price;
    }
}

// Represents an electronics item stored in the warehouse.
class Electronics extends WarehouseItem {
    public Electronics(String name, double price) {
        super(name, price);
    }
}

// Represents a grocery item stored in the warehouse.
class Groceries extends WarehouseItem {
    public Groceries(String name, double price) {
        super(name, price);
    }
}

// Represents a furniture item stored in the warehouse.
class Furniture extends WarehouseItem {
    public Furniture(String name, double price) {
        super(name, price);
    }
}

// Generic storage class restricted to WarehouseItem types.
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    // Adds an item of the storage's specified type.
    public void addItem(T item) {
        items.add(item);
    }

    // Returns the list of stored items.
    public List<T> getItems() {
        return items;
    }

    // Displays items from any list containing WarehouseItem subtypes.
    public static void displayItems(
            List<? extends WarehouseItem> items) {

        // Iterate through and print each warehouse item.
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

// Main class demonstrates storage for different warehouse categories.
public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {

        // Create storage for electronics and add products.
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(
                new Electronics("Laptop", 55000));
        electronicsStorage.addItem(
                new Electronics("Mobile", 20000));

        // Create storage for groceries and add a product.
        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(
                new Groceries("Rice", 800));

        // Create storage for furniture and add a product.
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(
                new Furniture("Chair", 1500));

        // Display all stored electronics.
        System.out.println("Electronics:");
        Storage.displayItems(electronicsStorage.getItems());

        // Display all stored groceries.
        System.out.println("\nGroceries:");
        Storage.displayItems(groceryStorage.getItems());

        // Display all stored furniture.
        System.out.println("\nFurniture:");
        Storage.displayItems(furnitureStorage.getItems());
    }
}