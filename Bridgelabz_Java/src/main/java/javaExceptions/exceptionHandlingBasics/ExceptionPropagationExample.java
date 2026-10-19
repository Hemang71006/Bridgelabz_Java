package javaExceptions.exceptionHandlingBasics;

/**
 * Problem Statement:
 * Create three methods: method1() throws an ArithmeticException,
 * method2() calls method1(), and main() calls method2() and handles
 * the propagated exception.
 *
 * Author: Hemang
 * Date: 17-10-2026
 */
public class ExceptionPropagationExample {

    // method1() causes an unchecked exception through division by zero.
    public static void method1() {
        int result = 10 / 0;
        System.out.println(result);
    }

    // method2() calls method1(); the exception propagates through it.
    public static void method2() {
        method1();
    }

    public static void main(String[] args) {

        try {
            // Call method2(), which indirectly calls method1().
            method2();

        } catch (ArithmeticException e) {

            // Handle the exception after it propagates to main().
            System.out.println("Handled exception in main");
        }
    }
}
