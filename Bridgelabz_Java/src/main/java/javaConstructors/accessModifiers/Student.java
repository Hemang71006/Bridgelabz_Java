package javaConstructors.accessModifiers;

/**
 * Problem 1 (GCR — Access Modifiers)
 * Create a Student class with:
 * rollNumber (public), name (protected), and CGPA (private).
 * Access and modify CGPA using public methods.
 * Create a subclass PostgraduateStudent to demonstrate protected members.
 *
 * Author : Hemang
 * Date : 29-09-2026
 */
public class Student {

    // Public variable
    public int rollNumber;

    // Protected variable
    protected String name;

    // Private variable
    private double CGPA;

    // Constructor
    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public method to access private CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public method to modify private CGPA
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    // Display student details
    void displayStudentDetails() {
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Name        : " + name);
        System.out.println("CGPA        : " + CGPA);
    }

    public static void main(String[] args) {

        // Create Student object
        Student student = new Student(101, "Hemang", 9.01);

        student.displayStudentDetails();

        // Access private CGPA using public getter
        System.out.println("\nCGPA using getter: " + student.getCGPA());

        // Modify private CGPA using public setter
        student.setCGPA(9.20);

        System.out.println("Updated CGPA: " + student.getCGPA());

        // Create PostgraduateStudent object
        PostgraduateStudent postgraduateStudent =
                new PostgraduateStudent(102, "Rahul", 8.75);

        System.out.println("\nPostgraduate Student:");
        postgraduateStudent.displayProtectedName();
    }
}

// Subclass
class PostgraduateStudent extends Student {

    PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    // Protected name can be accessed inside subclass
    void displayProtectedName() {
        System.out.println("Name from protected variable: " + name);
    }
}