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
    SmurfinatorMainController controller;
    private static MainMenuController instance;
   private MainMenuController(SmurfinatorMainController c){
    controller = c;
   }
   public static MainMenuController getInstance(SmurfinatorMainController c){
        if(instance == null){
            
            instance = new MainMenuController(c);
            return instance;
        }
        return instance;
    }
    public static MainMenuController getInstance(){
        if(instance == null){
            throw new NullPointerException();
        }
        return instance;
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
            loader.setController(controller);
            Parent root = loader.load();
            System.out.println(loader.getController().toString());  
            // MAKES INITIAL CALL THAT HAS TO BE MADE FOR SMURFINATOR TO WORK  
            //TODO 
            controller.makeInitialCall();
            
            
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
    @FXML
    private void closeGame(){
        javafx.application.Platform.exit();
    }
    @FXML
    private void collection(){

    }
    @FXML
    private void leaderboard(){

    }
    @FXML
    private void loginpopup(){
        
    }
}

