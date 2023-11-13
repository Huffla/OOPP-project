package group3.modelFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class UserDatabaseHandler {
    private ArrayList<User> user_list;
    File obj;
    public UserDatabaseHandler(){
        try {
            user_list = loadFromFile();
        } catch (Exception e) {
            user_list = new ArrayList();
            try {
                writeToFile();
            } catch (IOException e1) {
                System.out.println("What da hell are you doing");
                e1.printStackTrace();
            }
        }
        
        obj = new File("Users.txt");
    }

    public void addToList(User user){
        user_list.add(user);
        try {
            writeToFile();
        } catch (IOException e) {
            System.out.println("Writing exception");
            e.printStackTrace();
        }
        
    }
    private void writeToFile() throws IOException{
        try {
            File obj = new File("Users.txt");
            ObjectOutputStream objout;
            objout = new ObjectOutputStream(new FileOutputStream(obj));
            objout.writeObject(user_list);
            objout.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        
    
    
    private ArrayList<User> loadFromFile() throws IOException, ClassNotFoundException{
    
        ObjectInputStream objin = new ObjectInputStream(new FileInputStream(obj));
        ArrayList<User> users;
        users = (ArrayList<User>) objin.readObject();
        objin.close();
        return users;
    
    }

    public ArrayList<User> getUsers(){
        return user_list;
    }
}
