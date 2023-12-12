package group3;

import java.util.ArrayList;

import group3.modelFolder.login.LoginAuth;
import group3.modelFolder.user.User;
import group3.modelFolder.database.UserDatabaseHandler;
import javafx.event.ActionEvent;

public class LoginModel implements LoginInterface {
    private ArrayList<LoginObserver> loginObservers = new ArrayList();
    UserDatabaseHandler udbh;

    User loggedinuser;

    public LoginModel(UserDatabaseHandler database) {
        udbh = database;

    }

    @Override
    public void addObserver(LoginObserver lo) {
        loginObservers.add(lo);
    }

    public void userExistsError() {
        for (LoginObserver lo : loginObservers) {
            lo.userExistsError();
            ;
        }
    }

    @Override
    public void createUser(String name, String password) {
        boolean userExists = false;

        for (User u : udbh.getUsers()) {
            if (u.getName().equals(name)) {
                userExists = true;
                userExistsError();
                break;
            }
        }

        if (!userExists) {
            int hashedPassword = password.hashCode();
            User user = new User(name, hashedPassword);
            udbh.addUser(user);
            System.out.println("User Created");
        }
    }

    public void attemptLogin(String username, String password, ActionEvent event) throws NoSuchFieldException {
        LoginAuth loginauth = new LoginAuth(udbh.getUsers());
        loggedinuser = loginauth.attemptLogin(username, password);
        if (loggedinuser != null) {
            gotoMainMenu(event);
        }
        System.out.println("Login Successful!");
    }

    private void gotoMainMenu(ActionEvent event) {
        for (LoginObserver lo : loginObservers) {
            lo.gotoMainMenu(event);
        }
    }

}
