package finalproject.finalprojecttest;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

/**
 遊戲畫面:
 1.地圖
 2.LABEL顯示狀態
 3.Dice
 */
public class Controller3 {
    DataHolder data = DataHolder.get();
    Dice dice = new Dice();
    RadioButton[] buttonList;
    @FXML
    RadioButton button1;
    @FXML
    RadioButton button2;
    @FXML
    ToggleGroup toggleGroup;
    @FXML
    Label label;
    @FXML
    Button getPlayerChooseWhoButton, checkButton;
    @FXML
    Pane dicePane;
    public void Click() {
        buttonList = new RadioButton[]{button1, button2};
        button1.setVisible(false);
        button2.setVisible(false);
        dicePane.setVisible(true);
        dice.whoRolling(DataHolder.get().currentPlayer);
        dice.rollDice();
        diceOutput();
        /*if(!data.changePos(dice.reDice())) {
            System.out.print("pleaseReDice");
            /*
            讓玩家重骰

        }
        else{
            System.out.print("Fine");
        /*
            用data.pos找到位置，然後在地圖改變位置

        }*/
    }
    public void setButtonName(){ //設定選擇玩家時顯示RadioButton的文字跟UserData
        int CP = dice.currentPlayerInt;
        for(int i = 0, buttonListNumber = 0; buttonListNumber < 2; buttonListNumber++, i++){
            if (i == CP-1) i++;
            buttonList[buttonListNumber].setText(dice.playerName[i]);
            buttonList[buttonListNumber].setUserData(i+1);

        }
    }
    @FXML
    public void checkButtonOnPressed(){
        checkButton.setVisible(false);
        dicePane.setVisible(false);
    }
    @FXML
    public void getPlayerChooseWhoButtonOnPressed(){
        for (int i = 0; i < 2; i++){
            buttonList[i].setVisible(false);
        }
        getPlayerChooseWhoButton.setVisible(false);
        checkButton.setVisible(true);
        int thePlayerBeSelect = 0;
        if (toggleGroup.getSelectedToggle() != null) {
            String temp = toggleGroup.getSelectedToggle().getUserData().toString();
            thePlayerBeSelect = Integer.parseInt(temp);
        }
        else label.setText("please select");
        switch (dice.diceValueForAction) {
            case 2 -> {
                label.setText(dice.playerName[thePlayerBeSelect-1]+"後退了"+dice.diceValueForSteps+"步");
                dice.changePlayerPosition(thePlayerBeSelect, dice.diceValueForSteps);
            }
            case 3 -> {
                label.setText(dice.playerName[thePlayerBeSelect-1]+"後退了"+dice.diceValueForSteps+"步");
                dice.changePlayerPosition(thePlayerBeSelect, -dice.diceValueForSteps);
            }
        }


    }
    public void diceOutput(){ //呼叫此函式時，
        setButtonName();
        switch (dice.diceValueForAction) { // 要輸出誰移動、移動幾步，要顯示label、選擇
            case 0 -> { // 自己前進
                label.setText("你前進了"+dice.diceValueForSteps+"步");
                dice.changePlayerPosition(dice.currentPlayerInt, dice.diceValueForSteps);
            }
            case 1 -> { // 自己後退
                label.setText("你後退了"+dice.diceValueForSteps+"步");
                dice.changePlayerPosition(dice.currentPlayerInt, -dice.diceValueForSteps);
            }
            case 2 -> { //別人前進
                //顯示選擇 和確認按鈕 確認按鈕按下後根據選擇設定移動玩家、玩家位置移動、移動幾步\
                label.setText("請選擇要讓哪位玩家前進");
                for (int i = 0; i < 2; i++){
                    buttonList[i].setVisible(true);
                }
                getPlayerChooseWhoButton.setVisible(true);

            }
            case 3 -> { //別人後退
                label.setText("請選擇要讓哪位玩家後退");
                for (int i = 0; i < 2; i++){
                    buttonList[i].setVisible(true);
                }
                getPlayerChooseWhoButton.setVisible(true);

            }
            default -> System.out.println("rollDice 骰出值超過了");

        }
    }
}
