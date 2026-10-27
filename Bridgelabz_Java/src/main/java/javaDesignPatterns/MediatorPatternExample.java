package javaDesignPatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Create a ChatMediator interface, ChatRoom class, and User class.
 * Send messages between users through the mediator.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class MediatorPatternExample {

    // Define the operations provided by the mediator.
    interface ChatMediator {
        void sendMessage(String message, User sender);
        void addUser(User user);
    }

    // Manage users and distribute chat messages.
    static class ChatRoom implements ChatMediator {
        private List<User> users = new ArrayList<>();

        // Add a user to the chat room.
        public void addUser(User user) {
            users.add(user);
        }

        // Send a message to every user except the sender.
        public void sendMessage(String message, User sender) {
            for (User user : users) {
                if (user != sender) {
                    user.receive(message, sender.name);
                }
            }
        }
    }

    // Represent a user in the chat room.
    static class User {
        private String name;
        private ChatMediator mediator;

        // Connect the user to the mediator.
        public User(String name, ChatMediator mediator) {
            this.name = name;
            this.mediator = mediator;
        }

        // Send a message through the mediator.
        public void send(String message) {
            System.out.println(name + " sends: " + message);
            mediator.sendMessage(message, this);
        }

        // Display a message received from another user.
        public void receive(String message, String sender) {
            System.out.println(name + " receives from " + sender + ": " + message);
        }
    }

    // Test the Mediator pattern.
    public static void main(String[] args) {
        // Create the chat room.
        ChatMediator chatRoom = new ChatRoom();

        // Create users connected to the chat room.
        User amit = new User("Amit", chatRoom);
        User priya = new User("Priya", chatRoom);
        User rahul = new User("Rahul", chatRoom);

        // Register users with the mediator.
        chatRoom.addUser(amit);
        chatRoom.addUser(priya);
        chatRoom.addUser(rahul);

        // Send a message through the chat room.
        amit.send("Hello everyone!");
    }
}
