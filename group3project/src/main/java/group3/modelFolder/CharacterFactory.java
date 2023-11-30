package group3.modelFolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;

public class CharacterFactory {

    public CharacterFactory(){
    }
    private ArrayList<Trait> createTraitsFromStrings(Dictionary<String,Double> s){
        ArrayList<Trait> traits = new ArrayList<>();
        for(String name : Collections.list(s.keys())){
            traits.add(new Trait(name, s.get(name)));
        }
        return traits;
    }
    public  Character createCharacter(Dictionary<String,Double> characterTraitsNames, String name, String characterImage) {
        return new Character(createTraitsFromStrings(characterTraitsNames), name, characterImage);
    }
    public  Character createCharacter(Dictionary<String,Double> characterTraitsNames, String name) {
        return new Character(createTraitsFromStrings(characterTraitsNames), name);
    }
    public Character createCharacter(ArrayList<Trait> traits, String name,String path){
        return new Character(traits, name, path);
    }
    public Character createCharacter(ArrayList<Trait> traits, String name){
        return new Character(traits, name);
    }
    public  Character createCharacter(String name) {
        return new Character(name);
    }
}
