package group3.modelFolder;

import java.util.ArrayList;

import java.util.Hashtable;

public class CharacterInitializer {
    CharacterFactory cf = new CharacterFactory();
    CharacterDatabaseHandler cdh = new CharacterDatabaseHandler("Characters.txt");
    public CharacterInitializer(){

    }

    // initialize the characters
    public ArrayList<Character> intialize(){
        cdh.clearList();
        ArrayList<Character> characters = new ArrayList<>();
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("BOY", 1.0);
            put("LEADER", 1.0);
            put("OLD", 1.0);
            put("KIND", 1.0);
            put("CALM", 1.0);
            put("SMURF", 1.0);
            put("GLASSES", 1.0);
            put("FACIAL HAIR", 1.0);
            put("HAT", 1.0);
            put("DRUNK DRIVER", 0.7);
            put("MAGIC", 1.0);
            put("VIOLENT", 1.0);
        }}, "Papa Smurf (Alcoholic)", "/gammelsmorf.png"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("BOY", 1.0);
            put("LEADER", 1.0);
            put("OLD", 1.0);
            put("KIND", 1.0);
            put("SMURF", 1.0);
            put("CALM", 1.0);
            put("GLASSES", 1.0);
            put("FACIAL HAIR", 1.0);
            put("HAT", 1.0);
            put("DRUNK DRIVER", 0.1);
            put("MAGIC", 1.0);
        }}, "Papa Smurf", "/sussypapasmurf.png"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("BOY", 1.0);
            put("INVENTOR", 1.0);
            put("ALCHEMIST", 1.0);
            put("CALM", 1.0);
            put("SMURF", 1.0);
            put("GLASSES", 1.0);
            put("SMART", 1.0);
            put("HAT", 1.0);
            put("CREATIVE", 1.0);
        }}, "Alchemist Smurf", "/alchemistsmurf.png"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("GIRL", 1.0);
            put("KIND", 1.0);
            put("YOUNG", 1.0);
            put("SMURF", 1.0);
            put("FRECKLES", 1.0);
            put("LONG HAIR", 1.0);
            put("PLAYFUL", 1.0);
            put("HAT", 1.0);
            put("FUNNY", 1.0);
            put("BABY", 1.0);
        }}, "Sussette Smurf", "/Sassette_Smurfling.png"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("MALE", 1.0);
            put("MECHANICAL", 1.0);
            put("MURDERER", 1.0);
            put("SMURF", 1.0);
            put("EVIL", 1.0);
            put("SMART", 1.0);
            put("PLAYFUL", 1.0);
            put("HAT", 1.0);
            put("FUNNY", 1.0);
            put("VIOLENT", 1.0);
        }}, "Clockwork Smurf", "/Clowckworksmurf.png"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("BOY", 1.0);
            put("INVENTOR", 1.0);
            put("HANDY", 1.0);
            put("CALM", 1.0);
            put("STRONG", 1.0);
            put("SMURF", 1.0);
            put("SMART", 1.0);
            put("HAT", 1.0);
            put("CREATIVE", 1.0);
            put("WEAPON", 1.0);
        }}, "Handy Smurf", "/Handy_Smurf.png"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("BOY", 1.0);
            put("HUMAN", 1.0);
            put("PLAYFUL", 1.0);
            put("KIND", 1.0);
            put("BRAVE", 1.0);
            put("SMART", 1.0);
            put("BLACK HAIR", 1.0);
            put("LEADER", 1.0);
        }}, "Sir Johan", "/sirjohan.png"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("BOY", 1.0);
            put("MUSICIAN", 1.0);
            put("PLAYFUL", 1.0);
            put("HAT", 1.0);
            put("SMURF", 1.0);
            put("KIND", 1.0);
            put("CALM", 1.0);
            put("CREATIVE", 1.0);
            put("ARTISTIC", 1.0);
        }}, "Lute Smurf", "/lutesmorf.png"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("BOY", 1.0);
            put("FACIAL HAIR", 1.0);
            put("BRAVE", 1.0);
            put("HAT", 1.0);
            put("SMURF", 1.0);
            put("KIND", 1.0);
            put("CALM", 1.0);
            put("VIOLENT", 1.0);
            put("SKIRT", 1.0);
        }}, "Gutsy Smurf", "/Untitled.png"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("GIRL", 1.0);
            put("BLACK HAIR", 1.0);
            put("SMURF", 1.0);
            put("EVIL", 1.0);
            put("HAT", 1.0);
            put("SKIRT", 1.0);
            put("CALM", 1.0);
            put("VIOLENT", 1.0);
            put("SMART", 1.0);
        }}, "Vexy", "/vexy.png"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("GIRL", 1.0);
            put("SMURF", 1.0);
            put("KIND", 1.0);
            put("CALM", 1.0);
            put("HAT", 1.0);
            put("SKIRT", 1.0);
            put("PRETTY", 1.0);
            put("BLOND HAIR", 1.0);
            put("SMART", 1.0);
        }}, "Smurfette", "/Smurfette.png"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("GIRL", 1.0);
            put("OLD", 1.0);
            put("HAT", 1.0);
            put("SMURF", 1.0);
            put("LEADER", 1.0);
            put("DRESS", 1.0);
            put("WEAPON", 1.0);
            put("CALM", 1.0);
            put("SMART", 1.0);
        }}, "Smurfwillow", "/SmurfWillow.png"));
        characters.add( cf.createCharacter(new Hashtable<String, Double>(){{
            put("BOY", 1.0);
            put("OLD", 1.0);
            put("HAT", 1.0);
            put("LEADER", 1.0);
            put("KIND", 1.0);
            put("SMURF", 1.0);
            put("DRESS", 1.0);
            put("CALM", 1.0);
            put("RELIGIOUS", 1.0);
            put("FACIAL HAIR", 1.0);
            put("DRUNK DRIVER", 0.1);
        }}, "Pastor Joseff", "/Abloec_As_Pastor_Joseff.png"));




        cdh.addCharacters(characters);
        return characters;
    }
}
