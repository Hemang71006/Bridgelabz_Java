package javaStreams;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Problem (Address Book System - UC1 to UC12)
 * Run the Address Book System through a console menu.
 * Manage multiple Address Books and perform operations
 * across them using Java Streams.
 *
 * Author : Hemang
 * Date   : 15-10-2026
 */

public class AddressBookMain {
    // UC6: Store multiple Address Books using their names as keys.
    private static final Map<String, AddressBook> addressBooks =
            new HashMap<>();

    // UC6: Create a new Address Book.
    private static void createAddressBook(Scanner scanner) {
        System.out.print("Enter Address Book name: ");
        String name = scanner.nextLine();

        if (addressBooks.containsKey(name)) {
            System.out.println("Address Book already exists.");
            return;
        }

        addressBooks.put(name, new AddressBook(name));
        System.out.println("Address Book created successfully.");
    }

    // Select an existing Address Book by name.
    private static AddressBook selectAddressBook(Scanner scanner) {
        System.out.print("Enter Address Book name: ");
        String name = scanner.nextLine();

        AddressBook book = addressBooks.get(name);

        if (book == null) {
            System.out.println("Address Book not found.");
        }

        return book;
    }

    // UC1: Read contact information from the console.
    private static Contact readContact(Scanner scanner) {
        System.out.print("First name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("State: ");
        String state = scanner.nextLine();

        System.out.print("ZIP: ");
        String zip = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Build and return a Contact object from the entered values.
        return new Contact(firstName, lastName, address,
                city, state, zip, phone, email);
    }

    // Combine contacts from all Address Books into one list.
    private static List<Contact> getAllContacts() {
        return addressBooks.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .collect(Collectors.toList());
    }

    // UC8: Search contacts across all Address Books by city or state.
    private static void searchAcrossBooks(Scanner scanner) {
        System.out.print("Search by city or state? ");
        String searchType = scanner.nextLine();

        System.out.print("Enter city/state: ");
        String value = scanner.nextLine();

        // Filter contacts according to the selected location field.
        getAllContacts().stream()
                .filter(contact -> searchType.equalsIgnoreCase("city")
                        ? contact.getCity().equalsIgnoreCase(value)
                        : contact.getState().equalsIgnoreCase(value))
                .forEach(System.out::println);
    }

    // UC9: Group contacts from all Address Books by city or state.
    private static void viewGroupedContacts(Scanner scanner) {
        System.out.print("Group by city or state? ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("city")) {
            // Group all contacts by city.
            getAllContacts().stream()
                    .collect(Collectors.groupingBy(Contact::getCity))
                    .forEach((city, people) -> {
                        System.out.println("\nCity: " + city);
                        people.forEach(System.out::println);
                    });
        } else {
            // Group all contacts by state.
            getAllContacts().stream()
                    .collect(Collectors.groupingBy(Contact::getState))
                    .forEach((state, people) -> {
                        System.out.println("\nState: " + state);
                        people.forEach(System.out::println);
                    });
        }
    }

    // UC10: Count contacts by city or state across Address Books.
    private static void countGroupedContacts(Scanner scanner) {
        System.out.print("Count by city or state? ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("city")) {
            // Group by city and count the contacts in each group.
            getAllContacts().stream()
                    .collect(Collectors.groupingBy(
                            Contact::getCity, Collectors.counting()))
                    .forEach((city, count) ->
                            System.out.println(city + ": " + count));
        } else {
            // Group by state and count the contacts in each group.
            getAllContacts().stream()
                    .collect(Collectors.groupingBy(
                            Contact::getState, Collectors.counting()))
                    .forEach((state, count) ->
                            System.out.println(state + ": " + count));
        }
    }

    // UC11 and UC12: Sort contacts across all Address Books.
    private static void sortAllContacts(Scanner scanner) {
        System.out.print("Sort by name, city, state, or ZIP? ");
        String choice = scanner.nextLine();

        Comparator<Contact> comparator;

        // Choose the comparator according to the user's selection.
        switch (choice.toLowerCase()) {
            case "city":
                comparator = Comparator.comparing(
                        Contact::getCity, String.CASE_INSENSITIVE_ORDER);
                break;

            case "state":
                comparator = Comparator.comparing(
                        Contact::getState, String.CASE_INSENSITIVE_ORDER);
                break;

            case "zip":
                comparator = Comparator.comparing(Contact::getZip);
                break;

            default:
                comparator = Comparator.comparing(
                        Contact::getName, String.CASE_INSENSITIVE_ORDER);
        }

        // Sort and print the combined contacts.
        getAllContacts().stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }

    // Main method starts the console-based Address Book application.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Keep displaying the menu until the user chooses Exit.
        while (true) {
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Create Address Book");
            System.out.println("2. Add Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Edit Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Search Across Address Books");
            System.out.println("7. View Contacts by City/State");
            System.out.println("8. Count Contacts by City/State");
            System.out.println("9. Sort Contacts");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            String option = scanner.nextLine();

            // Perform the operation selected from the menu.
            switch (option) {
                case "1":
                    createAddressBook(scanner);
                    break;

                case "2": {
                    AddressBook book = selectAddressBook(scanner);

                    // Add the entered contact to the selected book.
                    if (book != null) {
                        book.addContact(readContact(scanner));
                    }
                    break;
                }

                case "3": {
                    AddressBook book = selectAddressBook(scanner);

                    // Display contacts in the selected book.
                    if (book != null) {
                        book.displayContacts();
                    }
                    break;
                }

                case "4": {
                    AddressBook book = selectAddressBook(scanner);

                    // Edit a contact after locating it by full name.
                    if (book != null) {
                        System.out.print("Enter existing contact full name: ");
                        String fullName = scanner.nextLine();

                        System.out.println("Enter the updated contact details:");
                        Contact updatedContact = readContact(scanner);

                        book.editContact(fullName, updatedContact);
                    }
                    break;
                }

                case "5": {
                    AddressBook book = selectAddressBook(scanner);

                    // Delete a contact by full name.
                    if (book != null) {
                        System.out.print("Enter contact full name: ");
                        String fullName = scanner.nextLine();
                        book.deleteContact(fullName);
                    }
                    break;
                }

                case "6":
                    searchAcrossBooks(scanner);
                    break;

                case "7":
                    viewGroupedContacts(scanner);
                    break;

                case "8":
                    countGroupedContacts(scanner);
                    break;

                case "9":
                    sortAllContacts(scanner);
                    break;

                case "0":
                    System.out.println("Exiting Address Book.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}