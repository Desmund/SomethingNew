package Main.Menu;

import Main.Game.Player;
import Main.Game.Record;
import Main.Game.TableOfRecords;
import Main.Utils;

import java.util.ArrayList;

/**
 * Created by Denis on 15.10.2014.
 */
public class RecordMenu extends BaseMenu {
    private TableOfRecords tb = new TableOfRecords();
    private double time;
    private static String table_path;

    public void printMenu(double t,boolean b) {
        if(b)
            setTable_path("Table.txt");
        else
            setTable_path("MultyTable.txt");
        time = t;
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
        ArrayList<Record> rec = tb.readFromFile();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<rec.size();i++){
            sb.append((i+1)+". "+rec.get(i)+"\n");
        }
        Utils.writeString(sb.toString());
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
        Player p = new Player(name,time);
        tb.writeToFile(p);
    }

    public static void setTable_path(String s){
        table_path = s;
    }

    public static String getTable_path() {
        return table_path;
    }
}
