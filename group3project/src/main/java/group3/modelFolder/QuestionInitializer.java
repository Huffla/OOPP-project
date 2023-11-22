package group3.modelFolder;

public class QuestionInitializer {
    QuestionDatabaseHandler db;
    public QuestionInitializer(String s){
        db = new QuestionDatabaseHandler(s);
        
        
    }

    public void initialize(){
        db.clearList();
    }
}
