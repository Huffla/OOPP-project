package group3.modelFolder.smurfinator;

public interface SmurfinatorInterface {
    public void answerYes();
    public void answerNo();
    public void answerDontKnow();
    public void answerRange(double d);
    public void createNewCharacter(String name,String path);
    public void addObserver(SmurfinatorObserver so);
    public void makeInitialCall();
    public void setCharacterCreationState();
    public void reset();

    public void guessWasCorrect();
}
