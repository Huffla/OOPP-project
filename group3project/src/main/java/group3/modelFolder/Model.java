package group3.modelFolder;

import java.util.ArrayList;

public class Model {
    ArrayList<User> user_list;
    UserDatabaseHandler user_handler = new UserDatabaseHandler();
    public Model(){
        user_list = user_handler.getUsers();
    }
    
}
