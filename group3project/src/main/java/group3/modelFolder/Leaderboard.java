package group3.modelFolder;

import java.util.ArrayList;

public class Leaderboard implements Observer{

    private Category category;
    private final CategoryUser usercat;
    private final CategoryCharacter charactercat;

    public Leaderboard(Category input){
        category = input;
        usercat = new CategoryUser();
        charactercat = new CategoryCharacter();
        
    }

    public void switchToCategoryUser(){
        category = usercat;
    };
    public void switchToCategoryCharacter(){
        category = charactercat;
    };


    @Override
    public void update(ArrayList<User> u, ArrayList<Character> c) {
        usercat.list.clear();
        usercat.list.addAll(u);
        charactercat.list.clear();
        charactercat.list.addAll(c);
        usercat.sort();
        charactercat.sort();
    }

    public ArrayList<User> getUserLeaderboard(){
        ArrayList<User> tempArr = new ArrayList<>();
        for(int i = 0; i<usercat.list.size(); i++){
            tempArr.add((User) usercat.list.get(i));
        }
        return tempArr;
    }
    public ArrayList<Character> getCharacterLeaderboard(){
        ArrayList<Character> tempArr = new ArrayList<>();
        for(int i = 0; i<charactercat.list.size(); i++){
            tempArr.add((Character) charactercat.list.get(i));
        }
        return tempArr;
    }

}
