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

    public static int readInteger()throws Exception{
        int num = Integer.parseInt(readString());
        return num;
    }

    public static char readKey()throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"Cp866"));
        int key = br.read();
        return (char)key;
    }

    public static String readString()throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        return s;
    }
}
