package Main.Game;

import java.util.Date;

/**
 * Created by Denis on 01.10.2014.
 */
public class Player {
    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public double getTime() {
        return time;
    }

    private String name;
    private Date date;
    private double time;

    public Player(String name,double time){
        this.name = name;
        this.time = time;
        date = new Date();
    }
}
