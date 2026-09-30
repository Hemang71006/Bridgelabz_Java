package javaConstructors.accessModifiers;

/**
 * Problem 4 (GCR — Access Modifiers)
 * Create an Employee class with:
 * employeeID (public), department (protected),
 * and salary (private).
 * Modify salary using a public method.
 * Create a subclass Manager to access employeeID and department.
 *
 * Author : Hemang
 * Date : 29-09-2026
 */
public class Employee {

    // Public variable
    public int employeeID;

    // Protected variable
    protected String department;

    // Private variable
    private double salary;

    // Constructor
    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify private salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Public method to access private salary
    public double getSalary() {
        return salary;
    }

    public static void main(String[] args) {

        // Create Manager object
        Manager manager =
                new Manager(501, "IT", 60000);

        // Display manager details
        manager.displayManagerDetails();

        // Modify private salary using setter
        manager.setSalary(70000);

        // Access updated salary using getter
        System.out.println("\nUpdated Salary: " + manager.getSalary());
    }
}

// Subclass
class Manager extends Employee {

    Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    // Access public employeeID and protected department
    void displayManagerDetails() {
        System.out.println("Employee ID : " + employeeID);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : " + getSalary());
    }
}