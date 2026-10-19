package javaExceptions.advancedExceptionHandling;

import java.io.IOException;

/**
 * Problem Statement:
 * Wrap an IOException inside a custom runtime exception, then retrieve
 * the original exception cause from the wrapper.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */

// Custom unchecked exception that stores the original cause.
class CustomRuntimeException extends RuntimeException {

    // Pass both the wrapper message and original exception to the parent.
    public CustomRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class ExceptionWrapper {

    // Simulate an operation that fails with IOException.
    public void throwWrappedException() {

        try {
            // Simulate the original checked exception.
            throw new IOException("Original IOException");

        } catch (IOException e) {
            // Wrap IOException inside our custom runtime exception.
            throw new CustomRuntimeException("Wrapped exception", e);
        }
    }

    // Catch the wrapper and inspect its original cause.
    public void handleException() {

        try {
            // This method throws the custom wrapper exception.
            throwWrappedException();

        } catch (CustomRuntimeException e) {
            // Print the wrapper's message.
            System.out.println("Caught CustomRuntimeException: "
                    + e.getMessage());

            // getCause() retrieves the original IOException.
            System.out.println("Original cause: "
                    + e.getCause().getMessage());
        }
    }

    public static void main(String[] args) {

        // Create the wrapper demonstration object.
        ExceptionWrapper wrapper = new ExceptionWrapper();

        // Run and handle the wrapped exception.
        wrapper.handleException();
    }
}
