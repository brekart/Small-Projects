/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.airoshambo;

import java.util.Random;

/**
 *
 * @author Braydon
 */
public class AIPlayer extends Player {

    CircularLinkedList CL = new CircularLinkedList();

    @Override
    public Move Move() {
        Random rand = new Random();
        int x = rand.nextInt(3);

        if (x == 0) {
            setChoice(Move.ROCK);
            return Move.ROCK;
        } else if (x == 1) {
            setChoice(Move.PAPER);
            return Move.PAPER;
        } else if (x == 2) {
            setChoice(Move.SCISSORS);
            return Move.SCISSORS;
        }
        return null;
    }

    @Override
    public void addResult(Round round) {
        CL.add(round);
    }
}
