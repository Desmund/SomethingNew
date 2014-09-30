package Main.Game;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Denis on 01.10.2014.
 */
public class Player {
    private String name;
    private String date;
    private double time;

    public Player(String name,double time){
        this.name = name;
        this.time = time;
        Date d =  new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        date = format1.format(d);
    }
}
