package Main.Menu;

import Main.FileUtils;
import Main.Game.Player;
import Main.Utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Created by Denis on 15.10.2014.
 */
public class RecordMenu extends BaseMenu {
    public void printMenu(double t) {
        setTime(t);
        Utils.writeString("Записать ваш результат в таблицу рекордов?");
        Utils.writeString("1 - Да");
        Utils.writeString("2 - Нет");
        getValue();
    }

    public void printMenu(boolean b) {
        Utils.writeEnter();
        if(b)
            table_path = "Table.txt";
        else
            table_path = "MultyTable.txt";
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

    private void writeToFile(){
        String name ="";
        Utils.writeString("Введите свое имя:");
        try {
            name = Utils.readString();
        }catch (Exception e){
            Utils.writeString("Ошибка ввода!");
        }
        double time = getTime();

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
        file.writeFile(table_path,code(s));
    }
}
