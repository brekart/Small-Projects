/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.sonic.testcode;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import org.kc7bfi.jflac.apps.Player;
/**
 *
 * @author braydon.rekart
 */
public class Runner_JFLAC {
    public static void main(String[] args) {
        // WILL PLAY ENTIRE SONG
        try {
            Player player = new Player();
            player.decode("D:\\PROJECT 1 JAVA LIBRARIES\\TheWhisper.FLAC");
        } catch (IOException | LineUnavailableException ex) {
            Logger.getLogger(Runner_JFLAC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
