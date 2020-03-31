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
public class Node {

    Round round;
    Node nextNode;

    public Node(Round round) {
        this.round = round;
        this.setNextNode(null);
    }

    public Round getRound() {
        return round;
    }

    public void setGame(Round round) {
        this.round = round;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setNextNodeRound(Round round) {
        this.nextNode.round = round;
    }

}
