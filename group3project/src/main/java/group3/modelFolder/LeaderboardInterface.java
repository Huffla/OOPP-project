package group3.modelFolder;

import java.util.ArrayList;

public interface LeaderboardInterface {
    void switchCategory(int i);
    public void updateLeaderboard();
    public ArrayList<LeaderboardEntry> getLeaderboard();
    public void addObserver(LeaderboardObserver so);

    void makeInitialCall();
}
