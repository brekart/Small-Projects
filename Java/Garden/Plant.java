package edu.blackburn.cs.cs212sp16.rekart.garden;
// This is the plant class. It's a plant you plant in the garden.
/**
 *
 * @author braydon.rekart
 */
public class Plant {

    private int howOld;
    private String plantType;
    private boolean hasFruit = false;

    public Plant(int plantTypeInput) {
        if (plantTypeInput == 1) {
            plantType = "Tomato Plant";
        }
        if (plantTypeInput == 2) {
            plantType = "Pineapple Plant";
        }
        if (plantTypeInput == 3) {
            plantType = "Raspberry Plant";
        }
        if (plantTypeInput == 4) {
            plantType = "Cucumber Plant";
        }
    }
    // This increments how old the plant is.
    public void addDay() {
        howOld++;
    }
    // This gets the age of the plant.
    public int howOld() {
        return howOld;
    }
    // This gets the plant type.
    public String getPlantType() {
        return plantType;
    }
    // This sets the fruit grown boolean to true.
    public void growFruit() {
        hasFruit = true;
    }
}
