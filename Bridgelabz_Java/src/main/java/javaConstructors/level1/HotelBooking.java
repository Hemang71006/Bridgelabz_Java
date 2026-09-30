package javaConstructors.level1;

/**
 * Problem 4 (GCR — Java Constructors Level 1 Assignment)
 * Create a HotelBooking class with attributes guestName,
 * roomType, and nights.
 * Use default, parameterized, and copy constructors
 * to initialize bookings.
 *
 * Author : Hemang
 * Date : 29-09-2026
 */
public class HotelBooking {

    // Instance variables
    String guestName;
    String roomType;
    int nights;

    // Default constructor
    HotelBooking() {
        guestName = "Unknown";
        roomType = "Standard";
        nights = 0;
    }

    // Parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    HotelBooking(HotelBooking otherBooking) {
        this.guestName = otherBooking.guestName;
        this.roomType = otherBooking.roomType;
        this.nights = otherBooking.nights;
    }

    // Display booking details
    void displayBookingDetails() {
        System.out.println("Guest Name : " + guestName);
        System.out.println("Room Type  : " + roomType);
        System.out.println("Nights     : " + nights);
    }

    public static void main(String[] args) {

        // Create booking using default constructor
        HotelBooking booking1 = new HotelBooking();

        // Create booking using parameterized constructor
        HotelBooking booking2 =
                new HotelBooking("Hemang", "Deluxe", 3);

        // Create booking using copy constructor
        HotelBooking booking3 = new HotelBooking(booking2);

        System.out.println("Default Constructor:");
        booking1.displayBookingDetails();

        System.out.println("\nParameterized Constructor:");
        booking2.displayBookingDetails();

        System.out.println("\nCopy Constructor:");
        booking3.displayBookingDetails();
    }
}
