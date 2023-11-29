package group3.modelFolder;

public interface SmurfinatorInterface {
    public void answerYes();
    public void answerNo();
    public void answerDontKnow();
    public void createNewCharacter(String s);
    public void addObserver(SmurfinatorObserver so);
    public void makeInitialCall();
}
