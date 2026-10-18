package javaStreams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Problem (Address Book System - UC1 to UC12)
 * Manage contacts in one Address Book.
 * Use Java Streams to search, group, count, and sort contacts.
 *
 * Author : Hemang
 * Date   : 15-10-2026
 */

public class AddressBook {
    private final String name;
    private final List<Contact> contacts = new ArrayList<>();

    // UC6: Create an Address Book with a name.
    public AddressBook(String name) {
        this.name = name;
    }

    // Return the Address Book name.
    public String getName() {
        return name;
    }

    // Provide contacts for operations across multiple Address Books.
    public List<Contact> getContacts() {
        return contacts;
    }

    // UC2 and UC5: Add a contact; UC7: check for duplicate names using Stream.
    public boolean addContact(Contact contact) {
        boolean duplicate = contacts.stream()
                .anyMatch(existing -> existing.equals(contact));

        if (duplicate) {
            System.out.println("Duplicate contact name. Contact not added.");
            return false;
        }

        contacts.add(contact);
        System.out.println("Contact added successfully.");
        return true;
    }

    // UC3: Find a contact by full name and update its information.
    public boolean editContact(String fullName, Contact updatedContact) {
        Optional<Contact> result = contacts.stream()
                .filter(contact ->
                        contact.getName().equalsIgnoreCase(fullName))
                .findFirst();

        if (!result.isPresent()) {
            System.out.println("Contact not found.");
            return false;
        }

        Contact contact = result.get();

        // Copy the updated details into the existing contact.
        contact.setAddress(updatedContact.getAddress());
        contact.setCity(updatedContact.getCity());
        contact.setState(updatedContact.getState());
        contact.setZip(updatedContact.getZip());
        contact.setPhone(updatedContact.getPhone());
        contact.setEmail(updatedContact.getEmail());

        System.out.println("Contact updated successfully.");
        return true;
    }

    // UC4: Delete a contact by full name.
    public boolean deleteContact(String fullName) {
        boolean removed = contacts.removeIf(contact ->
                contact.getName().equalsIgnoreCase(fullName));

        System.out.println(removed
                ? "Contact deleted successfully."
                : "Contact not found.");

        return removed;
    }

    // Display all contacts in this Address Book.
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address Book is empty.");
            return;
        }

        contacts.forEach(System.out::println);
    }

    // UC8: Search contacts in this book by city.
    public void searchByCity(String city) {
        contacts.stream()
                .filter(contact ->
                        contact.getCity().equalsIgnoreCase(city))
                .forEach(System.out::println);
    }

    // UC8: Search contacts in this book by state.
    public void searchByState(String state) {
        contacts.stream()
                .filter(contact ->
                        contact.getState().equalsIgnoreCase(state))
                .forEach(System.out::println);
    }

    // UC9: Group contacts by city and display each group.
    public void viewByCity() {
        contacts.stream()
                .collect(Collectors.groupingBy(Contact::getCity))
                .forEach((city, people) -> {
                    System.out.println("\nCity: " + city);
                    people.forEach(System.out::println);
                });
    }

    // UC9: Group contacts by state and display each group.
    public void viewByState() {
        contacts.stream()
                .collect(Collectors.groupingBy(Contact::getState))
                .forEach((state, people) -> {
                    System.out.println("\nState: " + state);
                    people.forEach(System.out::println);
                });
    }

    // UC10: Count contacts in each city.
    public void countByCity() {
        contacts.stream()
                .collect(Collectors.groupingBy(
                        Contact::getCity, Collectors.counting()))
                .forEach((city, count) ->
                        System.out.println(city + ": " + count));
    }

    // UC10: Count contacts in each state.
    public void countByState() {
        contacts.stream()
                .collect(Collectors.groupingBy(
                        Contact::getState, Collectors.counting()))
                .forEach((state, count) ->
                        System.out.println(state + ": " + count));
    }

    // UC11: Sort contacts alphabetically by full name.
    public void sortByName() {
        contacts.stream()
                .sorted(Comparator.comparing(
                        Contact::getName, String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
    }

    // UC12: Sort contacts by city.
    public void sortByCity() {
        contacts.stream()
                .sorted(Comparator.comparing(
                        Contact::getCity, String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
    }

    // UC12: Sort contacts by state.
    public void sortByState() {
        contacts.stream()
                .sorted(Comparator.comparing(
                        Contact::getState, String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
    }

    // UC12: Sort contacts by ZIP code.
    public void sortByZip() {
        contacts.stream()
                .sorted(Comparator.comparing(Contact::getZip))
                .forEach(System.out::println);
    }
}