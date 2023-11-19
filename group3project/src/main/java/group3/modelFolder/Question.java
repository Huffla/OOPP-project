package group3.modelFolder;

public abstract class Question {

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
