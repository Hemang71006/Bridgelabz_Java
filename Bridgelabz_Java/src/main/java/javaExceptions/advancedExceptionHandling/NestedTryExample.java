package javaExceptions.advancedExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem Statement:
 * Read a file using nested try-catch blocks. The inner catch handles
 * parsing errors, while the outer catch handles file I/O errors.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */
public class NestedTryExample {

    // Read a file and handle parsing and file errors separately.
    public void readFile(String filePath) {

        try {
            // Inner try handles the file-reading and parsing operation.
            try (BufferedReader reader =
                         new BufferedReader(new FileReader(filePath))) {

                // Read each line until the file ends.
                String line;
                while ((line = reader.readLine()) != null) {

                    // Simulate a parsing problem if a line contains "error".
                    if (line.contains("error")) {
                        throw new NumberFormatException(
                                "Parsing error in line: " + line);
                    }

                    // Print a line that passes the parsing check.
                    System.out.println(line);
                }

            } catch (NumberFormatException e) {
                // Handle the parsing exception inside the inner block.
                System.out.println("Inner exception: " + e.getMessage());
            }

        } catch (IOException e) {
            // Handle file-not-found or other file-reading errors outside.
            System.out.println("Outer exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // Use example.txt in the program's working directory.
        NestedTryExample example = new NestedTryExample();

        // Read and process the file.
        example.readFile("Bridgelabz_Java/src/main/java/javaExceptions/advancedExceptionHandling/example.txt");
    }
}
