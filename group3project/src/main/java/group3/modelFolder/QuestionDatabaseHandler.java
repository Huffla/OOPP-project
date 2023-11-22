package group3.modelFolder;

import java.util.ArrayList;

public class QuestionDatabaseHandler extends DatabaseHandler{

    public QuestionDatabaseHandler(String s) {
        super(s);

    }
    public void createMultipleChoiceQuestion(String s, Trait t){
        addToList(new MultipleChoiceQuestion(s, t));
    }
    public void createRangeQuestion(String s, Trait t){
        addToList(new rangeQuestion(s, t));
    }
    public ArrayList<Question> getQuestions(){
        ArrayList<Question> questions = new ArrayList<>();
        for(Object elem: data_list){
            questions.add((Question) elem);
        }
        return questions;
    }
    public void addQuestion(Question q) {
        addToList(q);
    }
    


}
