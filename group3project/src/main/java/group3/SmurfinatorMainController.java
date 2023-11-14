package group3;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

public class SmurfinatorMainController implements ControllerInitializer {

    @FXML
    private Rectangle buttonContainer;

    @Override
    public void initialize() {

        buttonContainer.setArcWidth(30.0);
        buttonContainer.setArcHeight(20.0);
    }

}
