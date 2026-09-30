package javaClassandObject.level2;

/**
 * Problem 2 (GCR — Java Class and Object Level 2 Assignment)
 * Create a BankAccount class with attributes accountHolder,
 * accountNumber, and balance.
 * Add methods for depositing, withdrawing with sufficient balance,
 * and displaying the current balance.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class BankAccount {

    // Bank account attributes
    private String accountHolder;
    private long accountNumber;
    private double balance;

    // Constructor to initialize account details
    public BankAccount(String accountHolder, long accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw money if sufficient balance exists
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to display current balance
    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {

        // Create a BankAccount object
        BankAccount account = new BankAccount(
                "Hemang",
                1234567890L,
                10000
        );

        // Deposit money
        account.deposit(5000);

        // Withdraw money
        account.withdraw(3000);

        // Display current balance
        account.displayBalance();
    }
}
