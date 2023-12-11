
package group3;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CompendiumController implements ControllerInitializer, CompendiumModelInterface {


    @FXML
    private Button leaderboardButton;

    @FXML
    private Button mainmenuButton;

    @FXML
    Button exitButton;

   

    private Stage stage; // Reference to the stage
    private SceneTransitionHandler sceneTransitionHandler = SceneTransitionHandler.getInstance();
    // Inject the stage using this method
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize() {

    }
    private static CompendiumController instance;
    private ArrayList<CompendiumModelInterface> observers = new ArrayList<>();
    private CompendiumController(CompendiumModelInterface observer){
        observers.add(observer);
    }

    public static CompendiumController getInstance(CompendiumModelInterface compendiumController){
        if(instance == null){
            instance = new CompendiumController(compendiumController);
            return instance;
        }
        return instance;
    }

    @FXML
    private void leaderboard(ActionEvent event) {
       sceneTransitionHandler.transitionToLeaderboard(event);
    }


    @FXML
    private void mainmenu(ActionEvent event) {
        sceneTransitionHandler.transitionToMainMenu(event);
    }


    @FXML
    private void closeGame(){
        javafx.application.Platform.exit();
    }


}
