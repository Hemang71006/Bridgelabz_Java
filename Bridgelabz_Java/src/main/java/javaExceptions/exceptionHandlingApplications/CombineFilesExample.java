package javaExceptions.exceptionHandlingApplications;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Problem Statement:
 * Read data from two files and write their combined contents
 * to a third file. Use try-with-resources to ensure all readers
 * and the writer are closed, including when an error occurs.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */
public class CombineFilesExample {

    public static void main(String[] args) {

        // Open both input files and the output file together.
        try (
                BufferedReader reader1 =
                        new BufferedReader(new FileReader("Bridgelabz_Java/src/main/java/javaExceptions/exceptionHandlingApplications/input1.txt"));
                BufferedReader reader2 =
                        new BufferedReader(new FileReader("Bridgelabz_Java/src/main/java/javaExceptions/exceptionHandlingApplications/input2.txt"));
                BufferedWriter writer =
                        new BufferedWriter(new FileWriter("Bridgelabz_Java/src/main/java/javaExceptions/exceptionHandlingApplications/combined.txt"))
        ) {
            String line;

            // Copy all lines from the first file to the output.
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            // Copy all lines from the second file to the output.
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Files combined successfully.");

        } catch (IOException e) {

            // Handle any input or output file error.
            System.out.println("Error combining files: " + e.getMessage());
        }
    }
}
