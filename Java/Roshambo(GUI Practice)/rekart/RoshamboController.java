/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blackburn.cs.cs212sp16.roshambo.rekart;

import java.net.*;
import java.util.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
// Estimated time: 10 hours.
// Worked 9pm - 12pm 3/30.
// Worked @ 1pm 4/1 - 5pm.
// Worked 4pm - 6pm 4/4.
// Worked 7pm - 9:10pm 4/5.
// Worked 1pm-2pm 4/7.
/**
 * FXML Controller class
 *
 * @author dakota.tebbe/braydon.rekart
 */
public class RoshamboController implements Initializable {
    // These are the text fields for FXML.
    @FXML
    private TextField output;
    @FXML
    private TextField output1;
    @FXML
    private TextField output2;
    @FXML
    private TextField aiWinsText;
    @FXML
    private TextField humanWinsText;
    @FXML
    private TextField tiesText;
    @FXML
    private ImageView characterOne;
    @FXML
    private ImageView characterTwo;
    @FXML
    private TextField gamesPlayed;
    // Regular fields.
    private int choice;
    private int counter = 0;
    HumanPlayer human = new HumanPlayer();
    AIPlayer ai = new AIPlayer();
    Stats stat = new Stats();
    int aiWins = stat.getAiWins();
    int humanWins = stat.getHumanWins();
    int gamesPlayedInt = stat.getGamesPlayed();
    String character = RoshamboMain.GAME.getPlayerCharacter();

    // This method handles the player choosing rock.
    @FXML
    private void handleRock(ActionEvent event) {
        this.choice = 1;
        this.output.setText("You choose: Rock");
        gamesPlayed.setText("Total games: " + Integer.toString(stat.getGamesPlayed()));
        human.humanTurnRock();
        int aiTurn = ai.aiTurn();

        if (human.humanTurnRock() == 1 && aiTurn == 0) {
            this.output2.setText("You tie!");
            handleRockAI();
            stat.addTie();
        }
        if (human.humanTurnRock() == 1 && aiTurn == 1) {
            this.output2.setText("AI wins!");
            stat.addAiWin();
            handlePaperAI();
        }
        if (human.humanTurnRock() == 1 && aiTurn == 2) {
            this.output2.setText("You win!");
            stat.addHumanWin();
            handleScissorsAI();
        }
        showAiWins();
        showHumanWins();
        showTies();
        stat.addGamePlayed();
    }

    // This method handles the player choosing paper.
    @FXML
    private void handlePaper(ActionEvent event) {
        this.choice = 2;
        this.output.setText("You choose: Paper");
        gamesPlayed.setText("Total games: " + Integer.toString(stat.getGamesPlayed()));
        human.humanTurnPaper();
        int aiTurn = ai.aiTurn();

        if (human.humanTurnPaper() == 2 && aiTurn == 0) {
            this.output2.setText("You win!");
            stat.addHumanWin();
            handleRockAI();
        }
        if (human.humanTurnPaper() == 2 && aiTurn == 1) {
            this.output2.setText("You tie!");
            handlePaperAI();
            stat.addTie();
        }
        if (human.humanTurnPaper() == 2 && aiTurn == 2) {
            this.output2.setText("AI wins!");
            stat.addAiWin();
            handleScissorsAI();
        }
        showAiWins();
        showHumanWins();
        showTies();
        stat.addGamePlayed();
    }

    // This method handles the player choosing scissors.
    @FXML
    private void handleScissors(ActionEvent event) {
        this.choice = 3;
        this.output.setText("You choose: Scissors");
        gamesPlayed.setText("Total games: " + Integer.toString(stat.getGamesPlayed()));
        human.humanTurnScissors();
        int aiTurn = ai.aiTurn();

        if (human.humanTurnScissors() == 3 && aiTurn == 0) {
            this.output2.setText("AI wins!");
            stat.addAiWin();
            handleRockAI();
        }

        if (human.humanTurnScissors() == 3 && aiTurn == 1) {
            this.output2.setText("You win!");
            stat.addHumanWin();
            handlePaperAI();
        }

        if (human.humanTurnScissors() == 3 && aiTurn == 2) {
            this.output2.setText("You tie!");
            handleScissorsAI();
            stat.addTie();
        }
        showAiWins();
        showHumanWins();
        showTies();
        stat.addGamePlayed();
    }

    // This method handles the AI choosing rock.
    @FXML
    private void handleRockAI() {
        this.output1.setText("AI chose: Rock");
    }

    // AI chooses paper.
    @FXML
    private void handlePaperAI() {
        this.output1.setText("AI chose: Paper");
    }

    // AI chooses scissors.
    @FXML
    private void handleScissorsAI() {
        this.output1.setText("AI chose: Scissors");
    }

    // Shows AI's number of wins.
    @FXML
    private void showAiWins() {
        aiWinsText.setText("AI wins: " + Integer.toString(stat.getAiWins()));
    }

    // Shows amount of human wins.
    @FXML
    private void showHumanWins() {
        this.humanWinsText.setText("Human wins: " + Integer.toString(stat.getHumanWins()));
    }

    // Shows ties.
    @FXML
    private void showTies() {
        this.tiesText.setText("Ties: " + Integer.toString(stat.getTies()));
    }
    // This initializes the program.

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.output.setText(RoshamboMain.GAME.getPlayerCharacter());
        //characterOne.setImage();
    }

}
