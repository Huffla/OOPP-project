package group3;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        SmurfinatorMain sceneManager = new SmurfinatorMain(primaryStage);
        String titlecss = getClass().getResource("styles/universalStyle.css").toExternalForm();
        String scenecss = getClass().getResource("styles/sceneStyle.css").toExternalForm();
        String[] stylesheetArray = {titlecss, scenecss};

        sceneManager.loadAndShowScene("stages/questionscene.fxml", stylesheetArray);
    }

    public static void main(String[] args) {
        launch();
    }
}
