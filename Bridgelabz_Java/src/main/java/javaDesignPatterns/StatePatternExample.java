package javaDesignPatterns;

/**
 * Problem: Create a State interface and implement NoCardState,
 * HasCardState, and AuthorizedState. Use ATMContext to change
 * the ATM's behavior according to its current state.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class StatePatternExample {

    // Define the behavior supported by each ATM state.
    interface State {
        void insertCard(ATMContext atm);
        void enterPin(ATMContext atm);
        void withdraw(ATMContext atm);
    }

    // Represent an ATM without an inserted card.
    static class NoCardState implements State {
        // Accept a card and move to the card-inserted state.
        public void insertCard(ATMContext atm) {
            System.out.println("Card inserted");
            atm.setState(new HasCardState());
        }

        // Reject PIN entry when no card is inserted.
        public void enterPin(ATMContext atm) {
            System.out.println("Please insert your card first");
        }

        // Reject withdrawal when no card is inserted.
        public void withdraw(ATMContext atm) {
            System.out.println("Please insert your card first");
        }
    }

    // Represent an ATM with a card but no PIN authorization.
    static class HasCardState implements State {
        // Reject another card insertion.
        public void insertCard(ATMContext atm) {
            System.out.println("Card is already inserted");
        }

        // Simulate successful PIN verification.
        public void enterPin(ATMContext atm) {
            System.out.println("PIN verified");
            atm.setState(new AuthorizedState());
        }

        // Require PIN authorization before withdrawal.
        public void withdraw(ATMContext atm) {
            System.out.println("Please enter your PIN first");
        }
    }

    // Represent an ATM with an authorized user.
    static class AuthorizedState implements State {
        // Prevent another card insertion during the session.
        public void insertCard(ATMContext atm) {
            System.out.println("Card is already inserted");
        }

        // Inform the user that authorization is already complete.
        public void enterPin(ATMContext atm) {
            System.out.println("User is already authorized");
        }

        // Allow withdrawal and return the ATM to its initial state.
        public void withdraw(ATMContext atm) {
            System.out.println("Cash withdrawn successfully");
            atm.setState(new NoCardState());
        }
    }

    // Maintain the current ATM state.
    static class ATMContext {
        private State state;

        // Start the ATM without an inserted card.
        public ATMContext() {
            state = new NoCardState();
        }

        // Change the current state.
        public void setState(State state) {
            this.state = state;
        }

        // Delegate card insertion to the current state.
        public void insertCard() {
            state.insertCard(this);
        }

        // Delegate PIN entry to the current state.
        public void enterPin() {
            state.enterPin(this);
        }

        // Delegate withdrawal to the current state.
        public void withdraw() {
            state.withdraw(this);
        }
    }

    // Test the State pattern.
    public static void main(String[] args) {
        // Create the ATM.
        ATMContext atm = new ATMContext();

        // Attempt withdrawal before inserting a card.
        atm.withdraw();

        // Insert the card and authorize the user.
        atm.insertCard();
        atm.enterPin();

        // Withdraw cash after authorization.
        atm.withdraw();

        // Attempt another withdrawal after the card session ends.
        atm.withdraw();
    }
}
