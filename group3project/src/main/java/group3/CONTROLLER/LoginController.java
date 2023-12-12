package group3.CONTROLLER;

import group3.modelFolder.login.LoginInterface;
import javafx.event.ActionEvent;

public class LoginController {
    LoginInterface loginInterface;

    public LoginController(LoginInterface li) {
        loginInterface = li;
    }

    public void createUserPressed(String name, String password) {
        loginInterface.createUser(name, password);
    }

    public void loginPressed(ActionEvent event, String username, String password) {
        try {
            loginInterface.attemptLogin(username, password, event);
        } catch (NoSuchFieldException e) {

        }
    }

    public void continueGuest() {
        loginInterface.continueGuest();
    }
}
