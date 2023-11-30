package group3.modelFolder;

public class TraitIntitializer {
    TraitDatabaseHandler db;
    public TraitIntitializer(String s){
        db = new TraitDatabaseHandler(s);
        
        
    }

    public void initialize(){
        db.clearList();
        db.addTrait(new Trait("GIRL", 0.0));
        db.addTrait(new Trait("BOY", 0.0));
        db.addTrait(new Trait("STRONG", 0.0));
        db.addTrait(new Trait("OLD", 0.0));
        db.addTrait(new Trait("SMART", 0.0));
        db.addTrait(new Trait("BABY", 0.0));
        db.addTrait(new Trait("KIND", 0.0));
        db.addTrait(new Trait("PRETTY", 0.0));
        db.addTrait(new Trait("ANGRY", 0.0));
        db.addTrait(new Trait("CLUMSY", 0.0));
        db.addTrait(new Trait("CALM", 0.0));
        db.addTrait(new Trait("ANIMAL", 0.0));
        db.addTrait(new Trait("GLASSES", 0.0));
        db.addTrait(new Trait("FACIAL HAIR", 0.0));
        db.addTrait(new Trait("HAT", 0.0));
        db.addTrait(new Trait("DRUNK DRIVER", 0.0));
    }
}
