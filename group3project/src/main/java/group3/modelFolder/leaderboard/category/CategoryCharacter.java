package group3.modelFolder.leaderboard.category;

import group3.modelFolder.leaderboard.CharacterLeaderboardEntry;
import group3.modelFolder.leaderboard.LeaderboardEntry;

import java.util.ArrayList;

public class CategoryCharacter extends Category{

    public CategoryCharacter(ArrayList<CharacterLeaderboardEntry> list, int i) {
        this.name = "amount of times guessed";
        this.list = charListToLbEList(list);
        this.categoryCode = i;
    }

    // turn a list of CharacterLeaderboardEntry into a list of LeaderboardEntry
    public ArrayList<LeaderboardEntry> charListToLbEList(ArrayList<CharacterLeaderboardEntry> list){
        return new ArrayList<>(list);
    }

    // return the list of LeaderboardEntry
    public ArrayList<LeaderboardEntry> getList(){
        return this.list;
    }
}