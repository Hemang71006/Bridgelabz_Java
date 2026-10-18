package javaRegex;

import java.util.Scanner;

/**
 * Problem: Test User Registration validations using regex patterns.
 * UC1-UC8 validate registration fields; UC9 tests the supplied email samples.
 *
 * Author : Hemang
 * Date   : 17-10-2026
 */

public class UserRegistrationMain {

    // UC1-UC8: Read and validate registration details.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("First name valid: "
                + UserRegistrationValidator.validateFirstName(firstName));

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Last name valid: "
                + UserRegistrationValidator.validateLastName(lastName));

        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Email valid: "
                + UserRegistrationValidator.validateEmail(email));

        System.out.print("Enter mobile (e.g. 91 9919819801): ");
        String mobile = scanner.nextLine();
        System.out.println("Mobile valid: "
                + UserRegistrationValidator.validateMobile(mobile));

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Password valid: "
                + UserRegistrationValidator.validatePassword(password));

        // UC9: Test the separately provided email sample list.
        System.out.println("\nUC9: Run email sample tests? (yes/no)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            EmailSampleMain.testEmailSamples();
        }

        scanner.close();
    }
}
