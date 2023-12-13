package group3;
/* 
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


public class CompendiumWindowHandler implements ControllerInitializer, LeaderboardObserver {

    private static CompendiumWindowHandler instance;

    LeaderboardInterface leaderboard;


    @FXML
    Button mainmenuButton;
    @FXML
    Button exitButton;

    @FXML
    Label leaderboardField;

    SceneTransitionHandler sceneTransitionHandler = SceneTransitionHandler.getInstance();

    private LeaderboardController controller;


    private Stage stage; // Reference to the stage

    // Inject the stage using this method
    public void setStage(Stage stage) {
        this.stage = stage;
    }


    @Override
    public void initialize() {

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



*/