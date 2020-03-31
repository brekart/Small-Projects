// This is the garden class. Plants and seedlings will be planted here.
package edu.blackburn.cs.cs212sp16.rekart.garden;

/**
 *
 * @author braydon.rekart
 */
public class Garden {

    private final Plant[] GardenPlants;
    private final Seedling[] GardenSeedlings;
    // This constructs a garden with the size given by the user.
    public Garden(int gardenSize) {
        GardenPlants = new Plant[gardenSize];
        GardenSeedlings = new Seedling[gardenSize];
    }
    // This method plants the seedling in the garden by taking the type and 
    // location.
    public void plantSeedling(int seedlingType, int whereInGarden) {
        if (GardenSeedlings[whereInGarden] == null
                && GardenPlants[whereInGarden] == null) {
            Seedling newSeedling = new Seedling(seedlingType);
            GardenSeedlings[whereInGarden] = newSeedling;
        } else {
            System.out.println("There is already a plant in this spot. You"
                    + " lose motivation for the day.");
        }
    }
    // This replaces the seedling with a plant.
    public void replaceSeedling(Seedling seedling) {
        for (int i = 0; i < GardenSeedlings.length; i++) {
            if (GardenSeedlings[i] == seedling) {
                GardenPlants[i] = GardenSeedlings[i].whenGrown();
                GardenSeedlings[i] = null;
            }
        }

    }
    // This prints out the garden with current plants.
    public void viewGarden() {
        boolean hasSomething = false;
        for (int i = 0; i < GardenPlants.length; i++) {
            if (GardenPlants[i] != null) {
                hasSomething = true;
                System.out.println(GardenPlants[i].getPlantType());
            }
        }
        for (int i = 0; i < GardenSeedlings.length; i++) {
            if (GardenSeedlings[i] != null) {
                hasSomething = true;
                System.out.println(GardenSeedlings[i].getSeedlingType());
            }
        }
        if (!hasSomething) {
            System.out.println("You have nothing in your garden.");
        }
    }
    // This uses the two methods to print out the garden.
    public void printGarden() {
        viewGardenSeedlings();
        viewGardenPlants();
    }
    // This adds a new day to the garden.
    public void newDay() {
        for (int i = 0; i < GardenSeedlings.length; i++) {
            if (GardenSeedlings[i] != null) {
                GardenSeedlings[i].addDay(this);
            }

        }
        for (int i = 0; i < GardenPlants.length; i++) {
            if (GardenPlants[i] != null) {
                GardenPlants[i].addDay();
            }
        }
    }

    // The following two methods are addons to the main viewGarden method.
    // Do not call these in Menu, call viewGarden. Call these in viewGarden.
    public int viewGardenSeedlings() {
        int numSeedlings = 0;
        for (int i = 0; i < GardenSeedlings.length; i++) {
            if (GardenSeedlings[i] != null) {
                numSeedlings++;
            }
        }
        return numSeedlings;
    }
 
    public int viewGardenPlants() {
        int numPlants = 0;
        for (int i = 0; i < GardenPlants.length; i++) {
            if (GardenPlants[i] != null) {
                numPlants++;
            }
        }
        return numPlants;
    }
}
