/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.roshambo.rekart;

import java.util.Random;

/**
 *
 * @author Braydon
 */
public class AIPlayer {

    private int whatWeapon;

    public int aiTurn() {
        Random rand = new Random();
        int x = rand.nextInt(3);

        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (x == 2) {
            return 2;
        }
        return -1;
    }
}
