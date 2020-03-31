// This is the seedling. It's the beginning stage of the plant.
package edu.blackburn.cs.cs212sp16.rekart.garden;

/**
 *
 * @author braydon.rekart
 */
public class Seedling {

    private int howOld = 1;
    private int size = 0;
    private String seedlingType;
    private int seedlingTypeInput;
    // This seedling constructor uses the type to construct one.
    public Seedling(int seedlingTypeInput) {
        if (seedlingTypeInput == 1) {
            seedlingType = "Tomato Seedling";
            this.seedlingTypeInput = 1;
        }
        if (seedlingTypeInput == 2) {
            seedlingType = "Pineapple Seedling";
            this.seedlingTypeInput = 2;
        }
        if (seedlingTypeInput == 3) {
            seedlingType = "Raspberry Seedling";
            this.seedlingTypeInput = 3;
        }
        if (seedlingTypeInput == 4) {
            seedlingType = "Cucumber Seedling";
            this.seedlingTypeInput = 4;
        }
    }
    // This sets how far grown the seedling is.
    public void setSeedlingSize(int seedlingSize) {
        size = seedlingSize;
    }
    // This gets the seedling size.
    public int getSeedlingSize(Seedling seedling) {
        return size;
    }
    // This changes the seedling to a plant when it's grown.
    public Plant whenGrown() {
        Plant grownPlant = new Plant(seedlingTypeInput);
        Fruit newFruit = new Fruit(seedlingTypeInput);   
        return grownPlant;
    }
    // This adds a day to the day count.
    public void addDay(Garden garden) {
        howOld++;
        if (howOld % 30 == 0) {
            garden.replaceSeedling(this);
        }
    }
    // This checks how old the plant is.
    public int howOld() {
        return howOld;
    }
    // This gets the seedling type.
    public String getSeedlingType() {
        return seedlingType;
    }
}
