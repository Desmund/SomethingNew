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
        rec.add(new Record(p.getName(),p.getDate(),p.getTime()));
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

//    private JSONObject sortTableValues(JSONObject obj){
//        ArrayList<Double> time = new ArrayList<Double>();
//        ArrayList<String> data = new ArrayList<String>();
//        JSONObject jo = new JSONObject();
//        for(int i=1;i<=obj.size();i++) {
//            jo.put(i, obj.get(Integer.toString(i)));
//            JSONArray ja = parsArr(jo,i);
//            time.add((Double) ja.get(2));
//            data.add(ja.toString());
//        }
//        JSONObject o = new JSONObject();
//        String dop_string = "";
//        double dop_double = 0;
//        for(int i = 0;i<time.size();i++) {
//            for (int j = i+1; j < time.size(); j++) {
//                if (time.get(i) > time.get(j)) {
//                    dop_double = time.get(j);
//                    time.set(j,time.get(i));
//                    time.set(i,dop_double);
//                    dop_string = data.get(j);
//                    data.set(j,data.get(i));
//                    data.set(i,dop_string);
//                }
//            }
//            JSONArray ar = new JSONArray();
//            Object or = new Object();
//            JSONParser parser = new JSONParser();
//            try {
//                 or = parser.parse(data.get(i));
//            }catch (Exception e){}
//            for(int k=0;k<3;k++)
//                ar.add(((JSONArray) or).get(k));
//            o.put(Integer.toString(i+1),ar);
//        }
//        return o;
//    }

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
