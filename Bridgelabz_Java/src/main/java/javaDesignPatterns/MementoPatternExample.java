package javaDesignPatterns;

/**
 * Problem: Create an Editor originator, a Memento to store editor state,
 * and a Caretaker to save and restore the editor's previous state.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class MementoPatternExample {

    // Store a saved copy of the editor's text.
    static class Memento {
        private final String text;

        // Save the text state.
        public Memento(String text) {
            this.text = text;
        }

        // Return the saved text.
        public String getText() {
            return text;
        }
    }

    // Represent the object whose state can be saved and restored.
    static class Editor {
        private String text = "";

        // Update the editor's current text.
        public void setText(String text) {
            this.text = text;
        }

        // Display the current editor text.
        public void display() {
            System.out.println("Editor text: " + text);
        }

        // Save the current state in a Memento.
        public Memento save() {
            return new Memento(text);
        }

        // Restore a previously saved state.
        public void restore(Memento memento) {
            text = memento.getText();
        }
    }

    // Manage saved editor states.
    static class Caretaker {
        private Memento savedState;

        // Store the editor's saved state.
        public void saveState(Editor editor) {
            savedState = editor.save();
        }

        // Restore the previously saved state.
        public void restoreState(Editor editor) {
            if (savedState != null) {
                editor.restore(savedState);
            }
        }
    }

    // Test the Memento pattern.
    public static void main(String[] args) {
        // Create the editor and caretaker.
        Editor editor = new Editor();
        Caretaker caretaker = new Caretaker();

        // Write the initial text.
        editor.setText("Hello Java");
        editor.display();

        // Save the initial state.
        caretaker.saveState(editor);

        // Change the text.
        editor.setText("Hello Design Patterns");
        editor.display();

        // Restore the saved text.
        caretaker.restoreState(editor);
        editor.display();
    }
}
