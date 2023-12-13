package group3.modelFolder.leaderboard;


import group3.modelFolder.leaderboard.category.Category;

public interface LeaderboardObserver {
    public void updateLeaderboardField(Category category);
}
