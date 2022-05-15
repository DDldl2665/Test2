package finalproject.finalprojecttest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
/**
 選腳色
 */

public class Controller2 {
    DataHolder data = DataHolder.get();
    @FXML
    RadioButton rb1 = new RadioButton();
    @FXML
    RadioButton rb2 = new RadioButton();
    @FXML
    RadioButton rb3 = new RadioButton();

    @FXML
    ImageView v = new ImageView();
    @FXML
    public void rb1Click() {
        data.setImage("a.png",v);
    }
    public void rb2Click() {
        v.setVisible(false);

    }
    public void buttonOnPressed(){
        FP.currentStage.setScene(FP.F3Scene);
    }
    public void rb3Click() {

        v.setVisible(true);
        data.setImage("a.png",v);
    }
}
