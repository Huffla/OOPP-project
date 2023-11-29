package group3.modelFolder;

public class QuestionInitializer {
    QuestionDatabaseHandler db;
    public QuestionInitializer(String s){
        db = new QuestionDatabaseHandler(s);
        
        
    }

    public void initialize(){
        db.clearList();
        db.createRangeQuestion("Hur stark är din karaktär?");
        db.createMultipleChoiceQuestion("Är karaktären snygg?");
        db.createMultipleChoiceQuestion("Är din karaktär af manligta grunder?");
        db.createRangeQuestion("Hur bra är karaktären på att köra?");
        db.createRangeQuestion("Hur många korvar käkar din karaktär per dag?");
        
    }
}
