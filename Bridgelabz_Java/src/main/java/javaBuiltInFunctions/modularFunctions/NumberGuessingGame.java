package javaBuiltInFunctions.modularFunctions;

import java.util.Scanner;

/**
 * Problem 1: Number Guessing Game
 * Computer guesses a number between 1 and 100 based on user feedback.
 *
 * Author : Hemang
 * Date : 28-09-2026
 */

public class NumberGuessingGame {

    // Generate a guess between the given lower and upper limits
    public static int generateGuess(int lower, int upper) {
        return (lower + upper) / 2;
    }

    // Get feedback from the user
    public static char getFeedback(Scanner scanner) {
        System.out.print("Enter feedback (H = High, L = Low, C = Correct): ");
        return scanner.next().toUpperCase().charAt(0);
    }

    // Calculate the next guess based on feedback
    public static int getNextGuess(int guess, char feedback, int[] range) {

        if (feedback == 'H') {
            range[1] = guess - 1;
        } else if (feedback == 'L') {
            range[0] = guess + 1;
        }

        return generateGuess(range[0], range[1]);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] range = {1, 100};
        int guess = generateGuess(range[0], range[1]);

        while (true) {

            System.out.println("Computer Guess: " + guess);

            char feedback = getFeedback(scanner);

            if (feedback == 'C') {
                System.out.println("Computer guessed your number correctly!");
                break;
            }

            guess = getNextGuess(guess, feedback, range);
        }

        scanner.close();
    }
}
