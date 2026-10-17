
package javaGenerics;

abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public abstract String getEvaluationType();
}

class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super(name);
    }

    public String getEvaluationType() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super(name);
    }

    public String getEvaluationType() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super(name);
    }

    public String getEvaluationType() {
        return "Research-Based";
    }
}

class Course<T extends CourseType> {
    private T course;

    public Course(T course) {
        this.course = course;
    }

    public T getCourse() {
        return course;
    }
}

class CourseManager {
    public static void displayCourses(
            java.util.List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println("Course: " + course.getCourseName());
            System.out.println("Evaluation: "
                    + course.getEvaluationType());
            System.out.println();
        }
    }
}

public class UniversityCourseManagementSystem {
    public static void main(String[] args) {
        java.util.List<CourseType> courses =
                new java.util.ArrayList<>();

        Course<ExamCourse> c1 =
                new Course<>(new ExamCourse("Java Programming"));

        Course<AssignmentCourse> c2 =
                new Course<>(new AssignmentCourse("Web Development"));

        Course<ResearchCourse> c3 =
                new Course<>(new ResearchCourse("Machine Learning"));

        courses.add(c1.getCourse());
        courses.add(c2.getCourse());
        courses.add(c3.getCourse());

        CourseManager.displayCourses(courses);
    }
}

