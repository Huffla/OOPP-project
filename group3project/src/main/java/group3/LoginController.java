package group3;

import java.io.IOException;

import group3.modelFolder.LoginAuth;
import group3.modelFolder.User;
import group3.modelFolder.UserDatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController implements ControllerInitializer, LoginObserver {

    @FXML
    private Button loginButton;
    @FXML
    private Button testButton;
    @FXML
    private Button createaccountButton;
    @FXML
    private Button guestButton;
    MainMenuController controller;
    private static LoginController instance;
    LoginInterface loginInterface;
    UserDatabaseHandler userDatabaseHandler = new UserDatabaseHandler("Users.txt");

    private LoginController(LoginInterface li) {
        loginInterface = li;
        li.addObserver(this);
    }

    public static LoginController getInstance(LoginInterface li) {
        if (instance == null) {
            instance = new LoginController(li);
            return instance;
        }
        return instance;
    }

    @Override
    public void initialize() {

    }

    @FXML
    private void createUser(String name, int password) {
        loginInterface.createUser(name, password);
    }

    public void setMainMenuController(MainMenuController mainmenucontroller) {
        controller = mainmenucontroller;
    }

    @FXML
    private void test(ActionEvent event) {
        String titlecss = getClass().getResource("styles/universalStyle.css").toExternalForm();
        String scenecss = getClass().getResource("styles/sceneStyle.css").toExternalForm();
        String[] stylesheetArray = { titlecss, scenecss };
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("stages/mainmenu.fxml"));
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
