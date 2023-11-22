package group3.modelFolder;

public class rangeQuestion extends Question {
    public rangeQuestion(String text, Trait trait){
        super(text, trait);

    }

    public Trait get_ranged_result(Double result){
        
        return new Trait(this.getQuestionTrait().getName(),result);
        
    }
}
