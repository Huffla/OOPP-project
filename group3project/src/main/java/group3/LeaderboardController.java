package group3;

import group3.modelFolder.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class LeaderboardController implements ControllerInitializer, LeaderboardObserver {

    private static LeaderboardController instance;

    LeaderboardInterface leaderboard;

    final int characterLeaderboardCode = 0;
    final int userLeaderboardCode = 1;

    @FXML
    Button mainmenuButton;
    @FXML
    Button exitButton;
    @FXML
    Button characterLeaderboardButton;
    @FXML
    Button userLeaderboardButton;
    @FXML
    Label leaderboardLabel;

    @FXML
    Label leaderboardField;

    SceneTransitionHandler sceneTransitionHandler = SceneTransitionHandler.getInstance();


    private Stage stage; // Reference to the stage

    // Inject the stage using this method
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Constructor
    private LeaderboardController(LeaderboardInterface s) {
        leaderboard = s;
        leaderboard.addObserver(this);

    }

    // Singleton pattern
    public static LeaderboardController getInstance(LeaderboardInterface s) {
        if (instance == null) {
            instance = new LeaderboardController(s);

        }
        return instance;
    }

    @Override
    public void initialize() {

    }

    // Make the initial call to the leaderboard
    public void makeInitialCall() {
        leaderboard.makeInitialCall();
    }

    // Update the leaderboard field
    @Override
    public void updateLeaderboardField(Category category){
        String tempString;
        leaderboardField.setText("");
        LeaderboardEntry lbE;
        for(int i = 0; i < category.getList().size(); i++){
            lbE = category.getList().get(i);
            tempString = leaderboardField.getText();
            leaderboardField.setText(tempString + lbE.getName() + ":" + " " + lbE.getSortValue() + "\n");
            }
        switchCategoryName(category);
    }

    // Switch category to display based on button pressed
    @FXML
    private void switchCategoryCharacter(){
        leaderboard.switchCategory(characterLeaderboardCode);
    }

    @FXML
    private void switchCategoryUser(){
        leaderboard.switchCategory(userLeaderboardCode);
    }

    // Change label describing leaderboard type
    @FXML
    private void switchCategoryName(Category category){
        this.leaderboardLabel.setText(category.getName());
    }

    @FXML
    private void switchToCollection(ActionEvent event) {
        String titlecss = getClass().getResource("styles/universalStyle.css").toExternalForm();
        String scenecss = getClass().getResource("styles/collectionStyle.css").toExternalForm();
        String[] stylesheetArray = { titlecss, scenecss };
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();
        SceneFactory sceneManager = new SceneFactory(stage);
        sceneManager.loadAndShowScene("stages/compendiumscene.fxml", stylesheetArray, CompendiumController.class);
    }

    @FXML
    private void switchToMainmenu(ActionEvent event) {
        String titlecss = getClass().getResource("styles/universalStyle.css").toExternalForm();
        String scenecss = getClass().getResource("styles/sceneStyle.css").toExternalForm();
        String[] stylesheetArray = { titlecss, scenecss };
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("stages/mainmenu.fxml"));
            Parent root = loader.load();
            System.out.println(loader.getController().toString());
            Scene scene = new Scene(root);
            scene.getStylesheets().addAll(stylesheetArray);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void closeGame(){
        javafx.application.Platform.exit();
    }


}
