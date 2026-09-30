package javaClassandObject.level1;

/**
 * Problem 1 (GCR — Java Class and Object Level 1 Assignment)
 * Create an Employee class with attributes name, id, and salary.
 * Add a method to display the employee details.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class EmployeeDetails {

    // Employee attributes
    private String name;
    private int id;
    private double salary;

    // Constructor to initialize employee details
    public EmployeeDetails(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Salary: " + salary);
    }

    public static void main(String[] args) {

        // Create an Employee object
        EmployeeDetails employee = new EmployeeDetails("Hemang", 101, 50000);

        // Display employee details
        employee.displayDetails();
    }
}
