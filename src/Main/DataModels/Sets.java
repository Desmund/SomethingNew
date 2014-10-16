package Main.DataModels;

/**
 * Created by Denis on 15.10.2014.
 */
public class Sets {
    private double time;
    private double step;
    private long counOfRound;
    private int difficulty;

    public Sets(double time, double step, long counOfRound, int difficulty) {
        this.time = time;
        this.step = step;
        this.counOfRound = counOfRound;
        this.difficulty = difficulty;
    }

    public Sets(){
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public long getCounOfRound() {
        return counOfRound;
    }

    public void setCounOfRound(long counOfRound) {
        this.counOfRound = counOfRound;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
