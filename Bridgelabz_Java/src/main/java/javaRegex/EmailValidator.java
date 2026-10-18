package javaRegex;

import java.util.regex.Pattern;

/**
 * Problem: Validate the supplied valid and invalid email samples.
 * Check email structure and reject malformed local parts and domains.
 *
 * Author : Hemang
 * Date   : 17-10-2026
 */

public class EmailValidator {

    // Allow letters, digits, underscore, plus, dash, and separated dots
    // before @. Domain has two or three labels followed by alphabetic TLD.
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9_+-]+(?:\\.[A-Za-z0-9_+-]+)*"
                    + "@[A-Za-z0-9]+(?:\\.[A-Za-z0-9]+)?"
                    + "\\.[A-Za-z]{2,}$");

    // Return true only when the email matches the regex.
    public static boolean isValid(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
