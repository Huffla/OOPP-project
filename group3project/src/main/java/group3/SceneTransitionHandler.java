package group3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneTransitionHandler {
    private SmurfinatorMainController smurfinatorController;
    private MainMenuController mainMenuController;
    private CompendiumController compendiumController;
    private LeaderboardController leaderboardController;
    private LoginController loginController;
    private static SceneTransitionHandler instance;

    public static SceneTransitionHandler getInstance() {
        if (instance == null) {
            instance = new SceneTransitionHandler();
            return instance;
        }
        return instance;
    }

    // This is a setter for the controllers
    public void setSmurfinatorController(SmurfinatorMainController smurfinatorController) {
        this.smurfinatorController = smurfinatorController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public void setMainMenuController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }

    public void setCompendiumController(CompendiumController compendiumController) {
        this.compendiumController = compendiumController;
    }

    public void setLeaderboardController(LeaderboardController leaderboardController) {
        this.leaderboardController = leaderboardController;
    }

    private SceneTransitionHandler() {

    }
    // TODO The idea is to have a single class that handles all scene transitions.
    // This will be done by passing the event

    public void transitionToMainMenu(ActionEvent event) {
        createScene(event, "styles/universalStyle.css", "styles/mainmenuStyle.css", "stages/mainmenu.fxml", "Main Menu",
                mainMenuController);
    }

    public void transitionToCompendium(ActionEvent event) {
        createScene(event, "styles/universalStyle.css", "styles/collectionStyle.css", "stages/compendiumscene.fxml",
                "Compendium", compendiumController);
    }

    public void transitionToLeaderboard(ActionEvent event) {
        createScene(event, "styles/universalStyle.css", "styles/leaderboardStyle.css", "stages/leaderboard.fxml",
                "Leaderboard", leaderboardController);
        leaderboardController.makeInitialCall();
    }

    public void transitionToSmurfinator(ActionEvent event) {
        createScene(event, "styles/universalStyle.css", "styles/sceneStyle.css", "stages/questionscene.fxml",
                "Smurfinator", smurfinatorController);
        smurfinatorController.makeInitialCall();
    }

    /**
     * @param event        The event that triggered the scene change
     * @param titleCssText The css file for the title
     * @param sceneCssText The css file for the scene
     * @param fxmlFile     The fxml file path for the scene
     * @param titleText    The title of the scene
     * @param controller   The controller for the scene
     *                     This method creates a scene and sets the css files,
     *                     title, and controller for the scene
     *                     It then sets the scene and shows the stage
     *
     */
    private void createScene(ActionEvent event, String titleCssText, String sceneCssText, String fxmlFile,
            String titleText, ControllerInitializer controller) {
        String titlecss = getClass().getResource(titleCssText).toExternalForm();
        String scenecss = getClass().getResource(sceneCssText).toExternalForm();
        String[] stylesheetArray = { titlecss, scenecss };
        Stage stage = (Stage) ((Node) event.getTarget()).getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            loader.setController(controller);
            Parent root = loader.load();
            System.out.println(loader.getController().toString());

            controller.initialize();

            Scene scene = new Scene(root);
            scene.getStylesheets().addAll(stylesheetArray);

            configureStage(stage, scene, titleText);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void configureStage(Stage stage, Scene scene, String name) {
        stage.setTitle(name);
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.setResizable(false);
    }

}
