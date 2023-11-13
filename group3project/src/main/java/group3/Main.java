package group3;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("questionscene.fxml"));
        Scene scene = new Scene(root);
        String titlecss = this.getClass().getResource("smurfTitle.css").toExternalForm();
        String scenecss = this.getClass().getResource("sceneStyle.css").toExternalForm();
        scene.getStylesheets().addAll(titlecss,scenecss);
        stage.setTitle("Smurfinator");
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}