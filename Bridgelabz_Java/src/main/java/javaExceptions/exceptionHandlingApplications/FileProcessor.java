package javaExceptions.exceptionHandlingApplications;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Problem Statement:
 * Create FileProcessor with processFiles(List<String> filePaths).
 * Read each file using BufferedReader, handle IOException, and
 * automatically close each reader using try-with-resources.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */
public class FileProcessor {

    // Read the contents of every file path supplied.
    public void processFiles(List<String> filePaths) {

        // Process each file separately so one failure doesn't prevent
        // attempting to read the remaining files.
        for (String filePath : filePaths) {
            System.out.println("Reading file: " + filePath);

            // Automatically close this file's reader when try ends.
            try (BufferedReader reader =
                         new BufferedReader(new FileReader(filePath))) {

                String line;

                // Read and print the file line by line.
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e) {

                // Report the file-reading error and continue the loop.
                System.out.println("Could not read file: " + filePath);
            }
        }
    }

    public static void main(String[] args) {

        // Provide the names of files to process.
        FileProcessor processor = new FileProcessor();
        processor.processFiles(List.of("Bridgelabz_Java/src/main/java/javaExceptions/exceptionHandlingApplications/first.txt", "Bridgelabz_Java/src/main/java/javaExceptions/exceptionHandlingApplications/second.txt"));
    }
}
