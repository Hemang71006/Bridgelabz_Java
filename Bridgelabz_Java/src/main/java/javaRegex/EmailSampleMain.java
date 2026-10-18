package javaRegex;

/**
 * Problem: Test the valid and invalid email examples from the practice PDF.
 * Print each email and the validator result.
 *
 * Author : Hemang
 * Date   : 17-10-2026
 */

public class EmailSampleMain {

    // Run all provided email examples and display their results.
    public static void testEmailSamples() {

        // Emails listed as valid in the practice PDF.
        String[] validEmails = {
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc-100@abc.net",
                "abc.100@abc.com.au",
                "abc@1.com",
                "abc@gmail.com.com",
                "abc+100@gmail.com"
        };

        // Emails listed as invalid in the practice PDF.
        String[] invalidEmails = {
                "abc",
                "abc@.com.my",
                "abc123@gmail.a",
                "abc123@.com",
                "abc123@.com.com",
                ".abc@abc.com",
                "abc()*@gmail.com",
                "abc@%*.com",
                "abc..2002@gmail.com",
                "abc.@gmail.com",
                "abc@abc@gmail.com",
                "abc@gmail.com.1a",
                "abc@gmail.com.aa.au"
        };

        // Confirm that every valid sample is accepted.
        System.out.println("\n--- Expected VALID emails ---");
        for (String email : validEmails) {
            System.out.println(email + " -> "
                    + EmailValidator.isValid(email));
        }

        // Confirm that every invalid sample is rejected.
        System.out.println("\n--- Expected INVALID emails ---");
        for (String email : invalidEmails) {
            System.out.println(email + " -> "
                    + EmailValidator.isValid(email));
        }
    }

    // Run this class directly to test the email examples.
    public static void main(String[] args) {
        testEmailSamples();
    }
}
