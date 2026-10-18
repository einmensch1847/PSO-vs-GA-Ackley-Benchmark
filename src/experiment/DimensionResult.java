package experiment;

import java.util.List;

public class DimensionResult {
    public String algorithmName;
    public int dimension;
    public double threshold;
    public double successRate;
    public double rmse;
    public double avgTimeMillis;
    public List<RunResult> runs;

    public DimensionResult(String algorithmName, int dimension, double threshold,
                           double successRate, double rmse,
                           double avgTimeMillis, List<RunResult> runs) {
        this.algorithmName = algorithmName;
        this.dimension = dimension;
        this.threshold = threshold;
        this.successRate = successRate;
        this.rmse = rmse;
        this.avgTimeMillis = avgTimeMillis;
        this.runs = runs;
    }
}