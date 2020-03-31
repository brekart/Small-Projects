/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.roshambo.rekart;

/**
 *
 * @author Braydon
 */
public class Stats {
    private int humanWins;
    private int aiWins;
    private int ties = 0;
    private int gamesPlayed = 1;

    public int getHumanWins() {
        return humanWins;
    }

    public void addHumanWin() {
        humanWins++;
    }

   public int getGamesPlayed() {
       return gamesPlayed;
   }
   public void addGamePlayed() {
       gamesPlayed++;
   }
    public int getAiWins() {
        return aiWins;
    }

    public void addAiWin() {
        aiWins++;
    }
    public void addTie() {
        ties++;
    }
    public int getTies() {
        return ties;
    }
    
}
