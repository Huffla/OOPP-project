package group3.modelFolder.leaderboard.category;

import group3.modelFolder.leaderboard.LeaderboardEntry;
import group3.modelFolder.leaderboard.UserLeaderboardEntry;

import java.util.ArrayList;

public class CategoryUser extends Category{

    public CategoryUser(ArrayList<UserLeaderboardEntry> list, int i) {
        this.name = "amount of contributions";
        this.list = userListToLbEList(list);
        this.categoryCode = i;
    }

    // turn a list of UserLeaderboardEntry into a list of LeaderboardEntry
    public ArrayList<LeaderboardEntry> userListToLbEList(ArrayList<UserLeaderboardEntry> list){
        return new ArrayList<>(list);
    }

    // return the list of LeaderboardEntry
    public ArrayList<LeaderboardEntry> getList(){
        return this.list;
    }
}