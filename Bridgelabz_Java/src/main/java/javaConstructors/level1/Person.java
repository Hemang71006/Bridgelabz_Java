package javaConstructors.level1;

/**
 * Problem 3 (GCR — Java Constructors Level 1 Assignment)
 * Create a Person class with a copy constructor that clones
 * another person's attributes.
 *
 * Author : Hemang
 * Date : 29-09-2026
 */
public class Person {

    // Instance variables
    String name;
    int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person otherPerson) {
        this.name = otherPerson.name;
        this.age = otherPerson.age;
    }

    // Display person details
    void displayPersonDetails() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }

    public static void main(String[] args) {

        // Create original object
        Person person1 = new Person("Hemang", 21);

        // Create copy using copy constructor
        Person person2 = new Person(person1);

        System.out.println("Original Person:");
        person1.displayPersonDetails();

        System.out.println("\nCopied Person:");
        person2.displayPersonDetails();
    }
}
