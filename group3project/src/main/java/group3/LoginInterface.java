package group3;

import group3.modelFolder.User;

public interface LoginInterface {
    public void addObserver(LoginObserver lo);
    public void attemptLogin(String name, String password) throws NoSuchFieldException;
    public void createUser(String name, String password);

}
