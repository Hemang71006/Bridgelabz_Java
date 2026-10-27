package javaDesignPatterns;

/**
 * Problem: Create AccountService, BalanceService, and TransactionService.
 * Create a BankFacade that calls these internal services so the client
 * can perform a banking operation through a single facade method.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class FacadePatternExample {

    // Handle account-related operations.
    static class AccountService {
        // Verify that the account exists.
        public void verifyAccount() {
            System.out.println("Account verified");
        }
    }

    // Handle balance-related operations.
    static class BalanceService {
        // Display the available account balance.
        public void checkBalance() {
            System.out.println("Balance checked: Rs. 5000");
        }
    }

    // Handle transaction-related operations.
    static class TransactionService {
        // Process a transaction for the requested amount.
        public void transferMoney(double amount) {
            System.out.println("Transferred Rs. " + amount);
        }
    }

    // Provide one simple interface for banking operations.
    static class BankFacade {
        private AccountService accountService;
        private BalanceService balanceService;
        private TransactionService transactionService;

        // Initialize the internal banking services.
        public BankFacade() {
            accountService = new AccountService();
            balanceService = new BalanceService();
            transactionService = new TransactionService();
        }

        // Perform a transfer using the internal services.
        public void transfer(double amount) {
            accountService.verifyAccount();
            balanceService.checkBalance();
            transactionService.transferMoney(amount);
        }
    }

    // Test the Facade pattern.
    public static void main(String[] args) {
        // Create the banking facade.
        BankFacade bank = new BankFacade();

        // Perform the transfer through one simple method.
        bank.transfer(1000.0);
    }
}
