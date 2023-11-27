package group3;

import group3.modelFolder.Character;
import group3.modelFolder.Model;
import group3.modelFolder.MultipleChoiceQuestion;
import group3.modelFolder.Question;
import group3.modelFolder.rangeQuestion;
import group3.modelFolder.MultipleChoiceQuestion;
import group3.modelFolder.Question;
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

public class SmurfinatorMainController implements ControllerInitializer {

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
    private Slider answerSlider;
    @FXML
    private AnchorPane buttonAnchorPane;
    @FXML
    private AnchorPane sliderAnchorPane;
    @FXML
    private ImageView guessImage;
    @FXML
    private AnchorPane guessContainer;
    @FXML
    private AnchorPane createnewcharactercontainer;
    @FXML
    private Button createcharacterButton;

    private Question question;

    @FXML
    private Text questionTitle;

    Model model = Model.getInstance("Users.txt","Questions.txt","Traits.txt");
    
    @Override
    public void initialize() {
        settingsButtonBuilder();
        question = model.smurfinator.getCurrentQuestion();
        questionTitle.setText(question.getQuestionText());
        buttonContainer.setArcWidth(40.0);
        buttonContainer.setArcHeight(40.0);
        displayQuestion();
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
        model.smurfinator.answerYes();
        updateQuestion();
    }

    @FXML
    private void noPressed(ActionEvent event){
        model.smurfinator.answerNo();
        updateQuestion();
    }

    @FXML
    private void dontknowPressed(ActionEvent event){
        model.smurfinator.answerDontKnow();
        updateQuestion();
    }

    private void displayQuestion(){
        if(question.getClass() == MultipleChoiceQuestion.class){
            sliderAnchorPane.setVisible(false);
            buttonAnchorPane.setVisible(true);
        }
        else if(question.getClass() == rangeQuestion.class){
            buttonAnchorPane.setVisible(false);
            sliderAnchorPane.setVisible(true);
        }
    }
    private void updateQuestion(){
        question = model.smurfinator.getCurrentQuestion();
        questionTitle.setText(question.getQuestionText());
        displayQuestion();
    }

    public void guessCharacter(Character c){
        buttonAnchorPane.setVisible(false);
        sliderAnchorPane.setVisible(false);
        Image image = new Image(c.getImagePath());
        guessImage.setImage(image);
        questionTitle.setText("You are thinking of:" + c.getName());
    }

    @FXML
    private void incorrectCharacter(){
        guessContainer.setVisible(false);
        createnewcharactercontainer.setVisible(true);
    }

    
}
