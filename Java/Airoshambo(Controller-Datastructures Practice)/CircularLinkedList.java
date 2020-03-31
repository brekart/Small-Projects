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
public class CircularLinkedList {

    private Node head;
    private Node current;
    private Node tail;
    int size = 0;

    public CircularLinkedList() {
        current = null;
        head = null;
        tail = null;
    }

    public boolean checkEmpty() {
        return (tail == null);
    }
    public Round getNext() {
        Node temp = current.getNextNode();
        current = temp.getNextNode();
        return temp.getRound();
    }
    
    public void add(Round round) {
        // Dunno how to do this.
        if (checkEmpty()) {
            current = new Node(round);
            head = current;
            tail = current;
            tail.setNextNode(head);
        } else {
            Node tempNode = new Node(round);
            tail.setNextNode(tempNode);
            tail = tempNode;
            tail.setNextNode(head);
        }
    }

    public int getSize() {
        return size;
    }

    public Round getCurrent() {
        return current.getRound();
    }

    public void setCurrent(Node current) {
        this.current = current;
    }

}
