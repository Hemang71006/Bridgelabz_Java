package javaMethods.level2;

import java.util.Scanner;

/**
 * Problem 8 (GCR — Java Methods Level 2 Assignment)
 * Find the youngest and tallest among Amar, Akbar,
 * and Anthony using their ages and heights.
 *
 * Author : Hemang
 * Date : 23-09-2026
 */
public class YoungestTallestFriend {

    // Method to find the youngest friend
    public static int findYoungest(int[] ages) {
        int youngestIndex = 0;

        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }

        return youngestIndex;
    }

    // Method to find the tallest friend
    public static int findTallest(double[] heights) {
        int tallestIndex = 0;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        return tallestIndex;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Store friend names
        String[] names = {"Amar", "Akbar", "Anthony"};

        // Create arrays for ages and heights
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Take age and height input
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = input.nextInt();

            System.out.print("Enter height of " + names[i] + ": ");
            heights[i] = input.nextDouble();
        }

        // Find youngest and tallest
        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);

        // Display results
        System.out.println("Youngest: " + names[youngestIndex]);
        System.out.println("Tallest: " + names[tallestIndex]);

        input.close();
    }
}
