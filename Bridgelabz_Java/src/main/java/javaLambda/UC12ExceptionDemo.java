package javaLambda;

/**
 * Problem (User Registration - UC12)
 * Demonstrate throwing and handling a custom exception
 * when a registration field contains invalid information.
 *
 * Author : Hemang
 * Date   : 14-10-2026
 */
public class UC12ExceptionDemo {

    // Throw a custom exception if the first name is invalid.
    public static void validateFirstNameOrThrow(String firstName)
            throws UC12UserRegistrationException {

        if (!UC1toUC8UserRegistration.validateName(firstName)) {
            throw new UC12UserRegistrationException("Invalid first name");
        }
    }

    public static void main(String[] args) {
        // Validate the sample and catch the custom exception.
        try {
            validateFirstNameOrThrow("he");
            System.out.println("First name is valid");
        } catch (UC12UserRegistrationException exception) {
            System.out.println("Registration error: "
                    + exception.getMessage());
        }
    }
}
