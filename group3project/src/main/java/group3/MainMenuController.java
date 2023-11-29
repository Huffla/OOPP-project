package group3;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

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
  
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("stages/questionscene.fxml"));
            SmurfinatorMainController controller = SmurfinatorMainController.getInstance();
            loader.setController(controller);
            Parent root = loader.load();
            System.out.println(loader.getController().toString());    
            
            
            
            controller.initialize();

            Scene scene = new Scene(root);
            scene.getStylesheets().addAll(stylesheetArray);

            configureStage(stage, scene);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void configureStage(Stage stage, Scene scene) {
        stage.setTitle("Smurfinator");
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.setResizable(false);
    }

}
