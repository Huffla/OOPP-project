package group3.modelFolder;

import java.util.ArrayList;

public class QuestionHandler extends DatabaseHandler{

    public QuestionHandler() {
        super("Question.txt");

    }
    public ArrayList<Question> getQuestions(){
        ArrayList<Question> questions = new ArrayList<>();
        for(Object elem: data_list){
            questions.add((Question) elem);
        }
        return questions;
    }


}
