package javaLinkedList;

/**
 * Problem 3 (GCR — Circular Linked List: Task Scheduler)
 * Create a task scheduler using a circular linked list.
 * Each node stores Task ID, Task Name, Priority, and Due Date.
 * Implement adding, removing, viewing, displaying, and searching tasks.
 *
 * Author : Hemang
 * Date : 06-10-2026
 */

class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;

    TaskNode next;

    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

public class TaskScheduler {

    TaskNode head;

    // Add task at beginning
    void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        TaskNode current = head;

        while (current.next != head) {
            current = current.next;
        }

        newNode.next = head;
        current.next = newNode;
        head = newNode;
    }

    // Add task at end
    void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        TaskNode current = head;

        while (current.next != head) {
            current = current.next;
        }

        current.next = newNode;
        newNode.next = head;
    }

    // Add task at a specific position
    void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        if (head == null) {
            System.out.println("Invalid position");
            return;
        }

        TaskNode current = head;

        for (int i = 1; i < position - 1; i++) {
            current = current.next;

            if (current == head) {
                System.out.println("Invalid position");
                return;
            }
        }

        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);

        newNode.next = current.next;
        current.next = newNode;
    }

    // Remove task by task ID
    void removeById(int taskId) {
        if (head == null) {
            return;
        }

        TaskNode current = head;
        TaskNode previous = null;

        do {
            if (current.taskId == taskId) {

                if (current == head) {
                    TaskNode last = head;

                    while (last.next != head) {
                        last = last.next;
                    }

                    if (head.next == head) {
                        head = null;
                    } else {
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    previous.next = current.next;
                }

                return;
            }

            previous = current;
            current = current.next;

        } while (current != head);
    }

    // View current task
    void viewCurrentTask() {
        if (head != null) {
            System.out.println("Current Task: " + head.taskName);
        }
    }

    // Move to next task
    void moveNext() {
        if (head != null) {
            head = head.next;
        }
    }

    // Display all tasks
    void display() {
        if (head == null) {
            return;
        }

        TaskNode current = head;

        do {
            System.out.println(
                    current.taskId + " " +
                            current.taskName + " " +
                            current.priority + " " +
                            current.dueDate
            );

            current = current.next;

        } while (current != head);
    }

    // Search task by priority
    void searchByPriority(int priority) {
        if (head == null) {
            return;
        }

        TaskNode current = head;

        do {
            if (current.priority == priority) {
                System.out.println("Task found: " + current.taskName);
            }

            current = current.next;

        } while (current != head);
    }

    public static void main(String[] args) {

        TaskScheduler list = new TaskScheduler();

        list.addAtBeginning(101, "Study Java", 1, "06-10-2026");
        list.addAtEnd(102, "Practice DSA", 2, "07-10-2026");
        list.addAtPosition(2, 103, "Practice LinkedList", 1, "08-10-2026");

        System.out.println("Tasks:");
        list.display();

        list.viewCurrentTask();

        list.moveNext();

        list.viewCurrentTask();

        list.searchByPriority(1);

        list.removeById(102);
    }
}
