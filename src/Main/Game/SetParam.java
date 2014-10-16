package Main.Game;

import Main.*;
import Main.DataModels.Sets;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * Created by Denis on 30.09.2014.
 */
public class SetParam {
    public enum DIFF{
        diff_easy,
        diff_med,
        diff_hard;
    }

    private static Sets s = new  Sets();

    private SetParam() {

    }

    public static void setTime(int diff){
        switch (diff) {
            case 0:
                s.setTime((int)(Math.random()*31) + 30);
                s.setStep(1);
                break;
            case 1:
                s.setTime((int)(Math.random()*21) + 20);
                s.setStep(0.5);
                break;
            case 2:
                s.setTime((int)(Math.random()*21) + 10);
                s.setStep(0.2);
                break;
        }
        s.setTime(s.getTime()/10.0);
    }

    public static void setDifficulty(int diff){
        s.setDifficulty(diff);
        setTime(diff);
    }

    public static void setCountOfRounds(){
        boolean enter = false;
        while(!enter) {
            s.setCounOfRound(Utils.readInteger());
            if(s.getCounOfRound()>0&&s.getCounOfRound()<=20)
                enter = true;
            else
                Utils.writeString("Количество раундов должнл быть больше 0 и меньше или равно 20!");
        }
    }

    public static int getDifficulty(){
        return s.getDifficulty();
    }

    public static double getTime(){
        return s.getTime();
    }

    public static long getCountOfRound(){
        return s.getCounOfRound();
    }

    public static double getStep(){
        return s.getStep();
    }
    public static void getParam(){
        String json_str = FileUtils.readFile("Sets.txt");
        Gson gson = new Gson();
        s = gson.fromJson(json_str,new TypeToken<Sets>(){}.getType());
    }

    public static void setParam(){
        Gson gson = new Gson();
        FileUtils.writeFile("Sets.txt",gson.toJson(s));
    }
}
