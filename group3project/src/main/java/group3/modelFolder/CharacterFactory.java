package group3.modelFolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CharacterFactory {

    public CharacterFactory(){
    }
    private ArrayList<Trait> createTraitsFromStrings(Dictionary<String,Double> s){

        ArrayList<Trait> traits = new ArrayList<>();
        File file = new File("traitlist.txt");
        Scanner scan;
        String line;
        String mainTrait = null;
        ArrayList<String> oppositeTraits = new ArrayList<>();

        for(String name : Collections.list(s.keys())){
            try {
                scan = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                if(line.equals("STOP")){
                    if(mainTrait != null && mainTrait.equals(name)) traits.add(new Trait(name, s.get(name), oppositeTraits));
                    mainTrait = null;
                    oppositeTraits = new ArrayList<>();
                }
                if(mainTrait == null){
                    mainTrait = line;
                }
                else{
                    oppositeTraits.add(line);
                }
            }
            traits.add(new Trait(name, s.get(name), oppositeTraits));
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
