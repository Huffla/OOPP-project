package group3.modelFolder;

public class MultipleChoiceQuestion extends Question {
    
    public MultipleChoiceQuestion(String text, Trait trait){
        super(text, trait);

    }

    public Trait answer_yes(){
        return new Trait(getQuestionTrait().getName() , 1.0);
    }
    public Trait answer_no(){
        return new Trait(getQuestionTrait().getName(), 0.0);
    }
    public Trait answer_dknow(){
        return new Trait(getQuestionTrait().getName(), 0.5);
    }
}
