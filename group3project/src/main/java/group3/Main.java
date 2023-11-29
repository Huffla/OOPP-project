package group3;

import group3.modelFolder.Model;


public class Main {

    static Model model;
    
    public static void main(String[] args) {
        model = Model.getInstance("Users.txt","Questions.txt","Traits.txt","Characters.txt");
        SmurfinatorMainController smufinatormaincontroller = SmurfinatorMainController.getInstance();
        MainMenuController mainmenucontroller = new MainMenuController();
        model.setMainController(mainmenucontroller);
        model.setSmurfinatorController(smufinatormaincontroller);
        model.createSmurfinator();
        MainMenu.launchapp(args);
    }
    
       
   
}