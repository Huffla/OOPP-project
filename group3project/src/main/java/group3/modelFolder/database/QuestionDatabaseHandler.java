package group3.modelFolder.database;

import group3.modelFolder.question.MultipleChoiceQuestion;
import group3.modelFolder.question.Question;
import group3.modelFolder.question.rangeQuestion;

import java.util.ArrayList;

public class QuestionDatabaseHandler extends DatabaseHandler{

    public QuestionDatabaseHandler(String s) {
        super(s);

    }
    public void createMultipleChoiceQuestion(String s){
        addToList(new MultipleChoiceQuestion(s));
    }
    public void createRangeQuestion(String s){
        addToList(new rangeQuestion(s));
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
