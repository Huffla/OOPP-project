package group3.modelFolder;

import java.io.Serializable;

public abstract class Question implements Serializable{

    private final String questionText;
    private final Trait questionTrait;

    public Question(String questionText, Trait questionTrait){
        this.questionText = questionText;
        this.questionTrait = questionTrait;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Trait getQuestionTrait() {
        return questionTrait;
    }
}
