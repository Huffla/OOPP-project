package group3;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        SceneFactory sceneManager = new SceneFactory(primaryStage);
        String titlecss = getClass().getResource("styles/universalStyle.css").toExternalForm();
        String scenecss = getClass().getResource("styles/sceneStyle.css").toExternalForm();
        String[] stylesheetArray = { titlecss, scenecss };
        String[] testArray = {};

        sceneManager.loadAndShowScene("stages/mainmenu.fxml", testArray, MainMenuController.class);
    }

    public static void main(String[] args) {
        launch();
    }
}
