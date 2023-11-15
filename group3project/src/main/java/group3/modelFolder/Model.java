package group3.modelFolder;

import java.io.IOException;
import java.util.ArrayList;

public class Model {
    ArrayList<User> user_list;
    ArrayList<Character> character_list;
    UserDatabaseHandler user_handler;
    CharacterDatabaseHandler character_handler = new CharacterDatabaseHandler();
    LoginAuth loginAuth;
    public Model(String user_file_name){
        user_handler = new UserDatabaseHandler(user_file_name);
        user_list = user_handler.getUsers();
        character_list = character_handler.getCharacters();
        loginAuth = new LoginAuth(user_handler.getUsers());
        

    }
    // returns the list of users
    public ArrayList<User> getUsers(){
        return user_list;
    }
    // returns the list of characters
    public ArrayList<Character> getCharacters(){
        return character_list;
    }
    // add a list of users to the database
    public void setUsers(ArrayList<User> ulist){
        for(User u: ulist){
            user_handler.addUser(u);
        }
        user_list = user_handler.getUsers();
    }
    // add a user to the database
    public void setUser(User u){
        user_handler.addUser(u);
        user_list = user_handler.getUsers(); // should not matter since the arrayList has the same reference everywhere
    }
    // clears the list of users
    public void clearUsers(){
        try {
            user_handler.clearList();
        } catch (Exception e) {
            System.out.println("Could not clear list");
        }
        
    }
    // removes a user object from the list of users
    public void removeUser(User u){
        try {
            user_handler.removeUser(u);
        } catch (IOException e) {
            System.out.println("IO exception");
            e.printStackTrace();
        }
    }
    
}
