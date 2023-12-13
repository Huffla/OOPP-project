package group3.modelFolder.smurfinator;

import group3.modelFolder.trait.Trait;
import group3.modelFolder.user.User;
import group3.modelFolder.character.Character;
import group3.modelFolder.character.CharacterFactory;
import group3.modelFolder.database.CharacterDatabaseHandler;
import group3.modelFolder.question.Question;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Dictionary;
import java.util.ArrayList;
import java.util.Collections;


public class Smurfinator implements SmurfinatorInterface{
    public static final double TRAITTRESHOLD = 0.1;
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

    CharacterDatabaseHandler cdh = new CharacterDatabaseHandler("Characters.txt");
    


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
    private void notifyObserversCreationStateOption(){
        for(SmurfinatorObserver so: smurfObservers){
            so.switchToCreateCharacterOption();
        }
    }
    private void notifyObserversCreationState(){
    for(SmurfinatorObserver so: smurfObservers){
            so.switchToCreateCharacter();
        }
    }

    // Gets Traits from the trait question dictionary and returns a list of them.
    private ArrayList<Trait> getTraitsFromDictionary() {
        ArrayList<Trait> traits = new ArrayList<>();
        traits = Collections.list(traitQuestionDict.keys());
        return traits;
    }

    public boolean getCharacterCreationState(){
        return characterCreatingState;
    }

    public ArrayList<Trait> getAskedTraits(){
        return askedTraits;
    }

    public Trait getCurrentTrait(){
        return currentTrait;
    }
  
    /**
     * @ Returns a question if there exists one otherwise null
     */
    /**
     * Updates the currentQuestion and the corresponding currentTrait
     * by choosing a new relevant question excluding ones already asked.
     */
    private void getNextQuestionFromRemainingCharacters(){
        if(traitsLeft.size() == 0){
            return;
            
        }
        int traitIndex = rn.nextInt(traitsLeft.size());
        Trait tempTrait = traitsLeft.get(traitIndex);
        currentQuestion = traitQuestionDict.get(tempTrait);
        currentTrait = tempTrait;
        traitsLeft.remove(tempTrait);
    }



    /**
     * calculates the most likely guess, comparing each possible alternative with the recorded answers i askedTraits.
     * @return the guessed character
     */
    private Character calculateGuess(){
        Character guess = new Character("null");

        Double previousClosestNumber = Double.MAX_VALUE;
        for(Character c: remainingCharacters){
            guess = calculateClosestCharacter(guess, previousClosestNumber, c);
        }
        return guess;
    }

    /**
     * Calculates the closest character given the input from the player given
     * the characters that have already been calculated.
     * @param guess
     * @param previousClosestNumber
     * @param c
     * @return
     */
    private Character calculateClosestCharacter(Character guess, Double previousClosestNumber, Character c) {
        Double currentValue = 0.0;

        for(Trait t:askedTraits){
            currentValue+= calculateDifference(c, t);
        }
        if(currentValue < previousClosestNumber) guess = c;
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
            if(tr.getName() == traitName){ characterStat = tr.get_amount_of_trait();}
        }
        playerTraitStat = t.get_amount_of_trait();
        currentValue = Math.abs(playerTraitStat-characterStat);
        return currentValue;
    }

    /**
     * Runs an update of the game, action depends on the current state of the game
     */
    public void update(){
        boolean switchedState = false;
        if(!characterCreatingState){
            switchedState = executeNormalGameUpdate();
        }
        if(characterCreatingState && switchedState == false){
            characterCreationStateUpdate();
        }
        if(switchedState) switchedState = false;

    }

    /**
     * The update routine called on if characterCreationState is active
     */
    private void characterCreationStateUpdate() {
        // Keep asking to get trait results
        // If no questions left do nothing and wait for the user to create a new character
        if(totalAmountOfQuestionsLeft == 0){
            notifyObserversCreationState();
            return;
        }
        attemptSendNextQuestion();

    }

    /**
     * Attempts to get and send the next question to the view
     */
    private void attemptSendNextQuestion() {
        try {
            getNextQuestionFromRemainingCharacters();
            totalAmountOfQuestionsLeft--;
            sendNextQuestionToObservers();
        } catch (NullPointerException e) {
            System.out.println("tried to get from an empty list");
        }
    }

    /**
     * The update routine that is called if the model is in the state where it still guesses for characters.
     * Sends guess if applicable and updates to character creation state if the criteria for it to happen is fulfilled.
     * @return Boolean that states if the game changed into characterCreationMode
     */
    private Boolean executeNormalGameUpdate() {
        if(totalAmountOfQuestionsLeft == 0 || remainingCharacters.size() == 1){
            this.guessedCharacter = calculateGuess();
            sendGuessToObservers();
            return false;
        }
        if(remainingCharacters.size() == 0){
            setCharacterCreationState();
            notifyObserversCreationStateOption();
            return true;
        }
        attemptSendNextQuestion();
        return false;
    }

    /**
     * Removes characters that are no longer relevant when considering the previous questions asked.
     * Depends on the current trait and its value.
     * @param d
     */
    private void updateRemainingCharacters(Double d){
        double valueOfTrait;
        if(d<0 || d>1) throw new IllegalArgumentException();
        for (int i = remainingCharacters.size() - 1; i>=0; i--) {
            valueOfTrait = 0.0;
            Character c = remainingCharacters.get(i);
            ArrayList<Trait> tList = c.getCharacterTraits();

            valueOfTrait = getValueOfTrait(tList);

            if (! (Math.abs(valueOfTrait- d) < TRAITTRESHOLD)  ) {
                remainingCharacters.remove(c);
            }

        }
    
    }

    /**
     *  Gets the value of a trait from a list of trait.
     * @param tList
     * @return Returns the value of the current trait that is being looked at.
     */
    private double getValueOfTrait( @NotNull ArrayList<Trait> tList) {
        double valueOfTrait = 0.0;
        for (Trait t : tList) {
            if (t.getName().equals(currentTrait.getName())) {
                valueOfTrait = t.get_amount_of_trait();
                break;
            }
        }
        return valueOfTrait;
    }

    public void setCharacterName(String s){
        createdCharacterName = s;
    }

    /**
     * Creates a new character and saves
     * @param name The name of a character
     * @param path The path to the image of the character
     */
    public void createNewCharacter(String name,String path){
        Character newCharacter =cFactory.createCharacter(askedTraits, name,path);
        characters.add(newCharacter);
        cdh.addCharacter(newCharacter);
        user.increaseContributions();
        reset();
    }
    public void setCharacterCreationState(){
        characterCreatingState = true;
    }
   

    public Character getGuessedCharacter(){
        return guessedCharacter;
    }

    /**
     * Removes the traits that are in the oppositeTrait list within a trait.
     * @param t The trait that we want to remove opposites from
     */
    public void removeOppositeTraits(Trait t){
        for(String trait : t.getOppositeTraits()){
            totalAmountOfQuestionsLeft--;
        }
        traitsLeft.removeIf(oppositeTrait -> t.getOppositeTraits().contains(oppositeTrait.getName()));
    }

    /**
     * Updates the state of remaining characters and traits with consideration to the player answering yes.
     */
    public void answerYes(){
        Trait tempTrait = currentTrait.copy(1.0);
        askedTraits.add(tempTrait);
        removeOppositeTraits(tempTrait);
        updateRemainingCharacters(1.0);
        update();
    }

    public void answerNo(){
        updateRemainingCharacters(0.0);
        update();
    }
    public void answerDontKnow(){
        Trait tempTrait = currentTrait.copy(0.5);
        askedTraits.add(tempTrait);
        update();
    }
    public void answerRange(double d){
        Trait tempTrait = currentTrait.copy(d);
        askedTraits.add(tempTrait);
        update();
    }

    

    /**
     * Resets the program so that it can be run again.
     */
    public void reset(){
        askedTraits.clear();
        traitsLeft.clear();
        remainingCharacters = (ArrayList<Character>)characters.clone();
        characterCreatingState = false;
        totalAmountOfQuestionsLeft = remainingCharacters.size();
        update();
    }

    @Override
    public void guessWasCorrect() {
        guessedCharacter.increaseGuessedAmount();
        cdh.updateFile();
        reset();
    }


}