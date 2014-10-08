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
    protected double timeOfAllRounds = 0;
    protected int n = new SetParam().getCountOfRound();

    public void printMenu(){
        //todo форматный ввывод.вывод 2 знаков после запятой
        printSets();
        for(int i=0;i<n;i++) {
            start(i);
        }
        waitForClick(timeOfAllRounds);
        new TableOfRecords().printMenu(timeOfAllRounds);
    }

    protected void printSets(){
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
    }

    protected void waitForClick(double value){
        //задержка
        try {
            Utils.readString();
        }catch (Exception e){}
        Utils.writeStringWithOutEnter("Результат за " + n + " раундов " + value +" секунд(ы)");
        Utils.writeEnter();
        try {
            Utils.readString();
        }catch (Exception e){}
    }

    protected double start(int i){
        Utils.writeString("Раунд " + (i+1) + " - Вы готовы?");
        Utils.writeString("Нажмите любую клавишу для начала");
        Utils.writeString("0 - Выход в главное меню");
        try {
            if(Utils.readKey()=='0')
                new GameMenu().printMenu();
        }catch (Exception e){}
        double timeOfRound = round();
        Utils.writeString("Вы нажали на " + timeOfRound + " секунд(е)");
        Utils.writeEnter();
        return timeOfRound;
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
        return ((time - t)/10)/100.0;
    }
}
