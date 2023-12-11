package group3.modelFolder;

public class CharacterLeaderboardEntry implements LeaderboardEntry{

    private Character character;
    private int sortValue;
    private String name;

    // Class representing a character in the leaderboard
    public CharacterLeaderboardEntry(Character character, int sortValue){
        this.character = character;
        this.name = character.getName();
        this.sortValue = sortValue;
    }

    public String getName(){
        return name;
    }

    public int getSortValue(){
        return sortValue;
    }
}
