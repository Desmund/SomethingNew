package Main;

import java.util.Date;

/**
 * Created by Denis on 04.10.2014.
 */
public class ThreadTimer implements Runnable {
    //todo исправить работу с таймером
    private double time;
    private double step;
    private Thread go;

    public ThreadTimer(double time,double step){
        this.step = step;
        this.time = time;
        go = new Thread(this);
        go.start();
    }

    public void run(){
        Thread th=Thread.currentThread();
        while(go==th) {
            long first = new Date().getTime();
            long last = new Date().getTime();
            while((last - first)<(step*1000)){
                last = new Date().getTime();
            }
            Utils.writeStringWithOutEnter("Игрок - ");
            System.out.format("%.2f", time);
            Utils.writeEnter();
            time -= step;
        }
    }

    public void stop(){
        go = null;
    }
}
