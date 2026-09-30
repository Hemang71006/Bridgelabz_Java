package javaConstructors.level1;

/**
 * Problem 6 (GCR — Java Constructors Level 1 Assignment)
 * Create a CarRental class with attributes customerName,
 * carModel, and rentalDays.
 * Add constructors to initialize the rental details
 * and calculate total cost.
 *
 * Author : Hemang
 * Date : 29-09-2026
 */
public class CarRental {

    // Instance variables
    String customerName;
    String carModel;
    int rentalDays;

    // Default constructor
    CarRental() {
        customerName = "Unknown";
        carModel = "Unknown";
        rentalDays = 0;
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Calculate total rental cost
    double calculateTotalCost(double dailyRate) {
        return rentalDays * dailyRate;
    }

    // Display rental details
    void displayRentalDetails() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Car Model     : " + carModel);
        System.out.println("Rental Days   : " + rentalDays);
    }

    public static void main(String[] args) {

        // Create rental using default constructor
        CarRental rental1 = new CarRental();

        // Create rental using parameterized constructor
        CarRental rental2 =
                new CarRental("Hemang", "Toyota Camry", 5);

        System.out.println("Default Constructor:");
        rental1.displayRentalDetails();

        System.out.println("\nParameterized Constructor:");
        rental2.displayRentalDetails();

        // Calculate cost using the given daily rate
        double dailyRate = 1500.0;
        double totalCost = rental2.calculateTotalCost(dailyRate);

        System.out.println("Daily Rate    : " + dailyRate);
        System.out.println("Total Cost    : " + totalCost);
    }
}
