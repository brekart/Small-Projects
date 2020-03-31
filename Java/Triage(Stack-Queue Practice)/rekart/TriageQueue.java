/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.triage.rekart;

import edu.blackburn.cs.cs212sp16.er.*;

/**
 *
 * @author Braydon
 */
public class TriageQueue extends AbstractQueue {
// Has front/last, increment/decrement.

    private ListElement end = null;

    @Override
    public void enqueue(Patient ptnt) {
        increment();
        ListElement newElement = new ListElement(ptnt);
        newElement.setNext(end);
        end = newElement;

    }

    @Override
    public Patient dequeue() {
        decrement();
        if (this.end.getPatient() == null) {
            return null;
        }
        return this.end.getPatient();
    }

}
