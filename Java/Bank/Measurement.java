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
public class Measurement {

    // Fields.
    private final String unit;
    private final double value;

    // Constructor.
    public Measurement(String unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    // Returns the unit of measure.
    public String getUnit() {
        return this.unit;
    }

    // Returns the value measured.
    public double getValue() {
        return this.value;
    }

}
