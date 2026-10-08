package javaLinkedList;

/**
 * Problem 4 (GCR — Singly Linked List: Inventory Management System)
 * Design an inventory management system using a singly linked list.
 * Each node stores Item Name, Item ID, Quantity, and Price.
 * Implement adding, removing, updating, searching, calculating total value,
 * and sorting inventory records.
 *
 * Author : Hemang
 * Date : 06-10-2026
 */

class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;

    ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }
}

public class InventoryManagement {

    ItemNode head;

    // Add item at the end
    void addItem(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);

        if (head == null) {
            head = newNode;
            return;
        }

        ItemNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Remove item by ID
    void removeItem(int itemId) {
        if (head == null) {
            return;
        }

        if (head.itemId == itemId) {
            head = head.next;
            return;
        }

        ItemNode current = head;

        while (current.next != null) {
            if (current.next.itemId == itemId) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }

    // Update quantity
    void updateQuantity(int itemId, int quantity) {
        ItemNode current = head;

        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = quantity;
                return;
            }

            current = current.next;
        }
    }

    // Search item by ID
    void searchById(int itemId) {
        ItemNode current = head;

        while (current != null) {
            if (current.itemId == itemId) {
                System.out.println("Item found: " + current.itemName);
                return;
            }

            current = current.next;
        }

        System.out.println("Item not found");
    }

    // Search item by name
    void searchByName(String itemName) {
        ItemNode current = head;

        while (current != null) {
            if (current.itemName.equals(itemName)) {
                System.out.println("Item found: " + current.itemName);
                return;
            }

            current = current.next;
        }

        System.out.println("Item not found");
    }

    // Calculate total inventory value
    double totalValue() {
        double total = 0;
        ItemNode current = head;

        while (current != null) {
            total += current.quantity * current.price;
            current = current.next;
        }

        return total;
    }

    // Sort by price in ascending order
    void sortByPrice() {
        for (ItemNode i = head; i != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {

                if (i.price > j.price) {
                    String tempName = i.itemName;
                    i.itemName = j.itemName;
                    j.itemName = tempName;

                    int tempId = i.itemId;
                    i.itemId = j.itemId;
                    j.itemId = tempId;

                    int tempQuantity = i.quantity;
                    i.quantity = j.quantity;
                    j.quantity = tempQuantity;

                    double tempPrice = i.price;
                    i.price = j.price;
                    j.price = tempPrice;
                }
            }
        }
    }

    // Display inventory
    void display() {
        ItemNode current = head;

        while (current != null) {
            System.out.println(
                    current.itemId + " " +
                            current.itemName + " " +
                            current.quantity + " " +
                            current.price
            );

            current = current.next;
        }
    }

    public static void main(String[] args) {

        InventoryManagement inventory = new InventoryManagement();

        inventory.addItem("Laptop", 101, 5, 50000);
        inventory.addItem("Mouse", 102, 10, 500);
        inventory.addItem("Keyboard", 103, 8, 1000);

        System.out.println("Inventory:");
        inventory.display();

        inventory.searchById(102);

        inventory.updateQuantity(102, 15);

        System.out.println("Total Value: " + inventory.totalValue());

        inventory.sortByPrice();

        System.out.println("After Sorting:");
        inventory.display();

        inventory.removeItem(103);
    }
}
