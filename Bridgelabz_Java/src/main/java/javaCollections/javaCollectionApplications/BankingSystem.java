package javaCollections.javaCollectionApplications;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Problem 3 (Collections - Banking System)
 * Store customer accounts using HashMap, sort balances using
 * TreeMap, and process withdrawal requests using a Queue.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */

public class BankingSystem {

    static class WithdrawalRequest {
        int accountNumber;
        double amount;

        // Initialize withdrawal request
        WithdrawalRequest(int accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {

        // Store account numbers and balances
        Map<Integer, Double> accounts = new HashMap<>();

        accounts.put(1001, 5000.0);
        accounts.put(1002, 3000.0);
        accounts.put(1003, 8000.0);

        // Queue withdrawal requests in order of arrival
        Queue<WithdrawalRequest> requests = new LinkedList<>();

        requests.add(new WithdrawalRequest(1001, 1000.0));
        requests.add(new WithdrawalRequest(1002, 500.0));
        requests.add(new WithdrawalRequest(1003, 2000.0));

        System.out.println("Processing Withdrawal Requests:");

        // Process requests one at a time
        while (!requests.isEmpty()) {

            WithdrawalRequest request = requests.remove();

            if (!accounts.containsKey(request.accountNumber)) {
                System.out.println("Account not found: " + request.accountNumber);
                continue;
            }

            double balance = accounts.get(request.accountNumber);

            // Check whether sufficient balance is available
            if (balance >= request.amount) {

                balance -= request.amount;
                accounts.put(request.accountNumber, balance);

                System.out.println(
                        "Account " + request.accountNumber
                                + ": Withdrawal successful. Balance: Rs. " + balance
                );

            } else {
                System.out.println(
                        "Account " + request.accountNumber
                                + ": Insufficient balance"
                );
            }
        }

        // Sort accounts by balance
        Map<Double, Integer> sortedBalances = new TreeMap<>();

        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sortedBalances.put(entry.getValue(), entry.getKey());
        }

        System.out.println("\nAccounts Sorted by Balance:");

        for (Map.Entry<Double, Integer> entry : sortedBalances.entrySet()) {
            System.out.println(
                    "Account " + entry.getValue()
                            + ": Rs. " + entry.getKey()
            );
        }
    }
}
