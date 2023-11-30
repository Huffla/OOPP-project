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
            put("KIND", 1.0);
            put("CALM", 1.0);
            put("GLASSES", 1.0);
            put("FACIAL HAIR", 1.0);
            put("HAT", 1.0);
            put("DRUNK DRIVER", 0.7);
        }}, "Old Smurf (Alcoholic)"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("BOY", 1.0);
            put("OLD", 1.0);
            put("KIND", 1.0);
            put("CALM", 1.0);
            put("GLASSES", 1.0);
            put("FACIAL HAIR", 1.0);
            put("HAT", 1.0);
            put("DRUNK DRIVER", 0.7);
        }}, "Old Smurf"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("BOY", 1.0);
            put("INVENTOR", 1.0);
            put("ALCHEMIST", 1.0);
            put("CALM", 1.0);
            put("GLASSES", 1.0);
            put("SMART", 1.0);
            put("HAT", 1.0);
            put("CREATIVE", 1.0);
        }}, "Alchemist Smurf"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("GIRL", 1.0);
            put("KIND", 1.0);
            put("BABY", 1.0);
            put("FRECKLES", 1.0);
            put("LONG HAIR", 1.0);
            put("PLAYFUL", 1.0);
            put("HAT", 1.0);
            put("FUNNY", 1.0);
        }}, "Sussette Smurf"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("MALE", 1.0);
            put("MECHANICAL", 1.0);
            put("MURDERER", 1.0);
            put("EVIL", 1.0);
            put("SMART", 1.0);
            put("PLAYFUL", 1.0);
            put("HAT", 1.0);
            put("FUNNY", 1.0);
        }}, "Clockwork Smurf"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("BOY", 1.0);
            put("INVENTOR", 1.0);
            put("HANDY", 1.0);
            put("CALM", 1.0);
            put("STRONG", 1.0);
            put("SMART", 1.0);
            put("HAT", 1.0);
            put("CREATIVE", 1.0);
        }}, "Handy Smurf"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("BOY", 1.0);
            put("HUMAN", 1.0);
            put("PLAYFUL", 1.0);
            put("KIND", 1.0);
            put("BRAVE", 1.0);
            put("SMART", 1.0);
            put("BLACK HAIR", 1.0);
            put("LEADER", 1.0);
        }}, "Sir Johan"));




        cdh.addCharacters(characters);
        return characters;
    }
}
