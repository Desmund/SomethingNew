package Main.Game;

import Main.Menu.*;
import Main.*;

import java.io.IOException;

/**
 * Created by Denis on 30.09.2014.
 */
public class SetParam extends BaseMenu {
    private static final int diff_easy = 0;
    private static final int diff_med = 1;
    private static final int diff_hard = 2;

    private static  char key = ' ';

    private static int difficulty = diff_med;

    private static double time = 4;

    private static double step = 0.5;

    private static int counOfRound = 20;

    public void setTime(int diff){
        switch (diff) {
            case 0:
                time = (int)Math.random()*31 + 30;
                step = 1;
                break;
            case 1:
                time = (int)Math.random()*21 + 20;
                step = 0.5;
                break;
            case 2:
                time = (int)Math.random()*21 + 10;
                step = 0.2;
                break;
        }
        time /=10.0;
    }

    private void setDifficulty(int diff){
        difficulty = diff;
        setTime(diff);
    }

    private void setCountOfRounds(){
        boolean enter = false;
        while(!enter) {
            try {
                counOfRound = Utils.readInteger();
                if(counOfRound>0&&counOfRound<=20)
                    enter = true;
                else
                    Utils.writeString("Количество раундов должнл быть больше 0 и меньше или равно 20!");
            } catch (Exception e) {
                Utils.writeString("Введите целое число!");
            }
        }
    }

    public void setKey(){
        try{
            key = Utils.readKey();
        }catch (Exception e){}
    }

    public char getKey(){
        return key;
    }

    public int getDifficulty(){
        return difficulty;
    }

    public double getTime(){
        return time;
    }

    public int getCountOfRound(){
        return counOfRound;
    }

    public double getStep(){
        return step;
    }

    @Override
    public void printMenu() {
        Utils.writeString("Выберите кол-во раундов(не больше 20):");
        setCountOfRounds();
        Utils.writeEnter();
        Utils.writeString("Выберите уровень сложности игры:");
        Utils.writeString("1 - Легкая");
        Utils.writeString("2 - Средняя");
        Utils.writeString("3 - Сложная");
        getValue();
        Utils.writeString("Выберите клавишу:");
        setKey();
        Utils.writeEnter();
        new GameMenu().printMenu();
    }

    @Override
    protected boolean select(int i) {
        switch (i) {
            case 1:
                setDifficulty(diff_easy);
                return true;
            case 2:
                setDifficulty(diff_med);
                return true;
            case 3:
                setDifficulty(diff_hard);
                return true;
            default:
                return false;
        }
    }
}
