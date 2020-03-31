/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.wind;
// Measurement class. It's what we use to measure the amount and type of stuff.
/**
 *
 * @author braydon.rekart
 */
public class Measurement {

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    private String unit;
    private double value;

    public Measurement(double value, String unit) {
        this.unit = unit;
        this.value = value;
    }
  
    @Override
    public String toString() {
        return value + " " + unit;
    }

}
