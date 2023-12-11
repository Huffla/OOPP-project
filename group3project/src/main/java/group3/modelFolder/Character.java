package group3.modelFolder;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Character implements Serializable, LeaderboardEntry{

    private ArrayList<Trait> characterTraits;
    private final String name;
    private String imagePath;
    private int guessedAmount;

    public Character(ArrayList<Trait> characterTraits, String name, String imagePath) {
        this.characterTraits = characterTraits;
        this.name = name;
        this.imagePath = imagePath;
        this.guessedAmount = 0;
    }
    public Character(ArrayList<Trait> characterTraits, String name) {
        this.characterTraits = characterTraits;
        this.name = name;
        this.guessedAmount = 0;

    }
    public Character(String name) {
        this.name = name;
        this.guessedAmount = 0;
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
    public String getImagePath() {
        try {
            return imagePath;
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }
    public void increaseGuessedAmount(){
        guessedAmount++;
    }
    public int getGuessedAmount(){
        return guessedAmount;
    }
    public int getSortValue(){
        return this.getGuessedAmount();
    }

}