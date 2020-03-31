/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package edu.blackburn.cs.cs212sp16.rekart.garden;

/**
 *
 * @author braydon.rekart
 */
public class Fruit {

    private String fruitType;

    public Fruit(int fruitGrown) {
        if (fruitGrown == 1) {
            fruitType = "Tomato";
        }
        if (fruitGrown == 2) {
            fruitType = "Pineapple";
        }
        if (fruitGrown == 3) {
            fruitType = "Raspberry";
        }
        if (fruitGrown == 4) {
            fruitType = "Cucumber";
        }
    }

}
