package javaDesignPatterns;

/**
 * Problem: Create a PaymentStrategy interface and implement
 * CashPayment, CardPayment, and UPIPayment. Use PaymentContext
 * to select and execute a payment strategy at runtime.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class StrategyPatternExample {

    // Define the common payment operation.
    interface PaymentStrategy {
        void pay(double amount);
    }

    // Implement payment using cash.
    static class CashPayment implements PaymentStrategy {
        // Process the cash payment.
        public void pay(double amount) {
            System.out.println("Paid Rs. " + amount + " using Cash");
        }
    }

    // Implement payment using a card.
    static class CardPayment implements PaymentStrategy {
        // Process the card payment.
        public void pay(double amount) {
            System.out.println("Paid Rs. " + amount + " using Card");
        }
    }

    // Implement payment using UPI.
    static class UPIPayment implements PaymentStrategy {
        // Process the UPI payment.
        public void pay(double amount) {
            System.out.println("Paid Rs. " + amount + " using UPI");
        }
    }

    // Execute whichever payment strategy is selected.
    static class PaymentContext {
        private PaymentStrategy strategy;

        // Set the payment strategy at runtime.
        public void setStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        // Execute the selected payment strategy.
        public void makePayment(double amount) {
            if (strategy == null) {
                System.out.println("Please select a payment method");
                return;
            }

            strategy.pay(amount);
        }
    }

    // Test the Strategy pattern.
    public static void main(String[] args) {
        // Create the payment context.
        PaymentContext context = new PaymentContext();

        // Select cash payment and execute it.
        context.setStrategy(new CashPayment());
        context.makePayment(500);

        // Switch to card payment.
        context.setStrategy(new CardPayment());
        context.makePayment(1000);

        // Switch to UPI payment.
        context.setStrategy(new UPIPayment());
        context.makePayment(750);
    }
}
