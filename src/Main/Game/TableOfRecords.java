package Main.Game;

import Main.FileUtils;
import Main.Menu.BaseMenu;
import Main.Menu.GameMenu;
import Main.Utils;
import org.json.simple.*;
import org.json.simple.parser.*;

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
        //todo организовать сортировку данных в таблице
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
        try {
            Object o = parser.parse(s);
            jsonObj = (JSONObject) o;
        }catch(Exception e){
            Utils.writeString("Ошибка,при парсинге строки!");
        }
        Player p= new Player(name,time);
        JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray();
        arr.add(p.getName());
        arr.add(p.getDate());
        arr.add(p.getTime());
        obj.put(jsonObj.size(),arr);
        if(!jsonObj.isEmpty())
            obj.putAll(jsonObj);
        s = obj.toString();
        file.writeFile(table_path,s);
    }

    private String readFromFile(){
        FileUtils file = new FileUtils();
        StringBuilder s = new StringBuilder();
        String json = file.readFile(table_path);
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(json);
            JSONObject jsonObj = (JSONObject) obj;
            for(int i=0;i<jsonObj.size();i++){
                JSONArray ja = (JSONArray) jsonObj.get(Integer.toString(i));
                s.append((i+1)+". ");
                s.append(ja.get(0).toString()+" ");
                s.append(ja.get(1).toString()+" ");
                s.append(ja.get(2).toString()+"\n");
            }
        }catch(Exception e){
            Utils.writeString("Ошибка,при парсинге строки!");
        }
        Utils.writeString(" ");
        return s.toString();
    }
}
