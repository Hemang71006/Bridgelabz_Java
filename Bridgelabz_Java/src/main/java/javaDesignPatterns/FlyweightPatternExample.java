package javaDesignPatterns;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Create a shared Font class and a FontFactory that reuses fonts.
 * Create Character objects with individual positions and shared Font objects.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class FlyweightPatternExample {

    // Store the shared font information.
    static class Font {
        private String name;
        private int size;

        // Initialize the font details.
        public Font(String name, int size) {
            this.name = name;
            this.size = size;
        }

        // Display the character using this font.
        public void display(char character, int position) {
            System.out.println("Character: " + character
                    + ", Font: " + name
                    + ", Size: " + size
                    + ", Position: " + position);
        }
    }

    // Reuse font objects instead of creating duplicates.
    static class FontFactory {
        private static final Map<String, Font> fonts = new HashMap<>();

        // Return an existing font or create it when missing.
        public static Font getFont(String name, int size) {
            String key = name + "-" + size;

            // Reuse the font if it already exists.
            if (!fonts.containsKey(key)) {
                fonts.put(key, new Font(name, size));
            }

            // Return the shared font object.
            return fonts.get(key);
        }
    }

    // Store character-specific information.
    static class CharacterData {
        private char character;
        private int position;
        private Font font;

        // Combine a character and position with a shared font.
        public CharacterData(char character, int position, Font font) {
            this.character = character;
            this.position = position;
            this.font = font;
        }

        // Display this character using its shared font.
        public void display() {
            font.display(character, position);
        }
    }

    // Test the Flyweight pattern.
    public static void main(String[] args) {
        // Get the same shared font for multiple characters.
        Font font1 = FontFactory.getFont("Arial", 12);
        Font font2 = FontFactory.getFont("Arial", 12);

        // Create characters with different positions.
        CharacterData first = new CharacterData('H', 1, font1);
        CharacterData second = new CharacterData('i', 2, font2);

        // Display both characters.
        first.display();
        second.display();

        // Verify that both characters share the same font object.
        System.out.println("Same font object: " + (font1 == font2));
    }
}
