/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.roshambo.rekart;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author braydon.rekart
 */
public class CharSelectController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

        // This method handles character selection and sets up the FXML loader.
    @FXML
    private void handleSelectCharacter(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        //System.out.println(b.getText());
        RoshamboMain.GAME.setPlayerCharacter(b.getText());
        //System.out.println(character);
        
        Parent root = FXMLLoader.load(getClass().getResource("Roshambo.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
