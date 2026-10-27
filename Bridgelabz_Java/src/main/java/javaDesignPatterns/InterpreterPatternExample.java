package javaDesignPatterns;

/**
 * Problem: Create an Expression interface with AddExpression and
 * SubExpression implementations. Interpret a simple expression
 * using the expression objects.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class InterpreterPatternExample {

    // Define the common expression interpretation method.
    interface Expression {
        int interpret();
    }

    // Represent a numeric value.
    static class NumberExpression implements Expression {
        private int number;

        // Store the number to be interpreted.
        public NumberExpression(int number) {
            this.number = number;
        }

        // Return the stored numeric value.
        public int interpret() {
            return number;
        }
    }

    // Represent an addition expression.
    static class AddExpression implements Expression {
        private Expression left;
        private Expression right;

        // Store the two expressions to be added.
        public AddExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        // Evaluate both expressions and add their values.
        public int interpret() {
            return left.interpret() + right.interpret();
        }
    }

    // Represent a subtraction expression.
    static class SubExpression implements Expression {
        private Expression left;
        private Expression right;

        // Store the two expressions to be subtracted.
        public SubExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        // Evaluate both expressions and subtract the right value.
        public int interpret() {
            return left.interpret() - right.interpret();
        }
    }

    // Test the Interpreter pattern.
    public static void main(String[] args) {
        // Create the expression 10 + 5.
        Expression addition = new AddExpression(
                new NumberExpression(10),
                new NumberExpression(5)
        );

        // Create the expression 20 - 8.
        Expression subtraction = new SubExpression(
                new NumberExpression(20),
                new NumberExpression(8)
        );

        // Interpret and display both expressions.
        System.out.println("10 + 5 = " + addition.interpret());
        System.out.println("20 - 8 = " + subtraction.interpret());

        // Combine expressions to evaluate (10 + 5) - 8.
        Expression combined = new SubExpression(
                addition,
                new NumberExpression(8)
        );

        // Display the combined expression's result.
        System.out.println("(10 + 5) - 8 = " + combined.interpret());
    }
}
