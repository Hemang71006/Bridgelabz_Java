
package javaGenerics;

import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - Rs." + price;
    }
}

class Electronics extends WarehouseItem {
    public Electronics(String name, double price) {
        super(name, price);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name, double price) {
        super(name, price);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name, double price) {
        super(name, price);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public static void displayItems(
            List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(
                new Electronics("Laptop", 55000));
        electronicsStorage.addItem(
                new Electronics("Mobile", 20000));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(
                new Groceries("Rice", 800));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(
                new Furniture("Chair", 1500));

        System.out.println("Electronics:");
        Storage.displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries:");
        Storage.displayItems(groceryStorage.getItems());

        System.out.println("\nFurniture:");
        Storage.displayItems(furnitureStorage.getItems());
    }
}

