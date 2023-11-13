package group3;

import java.util.ArrayList;

import group3.modelFolder.Model;
import group3.modelFolder.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Model model = new Model();
        System.out.println(model.getUsers());
        ArrayList<User> ulist = new ArrayList<>();
        ulist.add(new User("Spicy Smurf"));
        ulist.add(new User("Kalle Anka"));
        ulist.add(new User("DÄILBSIT"));

        model.setUsers(ulist);
        System.out.println(model.getUsers());
    }
}