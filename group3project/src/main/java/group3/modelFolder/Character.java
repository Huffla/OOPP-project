package group3.modelFolder;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Character implements Serializable{

    private ArrayList<Trait> characterTraits;
    private final String name;
    private Image characterImage;

    public Character(ArrayList<Trait> characterTraits, String name, Image characterImage) {
        this.characterTraits = characterTraits;
        this.name = name;
        this.characterImage = characterImage;
    }
    public Character(ArrayList<Trait> characterTraits, String name) {
        this.characterTraits = characterTraits;
        this.name = name;
    }
    public Character(String name) {
        this.name = name;
    }

    public ArrayList<Trait> getCharacterTraits() {
        try {
            return characterTraits;
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }
    public String getName() {
        try {
            return name;
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }
    public Image getCharacterImage() {
        try {
            return characterImage;
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }
}