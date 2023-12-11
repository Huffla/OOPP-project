package group3;

import javafx.scene.control.TextField;

import javax.swing.Action;

import group3.modelFolder.Character;
import group3.modelFolder.Model;
import group3.modelFolder.MultipleChoiceQuestion;
import group3.modelFolder.Question;
import group3.modelFolder.Smurfinator;
import group3.modelFolder.SmurfinatorInterface;
import group3.modelFolder.SmurfinatorObserver;
import group3.modelFolder.rangeQuestion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class SmurfinatorMainController implements ControllerInitializer, SmurfinatorObserver {

    @FXML
    private Rectangle buttonContainer;
    @FXML
    private Button settingsButton;
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
    private Button submitButton;
    @FXML
    private AnchorPane createsmurfcontainer;
    @FXML
    private Text sliderDisplayValue;
    @FXML
    private double sliderValue;
    @FXML
    private Button dontknowbuttonrange;

    private static SmurfinatorMainController instance;
    @FXML
    public Text questionTitle;
    @FXML
    public TextField pathToImageTextBox;

    SmurfinatorInterface smurfinator;

    SceneTransitionHandler sceneTransitionHandler = SceneTransitionHandler.getInstance();

    private SmurfinatorMainController(SmurfinatorInterface s) {
        smurfinator = s;
        smurfinator.addObserver(this);

    }

    // Singleton pattern
    public static SmurfinatorMainController getInstance(SmurfinatorInterface s) {
        if (instance == null) {
            instance = new SmurfinatorMainController(s);

        }
        return instance;
    }

    // Singleton pattern
    public static SmurfinatorMainController getInstance(){
        if(instance == null){
            throw new NullPointerException();
        }
        return instance;
    }

    public void makeInitialCall() {
        smurfinator.makeInitialCall();
    }

    @Override
    public void initialize() {
        settingsButtonBuilder();
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

    private void settingsButtonBuilder() {
        Image settingsicon = new Image("group3/images/settingsicon.png");
        ImageView settingsImageView = new ImageView(settingsicon);
        settingsButton.setGraphic(settingsImageView);
        settingsImageView.setPreserveRatio(true);
        settingsImageView.fitWidthProperty().bind(settingsButton.widthProperty());
        settingsImageView.fitHeightProperty().bind(settingsButton.heightProperty());
        settingsImageView.setScaleX(0.7);
        settingsImageView.setScaleY(0.7);
    }

    @FXML
    private void quitpopup() {
        QuitMenuLoader.showPopup("stages/quitpopup.fxml", "Settings");

    }

    @FXML
    private void gobackQuestion() {

    }

    @FXML
    private void answerRange(ActionEvent event) {
        smurfinator.answerRange(sliderValue);
    }

    @FXML
    private void yesPressed(ActionEvent event) {
        smurfinator.answerYes();
    }

    @FXML
    private void noPressed(ActionEvent event) {
        smurfinator.answerNo();
    }

    @FXML
    private void dontknowPressed(ActionEvent event) {
        smurfinator.answerDontKnow();
    }


    @FXML
    private void createNewCharacter(ActionEvent event) {
        String name = smurfname.getText();
        String path = pathToImageTextBox.getText();
        smurfinator.createNewCharacter(name,path);
    }

    private void displayQuestion(Question q) {
        if (q.getClass() == MultipleChoiceQuestion.class) {
            sliderAnchorPane.setVisible(false);
            buttonAnchorPane.setVisible(true);
        } else if (q.getClass() == rangeQuestion.class) {
            buttonAnchorPane.setVisible(false);
            sliderAnchorPane.setVisible(true);
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
        smurfinator.setCharacterCreationState();
    }

    @FXML
    private void askCharacterCreationQuestions() {
        guessContainer.setVisible(false);
        createnewcharactercontainer.setVisible(false);
        createsmurfcontainer.setVisible(false);
        makeInitialCall();
    }

    @Override
    public void makeGuess(Character c) {
        buttonAnchorPane.setVisible(false);
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
        sliderAnchorPane.setVisible(false);
        guessContainer.setVisible(false);
        createnewcharactercontainer.setVisible(true);
        questionTitle.setText("Character not found! Would you like to create a new character? (You have to answer all questions)");
    }

    @Override
    public void switchToCreateCharacter() {
        buttonAnchorPane.setVisible(false);
        sliderAnchorPane.setVisible(false);
        guessContainer.setVisible(false);
        createsmurfcontainer.setVisible(true);
        questionTitle.setText("Last step!");
    }
    @FXML
    public void returnToMainMenu(){
        smurfinator.reset();
        //TODO return to main menu
    }
    
    
}