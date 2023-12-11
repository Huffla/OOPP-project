package group3;

import group3.modelFolder.Model;


public class Main {

    static Model model;
    
    public static void main(String[] args) {
        SceneTransitionHandler sceneTransitionHandler = SceneTransitionHandler.getInstance();
        model = Model.getInstance("Users.txt","Questions.txt","Traits.txt","Characters.txt");
        SmurfinatorMainController smurfinatorController = SmurfinatorMainController.getInstance(model.getSmurfinator());
        LeaderboardController leaderboardController = LeaderboardController.getInstance(model.getLeaderboard());
        MainMenuController mainMenuController = MainMenuController.getInstance();
        sceneTransitionHandler.setSmurfinatorController(smurfinatorController);
        sceneTransitionHandler.setLeaderboardController(leaderboardController);
        sceneTransitionHandler.setMainMenuController(mainMenuController);
        MainMenu.launchapp(args);
        
    }
    
       
   
}