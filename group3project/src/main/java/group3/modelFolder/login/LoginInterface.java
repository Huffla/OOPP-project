package group3.modelFolder.login;

import javafx.event.ActionEvent;

public interface LoginInterface {
    public void addObserver(LoginObserver lo);

    public void attemptLogin(String name, String password, ActionEvent event) throws NoSuchFieldException;

    public void createUser(String name, String password);

    public void continueGuest();

}
