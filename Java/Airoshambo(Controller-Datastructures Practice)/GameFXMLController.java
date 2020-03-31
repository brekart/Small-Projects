/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.rekart.airoshambo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Braydon
 */
public class GameFXMLController implements Initializable {

    // Time estimate: 25 hours.
    // Worked 16 hours total.
    @FXML
    private TextField outcome;
    @FXML
    private TextField aiWinsText;
    @FXML
    private TextField aiWinsPercent;
    @FXML
    private TextField humanWinsText;
    @FXML
    private TextField humanWinsPercent;
    @FXML
    private TextField tiesText;
    @FXML
    private TextField tiesPercent;
    @FXML
    private TextField roundsPlayed;
    @FXML
    private TextField tiePercent;
    @FXML
    private TextField humansMove;
    @FXML
    private TextField aiMove;

    /**
     * Initializes the controller class.
     *
     * @param url
     */
    HumanPlayer human = new HumanPlayer();
    AIPlayer ai = new AIPlayer();
    Game game = new Game(human, ai, 10);

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    private void update() {
        
        aiWinsText.setText("AI wins: " + Double.toString(game.getStats().getP2Wins()));

        // Shows amount of human wins.
        this.humanWinsText.setText("Human wins: " + Double.toString(game.getStats().getP1Wins()));

        // Shows ties.
        this.tiesText.setText("Ties: " + Double.toString(game.getStats().getTies()));

        double percentage = (game.getStats().getP2Wins() / game.getStats().getGamesPlayed()) * 100;
        this.aiWinsPercent.setText("AI wins %: " + Double.toString(percentage));

        percentage = (game.getStats().getP1Wins() / game.getStats().getGamesPlayed()) * 100;
        this.humanWinsPercent.setText("Human wins %: " + Double.toString(percentage));

        percentage = (game.getStats().getTies() / game.getStats().getGamesPlayed()) * 100;
        this.tiesPercent.setText("Ties %: " + Double.toString(percentage));
        this.aiMove.setText("AI chose: " + ai.getChoice());
        this.humansMove.setText("You chose: " + human.getChoice());
    }

    @FXML
    private void handleRock(ActionEvent event) {
        human.setChoice(Move.ROCK);
        game.run();
        update();
    }

    @FXML
    private void handlePaper(ActionEvent event) {

        human.setChoice(Move.PAPER);
        game.run();
        update();
    }

    // This method handles the player choosing scissors.
    @FXML
    private void handleScissors(ActionEvent event) {
        human.setChoice(Move.SCISSORS);
        game.run();
        update();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
