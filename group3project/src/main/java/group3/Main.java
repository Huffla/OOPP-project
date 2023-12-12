package group3;

import group3.modelFolder.Model;

public class Main {

    static Model model;

    public static void main(String[] args) {
        SceneTransitionHandler sceneTransitionHandler = SceneTransitionHandler.getInstance();
        model = Model.getInstance("Users.txt", "Questions.txt", "Traits.txt", "Characters.txt");
        SmurfinatorWindowHandler smurfinatorController = SmurfinatorWindowHandler.getInstance(model.getSmurfinator());
        MainMenuController mainMenuController = MainMenuController.getInstance();
        CompendiumController compendiumController = CompendiumController.getInstance(model.getCompendium());
        LoginController loginController = LoginController.getInstance(model.getLoginModel());
        LeaderboardController leaderboardController = LeaderboardController.getInstance(model.getLeaderboard());
        sceneTransitionHandler.setLeaderboardController(leaderboardController);
        sceneTransitionHandler.setLoginController(loginController);
        sceneTransitionHandler.setSmurfinatorWindowHandler(smurfinatorController);
        sceneTransitionHandler.setMainMenuController(mainMenuController);
        sceneTransitionHandler.setCompendiumController(compendiumController);
        MainMenu.launchapp(args);

    }

}