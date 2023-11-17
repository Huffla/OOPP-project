
package group3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class QuitMenuController implements Initializable {

    @FXML
    Button yesquitbutton;
    @FXML
    Button noquitbutton;

    private Stage stage; // Reference to the stage

    // Inject the stage using this method
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void closeQuitMenu() {

        if (stage != null && stage.isShowing()) {

            stage.close();
        }
    }

}
