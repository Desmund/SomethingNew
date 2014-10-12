package Main;

import java.util.Date;

/**
 * Created by Denis on 04.10.2014.
 */
public class ThreadTimer implements Runnable {
    private double time;
    private double step;
    private Thread go;
    private long last,first;
    private int count = 0;
    private boolean b = true;

    public ThreadTimer(double time,double step){
        this.step = step;
        this.time = time;
        go = new Thread(this);
        go.start();
    }

    public void run(){
        while(go!=null) {
            first = setTime();
            last = setTime();
            while((last - first)<(step*1000)){
                last = new Date().getTime();
            }
            count++;
            go = getGo();
            if(go!=null) {
                Utils.writeStringWithOutEnter("Игрок - ");
                System.out.format("%.2f", time);
                Utils.writeEnter();
                time -= step;
            }
        }
    }

    private long setTime(){
        return new Date().getTime();
    }

    public long getTime(){
        long t = ((long)((count-1) * step * 1000))+ (last - first);
        return t;
    }

    private Thread getGo(){
        return go;
    }

    public void stop(){
        go = null;
        b = false;
    }
}
