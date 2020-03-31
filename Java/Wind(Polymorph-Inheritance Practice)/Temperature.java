/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.wind;
// Temperature class. This is where we'll define and use Celcius.
/**
 *
 * @author braydon.rekart
 */
public class Temperature extends Measurement{


    public Temperature(double value) {
        super(value , "C");
    }
    public double getTemperature() {
    return this.getValue();
}
    public double setTemperature(double newTemp) {
       this.setValue(newTemp);
       return this.getValue();
    }
    @Override
    public String toString() {
        return Math.round(this.getValue()) + " " + this.getUnit();
    }

}
