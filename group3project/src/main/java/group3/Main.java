package group3;

import java.util.ArrayList;

import group3.modelFolder.Model;
import group3.modelFolder.User;

public class Main {

    static Model model;
    public static void main(String[] args) {
        model = new Model();
        simpleTest();
    }
        // Just to test if objectoutputstream does anything, should be in JUnit tests but wanted a fast test.
    private static void simpleTest(){
        System.out.println(model.getUsers());
        ArrayList<User> ulist = new ArrayList<>();
        ulist.add(new User("Spicy Smurf")); 
        ulist.add(new User("Kalle Anka"));  
        ulist.add(new User("DÄILBSIT"));    

        model.setUsers(ulist);
        System.out.println(model.getUsers());
        
    }
}