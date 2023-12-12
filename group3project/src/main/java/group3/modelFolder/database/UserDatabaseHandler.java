package group3.modelFolder.database;

import group3.modelFolder.user.User;

import java.io.IOException;
import java.util.ArrayList;

public class UserDatabaseHandler extends DatabaseHandler {

    public UserDatabaseHandler(String s) {
        super(s);
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        for (Object elem : data_list) {
            users.add((User) elem);
        }
        return users;
    }

    public void addUser(User u) {
        for (Object data : data_list) {
            if (u.equals((User) data))
                return;
        }
        super.addToList(u);
    }

    public void removeUser(User u) throws IOException {
        data_list.remove(u);
        writeToFile();
    }

}
