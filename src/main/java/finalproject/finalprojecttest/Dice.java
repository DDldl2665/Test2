package finalproject.finalprojecttest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Dice {
    private DataHolder data = DataHolder.get();
    private int diceValueForAction=0; //骰出來的值
    private int diceValueForSteps = 0;
    private DataHolder currentPlayer;

    public Dice(){
        /*
         可改為每次建構就RANDOM隨機數字
         */
        this.value =1;
    }
    int value;
    public void roll(int whichPlayer){ //呼叫此函式時，需要輸入是誰在骰。1是玩家1，2是玩家二... 此函式不回傳 直接做完
        diceValueForAction= (int)(Math.random()*4); // 骰作何種動作
        diceValueForSteps = (int)(Math.random()*4); // 骰走幾步
        switch (whichPlayer) { //用來設定現在是誰在骰骰子
            case 1 -> currentPlayer = data.getDataHolder1();
            case 2 -> currentPlayer = data.getDataHolder2();
        }
        switch (diceValueForAction) { // 要輸出誰移動、移動幾步，要顯示label、選擇
            case 0 -> { // 自己前進
                currentPlayer.pos += diceValueForSteps;
                data.setWhoMove(whichPlayer);
                data.setMoveSteps(diceValueForSteps);
            }
            case 1 -> { // 自己後退
                currentPlayer.pos -= diceValueForSteps;
                data.setWhoMove(whichPlayer);
                data.setMoveSteps(-diceValueForSteps);
            }
            case 2 -> { //別人前進
                //顯示選擇
            }
            case 3 -> { //別人後退


            }
            default -> System.out.println("rollDice 骰出值超過了");

        }
    }

}
