package javaClassandObject.level1;

/**
 * Problem 5 (GCR — Java Class and Object Level 1 Assignment)
 * Create a MobilePhone class with attributes brand, model, and price.
 * Add a method to display all the details of the phone.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class MobilePhoneDetails {

    // Mobile phone attributes
    private String brand;
    private String model;
    private double price;

    // Constructor to initialize mobile phone details
    public MobilePhoneDetails(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display mobile phone details
    public void displayDetails() {
        System.out.println("Phone Brand: " + brand);
        System.out.println("Phone Model: " + model);
        System.out.println("Phone Price: " + price);
    }

    public static void main(String[] args) {

        // Create a MobilePhone object
        MobilePhoneDetails phone = new MobilePhoneDetails(
                "Samsung",
                "Galaxy S25",
                79999
        );

        // Display mobile phone details
        phone.displayDetails();
    }
}
