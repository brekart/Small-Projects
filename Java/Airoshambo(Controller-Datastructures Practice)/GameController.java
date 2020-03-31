/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.airoshambo;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Braydon
 */
public class GameController extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent rootTwo = FXMLLoader.load(getClass().getResource("GameFXML.fxml"));

        Stage stageTwo = new Stage();
        Scene sceneTwo = new Scene(rootTwo);
        stageTwo.setScene(sceneTwo);
        stageTwo.show();
    }
    GameFXMLController controller = new GameFXMLController();

    public static void main(String[] args) {
        launch(args);
    }

}
