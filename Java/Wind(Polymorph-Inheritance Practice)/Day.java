/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.wind;

import java.util.Random;
// Day class. This is where the magic happens.
/**
 *
 * @author braydon.rekart
 */
public class Day {

    // Fields begin.
    private Temperature morningTemp;
    private Temperature midDayTemp;
    private final int whichDay;

    public Day(int whichDay) {
        this.whichDay = whichDay;
    }

    public static int getRandomInt(int min, int max) {
        int range = max - min;
        return (int) (Math.random() * (range + 1)) + min;
    }

    // Main begins.

    public void beginDay() {
        // This random double will be the morning temperature of day one.
        double temp = getRandomInt(-20, 20);
        Temperature dayOneMorningTemp = new Temperature(temp);
        Temperature midDayTemp = new Temperature(temp);
        Cloud dayOneCloud = new Cloud(0.0);
        Wind dayOneWind = new Wind();
        Precipitation dayOnePrecip = new Precipitation(midDayTemp.getValue());
        // Precipitation dayOnePrecipitation = new Precipitation
        // Code for day one -- different than the others due to random first temp.
        if (dayOneCloud.getCloudLevel().equals("None")) {
            midDayTemp = new Temperature(dayOneMorningTemp.getTemperature() + 6);
        }
        if (dayOneCloud.getCloudLevel().equals("Light")) {
            midDayTemp = new Temperature(dayOneMorningTemp.getTemperature() + 3);
        }
        if (dayOneCloud.getCloudLevel().equals("Medium")) {
            midDayTemp = new Temperature(dayOneMorningTemp.getTemperature() - 3);
        }
        if (dayOneCloud.getCloudLevel().equals("Heavy")) {
            midDayTemp = new Temperature(dayOneMorningTemp.getTemperature() - 14);
        }
        System.out.println("Day 1: ");
        System.out.println("Morning Temperature: " + dayOneMorningTemp);
        System.out.println("Clouds: " + dayOneCloud);
        System.out.println("Midday Temperature: " + midDayTemp);
        System.out.println("Precipitation: " + dayOnePrecip);
        System.out.println("Wind: " + dayOneWind);

        // This is the for loop that will create the day's objects.
        for (int i = 2; i <= 20; i++) {
            Cloud newCloud = new Cloud(0.0);
            Temperature morningTemp = dayOneMorningTemp;
            Wind wind = new Wind();
            Precipitation precipitation = new Precipitation(midDayTemp.getValue());
            // Cloud conditions and their modifications.
            if (newCloud.getCloudLevel().equals("None")) {
                morningTemp = new Temperature(morningTemp.getTemperature() + 6);
            }
            if (newCloud.getCloudLevel().equals("Light")) {
                morningTemp = new Temperature(morningTemp.getTemperature() + 3);
            }
            if (newCloud.getCloudLevel().equals("Medium")) {
                morningTemp = new Temperature(morningTemp.getTemperature() - 3);
            }
            if (newCloud.getCloudLevel().equals("Heavy")) {
                morningTemp = new Temperature(morningTemp.getTemperature() - 14);
            }
            // Wind conditions and their modifications.
            double windModifiedSouth = (wind.getWindSpeed() / .5);
            double windModifiedNorth = (wind.getWindSpeed() / .65);

            if (wind.getWindDirection().equals("South")) {
                double tempTemp = (midDayTemp.getTemperature()
                        + windModifiedSouth);
                midDayTemp.setTemperature(tempTemp);
            }
            if (wind.getWindDirection().equals("North")) {
                double tempTemp = (midDayTemp.getTemperature()
                        - windModifiedNorth);
                midDayTemp.setTemperature(tempTemp);
            }
            // Wind modifications complete.

            System.out.println("Day " + i + ":");
            System.out.println("Morning Temperature: " + morningTemp);
            System.out.println("Clouds: " + newCloud);
            System.out.println("Midday Temperature: " + midDayTemp);
            System.out.println("Precipitation: " + precipitation);
            System.out.println("Wind: " + wind);
        }
    }
// To string.
    @Override
    public String toString() {
        return "Day " + whichDay;
    }

}
