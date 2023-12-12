package group3.CONTROLLER;

import group3.modelFolder.smurfinator.SmurfinatorInterface;

public class SmurfinatorController {
    SmurfinatorInterface smurfinator;
    public SmurfinatorController(SmurfinatorInterface si){
        smurfinator = si;

    }

    public void questionYesPressed(){smurfinator.answerYes();}
    public void questionNoPressed(){smurfinator.answerNo();}
    public void sliderValueNextPressed(double d){smurfinator.answerRange(d);}
    public void dontKnowPressed(){smurfinator.answerDontKnow();}

    public void createNewCharacterPressed(String name, String path){
        smurfinator.createNewCharacter(name,path);
    }
    public void backToMainPressed(){
        smurfinator.reset();
    }
    public void createCharacterOptionPressed(){
        smurfinator.makeInitialCall();
    }
    public void incorrectCharacterSignal(){
        smurfinator.setCharacterCreationState();
    }

    public void startNewGame() {
        smurfinator.makeInitialCall();
    }
}
