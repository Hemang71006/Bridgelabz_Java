package javaCollections.javaMaps;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Problem 6 (Collections - Insurance Policy Management System)
 * Store, retrieve, and manage insurance policies using Maps.
 *
 * Author : Hemang
 * Date   : 13-10-2026
 */

public class InsurancePolicyMapManagement {

    static class Policy {
        int policyNumber;
        String holderName;
        LocalDate expiryDate;
        String coverageType;
        double premium;

        // Initialize policy details
        Policy(int policyNumber, String holderName,
               LocalDate expiryDate, String coverageType,
               double premium) {

            this.policyNumber = policyNumber;
            this.holderName = holderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premium = premium;
        }

        @Override
        public String toString() {
            return policyNumber + " - " + holderName
                    + " - " + expiryDate
                    + " - " + coverageType
                    + " - Premium: " + premium;
        }
    }

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        // Store policies by policy number
        Map<Integer, Policy> hashMap = new HashMap<>();
        Map<Integer, Policy> linkedHashMap = new LinkedHashMap<>();

        Policy p1 = new Policy(101, "Aman",
                today.plusDays(10), "Health", 5000);

        Policy p2 = new Policy(102, "Riya",
                today.plusDays(45), "Auto", 7000);

        Policy p3 = new Policy(103, "Karan",
                today.plusDays(20), "Home", 6000);

        // Add policies to both maps
        Policy[] policies = {p1, p2, p3};

        for (Policy policy : policies) {
            hashMap.put(policy.policyNumber, policy);
            linkedHashMap.put(policy.policyNumber, policy);
        }

        // Sort policies by expiry date, then policy number
        Map<LocalDate, Policy> treeMap = new TreeMap<>();

        for (Policy policy : policies) {
            treeMap.put(policy.expiryDate, policy);
        }

        // Retrieve a policy by number
        System.out.println("Policy 101:");
        System.out.println(hashMap.get(101));

        // Display policies in insertion order
        System.out.println("\nPolicies in Insertion Order:");

        for (Policy policy : linkedHashMap.values()) {
            System.out.println(policy);
        }

        // Display policies expiring within 30 days
        System.out.println("\nPolicies Expiring Within 30 Days:");

        for (Policy policy : treeMap.values()) {
            if (!policy.expiryDate.isBefore(today)
                    && !policy.expiryDate.isAfter(today.plusDays(30))) {
                System.out.println(policy);
            }
        }

        // Find policies belonging to a particular holder
        System.out.println("\nPolicies of Aman:");

        for (Policy policy : hashMap.values()) {
            if (policy.holderName.equals("Aman")) {
                System.out.println(policy);
            }
        }

        // Remove expired policies
        hashMap.values().removeIf(
                policy -> policy.expiryDate.isBefore(today));

        System.out.println("\nPolicies After Removing Expired Ones: "
                + hashMap.size());
    }
}
