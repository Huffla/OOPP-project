package group3.modelFolder.smurfinator;

import group3.modelFolder.character.Character;
import group3.modelFolder.question.Question;

public interface SmurfinatorObserver {
    public void updateQuestion(Question q);
    public void makeGuess(Character c);
    public void switchToCreateCharacterOption();
    public void switchToCreateCharacter();
    
    
}
