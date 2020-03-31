/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Time estimated: 5 hours.
// Time taken: around 4 hours.
package edu.blackburn.cs.cs212sp16.rekart.wind;
// Runner class. It's our main. It begins the program.
/**
 *
 * @author braydon.rekart
 */
public class Runner {

    public static void main(String[] args) {
        System.out.println("Welcome to Weather 3000! Here's your report in"
                + " degrees Celsius:");
        Day d = new Day(1);
        d.beginDay();
    }
}
