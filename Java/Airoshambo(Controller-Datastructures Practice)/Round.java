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
public class Round {

    Move p1move;
    Move p2move;

    public Round(Move p1, Move p2) {
        this.p1move = p1;
        this.p2move = p2;
    }

    public Winner getWinner() {
        if (p1move == Move.ROCK) {
            if (p2move == Move.ROCK) {
                return Winner.TIE;
            } else if (p2move == Move.PAPER) {
                return Winner.P2;
            } else if (p2move == Move.SCISSORS) {
                return Winner.P1;
            }
        } else if (p1move == Move.PAPER) {
            if (p2move == Move.ROCK) {
                return Winner.P1;
            } else if (p2move == Move.PAPER) {
                return Winner.TIE;
            } else if (p2move == Move.SCISSORS) {
                return Winner.P2;
            }
        } else if (p1move == Move.SCISSORS) {
            if (p2move == Move.ROCK) {
                return Winner.P2;
            } else if (p2move == Move.PAPER) {
                return Winner.P1;
            } else if (p2move == Move.SCISSORS) {
                return Winner.TIE;
            }
        }
        return null;
    }
}
