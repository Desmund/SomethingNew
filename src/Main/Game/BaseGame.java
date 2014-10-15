package Main.Game;

import Main.Menu.GameMenu;
import Main.Menu.RecordMenu;
import Main.ThreadTimer;
import Main.Utils;
import java.util.Date;

/**
 * Created by Denis on 30.09.2014.
 */
public class BaseGame {

    private long time=0;
    protected double timeOfAllRounds = 0;
    protected long n = SetParam.getCountOfRound();

    public void printMenu(){
        printSets();
        for(int i=0;i<n;i++) {
            start(i);
        }
        waitForClick(timeOfAllRounds);
        new RecordMenu().printMenu(timeOfAllRounds,true);
    }

    protected void printSets(){
        Utils.writeString("Обновление таймера: " + SetParam.getStep());
        switch (SetParam.getDifficulty()) {
            case 0:
                Utils.writeString("Время раунда: 3-6");break;
            case 1:
                Utils.writeString("Время раунда: 2-4");break;
            case 2:
                Utils.writeString("Время раунда: 1-3");break;
        }
        Utils.writeString("Кол-во раундов: " + SetParam.getCountOfRound());
        Utils.writeEnter();
    }

    protected void waitForClick(double value){
        //задержка
        Utils.readString();
        Utils.writeStringWithOutEnter("Результат за " + n + " раундов ");
        System.out.format("%.2f", value);
        Utils.writeString(" секунд(ы)");
        Utils.writeEnter();
        Utils.readString();
    }

    protected double start(int i){
        Utils.writeString("Раунд " + (i+1) + " - Вы готовы?");
        Utils.writeString("Нажмите любую клавишу для начала");
        Utils.writeString("0 - Выход в главное меню");
        if(Utils.readKey()=='0')
            new GameMenu().printMenu();
        double timeOfRound = round();
        Utils.writeString("Вы нажали на " + timeOfRound + " секунд(е)");
        Utils.writeEnter();
        return timeOfRound;
    }

    protected double round(){
        double time_param = SetParam.getTime();
        double step_param = SetParam.getStep();
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
            c = Utils.readKey();
            if(c=='\n') {
                t = tt.getTime();
                tt.stop();
            }
        }
        timeOfAllRounds += ((Math.abs(time - t)/10)/100.0);
        SetParam.setTime(SetParam.getDifficulty());
        return ((time - t)/10)/100.0;
    }
}
