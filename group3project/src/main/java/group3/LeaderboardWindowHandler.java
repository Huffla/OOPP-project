package group3;

import group3.CONTROLLER.ControllerInitializer;
import group3.CONTROLLER.LeaderboardController;
import group3.modelFolder.leaderboard.LeaderboardEntry;
import group3.modelFolder.leaderboard.LeaderboardInterface;
import group3.modelFolder.leaderboard.LeaderboardObserver;
import group3.modelFolder.leaderboard.category.Category;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LeaderboardWindowHandler implements ControllerInitializer, LeaderboardObserver {

    private static LeaderboardWindowHandler instance;

    LeaderboardInterface leaderboard;


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

    private LeaderboardController controller;


    private Stage stage; // Reference to the stage

    // Inject the stage using this method
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Constructor
    private LeaderboardWindowHandler(LeaderboardInterface s) {
        leaderboard = s;
        s.addObserver(this);
        controller = new LeaderboardController(s);
    }

    // Singleton pattern
    public static LeaderboardWindowHandler getInstance(LeaderboardInterface s) {
        if (instance == null) {
            instance = new LeaderboardWindowHandler(s);

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
        controller.switchCategoryCharacter();
    }

    // Switch category to display users
    @FXML
    private void switchCategoryUser(){
        controller.switchCategoryUser();
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
    private void collection(ActionEvent event){
        sceneTransitionHandler.transitionToCompendium(event);
    }


    @FXML
    private void closeGame(){
        javafx.application.Platform.exit();
    }


}
