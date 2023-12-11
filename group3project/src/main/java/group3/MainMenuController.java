package group3;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainMenuController implements ControllerInitializer {

    @FXML
    Button playButton;
    SmurfinatorMainController smurfinatorMainController;
    LeaderboardController leaderboardController;
    private static MainMenuController instance;

    SceneTransitionHandler sceneTransitionHandler = SceneTransitionHandler.getInstance();

   private MainMenuController(){

   }
   public static MainMenuController getInstance(){
        if(instance == null){
            
            instance = new MainMenuController();
            return instance;
        }
        return instance;
    }


    @Override
    public void initialize() {

    }

    // Navigate to the Smurfinator game
    @FXML
    private void playgame(ActionEvent event) {
        sceneTransitionHandler.transitionToSmurfinator(event);
    }

    // configure program window
    private void configureStage(Stage stage, Scene scene) {
        stage.setTitle("Smurfinator");
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.setResizable(false);
    }

    // close the application
    @FXML
    private void closeGame(){
        javafx.application.Platform.exit();
    }
    @FXML
    private void collection(){

    }

    // Navigate to the leaderboard screen
    @FXML
    private void leaderboard(ActionEvent event){
        sceneTransitionHandler.transitionToLeaderboard(event);
    }
    @FXML
    private void loginpopup(){
        
    }
}

