/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.airoshambo;

/**
 *
 * @author braydon.rekart
 */
public abstract class Player {

    abstract Move Move();

    public abstract void addResult(Round round);
    
    protected Move choice;

    public Move getChoice() {
        return choice;
    }

    public void setChoice(Move choice) {
        this.choice = choice;
    }
}
