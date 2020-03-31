// This is the menu. It will handle input and output. Started at 6:00pm on 1/25.
package edu.blackburn.cs.cs212sp16.rekart.garden;

import java.util.Scanner;

/**
 *
 * @author braydon.rekart
 */
public class Menu {
    // This is the main class. It asks the user for input and also handles all
    // the method calling and such.
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Gardener 4000!");
        System.out.println("How many spaces are in your garden?");
        int gardenSize = in.nextInt();
        Garden garden = new Garden(gardenSize);
        // This handles the day.
        for (int day = 1; day < 100000; day++) {
            System.out.println("Day " + day + ": What would you like to do?");
            System.out.println("1: See garden");
            System.out.println("2: Plant seedlings");
            int userInput = in.nextInt();
            if (userInput == 1) {
                garden.viewGarden();
            }
            if (userInput == 2) {
                System.out.println("Choose a seedling to plant:");
                System.out.println("1. Tomato");
                System.out.println("2. Pineapple");
                System.out.println("3. Raspberry");
                System.out.println("4. Cucumber");
                int plantedSeedling = in.nextInt();
                System.out.println("Where in the garden do you want to plant it?");
                System.out.println("(Enter a number between 1 and "
                        + gardenSize + ")");
                int whereInGarden = in.nextInt() - 1;
                if (plantedSeedling == 1) {
                    garden.plantSeedling(plantedSeedling, whereInGarden);
                }
                if (plantedSeedling == 2) {
                    garden.plantSeedling(plantedSeedling, whereInGarden);
                }
                if (plantedSeedling == 3) {
                    garden.plantSeedling(plantedSeedling, whereInGarden);
                }
                if (plantedSeedling == 4) {
                    garden.plantSeedling(plantedSeedling, whereInGarden);
                }
            }
            garden.newDay();
        }
    }
}
