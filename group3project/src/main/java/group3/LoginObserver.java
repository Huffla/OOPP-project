package group3;

import javafx.event.ActionEvent;

public interface LoginObserver {
    public void gotoMainMenu(ActionEvent event);

    public void userExistsError();
}
