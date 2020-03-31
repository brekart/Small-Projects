/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.airoshambo;

/**
 *
 * @author Braydon
 */
public class Stats {

    private double p1Wins;
    private double p2Wins;
    private double ties = 0;
    private double gamesPlayed = 1;
    private boolean over = false;

    public void end() {
        over = true;
    }

    public void recordRound(Round round) {
        if (round.getWinner() == Winner.P1) {
            p1Wins++;
        } else if (round.getWinner() == Winner.P2) {
            p2Wins++;
        } else {
            ties++;
        }
        gamesPlayed++;
    }

    public boolean isOver() {
        return over;
    }

    public double getP1Wins() {
        return p1Wins;
    }

    public void addP1Win() {
        p1Wins++;
    }

    public double getGamesPlayed() {
        return gamesPlayed;
    }

    public void addGamePlayed() {
        gamesPlayed++;
    }

    public double getP2Wins() {
        return p2Wins;
    }

    public void addAiWin() {
        p2Wins++;
    }

    public void addTie() {
        ties++;
    }

    public double getTies() {
        return ties;
    }

}
