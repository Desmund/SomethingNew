package Main.Game;

import Main.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by Denis on 30.09.2014.
 */
public class SetParam {
    public enum DIFF{
        diff_easy,
        diff_med,
        diff_hard;
    }

    private static int difficulty = DIFF.diff_med.ordinal();
    private static double time = 0;
    private static double step = 0;
    private static long counOfRound = 0;

    private SetParam() {

    }

    public static void setTime(int diff){
        switch (diff) {
            case 0:
                time = (int)(Math.random()*31) + 30;
                step = 1;
                break;
            case 1:
                time = (int)(Math.random()*21) + 20;
                step = 0.5;
                break;
            case 2:
                time = (int)(Math.random()*21) + 10;
                step = 0.2;
                break;
        }
        time /=10.0;
    }

    public static void setDifficulty(int diff){
        difficulty = diff;
        setTime(diff);
    }

    public static void setCountOfRounds(){
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

    public static int getDifficulty(){
        return difficulty;
    }

    public static double getTime(){
        return time;
    }

    public static long getCountOfRound(){
        return counOfRound;
    }

    public static double getStep(){
        return step;
    }
    //todo переделать методы
    public static void getParam(){
        String json_str = FileUtils.readFile("Sets.txt");
        JsonObject obj = new JsonObject();
        JsonParser parser = new JsonParser();
        try{
            obj = (JsonObject) parser.parse(json_str);
        }catch(Exception e){}
        time = obj.get("time").getAsDouble();
        step =  obj.get("step").getAsDouble();
        counOfRound = obj.get("counOfRound").getAsInt();
        difficulty = obj.get("difficulty").getAsInt();
    }

    public static void setParam(){
        Gson gson = new Gson();
        Sets s = new Sets(time,step,counOfRound,difficulty);
        FileUtils.writeFile("Sets.txt",gson.toJson(s));
    }
}
