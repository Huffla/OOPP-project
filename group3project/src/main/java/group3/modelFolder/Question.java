package group3.modelFolder;

import java.io.Serializable;

public class Question implements Serializable{

    private final String questionText;
    

    public Question(String questionText){
        this.questionText = questionText;
       
    }

    public String getQuestionText() {
        return questionText;
    }
}

   
