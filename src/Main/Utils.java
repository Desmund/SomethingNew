package Main;

/**
 * Created by Denis on 30.09.2014.
 */
import java.io.*;

public class Utils {
    public static void writeString(String s){
        System.out.println(s);
    }

    public static void writeStringWithOutEnter(String s){
        System.out.print(s);
    }

    public static void writeDouble(double d){
        System.out.format("%.1f%n",d);
    }

    public static void writeEnter(){
        System.out.println();
    }

    public static int readInteger(){
        try {
            int num = Integer.parseInt(readString());
            return num;
        }catch(Exception e){
            Utils.writeString("Ошибка ввода числа!");
        }
        return -1;
    }

    public static char readKey(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "Cp866"));
            int key = br.read();
            return (char) key;
        }catch(Exception e){}
        return ' ';
    }

    public static String readString(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            return s;
        } catch (Exception e) {
        Utils.writeString("Ошибка ввода строки!");
        }
        return null;
    }
}
