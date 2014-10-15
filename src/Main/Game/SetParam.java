package Main.Game;

import Main.Menu.*;
import Main.*;

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



    public static boolean getParam(){
//        FileUtils file = new FileUtils();
//        String json_str = file.readFile("Sets.txt");
//        JSONObject obj = new JSONObject();
//        JSONParser parser = new JSONParser();
//        try{
//            obj = (JSONObject) parser.parse(json_str);
//        }catch(Exception e){}
//        JSONArray ja = (JSONArray) obj.get("sets");
//        time = (Double) ja.get(0);
//        step = (Double) ja.get(1);
//        counOfRound = (Long)ja.get(2);
        return false;
    }

    public static void setParam(){
//        FileUtils file = new FileUtils();
//        String json_str;
//        JSONArray ja = new JSONArray();
//        JSONObject obj = new JSONObject();
//        ja.add(time);
//        ja.add(step);
//        ja.add(counOfRound);
//        obj.put("sets",ja);
//        json_str = obj.toString();
//        file.writeFile("Sets.txt",json_str);
    }
}
