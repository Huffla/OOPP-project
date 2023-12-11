package group3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MainMenuController implements ControllerInitializer {

    @FXML
    Button playButton;
    SmurfinatorMainController controller;
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

    @FXML
    private void playgame(ActionEvent event) {
        sceneTransitionHandler.transitionToSmurfinator(event);
    }
    @FXML
    private void closeGame(){
        javafx.application.Platform.exit();
    }
    @FXML
    private void collection(ActionEvent event){
        sceneTransitionHandler.transitionToCompendium(event);
    }
    @FXML
    private void leaderboard(ActionEvent event){
    sceneTransitionHandler.transitionToLeaderboard(event);
    }
    @FXML
    private void loginpopup(){
        
    }

}

