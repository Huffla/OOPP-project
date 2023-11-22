package group3;

import group3.modelFolder.Model;
import group3.modelFolder.MultipleChoiceQuestion;
import group3.modelFolder.Question;
import group3.modelFolder.rangeQuestion;
import group3.modelFolder.MultipleChoiceQuestion;
import group3.modelFolder.Question;
import group3.modelFolder.rangeQuestion;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private void yesPressed(){
        model.smurfinator.answerYes();
        question = model.smurfinator.getCurrentQuestion();
    }

    private void displayQuestion(){
        if(question.getClass() == MultipleChoiceQuestion.class){
            //TODO fixa sen
        }
        else if(question.getClass() == rangeQuestion.class){
            //TODO också fixa sen
        }
    }
}
