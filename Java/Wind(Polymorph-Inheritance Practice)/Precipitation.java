/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.wind;
// Precipitation class. It's rain/snow.
import java.util.Random;

/**
 *
 * @author braydon.rekart
 */
public class Precipitation {
    
    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    private double level;
    private String rainSnowNone;
    public Precipitation(double temperature) {
// This creates how much precipitation and sets its level.
        Random howMuchPrecip = new Random();
        int maximum = 10;
        int temp = howMuchPrecip.nextInt(maximum);
        this.level = temp;
        
        if (temperature > 20) {
            this.level = temp;
            this.rainSnowNone = "None";
        }
        if (temperature < 20) {
            this.level = temp;
            this.rainSnowNone = "Rain";
        }
        if (temperature < 0) {
            this.level = temp;
            this.rainSnowNone = "Snow";
        }
    }
    
    @Override
    public String toString() {
        return Math.round(this.level) + " cm " + rainSnowNone;
    }

}
