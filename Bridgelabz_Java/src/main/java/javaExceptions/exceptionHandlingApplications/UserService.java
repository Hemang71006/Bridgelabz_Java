package javaExceptions.exceptionHandlingApplications;

/**
 * Problem Statement:
 * Create UserService with registerUser(username), which throws
 * UserAlreadyExistsException if the user is already registered.
 * Create checkUserExistence(username), which throws
 * UserNotFoundException if the user is not found. Handle both
 * exceptions in main() and display feedback.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */

// Custom checked exception for an existing user.
class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

// Custom checked exception for a user who does not exist.
class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

public class UserService {

    // Simulate a user already registered in the system.
    private final String existingUsername = "hemang";

    // Check whether the username is already registered.
    public void registerUser(String username)
            throws UserAlreadyExistsException {

        if (username.equalsIgnoreCase(existingUsername)) {
            throw new UserAlreadyExistsException(
                    "User already exists: " + username);
        }

        System.out.println("User registered: " + username);
    }

    // Simulate checking whether a username exists.
    public void checkUserExistence(String username)
            throws UserNotFoundException {

        if (!username.equalsIgnoreCase(existingUsername)) {
            throw new UserNotFoundException(
                    "User not found: " + username);
        }

        System.out.println("User found: " + username);
    }

    public static void main(String[] args) {
        UserService service = new UserService();

        // Demonstrate registering a username that already exists.
        try {
            service.registerUser("hemang");
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        // Demonstrate searching for a username that does not exist.
        try {
            service.checkUserExistence("rahul");
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
