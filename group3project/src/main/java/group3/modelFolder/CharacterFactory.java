package group3.modelFolder;

import java.awt.*;
import java.util.ArrayList;

public class CharacterFactory {

    public CharacterFactory(){
    }
    public static Character createCharacter(ArrayList<Trait> characterTraits, String name, Image characterImage) {
        return new Character(characterTraits, name, characterImage);
    }
    public static Character createCharacter(ArrayList<Trait> characterTraits, String name) {
        return new Character(characterTraits, name);
    }
    public static Character createCharacter(String name) {
        return new Character(name);
    }
}
