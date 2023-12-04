
package group3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CompendiumController implements ControllerInitializer {


    @FXML
    private Button leaderboardButton;

    @FXML
    private Button mainmenuButton;

    @FXML
    Button exitButton;

   

    private Stage stage; // Reference to the stage

    // Inject the stage using this method
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize() {

    }

    @FXML
    private void leaderboard(ActionEvent event) {
        String titlecss = getClass().getResource("styles/leaderboardStyle.css").toExternalForm();
        String scenecss = getClass().getResource("styles/collectionStyle.css").toExternalForm();
        String[] stylesheetArray = { titlecss, scenecss };
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        SceneFactory sceneManager = new SceneFactory(stage);
        sceneManager.loadAndShowScene("stages/leaderboard.fxml", stylesheetArray, LeaderboardController.class);
    }


    @FXML
    private void mainmenu(ActionEvent event) {
        String titlecss = getClass().getResource("styles/mainmenuStyle.css").toExternalForm();
        String scenecss = getClass().getResource("styles/universalStyle.css").toExternalForm();
        String[] stylesheetArray = { titlecss, scenecss };
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        SceneFactory sceneManager = new SceneFactory(stage);
        sceneManager.loadAndShowScene("stages/mainmenu.fxml", stylesheetArray, MainMenuController.class);
    }


    @FXML
    private void closeGame(){
        javafx.application.Platform.exit();
    }


}
