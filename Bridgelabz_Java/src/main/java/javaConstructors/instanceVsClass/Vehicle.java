package javaConstructors.instanceVsClass;

/**
 * Problem 3 (GCR — Instance vs. Class Variables and Methods)
 * Create a Vehicle class with instance variables ownerName and vehicleType,
 * and class variable registrationFee.
 *
 * Author : Hemang
 * Date : 29-09-2026
 */
public class Vehicle {

    // Instance variables
    String ownerName;
    String vehicleType;

    // Class variable fixed for all vehicles
    static double registrationFee = 5000.0;

    // Constructor
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method
    void displayVehicleDetails() {
        System.out.println("Owner Name      : " + ownerName);
        System.out.println("Vehicle Type    : " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    // Class method
    static void updateRegistrationFee(double newRegistrationFee) {
        registrationFee = newRegistrationFee;
    }

    public static void main(String[] args) {

        // Create Vehicle objects
        Vehicle vehicle1 = new Vehicle("Hemang", "Car");
        Vehicle vehicle2 = new Vehicle("Rahul", "Bike");

        System.out.println("Before Updating Registration Fee:");

        vehicle1.displayVehicleDetails();
        System.out.println();

        vehicle2.displayVehicleDetails();

        // Update common registration fee
        Vehicle.updateRegistrationFee(7500.0);

        System.out.println("\nAfter Updating Registration Fee:");

        vehicle1.displayVehicleDetails();
        System.out.println();

        vehicle2.displayVehicleDetails();
    }
}
