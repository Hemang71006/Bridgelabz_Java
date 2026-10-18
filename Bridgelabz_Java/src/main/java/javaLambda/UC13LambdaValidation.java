package javaLambda;

import java.util.function.Predicate;

/**
 * Problem (User Registration - UC13)
 * Use a functional interface and lambda expressions to validate
 * first name, last name, email, mobile number, and password.
 *
 * Author : Hemang
 * Date   : 14-10-2026
 */

// UC13: Functional interface for validating user fields.
@FunctionalInterface
interface UserFieldValidator {
    boolean validate(String value);
}

public class UC13LambdaValidation {

    // UC1 and UC2: Name starts with uppercase and contains at least 3 letters.
    static UserFieldValidator nameValidator = name ->
            name != null && name.length() >= 3
                    && Character.isUpperCase(name.charAt(0))
                    && name.chars().allMatch(Character::isLetter);

    // UC3: Validate email using a lambda expression.
    static UserFieldValidator emailValidator = email ->
            email != null && email.matches(
                    "^[A-Za-z0-9]+([._+-][A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z]{2,})+$");

    // UC4: Mobile number has country code, space, and 10 digits.
    static UserFieldValidator mobileValidator = mobile ->
            mobile != null && mobile.matches("^\\d{1,3} \\d{10}$");

    // UC5-UC8: Password requires 8 characters, uppercase, digit, and exactly one special character.
    static UserFieldValidator passwordValidator = password ->
            password != null
                    && password.length() >= 8
                    && password.chars().anyMatch(Character::isUpperCase)
                    && password.chars().anyMatch(Character::isDigit)
                    && password.chars().filter(ch ->
                    !Character.isLetterOrDigit(ch)).count() == 1;

    public static void main(String[] args) {

        // Validate and display first name.
        System.out.println("First name Hemang: "
                + nameValidator.validate("Hemang"));

        // Validate and display last name.
        System.out.println("Last name Jeswani: "
                + nameValidator.validate("Jeswani"));

        // Validate and display email.
        System.out.println("Email abc.xyz@bl.co.in: "
                + emailValidator.validate("abc.xyz@bl.co.in"));

        // Validate and display mobile number.
        System.out.println("Mobile 91 9919819801: "
                + mobileValidator.validate("91 9919819801"));

        // Validate and display password.
        System.out.println("Password Abcd123!: "
                + passwordValidator.validate("Abcd123!"));
    }
}