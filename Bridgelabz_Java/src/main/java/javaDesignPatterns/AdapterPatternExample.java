package javaDesignPatterns;

/**
 * Problem: Create an OldPrinter with oldPrint(), a NewPrinter
 * interface with print(), and an Adapter that allows the client
 * to use the old printer through the new interface.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class AdapterPatternExample {

    // Define the interface expected by the client.
    interface NewPrinter {
        void print();
    }

    // Provide the old printing method.
    static class OldPrinter {
        // Print using the old interface.
        public void oldPrint() {
            System.out.println("Printing using the old printer");
        }
    }

    // Adapt the old printer to the new interface.
    static class PrinterAdapter implements NewPrinter {
        private OldPrinter oldPrinter;

        // Receive the existing old printer.
        public PrinterAdapter(OldPrinter oldPrinter) {
            this.oldPrinter = oldPrinter;
        }

        // Convert the new print() call into an oldPrint() call.
        public void print() {
            oldPrinter.oldPrint();
        }
    }

    // Test the Adapter pattern.
    public static void main(String[] args) {
        // Create the old printer.
        OldPrinter oldPrinter = new OldPrinter();

        // Wrap the old printer with the adapter.
        NewPrinter printer = new PrinterAdapter(oldPrinter);

        // Call the new interface method.
        printer.print();
    }
}
