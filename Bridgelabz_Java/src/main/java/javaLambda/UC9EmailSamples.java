package javaLambda;

/**
 * Problem (User Registration - UC9)
 * Validate multiple email samples and display whether each
 * email satisfies the basic email validation rule.
 *
 * Author : Hemang
 * Date   : 14-10-2026
 */
public class UC9EmailSamples {

    public static void main(String[] args) {
        // Store sample email addresses.
        String[] emailSamples = {
                "abc.xyz@bl.co.in",
                "user@gmail.com",
                "plainaddress",
                "user@domain",
                "user@domain.com"
        };

        // Validate each email and print its result.
        for (String email : emailSamples) {
            System.out.println(email + " -> "
                    + UC1toUC8UserRegistration.validateEmail(email));
        }
    }
}
