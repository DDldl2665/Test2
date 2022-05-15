package finalproject.finalprojecttest;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DataHolder {
    ImageView ve = new ImageView();
    private static DataHolder dataHolder = new DataHolder();
    private static DataHolder dataHolder2 = new DataHolder();
    private DataHolder(){}

    public static DataHolder get(){
        return dataHolder;
    }

    public int pos;
    public int selectIndex;
    public int currentPlayer = 1;/**林盈利*/ // 擲骰子的時候告訴我是誰在骰
    private int whoMove = 0; /**林盈利*/ //等於1 玩家一移動，等於2 玩家二移動
    private int moveSteps = 0; /**林盈利*/ //當回合移動的玩家移動了幾步
    public void setWhoMove(int who) { whoMove = who; } /**林盈利*/ // 用來設whoMove
    public void setMoveSteps(int steps) { moveSteps = steps; }/**林盈利*/ // 用來設moveSteps
    public int getMoveSteps() { return moveSteps; }/**林盈利*/
    public int getWhoMove() { return moveSteps; }/**林盈利*/

    /**林盈利*/// 用來設moveSteps


    public Image getImage(ImageView v){
        Image c = v.getImage();
        return c;
    }
    public DataHolder getDataHolder1(){ /**林盈利*/ // 我用來抓dataHolder
        return dataHolder;
    }
    public DataHolder getDataHolder2(){ /**林盈利*/ // 我用來抓dataHolder
        return dataHolder2;
    }
    public boolean changePos(int value){
        if(pos + value > 100 || pos +value < 0)
            return false;

        pos+=value;
        return true;
    }
    /*

     */
    public void setImage(String name,ImageView v){
        Image a = new Image(name);
        v.setImage(a);
    }

}

