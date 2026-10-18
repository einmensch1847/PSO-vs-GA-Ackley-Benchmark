package experiment;

public class RunResult {
    public double bestFitness;
    public double error;
    public double timeMillis;
    public boolean success;

    public RunResult(double bestFitness, double error, double timeMillis, boolean success) {
        this.bestFitness = bestFitness;
        this.error = error;
        this.timeMillis = timeMillis;
        this.success = success;
    }
}