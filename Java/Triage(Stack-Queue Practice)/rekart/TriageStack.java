/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.triage.rekart;

import edu.blackburn.cs.cs212sp16.er.*;

/**
 *
 * @author arthur.levan
 */
public class TriageStack extends AbstractStack {

    private ListElement top = null;

    @Override
    public void push(Patient ptnt) {
        this.top = new ListElement(ptnt);
        this.top.setNext(top);
        increment();
    }

    @Override
    public Patient pop() {
        decrement();
        if(this.top.getPatient() == null){
            return null;
        }
        return this.top.getPatient();
    }

}
