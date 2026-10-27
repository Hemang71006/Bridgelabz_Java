package javaDesignPatterns;

/**
 * Problem: Create a Singleton Logger class with a private constructor,
 * a single shared instance, and a log() method.
 * Test whether multiple calls return the same instance.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class LoggerSingleton {

    // Create a single instance using the nested Holder class.
    private static class Holder {
        private static final LoggerSingleton INSTANCE = new LoggerSingleton();
    }

    // Prevent objects from being created outside this class.
    private LoggerSingleton() {
    }

    // Return the single shared instance.
    public static LoggerSingleton getInstance() {
        return Holder.INSTANCE;
    }

    // Print the supplied log message.
    public void log(String message) {
        System.out.println("Log: " + message);
    }

    // Test the Singleton pattern.
    public static void main(String[] args) {
        // Get the singleton instance twice.
        LoggerSingleton logger1 = LoggerSingleton.getInstance();
        LoggerSingleton logger2 = LoggerSingleton.getInstance();

        // Print messages using both references.
        logger1.log("Application started");
        logger2.log("Application running");

        // Check whether both references point to the same object.
        System.out.println("Same instance: " + (logger1 == logger2));
    }
}