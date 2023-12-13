package group3;

import group3.CONTROLLER.CompendiumController;
import group3.modelFolder.model.Model;

public class Main {

    static Model model;

    public static void main(String[] args) {
        SceneTransitionHandler sceneTransitionHandler = SceneTransitionHandler.getInstance();
        model = Model.getInstance("Users.txt", "Questions.txt", "Traits.txt", "Characters.txt");
        SmurfinatorWindowHandler smurfinatorWindowHandler = SmurfinatorWindowHandler.getInstance(model.getSmurfinator());
        MainMenuWindowHandler mainMenuWindowHandler = MainMenuWindowHandler.getInstance();
        CompendiumController compendiumController = CompendiumController.getInstance(model.getCompendium());
        LoginWindowHandler loginWindowHandler = LoginWindowHandler.getInstance(model.getLoginModel());
        LeaderboardWindowHandler leaderboardWindowHandler = LeaderboardWindowHandler.getInstance(model.getLeaderboard());
        sceneTransitionHandler.setLeaderboardController(leaderboardWindowHandler);
        sceneTransitionHandler.setLoginController(loginWindowHandler);
        sceneTransitionHandler.setSmurfinatorWindowHandler(smurfinatorWindowHandler);
        sceneTransitionHandler.setMainMenuController(mainMenuWindowHandler);
        sceneTransitionHandler.setCompendiumController(compendiumController);
        MainMenu.launchapp(args);

    }

}