package group3.modelFolder.login;

import javafx.event.ActionEvent;

public interface LoginObserver {
    public void gotoMainMenu(ActionEvent event);

    public void userExistsError();
}
