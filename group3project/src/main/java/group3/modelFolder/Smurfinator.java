package group3.modelFolder;

import java.util.Random;
import java.util.Dictionary;
import java.util.ArrayList;
import java.util.Collections;

import group3.SmurfinatorMainController;



public class Smurfinator implements SmurfinatorInterface{
    ArrayList<Trait> traitsLeft;
    ArrayList<Character> characters;
    ArrayList<Character> remainingCharacters;
    User user;
    ArrayList<Trait> askedTraits = new ArrayList<>();
    Character guessedCharacter;
    Random rn = new Random();
    Boolean characterCreatingState = false;
    
    CharacterFactory cFactory = new CharacterFactory();
    
    Question currentQuestion;
    Trait currentTrait;
    private String createdCharacterName;
    Dictionary<Trait,Question> traitQuestionDict;
    private ArrayList<SmurfinatorObserver> smurfObservers = new ArrayList<>();
    int totalAmountOfQuestionsLeft;


    public Smurfinator(Dictionary<Trait,Question> traitQuestionDict, ArrayList<Character> c, User u) {
        this.remainingCharacters = (ArrayList<Character>)c.clone();
        this.characters = c;
        this.user = u;
        this.traitQuestionDict = traitQuestionDict;
        this.traitsLeft = getTraitsFromDictionary();
        totalAmountOfQuestionsLeft = traitsLeft.size();
        
    }
        
    /**
     * Must call to get the initial question for the game to start
     */
    public void makeInitialCall(){
        /*
        getNextQuestion();
        totalAmountOfQuestionsLeft--;
        sendNextQuestionToObservers();
         */
        update();
    }
    public void addObserver(SmurfinatorObserver so){
        smurfObservers.add(so);
    }
    private void sendGuessToObservers(){
        for(SmurfinatorObserver so: smurfObservers){
            so.makeGuess(guessedCharacter);
        }
    }
    private void sendNextQuestionToObservers(){
        for(SmurfinatorObserver so: smurfObservers){
            so.updateQuestion(currentQuestion);
        }
    }


    /**
     * @param q
     * @return
     *  Deep copy of a list of questions.

    private ArrayList<Question> copyList(ArrayList<Question> q) {
    ArrayList<Question> list = new ArrayList<>();
    for(Question question: q){
    Trait t = question.getQuestionTrait();
    if(question.getClass() == MultipleChoiceQuestion.class){
    list.add(new MultipleChoiceQuestion(question.getQuestionText(),new Trait(t.getName(), t.get_amount_of_trait())));
    } else if(question.getClass() == rangeQuestion.class){
    list.add(new rangeQuestion(question.getQuestionText(),new Trait(t.getName(), t.get_amount_of_trait())));
    }
    }
    return list;
    }*/
    // Gets Traits from the trait question dictionary and returns a list of them.
    private ArrayList<Trait> getTraitsFromDictionary() {
        ArrayList<Trait> traits = new ArrayList<>();
        traits = Collections.list(traitQuestionDict.keys());
        return traits;
    }

  
    /**
     * @ Returns a question if there exists one otherwise null
     */
    // Howl(👑) skrev den här.
    //TODO Refactor into two methods
    private void getNextQuestion(){
        if(traitsLeft.size() == 0){
            return;
            
        }
        int traitIndex = rn.nextInt(0, traitsLeft.size());
        Trait tempTrait = traitsLeft.get(traitIndex);
        currentQuestion = traitQuestionDict.get(tempTrait);
        currentTrait = tempTrait;
        traitsLeft.remove(tempTrait);
    }
    



    private Character calculateGuess(){
        Character guess = new Character("null");

        Double previousClosestNumber = 0.0;
        for(Character c: remainingCharacters){
            Double currentValue = 0.0;

            for(Trait t:askedTraits){
                currentValue = calculateDifference(c, t);
            }
            if(currentValue < previousClosestNumber) guess = c;
        }
        return guess;
    }

    /**
     * Works when there only are traits that are answered yes/ranged/dontknow since no traits automatically will have the value 0.0
     * @param c
     * @param t
     * @return "Distance" between the value that the player placed in the trait and the character that is being compareds trait.
     */
    private Double calculateDifference(Character c, Trait t) {
        Double currentValue;
        String traitName = t.getName();
        Double characterStat = 0.0;
        Double playerTraitStat = 0.0;
        for(Trait tr: c.getCharacterTraits()){
            if(tr.getName() == traitName){ characterStat = tr.get_amount_of_trait();
            }
        }
        for(Trait tr: askedTraits){
            if(tr.getName() == traitName){ playerTraitStat = tr.get_amount_of_trait();
            }
        }
        currentValue = Math.abs(playerTraitStat-characterStat);
        return currentValue;
    }

    
    //TODO FIgure out how the controller answers when the user is given a prompt to create a new character.
    public void update(){



        if(!characterCreatingState){
            if(totalAmountOfQuestionsLeft == 0 || remainingCharacters.size() == 1){

                this.guessedCharacter = calculateGuess();
                
                sendGuessToObservers();
                setStateCreateCharacter();
                return;
            }
            try {
                getNextQuestion();
            } catch (NullPointerException e) { }
            totalAmountOfQuestionsLeft--;
            sendNextQuestionToObservers();
            
            
        }
        if(characterCreatingState){
            // Keep asking to get trait results
            if(totalAmountOfQuestionsLeft == 0){
                //TODO view must react to this and present an option to name the new character
                return;
                
            }
            try {
                getNextQuestion();
            } catch (NullPointerException e) {
                //TODO controller must realize when this happens and update the buttons so they correspond to the correct event.
                System.out.println("tried to get from an empty list");
            }

            //TODO send new question to view


        }

    }

    // Removes characters that are no longer relevant when considering the previous questions asked.
    private void updateRemainingCharacters(Double d){
        // removed if (d > 0)
        for (Character c : remainingCharacters) {
            ArrayList<Trait> tList = c.getCharacterTraits();
            for (Trait t : tList) {
                if (t.getName().equals(currentTrait.getName())) {
                    if (!t.get_amount_of_trait().equals(currentTrait.get_amount_of_trait())) {
                        remainingCharacters.remove(c);
                    }
                }
            }
        }
    
    }

    public void setCharacterName(String s){
        createdCharacterName = s;
    }

    public void createNewCharacter(String name){
        characters.add(cFactory.createCharacter(askedTraits, name));
        user.increaseContributions();
    }

    public void setStateCreateCharacter(){
        characterCreatingState = true;
    }

    public Character getGuessedCharacter(){
        return guessedCharacter;
    }

    public void answerYes(){
        askedTraits.add(new Trait(currentTrait.getName(), 1.0));
        updateRemainingCharacters(1.0);
        update();
    }

    public void answerNo(){
        updateRemainingCharacters(0.0);
        update();
    }
    public void answerDontKnow(){
        askedTraits.add(new Trait(currentTrait.getName(), 0.5));
        update();
    }
    public void answerRange(double d){
        askedTraits.add(new Trait(currentTrait.getName(), d));
        update();
    }

    


    public void reset(){
        askedTraits.clear();
        traitsLeft.clear();
        remainingCharacters = (ArrayList<Character>)characters.clone();
        characterCreatingState = false;
        totalAmountOfQuestionsLeft = remainingCharacters.size();
    }


}