package javaExceptions.exceptionHandlingBasics;

/**
 * Problem Statement:
 * Create a bank account with a withdraw(amount) method. Throw a
 * custom InsufficientBalanceException if the withdrawal exceeds
 * the balance, and IllegalArgumentException if the amount is negative.
 * Handle both exceptions in main().
 *
 * Author: Hemang
 * Date: 17-10-2026
 */

// Custom checked exception for insufficient account balance.
class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {

    // Store the account's current balance.
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Withdraw money and declare the checked exception with throws.
    public void withdraw(double amount) throws InsufficientBalanceException {

        // Reject negative withdrawal amounts.
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        // Reject withdrawals greater than the available balance.
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        // Deduct the amount after both validations pass.
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

public class BankTransactionExample {

    public static void main(String[] args) {

        // Create a bank account with an initial balance of 5000.
        BankAccount account = new BankAccount(5000);

        try {
            // Try withdrawing a sample amount.
            account.withdraw(1500);

        } catch (InsufficientBalanceException e) {

            // Handle the custom checked exception.
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {

            // Handle a negative withdrawal amount.
            System.out.println(e.getMessage());
        }
    }
}
