package group3;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class SmurfinatorMain {
    private Stage stage;

    public SmurfinatorMain(Stage stage) {
        this.stage = stage;
    }

    public void loadAndShowScene(String fxmlPath, String[] stylesheets) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            // Assuming the controller has an initialize method
            SmurfinatorMainController controller = loader.getController();
            controller.initialize();

            Scene scene = new Scene(root);
            scene.getStylesheets().addAll(stylesheets);

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
