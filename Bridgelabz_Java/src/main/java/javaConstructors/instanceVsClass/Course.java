package javaConstructors.instanceVsClass;

/**
 * Problem 2 (GCR — Instance vs. Class Variables and Methods)
 * Design a Course class with instance variables courseName, duration,
 * fee and class variable instituteName.
 *
 * Author : Hemang
 * Date : 29-09-2026
 */
public class Course {

    // Instance variables
    String courseName;
    int duration;
    double fee;

    // Class variable common to all courses
    static String instituteName = "BridgeLabz";

    // Constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println("Course Name : " + courseName);
        System.out.println("Duration    : " + duration + " months");
        System.out.println("Fee         : " + fee);
        System.out.println("Institute   : " + instituteName);
    }

    // Class method
    static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    public static void main(String[] args) {

        // Create Course objects
        Course course1 = new Course("Java Full Stack", 6, 30000);
        Course course2 = new Course("Python", 4, 20000);

        System.out.println("Before Updating Institute Name:");

        course1.displayCourseDetails();
        System.out.println();

        course2.displayCourseDetails();

        // Update common institute name
        Course.updateInstituteName("Tech Academy");

        System.out.println("\nAfter Updating Institute Name:");

        course1.displayCourseDetails();
        System.out.println();

        course2.displayCourseDetails();
    }
}
