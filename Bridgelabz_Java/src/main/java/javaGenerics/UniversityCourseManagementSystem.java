package javaGenerics;

/*
 * Problem Statement:
 * Develop a university course management system where courses have
 * different evaluation types, such as Exam-Based, Assignment-Based,
 * and Research-Based.
 *
 * Use an abstract CourseType class, a generic Course<T extends CourseType>
 * class, and a wildcard method (List<? extends CourseType>) to display
 * courses of different evaluation types.
 *
 * Author: Hemang
 * Date: 14-10-2026
 */

// Abstract base class representing a university course type.
abstract class CourseType {
    private String courseName;

    // Initializes the course name.
    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    // Returns the course name.
    public String getCourseName() {
        return courseName;
    }

    // Each course subtype defines its evaluation method.
    public abstract String getEvaluationType();
}

// Represents a course evaluated through exams.
class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super(name);
    }

    // Returns the evaluation type for this course.
    public String getEvaluationType() {
        return "Exam-Based";
    }
}

// Represents a course evaluated through assignments.
class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super(name);
    }

    // Returns the evaluation type for this course.
    public String getEvaluationType() {
        return "Assignment-Based";
    }
}

// Represents a course evaluated through research.
class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super(name);
    }

    // Returns the evaluation type for this course.
    public String getEvaluationType() {
        return "Research-Based";
    }
}

// Generic Course class restricted to CourseType subclasses.
class Course<T extends CourseType> {
    private T course;

    // Stores a course of the specified type.
    public Course(T course) {
        this.course = course;
    }

    // Returns the stored course.
    public T getCourse() {
        return course;
    }
}

// Manages and displays courses with different evaluation types.
class CourseManager {

    // Wildcard accepts lists containing any CourseType subtype.
    public static void displayCourses(
            java.util.List<? extends CourseType> courses) {

        // Iterate through the courses and display their details.
        for (CourseType course : courses) {
            System.out.println("Course: " + course.getCourseName());

            // Display how the course is evaluated.
            System.out.println("Evaluation: "
                    + course.getEvaluationType());

            System.out.println();
        }
    }
}

// Main class demonstrates the university course management system.
public class UniversityCourseManagementSystem {
    public static void main(String[] args) {

        // Create a list that can hold different course types.
        java.util.List<CourseType> courses =
                new java.util.ArrayList<>();

        // Create a course evaluated through exams.
        Course<ExamCourse> c1 =
                new Course<>(new ExamCourse("Java Programming"));

        // Create a course evaluated through assignments.
        Course<AssignmentCourse> c2 =
                new Course<>(new AssignmentCourse("Web Development"));

        // Create a course evaluated through research.
        Course<ResearchCourse> c3 =
                new Course<>(new ResearchCourse("Machine Learning"));

        // Add each wrapped course to the common course list.
        courses.add(c1.getCourse());
        courses.add(c2.getCourse());
        courses.add(c3.getCourse());

        // Display the course names and evaluation types.
        CourseManager.displayCourses(courses);
    }
}