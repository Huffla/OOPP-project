package group3.modelFolder;

public class QuestionInitializer {
    QuestionDatabaseHandler db;
    public QuestionInitializer(String s){
        db = new QuestionDatabaseHandler(s);
        
        
    }

    public void initialize(){
        db.clearList();
        db.createRangeQuestion("Hur stark är din karaktär?", new Trait("kraft", 0.0));
        db.createMultipleChoiceQuestion("Är karaktären snygg?", new Trait("Snygghet", 0.0));
        db.createMultipleChoiceQuestion("Är din karaktär af manligta grunder?", new Trait("Man", 0.0));
        db.createRangeQuestion("Hur bra är karaktären på att köra?", new Trait("Körförmåga", 0.0));
        db.createRangeQuestion("Hur många korvar käkar din karaktär per dag?", new Trait("Korveater", 0.0));
        
    }
}
