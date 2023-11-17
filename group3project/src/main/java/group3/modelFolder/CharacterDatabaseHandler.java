package group3.modelFolder;

import java.util.ArrayList;

public class CharacterDatabaseHandler extends DatabaseHandler{

    public CharacterDatabaseHandler() {
        super("Characters.txt");
        
    }
    public ArrayList<Character> getCharacters(){
        ArrayList<Character> characters = new ArrayList<>();
        for(Object elem: data_list){
            characters.add((Character)elem);
        }
        return characters;
    }

    public void removeCharacter(){
    
    }
    
    
}
