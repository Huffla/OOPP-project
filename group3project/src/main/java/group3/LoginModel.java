package group3;

import java.util.ArrayList;

import group3.modelFolder.LoginAuth;
import group3.modelFolder.User;
import group3.modelFolder.UserDatabaseHandler;


public class LoginModel implements LoginInterface {
    private ArrayList<LoginObserver> loginObservers = new ArrayList();
    UserDatabaseHandler udbh;
   
    User loggedinuser;
    public LoginModel(UserDatabaseHandler database){
    udbh = database;
    
    }
    
    @Override
    public void addObserver(LoginObserver lo) {
        loginObservers.add(lo);
    }

    @Override
    public void createUser(String name, String password) {
        int hashedpwrd = password.hashCode();
        User user = new User(name, hashedpwrd);
        udbh.addUser(user);
        System.out.println("User Created");
    }

    public void attemptLogin(String username, String password) throws NoSuchFieldException{
        LoginAuth loginauth = new LoginAuth(udbh.getUsers());
        loggedinuser = loginauth.attemptLogin(username, password);
        if (loggedinuser != null){
            gotoMainMenu();
        }
        System.out.println("Login Successful!");
    }

    private void gotoMainMenu(){
        for(LoginObserver lo : loginObservers){
            lo.gotoMainMenu();
        }
    }

}
