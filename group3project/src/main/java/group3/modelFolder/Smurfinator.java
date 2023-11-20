package group3.modelFolder;
import java.util.Random;
import java.util.ArrayList;

public class Smurfinator {
    ArrayList<Question> questions;
    ArrayList<Question> askableQuestions;
    ArrayList<Trait> traits;
    ArrayList<Character> characters;
    User user;
    ArrayList<Trait> accurateTraits;
    ArrayList<Question> askedQuestions;
    Character guessedCharacter;
    Random rn = new Random();
    Boolean characterCreatingState = false;

    public Smurfinator(ArrayList<Question> q, ArrayList<Trait> t, ArrayList<Character> c, User u){
        this.questions = q;
        this.askableQuestions = (ArrayList<Question>)q.clone();
        this.traits = t;
        this.characters = c;
        this.user = u;
    }
    
    private Question getNextQuestion(){
        int qInt = rn.nextInt(0, askableQuestions.size());
        Question tempQ = askableQuestions.get(qInt);
        askableQuestions.remove(qInt);
        return tempQ;
    }

    private Character calculateGuess(){
        Character guess = new Character("null");

        Double previousClosestNumber = 0.0;
        for(Character c: characters){
            Double currentValue = 0.0;

            for(Question q:askedQuestions){
                currentValue = calculateDifference(c, q);
            }
            if(currentValue < previousClosestNumber) guess = c;
        }
        return guess;
    }

    private Double calculateDifference(Character c, Question q) {
        Double currentValue;
        String traitName = q.getQuestionTrait().getName();
        Double characterStat = 0.0;
        Double playerTraitStat = 0.0;
        for(Trait t: c.getCharacterTraits()){
            if(t.getName() == traitName){ characterStat = t.get_amount_of_trait();
            }
        }
        for(Trait t: accurateTraits){
            if(t.getName() == traitName){ playerTraitStat = t.get_amount_of_trait();
            }
        }
        currentValue = Math.abs(playerTraitStat-characterStat);
        return currentValue;
    }

    public void update(){
        
        Question currentQuestion;

        if(characterCreatingState == false){
            currentQuestion = getNextQuestion();
            //TODO send new question to view
            /*
            if (charactersRemaining.size() == 1) {
                guessedCharacter = charactersRemaining.get(0);
                // TODO send character to view

            } else if (charactersRemaining.size() == 0) {
                characterCreatingState = true;
            }
             */



        }
        else{
            // Keep asking to get trait results
            currentQuestion = getNextQuestion();
            //TODO send new question to view

        }
    }
    
    public void setStateCreateCharacter(){
        characterCreatingState = true;
    }
    
    public Character getGuessedCharacter(){
        return guessedCharacter;
    }

    
    public void reset(){
        askableQuestions = (ArrayList<Question>)questions.clone();
        accurateTraits.clear();
        askableQuestions.clear();

    }

}
