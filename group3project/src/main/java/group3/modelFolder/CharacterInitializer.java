package group3.modelFolder;

import java.util.ArrayList;

import java.util.Hashtable;

public class CharacterInitializer {
    CharacterFactory cf = new CharacterFactory();
    CharacterDatabaseHandler cdh = new CharacterDatabaseHandler("Characters.txt");
    public CharacterInitializer(){
        
    }
    public ArrayList<Character> intialize(){
        cdh.clearList();
        ArrayList<Character> characters = new ArrayList<>();
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("BOY", 1.0);
            put("OLD", 1.0);
            put("CALM", 1.0);
            put("GLASSES", 1.0);
            put("FACIAL HAIR", 1.0);
            put("HAT", 1.0);
            put("DRUNK DRIVER", 0.7);
        }}, "old smurf (Alcoholic)"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
             put("BOY", 1.0);
            put("OLD", 1.0);
            put("KIND", 1.0);
            put("CALM", 1.0);
            put("GLASSES", 1.0);
            put("FACIAL HAIR", 1.0);
            put("HAT", 1.0);
            put("DRUNK DRIVER", 0.7);
        }}, "old smurf"));

        
        
        cdh.addCharacters(characters);
        return characters;
    }
}
