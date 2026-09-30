package javaConstructors.accessModifiers;

/**
 * Problem 3 (GCR — Access Modifiers)
 * Create a BankAccount class with:
 * accountNumber (public), accountHolder (protected),
 * and balance (private).
 * Access and modify balance using public methods.
 * Create a subclass SavingsAccount to access accountNumber
 * and accountHolder.
 *
 * Author : Hemang
 * Date : 29-09-2026
 */
public class BankAccount {

    // Public variable
    public String accountNumber;

    // Protected variable
    protected String accountHolder;

    // Private variable
    private double balance;

    // Constructor
    BankAccount(String accountNumber, String accountHolder,
                double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to access private balance
    public double getBalance() {
        return balance;
    }

    // Public method to modify private balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {

        // Create SavingsAccount object
        SavingsAccount account =
                new SavingsAccount("ACC101", "Hemang", 25000);

        // Display account details
        account.displayAccountDetails();

        // Modify private balance using setter
        account.setBalance(30000);

        // Access private balance using getter
        System.out.println("\nUpdated Balance: " + account.getBalance());
    }
}

// Subclass
class SavingsAccount extends BankAccount {

    SavingsAccount(String accountNumber, String accountHolder,
                   double balance) {
        super(accountNumber, accountHolder, balance);
    }

    // Access public accountNumber and protected accountHolder
    void displayAccountDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : " + getBalance());
    }
}