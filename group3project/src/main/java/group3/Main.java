package group3;

import java.util.ArrayList;

import group3.modelFolder.Model;
import group3.modelFolder.User;


public class Main {

    static Model model;
    
    public static void main(String[] args) {
        model = Model.getInstance("Users.txt");

        MainMenu.test(args);
    }
    
       
   
}