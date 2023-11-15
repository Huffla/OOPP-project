package group3.modelFolder;

import java.io.IOException;
import java.util.ArrayList;

public class Model {
    ArrayList<User> user_list;
    ArrayList<Character> character_list;
    UserDatabaseHandler user_handler = new UserDatabaseHandler();
    CharacterDatabaseHandler character_handler = new CharacterDatabaseHandler();
    public Model(){
        user_list = user_handler.getUsers();
        character_list = character_handler.getCharacters();
        

    }

    public ArrayList<User> getUsers(){
        return user_list;
    }
    public ArrayList<Character> getCharacters(){
        return character_list;
    }
    public void setUsers(ArrayList<User> ulist){
        for(User u: ulist){
            user_handler.addToList(u);
        }
        user_list = user_handler.getUsers();
    }
    public void clearUsers(){
        try {
            user_handler.clearList();
        } catch (Exception e) {
            System.out.println("Could not clear list");
        }
        
    }
    public void removeUser(User u){
        try {
            user_handler.removeUser(u);
        } catch (IOException e) {
            System.out.println("IO exception");
            e.printStackTrace();
        }
    }
    
}
