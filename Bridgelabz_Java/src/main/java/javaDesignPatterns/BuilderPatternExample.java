package javaDesignPatterns;

/**
 * Problem: Create a User class with private fields and a private constructor.
 * Use a static inner Builder class with methods returning Builder and
 * a build() method to create the User object.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class BuilderPatternExample {

    // Store the user's information.
    static class User {
        private String name;
        private int age;
        private String email;

        // Restrict direct object creation to the Builder.
        private User(Builder builder) {
            this.name = builder.name;
            this.age = builder.age;
            this.email = builder.email;
        }

        // Display the user's information.
        public void displayDetails() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Email: " + email);
        }

        // Build a User object step by step.
        static class Builder {
            private String name;
            private int age;
            private String email;

            // Set the user's name and return the Builder.
            public Builder setName(String name) {
                this.name = name;
                return this;
            }

            // Set the user's age and return the Builder.
            public Builder setAge(int age) {
                this.age = age;
                return this;
            }

            // Set the user's email and return the Builder.
            public Builder setEmail(String email) {
                this.email = email;
                return this;
            }

            // Create the final User object.
            public User build() {
                return new User(this);
            }
        }
    }

    // Test the Builder pattern.
    public static void main(String[] args) {
        // Create a User object by chaining Builder methods.
        User user = new User.Builder()
                .setName("Hemang")
                .setAge(21)
                .setEmail("hemang@example.com")
                .build();

        // Display the created user's information.
        user.displayDetails();
    }
}
