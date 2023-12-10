package group3;

import group3.modelFolder.Model;

public class Main {

    static Model model;

    public static void main(String[] args) {
        model = Model.getInstance("Users.txt", "Questions.txt", "Traits.txt", "Characters.txt");
        SmurfinatorMainController smurfinatorController = SmurfinatorMainController.getInstance(model.getSmurfinator());
        MainMenuController mainMenuController = MainMenuController.getInstance();
        LoginController loginController = LoginController.getInstance(model.getLoginModel());
        loginController.setMainMenuController(mainMenuController);
        mainMenuController.setSmurfinatorController(smurfinatorController);

        MainMenu.launchapp(args);

    }

}