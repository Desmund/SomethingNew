package Main.Game;

import Main.FileUtils;
import Main.Menu.BaseMenu;
import Main.Menu.GameMenu;
import Main.Utils;
import org.json.simple.*;
import org.json.simple.parser.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

/**
 * Created by Denis on 30.09.2014.
 */
public class TableOfRecords extends BaseMenu {

    private double time = 0;
    protected String table_path = "Table.txt";

    public void printMenu(double t) {
        setTime(t);
        Utils.writeString("Записать ваш результат в таблицу рекордов?");
        Utils.writeString("1 - Да");
        Utils.writeString("2 - Нет");
        getValue();
    }

    public void printMenu() {
        Utils.writeEnter();
        Utils.writeString("========Рекорды========");
        String s = readFromFile();
        Utils.writeString(s);
        try {
            Utils.readString();
        }catch (Exception e){}
        new GameMenu().printMenu();
    }

    @Override
    protected boolean select(int i) {
        switch (i){
            case 1:
                writeToFile();
                new GameMenu().printMenu();
                return true;
            case 2:
                new GameMenu().printMenu();
                return true;
        }
        return false;
    }

    private void setTime(double time){
        this.time = time;
    }

    private double getTime(){
        return time;
    }

    private void writeToFile(){
        String name ="";
        Utils.writeString("Введите свое имя:");
        try {
            name = Utils.readString();
        }catch (Exception e){
            Utils.writeString("Ошибка ввода!");
        }
        double time = getTime();
        FileUtils file = new FileUtils();
        String s = file.readFile(table_path);
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = new JSONObject();
        if(!s.isEmpty()){
            try {
                Object o = parser.parse(s);
                jsonObj = (JSONObject) o;
            } catch (Exception e) {
                Utils.writeString("Ошибка,при парсинге строки!");
            }
        }
        Player p= new Player(name,time);
        JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray();
        arr.add(p.getName());
        arr.add(p.getDate());
        arr.add(convertTime(p.getTime()));
        obj.put(jsonObj.size()+1,arr);
        if(!jsonObj.isEmpty())
            obj.putAll(jsonObj);
        s = obj.toString();
        file.writeFile(table_path,s);
    }

    private double convertTime(double b){
        int i = (int)b;
        int a = (int)((b - i)*100);
        b = i + a/100.0;
        return b;
    }

    private JSONObject parsObj(String json){
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = new JSONObject();
        try {
            Object obj = parser.parse(json);
            jsonObj = (JSONObject) obj;
        }catch(Exception e){
            Utils.writeString("Ошибка,при парсинге строки!");
        }
        return jsonObj;
    }

    private JSONArray parsArr(JSONObject jo,int i){
        JSONArray j = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            j =(JSONArray) parser.parse(jo.get(i).toString());
        }catch (Exception e) {}
        return j;
    }

    private String readFromFile(){
        FileUtils file = new FileUtils();
        StringBuilder s = new StringBuilder();
        String json = file.readFile(table_path);
        if(json.isEmpty()) {
            Utils.writeString("Таблица рекордов пустая!");
            return "";
        }
            JSONObject jsonObj = parsObj(json);
            jsonObj = sortTableValues(jsonObj);
            for(int i=1;i<=jsonObj.size();i++){
                JSONArray ja = (JSONArray) jsonObj.get(Integer.toString(i));
                s.append((i)+". ");
                s.append(ja.get(0).toString()+" ");
                s.append(ja.get(1).toString()+" ");
                s.append(ja.get(2).toString()+"\n");
            }
        Utils.writeString(" ");
        return s.toString();
    }

    private JSONObject sortTableValues(JSONObject obj){
        ArrayList<Double> time = new ArrayList<Double>();
        ArrayList<String> data = new ArrayList<String>();
        JSONObject jo = new JSONObject();
        for(int i=1;i<=obj.size();i++) {
            jo.put(i, obj.get(Integer.toString(i)));
            JSONArray ja = parsArr(jo,i);
            time.add((Double) ja.get(2));
            data.add(ja.toString());
        }
/*        jo.put(obj.size(), obj.get(obj.size()));
        JSONArray ja = parsArr(jo,obj.size());
        time.add((Double) ja.get(2));
        data.add(ja.toString());   */
        JSONObject o = new JSONObject();
        String dop_string = "";
        double dop_double = 0;
        for(int i = 0;i<time.size();i++) {
            for (int j = i+1; j < time.size(); j++) {
                if (time.get(i) > time.get(j)) {
                    dop_double = time.get(j);
                    time.set(j,time.get(i));
                    time.set(i,dop_double);
                    dop_string = data.get(j);
                    data.set(j,data.get(i));
                    data.set(i,dop_string);
                }
            }
            JSONArray ar = new JSONArray();
            Object or = new Object();
            JSONParser parser = new JSONParser();
            try {
                 or = parser.parse(data.get(i));
            }catch (Exception e){}
            for(int k=0;k<3;k++)
                ar.add(((JSONArray) or).get(k));
            o.put(Integer.toString(i+1),ar);
        }
        return o;
    }
}
