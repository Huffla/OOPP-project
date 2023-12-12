package group3.modelFolder.database;

import group3.modelFolder.character.Character;

import java.util.ArrayList;

public class CharacterDatabaseHandler extends DatabaseHandler{

    public CharacterDatabaseHandler(String name) {
        super(name);
        
    }
    
    public ArrayList<Character> getCharacters(){
        ArrayList<Character> characters = new ArrayList<>();
        for(Object elem: data_list){
            characters.add((Character)elem);
        }
        return characters;
    }

    public void addCharacters(ArrayList<Character> cList){
        for(Character c: cList){
            super.addToList(c);
        }
    }

    public void addCharacter(Character c){
        super.addToList(c);
    }

    public void removeCharacter(Character c){
        
    }
    
    
}
