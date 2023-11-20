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
    ArrayList<Character> charactersRemaining;
    Character guessedCharacter;
    Random rn = new Random();
    Boolean characterCreatingState = false;

    public Smurfinator(ArrayList<Question> q, ArrayList<Trait> t, ArrayList<Character> c, User u){
        this.questions = q;
        this.askableQuestions = (ArrayList<Question>)q.clone();
        this.traits = t;
        this.characters = c;
        this.charactersRemaining = (ArrayList<Character>)c.clone();
        this.user = u;
    }
    
    private Question getNextQuestion(){
        int qInt = rn.nextInt(0, askableQuestions.size());
        Question tempQ = askableQuestions.get(qInt);
        askableQuestions.remove(qInt);
        return tempQ;
    }

    public void update(){
        
        Question currentQuestion;

        if(characterCreatingState == false){
            currentQuestion = getNextQuestion();
            if(charactersRemaining.size() == 1){
                guessedCharacter = charactersRemaining.get(0);
                //TODO send character to view
                
            } else if(charactersRemaining.size() == 0){
                characterCreatingState = true;
            }
        }
        else{
            
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
        charactersRemaining = (ArrayList<Character>)characters.clone();
        accurateTraits.clear();
        askableQuestions.clear();

    }

}
