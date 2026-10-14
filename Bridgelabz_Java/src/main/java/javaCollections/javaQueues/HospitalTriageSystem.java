package javaCollections.javaQueues;

import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Problem 3 (Collections - Hospital Triage System)
 * Treat patients with higher severity first.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */

public class HospitalTriageSystem {

    static class Patient {
        String name;
        int severity;

        // Initialize patient details
        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }

        @Override
        public String toString() {
            return name + " (Severity: " + severity + ")";
        }
    }

    public static void main(String[] args) {

        // Higher severity receives higher priority
        PriorityQueue<Patient> patients =
                new PriorityQueue<>(
                        Comparator.comparingInt(
                                (Patient p) -> p.severity).reversed()
                );

        // Add patients to the queue
        patients.add(new Patient("John", 3));
        patients.add(new Patient("Alice", 5));
        patients.add(new Patient("Bob", 2));

        System.out.println("Patient Treatment Order:");

        // Treat the highest-severity patient first
        while (!patients.isEmpty()) {
            System.out.println(patients.remove());
        }
    }
}
