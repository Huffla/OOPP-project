package group3;

import group3.CONTROLLER.ControllerInitializer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneFactory {
    private Stage stage;

    public SceneFactory(Stage stage) {
        this.stage = stage;
    }

    public <T extends ControllerInitializer> void loadAndShowScene(String fxmlPath, String[] stylesheets,
                                                                   Class<T> controllerClass) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            T controller = loader.getController();
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
