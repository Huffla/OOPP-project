package group3;

import group3.modelFolder.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class LeaderboardController implements ControllerInitializer, LeaderboardObserver {

    private static LeaderboardController instance;

    LeaderboardInterface leaderboard;

    final int characterLeaderboardCode = 0;
    final int userLeaderboardCode = 1;

    @FXML
    Button mainmenuButton;
    @FXML
    Button exitButton;
    @FXML
    Button characterLeaderboardButton;
    @FXML
    Button userLeaderboardButton;
    @FXML
    Label leaderboardLabel;

    @FXML
    Label leaderboardField;

    SceneTransitionHandler sceneTransitionHandler = SceneTransitionHandler.getInstance();


    private Stage stage; // Reference to the stage

    // Inject the stage using this method
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Constructor
    private LeaderboardController(LeaderboardInterface s) {
        leaderboard = s;
        leaderboard.addObserver(this);

    }

    // Singleton pattern
    public static LeaderboardController getInstance(LeaderboardInterface s) {
        if (instance == null) {
            instance = new LeaderboardController(s);

        }
        return instance;
    }

    @Override
    public void initialize() {

    }

    // Make the initial call to the leaderboard
    public void makeInitialCall() {
        leaderboard.makeInitialCall();
    }

    // Update the leaderboard field
    @Override
    public void updateLeaderboardField(Category category){
        String tempString;
        leaderboardField.setText("");
        LeaderboardEntry lbE;
        for(int i = 0; i < category.getList().size(); i++){
            lbE = category.getList().get(i);
            tempString = leaderboardField.getText();
            leaderboardField.setText(tempString + lbE.getName() + ":" + " " + lbE.getSortValue() + "\n");
            }
        switchCategoryName(category);
    }

    // Switch category to display characters
    @FXML
    private void switchCategoryCharacter(){
        leaderboard.switchCategory(characterLeaderboardCode);
    }

    // Switch category to display users
    @FXML
    private void switchCategoryUser(){
        leaderboard.switchCategory(userLeaderboardCode);
    }

    // Change label describing leaderboard type
    @FXML
    private void switchCategoryName(Category category){
        this.leaderboardLabel.setText(category.getName());
    }

    // Navigate to the Compendium
    @FXML
    private void switchToCollection(ActionEvent event) {
        sceneTransitionHandler.transitionToCompendium(event);
    }

    // Navigate to the main menu
    @FXML
    private void switchToMainmenu(ActionEvent event) {
        sceneTransitionHandler.transitionToMainMenu(event);
    }


    @FXML
    private void closeGame(){
        javafx.application.Platform.exit();
    }


}
