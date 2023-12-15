package group3;

import group3.CONTROLLER.ControllerInitializer;
import group3.modelFolder.character.Character;
import group3.modelFolder.question.MultipleChoiceQuestion;
import group3.modelFolder.question.Question;
import group3.modelFolder.question.rangeQuestion;
import group3.CONTROLLER.SmurfinatorController;
import group3.modelFolder.smurfinator.SmurfinatorInterface;
import group3.modelFolder.smurfinator.SmurfinatorObserver;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class SmurfinatorWindowHandler implements ControllerInitializer, SmurfinatorObserver {

    @FXML
    private Rectangle buttonContainer;

    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;
    @FXML
    private Button dontknowButton;
    @FXML
    private Button confirmYesGuess;
    @FXML
    private Button confirmNoGuess;
    @FXML
    private Slider answerSlider;
    @FXML
    private AnchorPane buttonAnchorPane;
    @FXML
    private AnchorPane sliderAnchorPane;
    @FXML
    private ImageView guessImage;
    @FXML
    private ImageView guessDisplay;
    @FXML
    private AnchorPane guessContainer;
    @FXML
    private AnchorPane createnewcharactercontainer;
    @FXML
    private Button createCharacterButton;
    @FXML
    private TextField smurfname;

    @FXML
    private AnchorPane imageContainer;
    
    @FXML
    private Button submitButton;
    @FXML
    private AnchorPane createsmurfcontainer;
    @FXML
    private Text sliderDisplayValue;
    @FXML
    private double sliderValue;
    @FXML
    private Button dontknowbuttonrange;

    private static SmurfinatorWindowHandler instance;
    @FXML
    public Text questionTitle;
    @FXML
    public TextField pathToImageTextBox;



    SceneTransitionHandler sceneTransitionHandler = SceneTransitionHandler.getInstance();
    private SmurfinatorController controller;
    private SmurfinatorWindowHandler(SmurfinatorInterface s) {
        s.addObserver(this);
        controller = new SmurfinatorController(s);

    }

    // Singleton pattern
    public static SmurfinatorWindowHandler getInstance(SmurfinatorInterface s) {
        if (instance == null) {
            instance = new SmurfinatorWindowHandler(s);

        }
        return instance;
    }

    /*public void addCreateCharacterButtonListener(CharacterCreationController c) { Niklas Broberg skrev dessa rader, behåll för good luck
        createCharacterButton.setOnAction(e -> {
            c.createNewCharacter();
        });
    }*/

    // Singleton pattern
    public static SmurfinatorWindowHandler getInstance(){
        if(instance == null){
            throw new NullPointerException();
        }
        return instance;
    }


    @Override
    public void initialize() {
        buttonContainer.setArcWidth(40.0);
        buttonContainer.setArcHeight(40.0);
        addSliderListener();
        answerSlider.setMajorTickUnit(0.1);
    }

    private void addSliderListener() {
        answerSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            int scaledValue = (int) (newValue.doubleValue() * 10);
            sliderDisplayValue.setText(String.valueOf(scaledValue));
            sliderValue = newValue.doubleValue();
        });
    }



    @FXML
    private void answerRange(ActionEvent event) {
        controller.sliderValueNextPressed(sliderValue);
    }

    @FXML
    private void yesPressed(ActionEvent event) {
        controller.questionYesPressed();
    }

    @FXML
    private void noPressed(ActionEvent event) {
        controller.questionNoPressed();
    }

    @FXML
    private void dontknowPressed(ActionEvent event) {
        controller.dontKnowPressed();
    }


    @FXML
    private void createNewCharacter(ActionEvent event) {
        String name = smurfname.getText();
        String path = pathToImageTextBox.getText();
        controller.createNewCharacterPressed(name,path);
        createsmurfcontainer.setVisible(false);

    }

    private void displayQuestion(Question q) {
        if (q.getClass() == MultipleChoiceQuestion.class) {
            sliderAnchorPane.setVisible(false);
            buttonAnchorPane.setVisible(true);
            imageContainer.setVisible(true);
        } else if (q.getClass() == rangeQuestion.class) {
            buttonAnchorPane.setVisible(false);
            sliderAnchorPane.setVisible(true);
            imageContainer.setVisible(true);
        }
    }

    public void updateQuestion(Question q) {
        System.out.println("Question updated!!!");
        questionTitle.setText(q.getQuestionText());
        displayQuestion(q);
    }

    @FXML
    private void incorrectCharacter(ActionEvent event) {
        guessContainer.setVisible(false);
        createnewcharactercontainer.setVisible(true);
        controller.incorrectCharacterSignal();
    }

    @FXML
    private void askCharacterCreationQuestions() {
        guessContainer.setVisible(false);
        createnewcharactercontainer.setVisible(false);
        createsmurfcontainer.setVisible(false);
        controller.createCharacterOptionPressed();
    }

    @Override
    public void makeGuess(Character c) {
        buttonAnchorPane.setVisible(false);
        imageContainer.setVisible(false);
        sliderAnchorPane.setVisible(false);
        
        guessContainer.setVisible(true);
        Image image = new Image(c.getImagePath());
        guessImage.setImage(image);
        System.out.println("Guessed a character!");
        
        questionTitle.setText("Are you thinking of: " + c.getName()+"?");
    }

    //TODO make it so that the player can decice if they want to create a  new character. If they do they have to answer the rest of the questions
    @Override
    public void switchToCreateCharacterOption() {
        buttonAnchorPane.setVisible(false);
        imageContainer.setVisible(false);
        sliderAnchorPane.setVisible(false);
        guessContainer.setVisible(false);
        createnewcharactercontainer.setVisible(true);
        questionTitle.setText("Character not found! Would you like to create a new character? (You have to answer all questions)");
    }

    @Override
    public void switchToCreateCharacter() {
        buttonAnchorPane.setVisible(false);
        imageContainer.setVisible(false);
        sliderAnchorPane.setVisible(false);
        guessContainer.setVisible(false);
        createsmurfcontainer.setVisible(true);
        questionTitle.setText("Last step!");
    }
    @FXML
    public void returnToMainMenu(ActionEvent event){
        controller.backToMainPressed();
        sceneTransitionHandler.transitionToMainMenu(event);
    }
    @FXML
    public void answerYesGuess(ActionEvent event){
        controller.answerYesGuessPressed();
        sceneTransitionHandler.transitionToMainMenu(event);
    }

    public void newGameStart() {
        controller.startNewGame();
    }

    @FXML
    private void collection(ActionEvent event){
        sceneTransitionHandler.transitionToCompendium(event);
    }

    // Navigate to the leaderboard screen
    @FXML
    private void leaderboard(ActionEvent event){
        sceneTransitionHandler.transitionToLeaderboard(event);
    }


    // close the application
    @FXML
    private void closeGame(){
        javafx.application.Platform.exit();
    }


}