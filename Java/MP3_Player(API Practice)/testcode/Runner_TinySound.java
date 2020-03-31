/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.sonic.testcode;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;
import kuusisto.tinysound.Music;

/**
 *
 * @author braydon.rekart
 */
public class Runner_TinySound {

    public static void main(String[] args) {
        TinySound.init();
        File file = new File("D:\\PROJECT 1 JAVA LIBRARIES\\The_Whisper.wav");
        
        Music musicFile = TinySound.loadMusic(file);
        musicFile.play(true);
        
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Runner_TinySound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
