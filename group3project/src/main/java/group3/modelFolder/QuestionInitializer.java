package group3.modelFolder;

public class QuestionInitializer {
    QuestionDatabaseHandler db;
    public QuestionInitializer(String s){
        db = new QuestionDatabaseHandler(s);
        
        
    }

    public void initialize(){
        db.clearList();
        
        db.createMultipleChoiceQuestion("Is your character a girl?");
        db.createMultipleChoiceQuestion("Is your character male?");
        db.createMultipleChoiceQuestion("Is your character strong?");
        db.createMultipleChoiceQuestion("Is your character old?");
        db.createMultipleChoiceQuestion("Is your character smart?");
        db.createMultipleChoiceQuestion("Is your character very young?");
        db.createMultipleChoiceQuestion("Is your character nice to others?");
        db.createMultipleChoiceQuestion("Is your character good looking?");
        db.createMultipleChoiceQuestion("Does your character have anger issues?");
        db.createMultipleChoiceQuestion("Does your character make a lot of mistakes?");
        db.createMultipleChoiceQuestion("Is your character considered calm?");
        db.createMultipleChoiceQuestion("Is your character an animal?");
        db.createMultipleChoiceQuestion("Does your character wear glasses?");
        db.createMultipleChoiceQuestion("Does your character have facial hair");
        db.createMultipleChoiceQuestion("Does your character wear a hat?");
        db.createRangeQuestion("How likely is your character to drive drunk when drinking fermented hallonsaft?");
        db.createMultipleChoiceQuestion("Does your character care more for themselves than others?");
        db.createMultipleChoiceQuestion("Is your character considered funny?");
        db.createMultipleChoiceQuestion("Does your character possess magical abilities?");
        db.createMultipleChoiceQuestion("Is your character creative?");
        db.createMultipleChoiceQuestion("Does your character have blond hair?");
        db.createMultipleChoiceQuestion("Does your character have freckles?");
        db.createMultipleChoiceQuestion("Is your character evil?");
    }
}
