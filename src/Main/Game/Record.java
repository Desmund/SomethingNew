package Main.Game;

import java.util.Date;

/**
 * Created by Denis on 15.10.2014.
 */
public class Record {
    private String name;
    private Date date;
    private double time;

    public Record(String name, Date date, double time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
