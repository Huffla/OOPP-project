package group3.modelFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class UserDatabaseHandler extends DatabaseHandler{
   
    public UserDatabaseHandler(String s){
        super(s);
    }
    
    public ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        for(Object elem: data_list){
            users.add((User)elem);
        }
        return users;
    }

    
    public void addUser(User u) {
        for(Object data: data_list){
            if(u.equals((User) data)) return;
        }
        super.addToList(u);
    }

    public void removeUser(User u) throws IOException{
        data_list.remove(u);
        writeToFile();
    }

    
}
