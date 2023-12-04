package group3;

import java.io.IOException;

import group3.modelFolder.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class MainMenu extends Application {
    
    
    public static void launchapp(String[] args){
        
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        
        String[] testArray = {};
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("stages/mainmenu.fxml"));
            
            MainMenuController controller = MainMenuController.getInstance();
            loader.setController(controller);
            Parent root = loader.load();

            controller.initialize();

            Scene scene = new Scene(root);
            scene.getStylesheets().addAll(testArray);

            configureStage(primaryStage, scene);
            primaryStage.setScene(scene);
            primaryStage.show();
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
