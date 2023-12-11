package group3.modelFolder;

import java.util.ArrayList;

public class CategoryCharacter extends Category{

    public CategoryCharacter(ArrayList<Character> list, int i) {
        this.name = "amount of times guessed";
        this.list = charListToLbEList(list);
        this.categoryCode = i;
    }

    public ArrayList<LeaderboardEntry> charListToLbEList(ArrayList<Character> list){
        ArrayList<LeaderboardEntry> temp = new ArrayList<>();
        for (Character character : list) {
            temp.add(character);
        }
        return temp;
    }
    public ArrayList<LeaderboardEntry> getList(){
        return this.list;
    }
}