package javaLinkedList;

/**
 * Problem 7 (GCR — Singly Linked List: Social Media Friend Connections)
 * Create a system to manage social media friend connections using a singly linked list.
 * Each node stores User ID, Name, Age, and Friend IDs.
 * Implement adding, removing, finding mutual friends, displaying,
 * searching, and counting friends.
 *
 * Author : Hemang
 * Date : 06-10-2026
 */

class FriendNode {
    int userId;
    String name;
    int age;

    int[] friends;
    int friendCount;

    FriendNode next;

    FriendNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        friends = new int[10];
    }

    // Add friend ID
    void addFriend(int friendId) {
        friends[friendCount] = friendId;
        friendCount++;
    }

    // Remove friend ID
    void removeFriend(int friendId) {
        for (int i = 0; i < friendCount; i++) {
            if (friends[i] == friendId) {

                for (int j = i; j < friendCount - 1; j++) {
                    friends[j] = friends[j + 1];
                }

                friendCount--;
                return;
            }
        }
    }
}

public class SocialMediaFriends {

    FriendNode head;

    // Add user
    void addUser(int userId, String name, int age) {
        FriendNode newNode = new FriendNode(userId, name, age);

        if (head == null) {
            head = newNode;
            return;
        }

        FriendNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Find user by ID
    FriendNode findUser(int userId) {
        FriendNode current = head;

        while (current != null) {
            if (current.userId == userId) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    // Add friendship
    void addFriendConnection(int user1, int user2) {
        FriendNode first = findUser(user1);
        FriendNode second = findUser(user2);

        if (first != null && second != null) {
            first.addFriend(user2);
            second.addFriend(user1);
        }
    }

    // Remove friendship
    void removeFriendConnection(int user1, int user2) {
        FriendNode first = findUser(user1);
        FriendNode second = findUser(user2);

        if (first != null && second != null) {
            first.removeFriend(user2);
            second.removeFriend(user1);
        }
    }

    // Display friends of a user
    void displayFriends(int userId) {
        FriendNode user = findUser(userId);

        if (user == null) {
            return;
        }

        System.out.println("Friends of " + user.name + ":");

        for (int i = 0; i < user.friendCount; i++) {
            System.out.println(user.friends[i]);
        }
    }

    // Count friends
    void countFriends(int userId) {
        FriendNode user = findUser(userId);

        if (user != null) {
            System.out.println("Friend Count: " + user.friendCount);
        }
    }

    // Find mutual friends
    void findMutualFriends(int user1, int user2) {
        FriendNode first = findUser(user1);
        FriendNode second = findUser(user2);

        if (first == null || second == null) {
            return;
        }

        System.out.println("Mutual Friends:");

        for (int i = 0; i < first.friendCount; i++) {
            for (int j = 0; j < second.friendCount; j++) {

                if (first.friends[i] == second.friends[j]) {
                    System.out.println(first.friends[i]);
                }
            }
        }
    }

    public static void main(String[] args) {

        SocialMediaFriends socialMedia =
                new SocialMediaFriends();

        socialMedia.addUser(1, "Hemang", 21);
        socialMedia.addUser(2, "Rahul", 21);
        socialMedia.addUser(3, "Aman", 22);

        socialMedia.addFriendConnection(1, 2);
        socialMedia.addFriendConnection(1, 3);

        socialMedia.displayFriends(1);

        socialMedia.countFriends(1);

        socialMedia.findMutualFriends(1, 2);

        socialMedia.removeFriendConnection(1, 2);
    }
}
