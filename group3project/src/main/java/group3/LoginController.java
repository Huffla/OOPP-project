/* 
package group3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements ControllerInitializer {


    @FXML
    private Button leaveButton;

    @FXML
    private Button enterButton;


    private Stage stage; // Reference to the stage

    // Inject the stage using this method
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    leaveButton.setOnAction(event -> {
        Stage stage = (Stage) leaveButton.getScene().getWindow();
        stage.close();
    });
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
    private void closeQuitMenu() {

        if (stage != null && stage.isShowing()) {
            stage.close();
        }
    }

}

*/