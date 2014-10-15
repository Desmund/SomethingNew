package Main.Game;

import Main.FileUtils;
import Main.Menu.RecordMenu;
import Main.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;

/**
 * Created by Denis on 30.09.2014.
 */
public class TableOfRecords{

    private double time = 0;
    protected String table_path;

    public void writeToFile(Player p){
        ArrayList<Record> rec = readFromFile();
        boolean b = true;
        Record r = new Record(p.getName(),p.getDate(),p.getTime());
        for(int i=0;i< rec.size();i++) {
            if(rec.get(i).getTime()>p.getTime()) {
                rec.add(i,r);
                b = false;
                break;
            }
        }
        if (b){
            rec.add(r);
        }
        Gson gson = new Gson();
        table_path = RecordMenu.getTable_path();
        FileUtils.writeFile(table_path,gson.toJson(rec));
    }

    public ArrayList<Record> readFromFile(){
        table_path = RecordMenu.getTable_path();
        String json =FileUtils.readFile(table_path);
        if(json.isEmpty()) {
            Utils.writeString("Таблица рекордов пустая!");
            return new ArrayList<Record>();
        }
        Gson gson = new Gson();
        ArrayList<Record> l = gson.fromJson(json,new TypeToken<ArrayList<Record>>(){}.getType());
        return l;
    }

//    private String code(String s){
//        ArrayList<Integer> setOfChar = new ArrayList<Integer>();
//        for(int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//            if(i%2==1)
//                setOfChar.add((int)c-(i%9));
//            else
//                setOfChar.add((int)c+(i%9));
//        }
//        JSONArray arr = new JSONArray();
//        arr.addAll(setOfChar);
//        s = arr.toString();
//        return s;
//    }
//
//    private String decode(String s){
//        StringBuilder cs = new StringBuilder();
//        JSONParser parse = new JSONParser();
//        JSONArray arr = new JSONArray();
//        try{
//            arr = (JSONArray) parse.parse(s);
//        }catch(Exception e){}
//        for(int i = 0; i < arr.size(); i++){
//            long c = (Long) arr.get(i);
//            if(i%2==1)
//                cs.append((char)(c+(i%9)));
//            else
//                cs.append((char)(c-(i%9)));
//        }
//        s = cs.toString();
//        return s;
//    }
}
