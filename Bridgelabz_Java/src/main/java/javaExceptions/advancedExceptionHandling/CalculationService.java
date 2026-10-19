package javaExceptions.advancedExceptionHandling;

/**
 * Problem Statement:
 * Create a custom checked exception and propagate it from a calculation
 * method to another method, where it is handled.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */

// Custom checked exception for calculation failures.
class CalculationException extends Exception {

    // Set the exception message.
    public CalculationException(String message) {
        super(message);
    }
}

public class CalculationService {

    // Declare that this method may throw CalculationException.
    public void performCalculation(int value)
            throws CalculationException {

        // Reject negative input.
        if (value < 0) {
            throw new CalculationException("Value must be non-negative");
        }

        // Reject zero because this example treats it as an invalid result.
        if (value == 0) {
            throw new CalculationException("Calculation resulted in zero");
        }

        // Perform the calculation for a valid positive value.
        System.out.println("Calculation result: " + (value * 2));
    }

    // Call the calculation method and handle its exception.
    public void process() {

        try {
            // This negative value causes CalculationException.
            performCalculation(-5);

        } catch (CalculationException e) {
            // Handle the propagated exception here.
            System.out.println("Exception caught in process: "
                    + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // Create the service and execute the process.
        CalculationService service = new CalculationService();
        service.process();
    }
}
