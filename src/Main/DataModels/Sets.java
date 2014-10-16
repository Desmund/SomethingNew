package Main.DataModels;

/**
 * Created by Denis on 15.10.2014.
 */
public class Sets {
    private double time;
    private double step;
    private long counOfRound;
    private DIFF difficulty;
    public enum DIFF{
        diff_easy,
        diff_med,
        diff_hard;
    }

    public Sets(double time, double step, long counOfRound, DIFF difficulty) {
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

    public DIFF getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DIFF difficulty) {
        this.difficulty = difficulty;
    }
}
