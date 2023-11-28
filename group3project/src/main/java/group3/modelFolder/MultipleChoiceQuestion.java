package group3.modelFolder;

public class MultipleChoiceQuestion extends Question {

    public MultipleChoiceQuestion(String text){
        super(text);

    }

    public double answer_yes(){
        return 1.0;
    }
    public double answer_no(){
        return 0.0;
    }
    public double answer_dknow(){
        return 0.5;
    }
}