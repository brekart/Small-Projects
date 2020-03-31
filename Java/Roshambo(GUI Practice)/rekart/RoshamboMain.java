/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.roshambo.rekart;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author dakota.tebbe/braydon.rekart
 */
public class RoshamboMain extends Application {

    public static final Roshambo GAME = new Roshambo();
// This method overrides the start method.

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent rootTwo = FXMLLoader.load(getClass().getResource("CharSelect.fxml"));

        Stage stageTwo = new Stage();
        Scene sceneTwo = new Scene(rootTwo);
        stageTwo.setScene(sceneTwo);
        stageTwo.show();
    }

    /**
     * @param args the command line arguments
     */
    RoshamboController rc = new RoshamboController();

    public static void main(String[] args) {
        launch(args);

    }

}
