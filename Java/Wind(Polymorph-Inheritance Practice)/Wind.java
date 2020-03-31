/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.wind;

import java.util.Random;

/**
 *
 * @author braydon.rekart
 */
public class Wind {

    private double windsSpeed;
    private String windDirection;

    public Wind() {
        double windSpeedTest;
        String windDirection = "";
        int windDirectionInt = (int) (Math.random() * 4 + 1);
        if (windDirectionInt == 1) {
            windDirection = "North";
        }
        if (windDirectionInt == 2) {
            windDirection = "South";
        }
        if (windDirectionInt == 3) {
            windDirection = "East";
        }
        if (windDirectionInt == 4) {
            windDirection = "West";
        }
        this.windDirection = windDirection;

        Random windSpeed = new Random();
        double minimum = -20.0;
        double maximum = 20.0;
        double temp = minimum + (maximum - minimum) * windSpeed.nextDouble();
        this.windsSpeed = temp;
    }

    public double getWindSpeed() {
        return this.windsSpeed;
    }

    public String getWindDirection() {
        return this.windDirection;
    }

    // public Wind(Measurement speed) {
    //      this.speed = speed;
    // }
    @Override
    public String toString() {
        return Math.round(windsSpeed) + " kph " + windDirection;
    }

}
