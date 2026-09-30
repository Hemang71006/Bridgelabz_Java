package javaClassandObject.level2;

/**
 * Problem 1 (GCR — Java Class and Object Level 2 Assignment)
 * Create a Student class with attributes name, rollNumber, and marks.
 * Add methods to calculate the grade based on marks and display
 * the student's details and grade.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class Student {

    // Student attributes
    private String name;
    private int rollNumber;
    private double marks;

    // Constructor to initialize student details
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate grade
    public char calculateGrade() {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 75) {
            return 'B';
        } else if (marks >= 60) {
            return 'C';
        } else if (marks >= 50) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Method to display student details and grade
    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }

    public static void main(String[] args) {

        // Create a Student object
        Student student = new Student("Hemang", 101, 88);

        // Display student details
        student.displayDetails();
    }
}
