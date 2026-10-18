package javaGenerics;

/*
 * Problem Statement:
 * Develop an AI-Driven Resume Screening System that processes resumes
 * for different job roles, such as Software Engineer, Data Scientist,
 * and Product Manager, while ensuring type safety.
 *
 * Use an abstract JobRole class, a generic Resume<T extends JobRole>
 * class, and a wildcard method that accepts a list of different job roles.
 *
 * Author: Hemang
 * Date: 14-10-2026
 */

// Abstract class representing a candidate's job role.
abstract class JobRole {
    private String candidateName;

    // Initializes the candidate's name.
    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    // Returns the candidate's name.
    public String getCandidateName() {
        return candidateName;
    }

    // Each specific job role provides its own role name.
    public abstract String getRole();
}

// Represents a candidate applying for a Software Engineer position.
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name) {
        super(name);
    }

    // Returns the specific job role.
    public String getRole() {
        return "Software Engineer";
    }
}

// Represents a candidate applying for a Data Scientist position.
class DataScientist extends JobRole {
    public DataScientist(String name) {
        super(name);
    }

    // Returns the specific job role.
    public String getRole() {
        return "Data Scientist";
    }
}

// Represents a candidate applying for a Product Manager position.
class ProductManager extends JobRole {
    public ProductManager(String name) {
        super(name);
    }

    // Returns the specific job role.
    public String getRole() {
        return "Product Manager";
    }
}

// Generic Resume class restricted to valid JobRole types.
class Resume<T extends JobRole> {
    private T applicant;

    // Stores the applicant using the specified job-role type.
    public Resume(T applicant) {
        this.applicant = applicant;
    }

    // Returns the applicant associated with this resume.
    public T getApplicant() {
        return applicant;
    }
}

// Screens resumes for applicants belonging to any JobRole subtype.
class ResumeScreening {

    // Upper-bounded wildcard allows lists of different JobRole subtypes.
    public static void screenResumes(
            java.util.List<? extends JobRole> applicants) {

        // Process each applicant in the list.
        for (JobRole applicant : applicants) {
            System.out.println("Candidate: "
                    + applicant.getCandidateName());

            // Display the role for which the candidate applied.
            System.out.println("Applied Role: "
                    + applicant.getRole());

            // Confirm that the resume has been received.
            System.out.println("Status: Resume received");
            System.out.println();
        }
    }
}

// Main class that demonstrates the resume screening system.
public class AIResumeScreeningSystem {
    public static void main(String[] args) {

        // Create type-safe resumes for different job roles.
        Resume<SoftwareEngineer> r1 =
                new Resume<>(new SoftwareEngineer("Rahul"));

        Resume<DataScientist> r2 =
                new Resume<>(new DataScientist("Priya"));

        Resume<ProductManager> r3 =
                new Resume<>(new ProductManager("Amit"));

        // Store applicants from different job roles in one list.
        java.util.List<JobRole> applicants =
                new java.util.ArrayList<>();

        // Add each resume's applicant to the screening list.
        applicants.add(r1.getApplicant());
        applicants.add(r2.getApplicant());
        applicants.add(r3.getApplicant());

        // Screen and display all applicants.
        ResumeScreening.screenResumes(applicants);
    }
}