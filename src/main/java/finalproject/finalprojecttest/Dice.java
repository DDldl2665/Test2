package finalproject.finalprojecttest;

public class Dice {
    public DataHolder data = DataHolder.get();
    public int diceValueForAction=0; //骰出來的值
    public int diceValueForSteps = 0;
    public int currentPlayerInt = 1;
    public String[] playerName = {"玩家一","玩家二","玩家三","玩家四"};


    public Dice(){
        /*
         可改為每次建構就RANDOM隨機數字
         */

        this.value =1;
    }
    int value;
    int testvalue = 0;
    public void changePlayerPosition(int movePlayer, int moveSteps){
        data.setWhoMove(movePlayer);
        data.setMoveSteps(moveSteps);
        DataHolder movePlayerData ;
        switch (movePlayer) {
            case 1 -> movePlayerData = data.getDataHolder1();
            case 2 -> movePlayerData = data.getDataHolder2();
            default -> {
                System.out.println("movePlayerData未初始化 在Dice.java changePlayerPosition");
                movePlayerData = data.getDataHolder1();
                movePlayerData.pos -= moveSteps;
            }
        }
        movePlayerData.pos += moveSteps;
    }
    public void rollDice(){
        diceValueForAction= (int)(Math.random()*4); // 骰作何種動作
        diceValueForSteps = (int)(Math.random()*4); // 骰走幾步
    }
    public void whoRolling(int whichPlayer){
        this.currentPlayerInt = whichPlayer;
        switch (whichPlayer) { //用來設定現在是誰在骰骰子
            case 1 -> currentPlayerInt = 1;
            case 2 -> currentPlayerInt = 2;
        }
    }


}
