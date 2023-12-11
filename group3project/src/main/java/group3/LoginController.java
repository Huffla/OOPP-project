package group3;

import java.io.IOException;

import javax.swing.Action;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private TextField createuserfield;
    @FXML
    private TextField userfield;
    @FXML
    private TextField passfield;
    @FXML
    private TextField createpassfield;
    @FXML
    private Button submitaccountButton;
    @FXML
    private Label displaytest;
    @FXML
    private AnchorPane loginContainer;
    @FXML
    private AnchorPane createContainer;
    @FXML
    private Button testing;
    @FXML
    private Button goBackButton;
    @FXML
    private Label errorText;

    String userpwrd = "";
    String username = "";
    String newuserpwrd = "";
    String newusername = "";

    SceneTransitionHandler sceneTransitionHandler = SceneTransitionHandler.getInstance();
    MainMenuController controller;
    private static LoginController instance;
    LoginInterface loginInterface;

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

        createpassfield.textProperty().addListener((observable, oldValue, newValue) -> {
            newuserpwrd = newValue;
        });

        createuserfield.textProperty().addListener((observable, oldValue, newValue) -> {
            newusername = newValue;
        });

        passfield.textProperty().addListener((observable, oldValue, newValue) -> {
            userpwrd = newValue;
        });

        userfield.textProperty().addListener((observable, oldValue, newValue) -> {
            username = newValue;

        });

    }

    @FXML
    private void toggleCreateUser(ActionEvent event) {
        loginContainer.setVisible(false);
        createContainer.setVisible(true);
    }

    @FXML
    private void toggleLogin(ActionEvent event) {
        loginContainer.setVisible(true);
        createContainer.setVisible(false);
    }

    @FXML
    private void createUser() {
        loginInterface.createUser(newusername, newuserpwrd);

    }

    @FXML
    private void goBack() {
        toggleLogin(null);
    }

    public void setMainMenuController(MainMenuController mainmenucontroller) {
        controller = mainmenucontroller;
    }

    @FXML
    public void attemptLogin(ActionEvent event) throws NoSuchFieldException {
        loginInterface.attemptLogin(username, userpwrd, event);

    }

    public void userExistsError() {
        errorText.setText("User already exists!");
    }

    public void gotoMainMenu(ActionEvent event) {
        sceneTransitionHandler.transitionToMainMenu(event);

    }

    private void configureStage(Stage stage, Scene scene) {
        stage.setTitle("Smurfinator");
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.setResizable(false);
    }

}
