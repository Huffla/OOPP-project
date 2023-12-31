package group3.modelFolder.login;

import java.util.ArrayList;

import group3.modelFolder.login.LoginAuth;
import group3.modelFolder.login.LoginInterface;
import group3.modelFolder.login.LoginObserver;
import group3.modelFolder.model.Model;
import group3.modelFolder.user.User;
import group3.modelFolder.database.UserDatabaseHandler;
import javafx.event.ActionEvent;

public class LoginModel implements LoginInterface {
    private ArrayList<LoginObserver> loginObservers = new ArrayList();
    UserDatabaseHandler udbh;
    Model model;

    User loggedinuser;

    public LoginModel(UserDatabaseHandler database) {
        udbh = database;
    
    }

    public void setModel(Model m){
        model = m;
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

    public void userCreatedMsg() {
        for (LoginObserver lo : loginObservers) {
            lo.userCreatedMsg();
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
            userCreatedMsg();
            System.out.println("User Created");
        }
    }

    public void attemptLogin(String username, String password, ActionEvent event) throws NoSuchFieldException {
        LoginAuth loginauth = new LoginAuth(udbh.getUsers());
        loggedinuser = loginauth.attemptLogin(username, password);
        if (loggedinuser != null) {
            model.setCurrentUser(loggedinuser);
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
