package Main.Game;

import Main.Menu.GameMenu;
import Main.Utils;
import java.util.Date;

/**
 * Created by Denis on 30.09.2014.
 */
public class BaseGame {
    private long time=0;
    //todo добавить работу с Thread
    public void printMenu(){
        Utils.writeString("Обновление таймера: " + new SetParam().getStep());
        switch (new SetParam().getDifficulty()) {
            case 0:
                Utils.writeString("Время раунда: 3-6");break;
            case 1:
                Utils.writeString("Время раунда: 2-4");break;
            case 2:
                Utils.writeString("Время раунда: 1-3");break;
        }
        Utils.writeString("Кол-во раундов: " + new SetParam().getCountOfRound());
        start();
        new TableOfRecords().printMenu();
    }

    protected void start(){
        int n = new SetParam().getCountOfRound();
        for(int i=0;i<n;i++){
            Utils.writeString("Раунд " + (i+1) + " - Вы готовы?");
            try {
                Utils.readString();
            }catch (Exception e){}
            Utils.writeString("Вы нажали на " + round());
        }
        //задержка
        try {
            Utils.readString();
        }catch (Exception e){}
        Utils.writeString("Твой результат за "+n+" раундов "+time+" секунды!");
        try {
            Utils.readString();
        }catch (Exception e){}
    }

    protected long round(){
        //todo обработка нажатия клавиши
        //todo перевод long->double
        double step = new SetParam().getStep();
        long ts = 0,tf = 0;
        Date d = new Date();
        ts = d.getTime();
        char c = new SetParam().getKey();
        char down = ' ';
        while(c!=down){
            d = new Date();
            tf = d.getTime();
            if((tf-ts)%step==0)
                counter(tf-ts);
            try {
                down = Utils.readKey();
            }catch (Exception e){}
        }
        d = new Date();
        tf = d.getTime();
        time += Math.abs(tf);
        return tf;
    }

    protected void counter(double num){
        Utils.writeString(Double.toString(num));
    }
}
