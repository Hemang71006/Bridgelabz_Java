package javaExceptions.exceptionHandlingBasics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem Statement:
 * Read and print the first line of "info.txt" using BufferedReader.
 * Use try-with-resources to close the reader automatically and
 * handle IOException if the file cannot be read.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */
public class TryWithResourcesExample {

    public static void main(String[] args) {

        // Try-with-resources automatically closes the reader.
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("Bridgelabz_Java/src/main/java/javaExceptions/exceptionHandlingBasics/info.txt"))) {

            // Read only the first line of the file.
            String firstLine = reader.readLine();

            // Print the line if the file contains text.
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty");
            }

        } catch (IOException e) {

            // Handle errors while opening or reading the file.
            System.out.println("Error reading file");
        }
    }
}
