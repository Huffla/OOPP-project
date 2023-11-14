package group3;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

public class SmurfinatorMainController {

    @FXML
    private Rectangle buttonContainer;

    public void initialize() {
        // This method is called after the FXML file has been loaded
        // You can perform any initialization logic here
        buttonContainer.setArcWidth(30.0);
        buttonContainer.setArcHeight(20.0);
    }

    // Add any additional methods or event handlers as needed
}
