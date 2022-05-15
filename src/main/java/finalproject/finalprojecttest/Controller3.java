package finalproject.finalprojecttest;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 遊戲畫面:
 1.地圖
 2.LABEL顯示狀態
 3.Dice
 */
public class Controller3 {
    DataHolder data = DataHolder.get();
    Dice dice = new Dice();
    @FXML
    RadioButton button1, button2;
    @FXML
    ToggleGroup toggleGroup;
    public void Click() {
        if(!data.changePos(dice.reDice())) {
            System.out.print("pleaseReDice");
            /*
            讓玩家重骰
            */
        }
        else{
            System.out.print("Fine");
        /*
            用data.pos找到位置，然後在地圖改變位置
         */
        }
    }
}
