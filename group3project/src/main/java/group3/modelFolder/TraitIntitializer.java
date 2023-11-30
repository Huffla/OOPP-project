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
        db.addTrait(new Trait("SELF CENTERED", 0.0));
        db.addTrait(new Trait("FUNNY", 0.0));
        db.addTrait(new Trait("MAGIC", 0.0));
        db.addTrait(new Trait("CREATIVE", 0.0));
        db.addTrait(new Trait("BLOND", 0.0));
        db.addTrait(new Trait("FRECKLES", 0.0));
        db.addTrait(new Trait("EVIL", 0.0));
        db.addTrait(new Trait("LONG HAIR", 0.0));
        db.addTrait(new Trait("TATTOO", 0.0));
        db.addTrait(new Trait("JACKET", 0.0));
        db.addTrait(new Trait("UGLY", 0.0));
        db.addTrait(new Trait("BLACK HAIR", 0.0));
        db.addTrait(new Trait("MONSTER", 0.0));
        db.addTrait(new Trait("HUMAN", 0.0));
        db.addTrait(new Trait("PLAYFUL", 0.0));
        db.addTrait(new Trait("INVENTOR", 0.0));
        db.addTrait(new Trait("ARTISTIC", 0.0));
        db.addTrait(new Trait("FOODIE", 0.0));
        db.addTrait(new Trait("LEADER", 0.0));
        db.addTrait(new Trait("ALCHEMIST", 0.0));
        db.addTrait(new Trait("MECHANICAL", 0.0));
        db.addTrait(new Trait("MURDERER", 0.0));
        db.addTrait(new Trait("HANDY", 0.0));
        db.addTrait(new Trait("BRAVE", 0.0));
        db.addTrait(new Trait("MUSICIAN", 0.0));
        db.addTrait(new Trait("VIOLENT", 0.0));
        db.addTrait(new Trait("DUMB", 0.0));
        db.addTrait(new Trait("SKIRT", 0.0));
        db.addTrait(new Trait("WEAPON", 0.0));
        db.addTrait(new Trait("RELIGIOUS", 0.0));
        db.addTrait(new Trait("DRESS", 0.0));








    }
}
