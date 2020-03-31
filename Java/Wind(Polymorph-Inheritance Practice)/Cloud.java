/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.wind;

/**
 *
 * @author braydon.rekart
 */
// Cloud class is a type of precipitation. It has a level.
public class Cloud extends Precipitation{

    private String level;
// This cloud constructor sets the cloud level.
    public Cloud(double test) {
        super(test);
        String cloudLevel = "";
        int cloudLevelNumber = (int) (Math.random() * 4 + 1);
        if (cloudLevelNumber == 1) {
            cloudLevel = "None";
        }
        if (cloudLevelNumber == 2) {
            cloudLevel = "Light";
        }
        if (cloudLevelNumber == 3) {
            cloudLevel = "Medium";
        }
        if (cloudLevelNumber == 4) {
            cloudLevel = "Heavy";
        }
        this.level = cloudLevel;
    }
// To string overrider.
    @Override
    public String toString() {
        return this.level;
    }
// Gets cloud level.
    public String getCloudLevel() {
        return this.level;
    }
}

