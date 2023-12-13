package group3.modelFolder.trait;

import group3.modelFolder.database.TraitDatabaseHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TraitIntitializer {
    TraitDatabaseHandler db;
    public TraitIntitializer(String s){
        db = new TraitDatabaseHandler(s);


    }

    private void addTraitToDb(Scanner scan){
        String line;
        String mainTrait = null;
        ArrayList<String> oppositeTraits = new ArrayList<>();

        while (scan.hasNextLine()) {
            line = scan.nextLine();
            if(line.equals("STOP")){
                db.addTrait(new Trait(mainTrait, 0.0, oppositeTraits));
                mainTrait = null;
                oppositeTraits = new ArrayList<>();
            }
            else{
                if(mainTrait == null){
                    mainTrait = line;
                }
                else{
                    oppositeTraits.add(line);
                }
            }
        }
    }

    public void loadTraits() {
        File file = new File("traitlist.txt");
        Scanner scan;

        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        addTraitToDb(scan);
    }

    public void initialize(){
        db.clearList();
        loadTraits();



    }
}
