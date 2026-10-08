package javaLinkedList;

/**
 * Problem 6 (GCR — Circular Linked List: Round Robin Scheduling Algorithm)
 * Implement a round-robin CPU scheduling algorithm using a circular linked list.
 * Each node stores Process ID, Burst Time, and Priority.
 * Implement adding, removing, scheduling, displaying,
 * and calculating average waiting and turn-around time.
 *
 * Author : Hemang
 * Date : 06-10-2026
 */

class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    ProcessNode next;

    ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

public class RoundRobinScheduling {

    ProcessNode head;

    // Add process at the end
    void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode =
                new ProcessNode(processId, burstTime, priority);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        ProcessNode current = head;

        while (current.next != head) {
            current = current.next;
        }

        current.next = newNode;
        newNode.next = head;
    }

    // Remove process by ID
    void removeProcess(int processId) {
        if (head == null) {
            return;
        }

        ProcessNode current = head;
        ProcessNode previous = null;

        do {
            if (current.processId == processId) {

                if (current == head) {
                    ProcessNode last = head;

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

    // Display circular list
    void display() {
        if (head == null) {
            return;
        }

        ProcessNode current = head;

        do {
            System.out.println(
                    "P" + current.processId +
                            " Burst: " + current.burstTime +
                            " Priority: " + current.priority
            );

            current = current.next;

        } while (current != head);
    }

    // Calculate average waiting and turnaround time
    void calculateTimes(int quantum) {
        if (head == null) {
            return;
        }

        ProcessNode current = head;
        int waitingTime = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int processCount = 0;

        do {
            totalWaitingTime += waitingTime;
            waitingTime += current.burstTime;
            totalTurnaroundTime += waitingTime;

            processCount++;
            current = current.next;

        } while (current != head);

        System.out.println(
                "Average Waiting Time: " +
                        (double) totalWaitingTime / processCount
        );

        System.out.println(
                "Average Turnaround Time: " +
                        (double) totalTurnaroundTime / processCount
        );
    }

    public static void main(String[] args) {

        RoundRobinScheduling scheduler =
                new RoundRobinScheduling();

        scheduler.addProcess(1, 5, 1);
        scheduler.addProcess(2, 3, 2);
        scheduler.addProcess(3, 4, 1);

        System.out.println("Processes:");
        scheduler.display();

        scheduler.calculateTimes(2);

        scheduler.removeProcess(2);
    }
}
