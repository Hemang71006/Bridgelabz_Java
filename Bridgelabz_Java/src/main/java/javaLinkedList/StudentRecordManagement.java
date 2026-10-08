package javaLinkedList;

/**
 * Problem 1 (GCR — Singly Linked List: Student Record Management)
 * Create a program to manage student records using a singly linked list.
 * Each node stores Roll Number, Name, Age, and Grade.
 * Implement adding, deleting, searching, displaying, and updating student records.
 *
 * Author : Hemang
 * Date : 06-10-2026
 */

class StudentNode {
    int rollNumber;
    String name;
    int age;
    char grade;
    StudentNode next;

    StudentNode(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

public class StudentRecordManagement {

    StudentNode head;

    // Add student at beginning
    void addAtBeginning(int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add student at end
    void addAtEnd(int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        StudentNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Add student at a specific position
    void addAtPosition(int position, int rollNumber, String name, int age, char grade) {
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }

        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        StudentNode current = head;

        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete student by roll number
    void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            return;
        }

        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }

        StudentNode current = head;

        while (current.next != null) {
            if (current.next.rollNumber == rollNumber) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }

    // Search student by roll number
    void searchByRollNumber(int rollNumber) {
        StudentNode current = head;

        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Student found: " + current.name);
                return;
            }

            current = current.next;
        }

        System.out.println("Student not found");
    }

    // Display all students
    void display() {
        StudentNode current = head;

        while (current != null) {
            System.out.println(
                    current.rollNumber + " " +
                            current.name + " " +
                            current.age + " " +
                            current.grade
            );

            current = current.next;
        }
    }

    // Update grade by roll number
    void updateGrade(int rollNumber, char newGrade) {
        StudentNode current = head;

        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                return;
            }

            current = current.next;
        }
    }

    public static void main(String[] args) {

        StudentRecordManagement list = new StudentRecordManagement();

        list.addAtBeginning(101, "Rahul", 20, 'A');
        list.addAtEnd(102, "Aman", 21, 'B');
        list.addAtPosition(2, 103, "Hemang", 21, 'A');

        System.out.println("Student Records:");
        list.display();

        list.searchByRollNumber(103);

        list.updateGrade(102, 'A');

        list.deleteByRollNumber(101);

        System.out.println("After update and deletion:");
        list.display();
    }
}
