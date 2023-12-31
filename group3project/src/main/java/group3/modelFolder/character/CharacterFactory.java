package group3.modelFolder.character;

import group3.modelFolder.trait.Trait;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CharacterFactory {

    public CharacterFactory(){
    }

    //Scans traitlist.txt to find the opposite traits of the trait with the name s
    private ArrayList<String> createTraitOpposites(String s){
        File file = new File("traitlist.txt");
        Scanner scan;
        String line;
        String mainTrait = null;
        ArrayList<String> oppositeTraits = new ArrayList<>();

        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            if(line.equals("STOP")){
                assert mainTrait != null;
                if(mainTrait.equals(s)) break;
                mainTrait = null;
                oppositeTraits = new ArrayList<>();
            }
            else if(mainTrait == null){
                mainTrait = line;
            }
            else{
                oppositeTraits.add(line);
            }
        }
        return oppositeTraits;
    }

    //creates a trait from its name and a value
    private ArrayList<Trait> createTraitsFromStrings(Dictionary<String,Double> s){

        ArrayList<Trait> traits = new ArrayList<>();
        for(String name : Collections.list(s.keys())){
            createTraitOpposites(name);
            traits.add(new Trait(name, s.get(name), createTraitOpposites(name)));
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
