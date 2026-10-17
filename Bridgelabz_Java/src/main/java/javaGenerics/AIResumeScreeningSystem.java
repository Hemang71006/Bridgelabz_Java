
package javaGenerics;

abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public abstract String getRole();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name) {
        super(name);
    }

    public String getRole() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String name) {
        super(name);
    }

    public String getRole() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String name) {
        super(name);
    }

    public String getRole() {
        return "Product Manager";
    }
}

class Resume<T extends JobRole> {
    private T applicant;

    public Resume(T applicant) {
        this.applicant = applicant;
    }

    public T getApplicant() {
        return applicant;
    }
}

class ResumeScreening {
    public static void screenResumes(
            java.util.List<? extends JobRole> applicants) {
        for (JobRole applicant : applicants) {
            System.out.println("Candidate: "
                    + applicant.getCandidateName());
            System.out.println("Applied Role: "
                    + applicant.getRole());
            System.out.println("Status: Resume received");
            System.out.println();
        }
    }
}

public class AIResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 =
                new Resume<>(new SoftwareEngineer("Rahul"));

        Resume<DataScientist> r2 =
                new Resume<>(new DataScientist("Priya"));

        Resume<ProductManager> r3 =
                new Resume<>(new ProductManager("Amit"));

        java.util.List<JobRole> applicants =
                new java.util.ArrayList<>();

        applicants.add(r1.getApplicant());
        applicants.add(r2.getApplicant());
        applicants.add(r3.getApplicant());

        ResumeScreening.screenResumes(applicants);
    }
}

