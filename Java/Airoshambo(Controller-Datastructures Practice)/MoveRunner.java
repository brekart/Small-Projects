/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.airoshambo;

/**
 *
 * @author joshua.gross
 */
public class MoveRunner {

    public static void main(String[] args) {
        Move mr = Move.ROCK;
        Move mp = Move.PAPER;
        // Here he shows us that moves of same type but different names are equal?
        Move ms = Move.SCISSORS;
        Move ms2 = Move.SCISSORS;
        if (!mr.equals(mp)) {
            System.out.println(mr + " is not equal to "  + mp);
        }
        
        if (ms != ms2) {
            System.out.println(ms + "!=" + ms2); 
        }
    }

}
