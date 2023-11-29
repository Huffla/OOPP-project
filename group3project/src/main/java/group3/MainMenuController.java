package group3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainMenuController implements ControllerInitializer {

    @FXML
    Button playButton;

    @FXML
    Button collectionButton;

    @FXML
    Button leaderboardButton;

    @FXML
    Button exitButton;

    @FXML
    Button loginButton;





    @Override
    public void initialize() {

    }

    @FXML
    private void playgame(ActionEvent event) {
        String titlecss = getClass().getResource("styles/universalStyle.css").toExternalForm();
        String scenecss = getClass().getResource("styles/sceneStyle.css").toExternalForm();
        String[] stylesheetArray = { titlecss, scenecss };
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        SceneFactory sceneManager = new SceneFactory(stage);
        sceneManager.loadAndShowScene("stages/questionscene.fxml", stylesheetArray, SmurfinatorMainController.class);

    }

    @FXML
    private void collection(ActionEvent event) {
        String titlecss = getClass().getResource("styles/universalStyle.css").toExternalForm();
        String scenecss = getClass().getResource("styles/collectionStyle.css").toExternalForm();
        String[] stylesheetArray = { titlecss, scenecss };
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        SceneFactory sceneManager = new SceneFactory(stage);
        sceneManager.loadAndShowScene("stages/compendiumscene.fxml", stylesheetArray, CompendiumController.class);
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
    private void loginpopup() {
        QuitMenuLoader.showPopup("stages/loginpopup.fxml", "Login");
    }

}
