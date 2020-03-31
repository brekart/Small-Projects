/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.bank2;

/**
 *
 * @author joshua.gross
 */
public class Percentage extends Measurement {

    // Constructor.
    public Percentage(String unit, double value) {
        super(unit, value);
    }

    // Overrides toString.
    @Override
    public String toString() {
        return "" + this.getValue() + this.getUnit();
    }

}
