package javaLambda;

/**
 * Problem (User Registration - UC1 to UC8)
 * Validate first name, last name, email, mobile number, and password
 * using character-based validation without regular expressions.
 *
 * Author : Hemang
 * Date   : 14-10-2026
 */

// Generic functional interface for validating a value.
@FunctionalInterface
interface Validator<T> {
    boolean validate(T value);
}

public class UC1toUC8UserRegistration {

    // UC1 and UC2: Name must start with uppercase and contain at least 3 letters.
    public static boolean validateName(String name) {
        if (name == null || name.length() < 3
                || !Character.isUpperCase(name.charAt(0))) {
            return false;
        }

        // Ensure every character is a letter.
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    // UC3: Validate a basic email format without regex.
    public static boolean validateEmail(String email) {
        if (email == null) {
            return false;
        }

        int atIndex = email.indexOf('@');

        // Require exactly one @ and non-empty text on both sides.
        if (atIndex <= 0 || atIndex != email.lastIndexOf('@')
                || atIndex == email.length() - 1) {
            return false;
        }

        String username = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);

        // Reject username or domain beginning or ending with a dot.
        if (username.startsWith(".") || username.endsWith(".")
                || domain.startsWith(".") || domain.endsWith(".")) {
            return false;
        }

        int dotIndex = domain.lastIndexOf('.');

        // Require a domain and a non-empty extension.
        if (dotIndex <= 0 || dotIndex == domain.length() - 1) {
            return false;
        }

        String extension = domain.substring(dotIndex + 1);

        // Extension must contain at least two letters.
        if (extension.length() < 2) {
            return false;
        }

        for (int i = 0; i < extension.length(); i++) {
            if (!Character.isLetter(extension.charAt(i))) {
                return false;
            }
        }

        // Reject whitespace anywhere in the email.
        for (int i = 0; i < email.length(); i++) {
            if (Character.isWhitespace(email.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    // UC4: Mobile number must have a country code, space, and 10 digits.
    public static boolean validateMobile(String mobile) {
        if (mobile == null) {
            return false;
        }

        int spaceIndex = mobile.indexOf(' ');

        // Require one space and exactly 10 digits after it.
        if (spaceIndex < 1 || spaceIndex != mobile.lastIndexOf(' ')
                || mobile.length() - spaceIndex - 1 != 10) {
            return false;
        }

        // Country code must contain 1 to 3 digits.
        if (spaceIndex > 3) {
            return false;
        }

        // Validate country-code digits.
        for (int i = 0; i < spaceIndex; i++) {
            if (!Character.isDigit(mobile.charAt(i))) {
                return false;
            }
        }

        // Validate the 10 mobile-number digits.
        for (int i = spaceIndex + 1; i < mobile.length(); i++) {
            if (!Character.isDigit(mobile.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    // UC5-UC8: Password needs 8 characters, uppercase, digit, and exactly one special character.
    public static boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasDigit = false;
        int specialCount = 0;

        // Check each password character.
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                specialCount++;
            }
        }

        return hasUppercase && hasDigit && specialCount == 1;
    }

    public static void main(String[] args) {
        // Create lambda validators for each field.
        Validator<String> firstNameValidator =
                name -> validateName(name);

        Validator<String> lastNameValidator =
                name -> validateName(name);

        Validator<String> emailValidator =
                email -> validateEmail(email);

        Validator<String> mobileValidator =
                mobile -> validateMobile(mobile);

        Validator<String> passwordValidator =
                password -> validatePassword(password);

        // Display validation results.
        System.out.println("First name Hemang: "
                + firstNameValidator.validate("Hemang"));
        System.out.println("Last name Jeswani: "
                + lastNameValidator.validate("Jeswani"));
        System.out.println("Email abc.xyz@bl.co.in: "
                + emailValidator.validate("abc.xyz@bl.co.in"));
        System.out.println("Mobile 91 9919819801: "
                + mobileValidator.validate("91 9919819801"));
        System.out.println("Password Abcd123!: "
                + passwordValidator.validate("Abcd123!"));
    }
}