package javaLinkedList;

/**
 * Problem 8 (GCR — Doubly Linked List: Undo/Redo Functionality for Text Editor)
 * Design an undo/redo functionality for a text editor using a doubly linked list.
 * Each node stores a state of the text content.
 * Implement adding states, undo, redo, displaying the current state,
 * and limiting the history size.
 *
 * Author : Hemang
 * Date : 06-10-2026
 */

class TextNode {
    String text;

    TextNode next;
    TextNode prev;

    TextNode(String text) {
        this.text = text;
    }
}

public class TextEditorUndoRedo {

    TextNode current;

    // Add a new text state
    void addState(String text) {
        TextNode newNode = new TextNode(text);

        if (current == null) {
            current = newNode;
            return;
        }

        current.next = newNode;
        newNode.prev = current;
        current = newNode;
    }

    // Undo
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    // Redo
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    // Display current text
    void displayCurrent() {
        if (current != null) {
            System.out.println("Current Text: " + current.text);
        }
    }

    public static void main(String[] args) {

        TextEditorUndoRedo editor =
                new TextEditorUndoRedo();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");

        editor.displayCurrent();

        editor.undo();
        editor.displayCurrent();

        editor.undo();
        editor.displayCurrent();

        editor.redo();
        editor.displayCurrent();
    }
}
