package group3;

import java.util.ArrayList;

import group3.modelFolder.User;

public class LoginModel implements LoginInterface {
    private ArrayList<LoginObserver> loginObservers = new ArrayList();

    @Override
    public void addObserver(LoginObserver lo) {
        loginObservers.add(lo);
    }

    @Override
    public void createUser(String name, int password) {
        // userDatabaseHandler.addUser(new User(name, password));
    }

}
