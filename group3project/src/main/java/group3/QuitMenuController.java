
package group3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class QuitMenuController implements Initializable {

    @FXML
    Button quitButton;
    @FXML
    Button resumeButton;
    @FXML
    Button quitmainmenuButton;

    private static Stage stage; 

    
    public static void setStage(Stage newstage) {
        stage = newstage;
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

    @FXML
    private void closeGame(){
        javafx.application.Platform.exit();
    }

    @FXML
    private void returnMainMenu(ActionEvent event){
         if (stage != null && stage.isShowing()) {
            stage.close();
        }
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        SceneFactory sceneManager = new SceneFactory(stage);
        String[] stylearray = {};
        sceneManager.loadAndShowScene("stages/mainmenu.fxml", stylearray , MainMenuWindowHandler.class);

    }
}
