package javaExceptions.exceptionHandlingBasics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem Statement:
 * Read the contents of "data.txt". If the file does not exist or
 * cannot be read, handle IOException and display "File not found".
 *
 * Author: Hemang
 * Date: 17-10-2026
 */
public class CheckedExceptionExample {

    public static void main(String[] args) {

        // Try-with-resources automatically closes the reader.
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("Bridgelabz_Java/src/main/java/javaExceptions/exceptionHandlingBasics/data.txt"))) {

            String line;

            // Read and print each line until the end of the file.
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {

            // Handle file-related checked exceptions.
            System.out.println("File not found");
        }
    }
}
