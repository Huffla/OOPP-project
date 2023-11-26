package group3.modelFolder;
import java.util.Random;
import java.util.ArrayList;

public class Smurfinator {
    ArrayList<Question> questions;
    ArrayList<Question> askableQuestions;
    ArrayList<Trait> traits;
    ArrayList<Character> characters;
    ArrayList<Character> remainingCharacters;
    User user;
    ArrayList<Trait> askedTraits;
    ArrayList<Question> askedQuestions;
    Character guessedCharacter;
    Random rn = new Random();
    Boolean characterCreatingState = false;
    int questionsSinceLastGuess = 0;
    CharacterFactory cFactory = new CharacterFactory();
    final int timeToGuess = 10;
    Question currentQuestion;
    Trait currentTrait;
    

    public Smurfinator(ArrayList<Question> q, ArrayList<Trait> t, ArrayList<Character> c, User u){
        this.questions = q;
        this.askableQuestions = copyList(q);
        this.remainingCharacters = (ArrayList<Character>)c.clone();
        this.traits = t;
        this.characters = c;
        this.user = u;
        try {
            currentQuestion = getNextQuestion();
        } catch (NullPointerException e) {
            System.out.println("AAA Bork");
        }
        
    }

    
    /**
     * @param q
     * @return
     *  Deep copy of a list of questions.
     */
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
    }
    
    /**
     * @return Returns a question if there exists one otherwise null
     */
    // Howl skrev den här.
    private Question getNextQuestion() throws NullPointerException{
        if(askableQuestions.size() == 0){
            throw new NullPointerException();
        }
        int qInt = rn.nextInt(0, askableQuestions.size());
        Question tempQ = askableQuestions.get(qInt);
        currentQuestion = tempQ;
        currentTrait = tempQ.getQuestionTrait();
        askableQuestions.remove(qInt);
        return tempQ;

    }
    

   
    private Character calculateGuess(){
        Character guess = new Character("null");

        Double previousClosestNumber = 0.0;
        for(Character c: remainingCharacters){
            Double currentValue = 0.0;

            for(Question q:askedQuestions){
                currentValue = calculateDifference(c, q);
            }
            if(currentValue < previousClosestNumber) guess = c;
        }
        return guess;
    }
    
    /**
     * @param c
     * @param q
     * @return "Distance" between the value that the player placed in the trait and the character that is being compareds trait.
     */
    private Double calculateDifference(Character c, Question q) {
        Double currentValue;
        String traitName = q.getQuestionTrait().getName();
        Double characterStat = 0.0;
        Double playerTraitStat = 0.0;
        for(Trait t: c.getCharacterTraits()){
            if(t.getName() == traitName){ characterStat = t.get_amount_of_trait();
            }
        }
        for(Trait t: askedTraits){
            if(t.getName() == traitName){ playerTraitStat = t.get_amount_of_trait();
            }
        }
        currentValue = Math.abs(playerTraitStat-characterStat);
        return currentValue;
    }

    //TODO Figure out how the controller answers questions. 
    //TODO FIgure out how the controller answers when the user is given a prompt to create a new character.
    public Question update(){
        
        Question currentQuestion;
        
        if(characterCreatingState == false){
            try {
                currentQuestion = getNextQuestion();
            } catch (NullPointerException e) {
                //TODO controller must realize when this happens and update the buttons so they correspond to the correct event.
                return new Question("Create new character?",new Trait("null", 0.0)) {
                };
            }
            questionsSinceLastGuess++;

            if(questionsSinceLastGuess == timeToGuess){
                questionsSinceLastGuess = 0;
                this.guessedCharacter = calculateGuess();
            }
        }    
        else{
            // Keep asking to get trait results
            try {
                currentQuestion = getNextQuestion();
            } catch (NullPointerException e) {
                //TODO controller must realize when this happens and update the buttons so they correspond to the correct event.
                return new Question("Create new character?",new Trait("null", 0.0)) {
                    
                };
            }
            
            //TODO send new question to view

        }
        return currentQuestion;
    }
    // Removes questions that are no longer relevant when considering the previous questions asked.
    private void updateRemainingCharacters(Double d){
        for(Character c : remainingCharacters){
            ArrayList<Trait> tList = c.getCharacterTraits();
            for(Trait t: tList){
                if(t.getName().equals(currentTrait.getName())){
                    if(!t.get_amount_of_trait().equals(currentTrait.get_amount_of_trait())){
                        remainingCharacters.remove(c);
                    }

                }
            }
        }
    }   
    

    public void createNewCharacter(String name){
        characters.add(cFactory.createCharacter(askedTraits, name)) ;
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
         askedTraits.add(new Trait(currentTrait.getName(), 0.0));
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

    public Question getCurrentQuestion(){
        return currentQuestion;
    }

    
    public void reset(){
        askedTraits.clear();
        askableQuestions.clear();
        askableQuestions = copyList(questions);
        characterCreatingState = false;

    }


}
