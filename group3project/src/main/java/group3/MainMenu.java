package group3;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainMenu extends Application {
    @Override
    public void start(Stage primaryStage) {
        SceneFactory sceneManager = new SceneFactory(primaryStage);
        String[] testArray = {};

        sceneManager.loadAndShowScene("stages/mainmenu.fxml", testArray, MainMenuController.class);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
