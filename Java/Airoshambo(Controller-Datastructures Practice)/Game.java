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
public class Game {

    private Stats stats = new Stats();
    private Player p1;
    private Player p2;
    private int rounds;
    private boolean over = false;
    private int roundsPlayed = 0;

    public Game(Player p1, Player p2, int rounds) {
        this.p1 = p1;
        this.p2 = p2;
        this.rounds = rounds;
    }
    public Stats getStats() {
        return stats;
    }

    public void run() {

        if (roundsPlayed < rounds) {
            Move p1move = p1.Move();
            Move p2move = p2.Move();
            Round tempRound = new Round(p1move, p2move);
            Winner winner = tempRound.getWinner();
            p1.addResult(tempRound);
            p2.addResult(tempRound);
            stats.recordRound(tempRound);
            roundsPlayed++;
        }

    }
}
