package Main.Game;

import Main.Menu.GameMenu;
import Main.ThreadTimer;
import Main.Utils;
import java.util.Date;

/**
 * Created by Denis on 30.09.2014.
 */
public class BaseGame {

    private long time=0;
    private double timeOfAllRounds = 0;

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
        Utils.writeEnter();
        start();
        new TableOfRecords().printMenu(timeOfAllRounds);
    }

    protected void start(){
        int n = new SetParam().getCountOfRound();
        for(int i=0;i<n;i++){
            Utils.writeString("Раунд " + (i+1) + " - Вы готовы?");
            Utils.writeString("Нажмите любую клавишу для начала");
            Utils.writeString("0 - Выход в главное меню");
            try {
                if(Utils.readKey()=='0')
                    new GameMenu().printMenu();
            }catch (Exception e){}
            Utils.writeString("Вы нажали на " + round() + " секунд(е)");
            Utils.writeEnter();
        }
        //задержка
        try {
            Utils.readString();
        }catch (Exception e){}
        Utils.writeStringWithOutEnter("Твой результат за " + n + " раундов " + timeOfAllRounds +" секунд(ы)");
        try {
            Utils.readString();
        }catch (Exception e){}
    }

    protected double round(){
        double time_param = new SetParam().getTime();
        double step_param = new SetParam().getStep();
        ThreadTimer tt = new ThreadTimer(time_param,step_param);
        long step =(long) (step_param*1000);
        time = (long) (time_param*1000);
        long ts = 0,tf = 0, t = 0;
        Date d = new Date();
        ts = d.getTime();
        char c = ' ';
        while(c!='\n'){
            d = new Date();
            tf = d.getTime();
            t = tf-ts;
            try {
                c = Utils.readKey();
            }catch (Exception e){}
            if(c=='\n')
                tt.stop();
        }
        d = new Date();
        t = d.getTime() - ts;
        timeOfAllRounds += Math.abs(((time - t)/10)/100.0);

        new SetParam().setTime(new SetParam().getDifficulty());
        return (t/10)/100.0;
    }

    protected void counter(double num){
        Utils.writeString(Double.toString(num));
    }
}
