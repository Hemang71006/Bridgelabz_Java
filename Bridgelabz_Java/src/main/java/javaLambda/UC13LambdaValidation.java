package javaLambda;

public class UC13LambdaValidation {

    // Functional interface: contains exactly one abstract method
    @FunctionalInterface
    interface UserValidator {
        boolean validate(String value);
    }

    public static void main(String[] args) {

        // Lambda expressions for each field validation
        UserValidator firstName = name ->
                name != null && name.length() >= 3
                        && Character.isUpperCase(name.charAt(0))
                        && name.chars().allMatch(Character::isLetter);

        UserValidator lastName = name ->
                name != null && name.length() >= 3
                        && Character.isUpperCase(name.charAt(0))
                        && name.chars().allMatch(Character::isLetter);

        UserValidator email = value ->
                value != null && value.matches(
                        "^[A-Za-z0-9]+([._+-][A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z]{2,})+$");

        UserValidator mobile = value ->
                value != null && value.matches("^\\+[0-9]{1,3} [0-9]{10}$");

        UserValidator password = value ->
                value != null
                        && value.length() >= 8
                        && value.chars().anyMatch(Character::isUpperCase)
                        && value.chars().anyMatch(Character::isDigit)
                        && value.chars().filter(ch ->
                        !Character.isLetterOrDigit(ch)).count() == 1;

        // Test user details
        String first = "Hemang";
        String last = "Jeswani";
        String mail = "hemang.j@gmail.com";
        String phone = "+91 9876543210";
        String pass = "Hello@123";

        // Validate and display results
        System.out.println("First Name: " + firstName.validate(first));
        System.out.println("Last Name: " + lastName.validate(last));
        System.out.println("Email: " + email.validate(mail));
        System.out.println("Mobile: " + mobile.validate(phone));
        System.out.println("Password: " + password.validate(pass));
    }
}
