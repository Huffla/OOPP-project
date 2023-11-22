package group3.modelFolder;

import java.util.ArrayList;

public class Leaderboard implements Observer{

    private Category category;
    private CategoryUser usercat;
    private CategoryCharacter charactercat;

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
        for(int i = 0; i<u.size();i++){
            usercat.list.add(u.get(i));
        }
        charactercat.list.clear();
        for(int i = 0; i<c.size();i++){
            charactercat.list.add(c.get(i));
        }
        usercat.sort();
        charactercat.sort();
    }


}
