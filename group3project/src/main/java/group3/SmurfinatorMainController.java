package group3;

import javafx.scene.control.TextField;

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

public class SmurfinatorMainController implements ControllerInitializer, SmurfinatorObserver{

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

    private static SmurfinatorMainController instance;
    @FXML
    public Text questionTitle;
    
    
    SmurfinatorInterface smurfinator;

    private SmurfinatorMainController(SmurfinatorInterface s){
        smurfinator = s;
        smurfinator.addObserver(this);
        
    }
    public static SmurfinatorMainController getInstance(SmurfinatorInterface s) {
        if (instance == null){
            instance = new SmurfinatorMainController(s);
            
        }
        return instance;
    }
    public void makeInitialCall(){
        smurfinator.makeInitialCall();
    }
    
    @Override
    public void initialize() {
        settingsButtonBuilder();
        buttonContainer.setArcWidth(40.0);
        buttonContainer.setArcHeight(40.0);
        
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
    private void gobackQuestion(){

    }

    @FXML
    private void yesPressed(ActionEvent event){
        smurfinator.answerYes();
    }

    @FXML
    private void noPressed(ActionEvent event){
        smurfinator.answerNo();
    }

    @FXML
    private void dontknowPressed(ActionEvent event){
        smurfinator.answerDontKnow();
    }
    private void nameCharacter(){
        //TODO display screen with box for entering name of created character
    }
     @FXML
    private void createNewCharacter(ActionEvent event){
        String name = smurfname.getText();
        smurfinator.createNewCharacter(name);
    }



    private void displayQuestion(Question q){
        if(q.getClass() == MultipleChoiceQuestion.class){
            sliderAnchorPane.setVisible(false);
            buttonAnchorPane.setVisible(true);
        }
        else if(q.getClass() == rangeQuestion.class){
            buttonAnchorPane.setVisible(false);
            sliderAnchorPane.setVisible(true);
        }
    }
    public void updateQuestion(Question q){
        System.out.println("Question updated!!!");
        questionTitle.setText(q.getQuestionText());
        displayQuestion(q);
    }
    
    @FXML
    private void incorrectCharacter(ActionEvent event){
        guessContainer.setVisible(false);
        createnewcharactercontainer.setVisible(true);
    }

   
    @FXML
    private void startsmurfcreate(){
        createnewcharactercontainer.setVisible(false);
        createsmurfcontainer.setVisible(true);
    }
    @Override
    public void makeGuess(Character c) {
        buttonAnchorPane.setVisible(false);
        sliderAnchorPane.setVisible(false);
        
        Image image = new Image(c.getImagePath());
        guessImage.setImage(image);
        questionTitle.setText("You are thinking of:" + c.getName());
    }
}