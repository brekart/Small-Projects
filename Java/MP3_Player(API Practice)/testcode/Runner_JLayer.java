/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.sonic.testcode;

import javazoom.jl.player.*;
import java.io.FileInputStream;

public class Runner_JLayer {

    public static void main(String[] args) {
// THIS DOES NOT HAVE STOP IMPLEMENTED YET. ONCE PLAYED IT WILL PLAY THE ENTIRE SONG.

        try {

            FileInputStream filestream = new FileInputStream("D:\\PROJECT 1 JAVA LIBRARIES\\TTSG.mp3");
            Player mp3player = new Player(filestream);
            mp3player.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
