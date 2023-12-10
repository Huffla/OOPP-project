package group3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class SceneTransitionHandler {
    public SceneTransitionHandler() {

    }
 //TODO The idea is to have a single class that handles all scene transitions. This will be done by passing the event
    
    public void transitionToMainMenu() {
        String titlecss = getClass().getResource("styles/mainmenuStyle.css").toExternalForm();
        String scenecss = getClass().getResource("styles/universalStyle.css").toExternalForm();
        String[] stylesheetArray = { titlecss, scenecss };
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        SceneFactory sceneManager = new SceneFactory(stage);
        sceneManager.loadAndShowScene("stages/mainmenu.fxml", stylesheetArray, MainMenuController.class);
    }

    public void transitionToCompendium() {

    }

    public void transitionToLeaderboard() {
        String titlecss = getClass().getResource("styles/leaderboardStyle.css").toExternalForm();
        String scenecss = getClass().getResource("styles/collectionStyle.css").toExternalForm();
        String[] stylesheetArray = { titlecss, scenecss };
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();


        sceneManager.loadAndShowScene("stages/leaderboard.fxml", stylesheetArray, LeaderboardController.class)
    }
    public void transitionSmurfinator() {
        String titlecss = getClass().getResource("styles/universalStyle.css").toExternalForm();
        String scenecss = getClass().getResource("styles/sceneStyle.css").toExternalForm();
        String[] stylesheetArray = { titlecss, scenecss };
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();

        sceneManager.loadAndShowScene("stages/questionscene.fxml", stylesheetArray, SmurfinatorMainController.class)

    }

}
