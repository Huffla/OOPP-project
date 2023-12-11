package group3;

import group3.modelFolder.Model;

public class Main {

    static Model model;

    public static void main(String[] args) {
        SceneTransitionHandler sceneTransitionHandler = SceneTransitionHandler.getInstance();
        model = Model.getInstance("Users.txt", "Questions.txt", "Traits.txt", "Characters.txt");
        SmurfinatorMainController smurfinatorController = SmurfinatorMainController.getInstance(model.getSmurfinator());
        MainMenuController mainMenuController = MainMenuController.getInstance();
        CompendiumController compendiumController = CompendiumController.getInstance(model.getCompendium());

        sceneTransitionHandler.setSmurfinatorController(smurfinatorController);
        sceneTransitionHandler.setMainMenuController(mainMenuController);
        sceneTransitionHandler.setCompendiumController(compendiumController);

        MainMenu.launchapp(args);

    }

}