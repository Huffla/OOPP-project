package group3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainMenuController implements ControllerInitializer {

    @FXML
    Button playButton;
    public MainMenuController(){
        
    }
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
}
