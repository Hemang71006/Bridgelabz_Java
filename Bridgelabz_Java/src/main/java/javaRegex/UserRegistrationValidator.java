package javaRegex;

import java.util.regex.Pattern;

/**
 * Problem: User Registration using Java Regular Expressions.
 * Validate first name, last name, email, mobile number, and password.
 *
 * Author : Hemang
 * Date   : 17-10-2026
 */

public class UserRegistrationValidator {

    // UC1: First name starts with capital and contains at least 3 letters.
    private static final Pattern FIRST_NAME =
            Pattern.compile("^[A-Z][a-zA-Z]{2,}$");

    // UC2: Last name starts with capital and contains at least 3 letters.
    private static final Pattern LAST_NAME =
            Pattern.compile("^[A-Z][a-zA-Z]{2,}$");

    // UC3: Email has a local part, @, domain, and valid alphabetic TLD.
    private static final Pattern EMAIL =
            Pattern.compile("^[A-Za-z0-9_+-]+(?:\\.[A-Za-z0-9_+-]+)*"
                    + "@[A-Za-z0-9]+(?:\\.[A-Za-z0-9]+)?"
                    + "\\.[A-Za-z]{2,}$");

    // UC4: Two-digit country code, one space, and 10-digit mobile number.
    private static final Pattern MOBILE =
            Pattern.compile("^\\d{2} \\d{10}$");

    // UC5-UC8: At least 8 chars, one uppercase, one digit, exactly one special.
    private static final Pattern PASSWORD =
            Pattern.compile("^(?=.*[A-Z])(?=.*\\d)"
                    + "[A-Za-z0-9]*[^A-Za-z0-9][A-Za-z0-9]*$");

    // Validate first name using its pattern.
    public static boolean validateFirstName(String firstName) {
        return FIRST_NAME.matcher(firstName).matches();
    }

    // Validate last name using its pattern.
    public static boolean validateLastName(String lastName) {
        return LAST_NAME.matcher(lastName).matches();
    }

    // Validate email using its pattern.
    public static boolean validateEmail(String email) {
        return EMAIL.matcher(email).matches();
    }

    // Validate mobile number using its pattern.
    public static boolean validateMobile(String mobile) {
        return MOBILE.matcher(mobile).matches();
    }

    // Validate all password rules together.
    public static boolean validatePassword(String password) {
        return password.length() >= 8
                && PASSWORD.matcher(password).matches();
    }
}
