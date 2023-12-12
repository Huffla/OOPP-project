package group3;

import group3.modelFolder.model.Model;

public class Main {

    static Model model;

    public static void main(String[] args) {
        SceneTransitionHandler sceneTransitionHandler = SceneTransitionHandler.getInstance();
        model = Model.getInstance("Users.txt", "Questions.txt", "Traits.txt", "Characters.txt");
        SmurfinatorWindowHandler smurfinatorController = SmurfinatorWindowHandler.getInstance(model.getSmurfinator());
        MainMenuWindowHandler mainMenuWindowHandler = MainMenuWindowHandler.getInstance();
        CompendiumController compendiumController = CompendiumController.getInstance(model.getCompendium());
        LoginWindowHandler loginWindowHandler = LoginWindowHandler.getInstance(model.getLoginModel());
        LeaderboardController leaderboardController = LeaderboardController.getInstance(model.getLeaderboard());
        sceneTransitionHandler.setLeaderboardController(leaderboardController);
        sceneTransitionHandler.setLoginController(loginWindowHandler);
        sceneTransitionHandler.setSmurfinatorWindowHandler(smurfinatorController);
        sceneTransitionHandler.setMainMenuController(mainMenuWindowHandler);
        sceneTransitionHandler.setCompendiumController(compendiumController);
        MainMenu.launchapp(args);

    }

}