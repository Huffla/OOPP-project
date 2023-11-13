package group3.modelFolder;

import java.util.ArrayList;

public class Model {
    ArrayList<User> user_list;
    UserDatabaseHandler user_handler = new UserDatabaseHandler();
    CharacterDatabaseHandler character_handler = new CharacterDatabaseHandler();
    public Model(){
        user_list = user_handler.getUsers();
    }
    
}
