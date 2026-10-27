package javaDesignPatterns;

import java.util.Arrays;
import java.util.List;

/**
 * Problem: Create a NameRepository that stores names in a list
 * and provides a custom Iterator to traverse the collection.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class IteratorPatternExample {

    // Define the operations supported by the custom iterator.
    interface NameIterator {
        boolean hasNext();
        String next();
    }

    // Store names and provide an iterator for traversal.
    static class NameRepository {
        private List<String> names = Arrays.asList(
                "Amit", "Priya", "Rahul", "Sneha"
        );

        // Return a custom iterator for the names.
        public NameIterator getIterator() {
            return new NameIterator() {
                private int index = 0;

                // Check whether another name is available.
                public boolean hasNext() {
                    return index < names.size();
                }

                // Return the next name and move the index forward.
                public String next() {
                    if (hasNext()) {
                        return names.get(index++);
                    }

                    // Return null when there are no more names.
                    return null;
                }
            };
        }
    }

    // Test the Iterator pattern.
    public static void main(String[] args) {
        // Create the repository.
        NameRepository repository = new NameRepository();

        // Get the custom iterator.
        NameIterator iterator = repository.getIterator();

        // Traverse and print every name.
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
