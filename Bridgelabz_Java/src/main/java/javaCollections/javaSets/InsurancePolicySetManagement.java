
package javaCollections.javaSets;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Problem 6 (Collections - Set Interface)
 * Manage unique insurance policies using different Set implementations.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */
public class InsurancePolicySetManagement {

    static class Policy {
        int policyNumber;
        String holderName;
        LocalDate expiryDate;
        String coverageType;
        double premium;

        // Initialize policy details
        Policy(int policyNumber, String holderName,
               LocalDate expiryDate, String coverageType, double premium) {
            this.policyNumber = policyNumber;
            this.holderName = holderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premium = premium;
        }

        // Compare policies using their unique policy numbers
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Policy)) return false;
            Policy other = (Policy) obj;
            return policyNumber == other.policyNumber;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(policyNumber);
        }

        // Display policy details
        @Override
        public String toString() {
            return policyNumber + " - " + holderName + " - "
                    + expiryDate + " - " + coverageType
                    + " - Premium: " + premium;
        }
    }

    public static void main(String[] args) {
        // Create sample policies
        Policy p1 = new Policy(101, "Aman",
                LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy(102, "Riya",
                LocalDate.now().plusDays(45), "Auto", 7000);
        Policy p3 = new Policy(103, "Karan",
                LocalDate.now().plusDays(20), "Home", 6000);
        Policy duplicate = new Policy(101, "Aman",
                LocalDate.now().plusDays(10), "Health", 5000);

        // HashSet provides uniqueness and fast lookups
        Set<Policy> hashSet = new HashSet<>();
        hashSet.add(p1);
        hashSet.add(p2);
        hashSet.add(p3);
        hashSet.add(duplicate);

        // LinkedHashSet preserves insertion order
        Set<Policy> linkedHashSet = new LinkedHashSet<>(hashSet);

        // TreeSet sorts policies by expiry date
        Set<Policy> treeSet = new TreeSet<>(
                Comparator.comparing((Policy p) -> p.expiryDate)
                        .thenComparingInt(p -> p.policyNumber));
        treeSet.addAll(hashSet);

        // Display unique policies
        System.out.println("Unique policies: " + hashSet.size());

        // Display policies expiring within the next 30 days
        System.out.println("Expiring within 30 days:");
        for (Policy policy : treeSet) {
            if (!policy.expiryDate.isBefore(LocalDate.now())
                    && !policy.expiryDate.isAfter(LocalDate.now().plusDays(30))) {
                System.out.println(policy);
            }
        }

        // Display policies with Health coverage
        System.out.println("Health policies:");
        for (Policy policy : linkedHashSet) {
            if (policy.coverageType.equals("Health")) {
                System.out.println(policy);
            }
        }

        // Check duplicate policy numbers
        System.out.println("Duplicate policy number detected: "
                + (hashSet.size() < 4));

        // Compare basic performance characteristics
        System.out.println("HashSet: generally fast add, remove, and search");
        System.out.println("LinkedHashSet: preserves insertion order");
        System.out.println("TreeSet: maintains sorted order");
    }
}

