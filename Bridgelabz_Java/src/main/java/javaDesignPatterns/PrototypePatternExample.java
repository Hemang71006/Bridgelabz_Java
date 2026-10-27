package javaDesignPatterns;

/**
 * Problem: Create an Employee class implementing Cloneable.
 * Override clone(), create an original Employee, clone it,
 * and verify that both objects contain the same data.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class PrototypePatternExample {

    // Define an Employee class that supports cloning.
    static class Employee implements Cloneable {
        private int id;
        private String name;
        private String department;

        // Initialize employee details.
        public Employee(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }

        // Create and return a copy of the employee.
        @Override
        public Employee clone() {
            try {
                // Use Object's clone method to copy this object.
                return (Employee) super.clone();
            } catch (CloneNotSupportedException exception) {
                // Convert the unexpected checked exception into a runtime exception.
                throw new AssertionError(exception);
            }
        }

        // Display employee details.
        public void displayDetails() {
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Department: " + department);
        }
    }

    // Test the Prototype pattern.
    public static void main(String[] args) {
        // Create the original Employee object.
        Employee original = new Employee(101, "Hemang", "Engineering");

        // Clone the original Employee object.
        Employee cloned = original.clone();

        // Display the original employee's details.
        System.out.println("--- Original Employee ---");
        original.displayDetails();

        // Display the cloned employee's details.
        System.out.println("\n--- Cloned Employee ---");
        cloned.displayDetails();

        // Verify that the objects are different but contain matching data.
        System.out.println("\nSame object: " + (original == cloned));
    }
}
