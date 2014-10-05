package Main.Game;

import Main.Menu.GameMenu;
import Main.Utils;
import java.util.ArrayList;

/**
 * Created by Denis on 30.09.2014.
 */
public class MultyPlay extends BaseGame {
    //todo переопределить методы  BaseGame
    private int countOfPlayers = 0;

    @Override
    protected void start() {
        double min;
        int player;
        ArrayList<Double> list = new ArrayList<Double>();
        for(int i=0;i<countOfPlayers;i++) {
            Utils.writeString("Ход "+(i+1)+" игрока");
            super.start();
            list.add(timeOfAllRounds);
        }
        min = list.get(0);
        player = 0;
        for(int i= 1;i<list.size();i++){
            if(min>list.get(i)) {
                min = list.get(i);
                player = i+1;
            }
        }
        Utils.writeString("Победил игрок "+player+" с результатом:"+min);
    }

    public void printMenu() {
        Utils.writeString("Введите кол-во игроков (2-4):");
        readCountOfPlayers();
        printSets();
        start();
        new GameMenu().printMenu();
    }

    private int readCountOfPlayers(){
        while((countOfPlayers>4)||(countOfPlayers<=1)) {
            try {
                countOfPlayers = Utils.readInteger();
                if((countOfPlayers>4)||(countOfPlayers<=1))
                    Utils.writeString("Кол-во игроков должно быть от 2 до 4!");
            } catch (Exception e) {
                countOfPlayers = 0;
                Utils.writeString("Ошибка ввода числа!");
            }
        }
        return countOfPlayers;
    }
}
