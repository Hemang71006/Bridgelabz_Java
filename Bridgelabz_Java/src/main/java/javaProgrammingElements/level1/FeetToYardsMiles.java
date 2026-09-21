package javaProgrammingElements.level1;

import java.util.Scanner;

public class FeetToYardsMiles {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in feet: ");
        double distanceInFeet = input.nextDouble();

        double yards = distanceInFeet / 3;
        double miles = yards / 1760;

        System.out.println("The distance in feet is " + distanceInFeet +
                ", in yards is " + yards +
                " and in miles is " + miles);

        input.close();
    }
}
