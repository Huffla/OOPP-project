package group3.modelFolder;

public class TraitIntitializer {
    TraitDatabaseHandler db;
    public TraitIntitializer(String s){
        db = new TraitDatabaseHandler(s);
        
        
    }

    public void initialize(){
        db.clearList();
        db.addTrait(new Trait("kraft", 0.0));
        db.addTrait(new Trait("Snygghet", 0.0));
        db.addTrait(new Trait("Man", 0.0));
        db.addTrait(new Trait("Körförmåga", 0.0));
        db.addTrait(new Trait("Korveater", 0.0));
    }
}
