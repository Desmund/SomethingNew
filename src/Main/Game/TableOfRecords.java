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

    public void printMenu(double t) {
        setTime(t);
        Utils.writeString("Записать ваш результат в таблицу рекордов?");
        Utils.writeString("1 - Да");
        Utils.writeString("2 - Нет");
        getValue();
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
        String table_path = "e:/js/SomethingNew/Table.txt";
        FileUtils file = new FileUtils();
        Player p= new Player(name,time);
        JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray();
        arr.add(p.getDate());
        arr.add(p.getTime());
        obj.put(p.getName(),arr);
        file.writeFile(table_path,obj.toString());
    }
}
