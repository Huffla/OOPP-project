package group3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuWindowHandler implements ControllerInitializer {

    @FXML
    Button playButton;
    SmurfinatorWindowHandler controller;
    private static MainMenuWindowHandler instance;

    SceneTransitionHandler sceneTransitionHandler = SceneTransitionHandler.getInstance();
   private MainMenuWindowHandler(){


   }

    public static MainMenuWindowHandler getInstance(){
        if(instance == null){
            instance = new MainMenuWindowHandler();
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

    // close the application
    @FXML
    private void closeGame(){
        javafx.application.Platform.exit();
    }
    @FXML
    private void collection(ActionEvent event){
        sceneTransitionHandler.transitionToCompendium(event);
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

