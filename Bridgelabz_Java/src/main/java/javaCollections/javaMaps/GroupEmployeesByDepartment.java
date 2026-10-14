package javaCollections.javaMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem 5 (Collections - Group Objects by Property)
 * Group employees by department using a Map.
 *
 * Author : Hemang
 * Date   : 12-10-2026
 */

public class GroupEmployeesByDepartment {

    static class Employee {
        String name;
        String department;

        // Initialize employee details
        Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));

        Map<String, List<Employee>> grouped = new HashMap<>();

        // Group employees by department
        for (Employee employee : employees) {
            grouped.computeIfAbsent(employee.department,
                    key -> new ArrayList<>()).add(employee);
        }

        System.out.println("Employees by Department:");

        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
