package project.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class HelpController {

    public Button okButton;

    public void onOk(ActionEvent actionEvent) {
        okButton.getScene().getWindow().hide();
    }
}
