package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class Controller {
    public Button button;

    public void onAction(ActionEvent actionEvent) throws IOException {
        boolean x = ConfirmBox.display("Hey", "Testtest");
        System.out.println(x);
    }
}
