// This is the basket class. The gardener will be able to put fruit in it, or
// take seedlings out to plant into the garden.
package edu.blackburn.cs.cs212sp16.rekart.garden;

/**
 *
 * @author braydon.rekart
 */
public class Basket {

    private int numberOfPickedPlants;
    private final Plant[] basketPlants;
    private int spotInBasket;
    private final int howMuchSpace;
    // This basket constructor constructs the basket with a size large enough
    // to hold all the plants.
    public Basket(int basketSize) {
        basketPlants = new Plant[basketSize];
        howMuchSpace = basketSize;
    }
    // This adds a plant to the basket.
    public void addToBasket(Plant plant) {
        for (int i = 0; i < howMuchSpace; i++) {
            basketPlants[i] = plant;
        }
    }
    // This views the basket by printing out the plants within.
    public void viewBasket() {
        for (int i = 0; i < basketPlants.length; i++) {
            if (basketPlants[i] != null) {
                System.out.println(basketPlants[i].getPlantType());
            }
        }
    }
}
