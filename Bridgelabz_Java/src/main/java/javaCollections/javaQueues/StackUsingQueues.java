package javaCollections.javaQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 4 (Collections - Implement a Stack Using Queues)
 * Implement push, pop, and top operations using two queues.
 *
 * Author : Hemang
 * Date   : 13-10-2026
 */

public class StackUsingQueues {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    // Push an element onto the stack
    void push(int value) {

        // Add the new element to the second queue
        queue2.add(value);

        // Move existing elements behind the new element
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        // Swap the two queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Remove the top element
    int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return queue1.remove();
    }

    // Return the top element without removing it
    int top() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return queue1.peek();
    }

    public static void main(String[] args) {

        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top Element: " + stack.top());
        System.out.println("Popped Element: " + stack.pop());
        System.out.println("Top After Pop: " + stack.top());
    }
}
