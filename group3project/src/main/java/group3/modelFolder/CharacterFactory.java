package group3.modelFolder;

import java.awt.*;
import java.util.ArrayList;

public class CharacterFactory {

    public CharacterFactory(){
    }
    public  Character createCharacter(ArrayList<Trait> characterTraits, String name, String characterImage) {
        return new Character(characterTraits, name, characterImage);
    }
    public  Character createCharacter(ArrayList<Trait> characterTraits, String name) {
        return new Character(characterTraits, name);
    }
    public  Character createCharacter(String name) {
        return new Character(name);
    }
}
