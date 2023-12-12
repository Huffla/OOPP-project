package group3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginWindowHandler implements ControllerInitializer, LoginObserver {

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
    private static LoginWindowHandler instance;
    LoginController controller;

    private LoginWindowHandler(LoginInterface li) {
        controller = new LoginController(li);

        li.addObserver(this);
    }

    public static LoginWindowHandler getInstance(LoginInterface li) {
        if (instance == null) {
            instance = new LoginWindowHandler(li);
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
        controller.createUserPressed(newusername,newuserpwrd);

    }

    @FXML
    private void goBack() {
        toggleLogin(null);
    }

    @FXML
    public void attemptLogin(ActionEvent event) throws NoSuchFieldException {
        controller.loginPressed(event,username,userpwrd);

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
