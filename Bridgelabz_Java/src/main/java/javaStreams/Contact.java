package javaStreams;

import java.util.Objects;

/**
 * Problem (Address Book System - UC1 to UC12)
 * Create a Contact class to store and manage a person's details.
 * Compare contacts by full name to identify duplicate entries.
 *
 * Author : Hemang
 * Date   : 15-10-2026
 */

public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    // UC1: Initialize a contact with all required details.
    public Contact(String firstName, String lastName, String address,
                   String city, String state, String zip,
                   String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    // Return the person's full name.
    public String getName() {
        return firstName + " " + lastName;
    }

    // Return contact details for editing and Stream operations.
    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    // UC3: Update the contact's address.
    public void setAddress(String address) {
        this.address = address;
    }

    // UC3: Update the contact's city.
    public void setCity(String city) {
        this.city = city;
    }

    // UC3: Update the contact's state.
    public void setState(String state) {
        this.state = state;
    }

    // UC3: Update the contact's ZIP code.
    public void setZip(String zip) {
        this.zip = zip;
    }

    // UC3: Update the contact's phone number.
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // UC3: Update the contact's email.
    public void setEmail(String email) {
        this.email = email;
    }

    // UC7: Contacts with the same full name are considered duplicates.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Contact)) {
            return false;
        }

        Contact other = (Contact) obj;
        return getName().equalsIgnoreCase(other.getName());
    }

    // Generate a hash code consistent with equals().
    @Override
    public int hashCode() {
        return Objects.hash(getName().toLowerCase());
    }

    // Display all contact information.
    @Override
    public String toString() {
        return "Name: " + getName()
                + ", Address: " + address
                + ", City: " + city
                + ", State: " + state
                + ", ZIP: " + zip
                + ", Phone: " + phone
                + ", Email: " + email;
    }
}