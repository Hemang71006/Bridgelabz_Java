package javaLambda;

/**
 * Problem (User Registration - UC12)
 * Create a custom exception to report invalid registration
 * information with a meaningful error message.
 *
 * Author : Hemang
 * Date   : 14-10-2026
 */
public class UC12UserRegistrationException extends Exception {

    // Initialize the custom exception with an error message.
    public UC12UserRegistrationException(String message) {
        super(message);
    }
}
