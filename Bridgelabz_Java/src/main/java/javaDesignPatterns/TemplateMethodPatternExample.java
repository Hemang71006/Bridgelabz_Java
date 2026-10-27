package javaDesignPatterns;

/**
 * Problem: Create an abstract OrderProcess class with a template method.
 * Create subclasses that override individual order-processing steps,
 * then execute the complete template method.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class TemplateMethodPatternExample {

    // Define the common order-processing sequence.
    abstract static class OrderProcess {
        // Execute the order steps in a fixed sequence.
        public final void processOrder() {
            selectItem();
            makePayment();
            deliverOrder();
        }

        // Require subclasses to select an item.
        abstract void selectItem();

        // Require subclasses to implement payment.
        abstract void makePayment();

        // Provide a default delivery step.
        public void deliverOrder() {
            System.out.println("Order delivered");
        }
    }

    // Define the steps for processing an online order.
    static class OnlineOrder extends OrderProcess {
        // Select an item for the online order.
        public void selectItem() {
            System.out.println("Item selected online");
        }

        // Pay for the online order.
        public void makePayment() {
            System.out.println("Online payment completed");
        }

        // Deliver the online order.
        public void deliverOrder() {
            System.out.println("Order delivered to home");
        }
    }

    // Define the steps for processing a store order.
    static class StoreOrder extends OrderProcess {
        // Select an item at the store.
        public void selectItem() {
            System.out.println("Item selected in store");
        }

        // Pay for the store order.
        public void makePayment() {
            System.out.println("Payment completed at counter");
        }

        // Use the parent's default delivery step.
    }

    // Test the Template Method pattern.
    public static void main(String[] args) {
        // Process an online order.
        OrderProcess onlineOrder = new OnlineOrder();
        System.out.println("--- Online Order ---");
        onlineOrder.processOrder();

        // Process a store order.
        OrderProcess storeOrder = new StoreOrder();
        System.out.println("\n--- Store Order ---");
        storeOrder.processOrder();
    }
}
