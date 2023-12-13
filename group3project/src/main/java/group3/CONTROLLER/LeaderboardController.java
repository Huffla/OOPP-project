package group3.CONTROLLER;

import group3.modelFolder.leaderboard.LeaderboardInterface;

public class LeaderboardController {


    final int characterLeaderboardCode = 0;
    final int userLeaderboardCode = 1;

    LeaderboardInterface leaderboard;

    public LeaderboardController(LeaderboardInterface lbi){
        leaderboard = lbi;
    }
    public void switchCategoryCharacter() {
        leaderboard.switchCategory(characterLeaderboardCode);
    }

    public void switchCategoryUser() {
        leaderboard.switchCategory(userLeaderboardCode);
    }
}
