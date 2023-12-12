package group3;

import javafx.event.ActionEvent;

public interface LoginInterface {
    public void addObserver(LoginObserver lo);

    public void attemptLogin(String name, String password, ActionEvent event) throws NoSuchFieldException;

    public void createUser(String name, String password);

}
