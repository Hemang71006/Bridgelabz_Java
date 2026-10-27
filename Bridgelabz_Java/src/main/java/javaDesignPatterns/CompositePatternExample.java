package javaDesignPatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Create an Employee interface with showDetails().
 * Implement Developer and Manager classes, allow Manager to contain
 * employees, provide add/remove methods, and print the hierarchy.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class CompositePatternExample {

    // Define the common employee interface.
    interface Employee {
        void showDetails();
    }

    // Represent an individual developer.
    static class Developer implements Employee {
        private String name;

        // Initialize the developer's name.
        public Developer(String name) {
            this.name = name;
        }

        // Display developer details.
        public void showDetails() {
            System.out.println("Developer: " + name);
        }
    }

    // Represent a manager who can contain other employees.
    static class Manager implements Employee {
        private String name;
        private List<Employee> employees = new ArrayList<>();

        // Initialize the manager's name.
        public Manager(String name) {
            this.name = name;
        }

        // Add an employee to the manager's team.
        public void addEmployee(Employee employee) {
            employees.add(employee);
        }

        // Remove an employee from the manager's team.
        public void removeEmployee(Employee employee) {
            employees.remove(employee);
        }

        // Display the manager and all employees in the team.
        public void showDetails() {
            System.out.println("Manager: " + name);

            // Display every employee managed by this manager.
            for (Employee employee : employees) {
                employee.showDetails();
            }
        }
    }

    // Test the Composite pattern.
    public static void main(String[] args) {
        // Create individual employees.
        Employee developer1 = new Developer("Amit");
        Employee developer2 = new Developer("Priya");

        // Create a manager.
        Manager manager = new Manager("Rahul");

        // Add developers to the manager's team.
        manager.addEmployee(developer1);
        manager.addEmployee(developer2);

        // Display the complete team hierarchy.
        manager.showDetails();

        // Remove one developer from the team.
        manager.removeEmployee(developer2);

        // Display the updated team hierarchy.
        System.out.println("\nAfter removing an employee:");
        manager.showDetails();
    }
}
