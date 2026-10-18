package experiment;

import algorithms.GeneticAlgorithm;
import algorithms.PSO;
import core.AckleyFunction;
import core.ObjectiveFunction;
import utils.ThresholdUtil;

import java.util.ArrayList;
import java.util.List;

public class Experiment {

    public static final int[] DIMENSIONS = {1, 2, 3, 5, 10, 20, 30, 40, 50, 100};

    public static final int RUNS_PER_DIMENSION = 10;

    private static int getMaxIterations(int dimensions) {
        if (dimensions <= 5) return 1000;
        if (dimensions <= 20) return 1500;
        if (dimensions <= 50) return 2000;
        return 3000;
    }

    private static int getSwarmSize(int dimensions) {
        return 30 + dimensions;
    }

    private static int getPopulationSize(int dimensions) {
        return 30 + dimensions;
    }

    public static List<DimensionResult> runAll() {
        List<DimensionResult> allResults = new ArrayList<>();
        ObjectiveFunction ackley = new AckleyFunction();

        final double Y_STAR = 0.0;

        for (int dim : DIMENSIONS) {
            double threshold = ThresholdUtil.getThreshold(dim);

            double[] minBounds = new double[dim];
            double[] maxBounds = new double[dim];
            for (int i = 0; i < dim; i++) {
                minBounds[i] = -32.768;
                maxBounds[i] = 32.768;
            }

            int maxIter = getMaxIterations(dim);
            int swarmSize = getSwarmSize(dim);
            int popSize = getPopulationSize(dim);

            System.out.println("\n========== Dimension = " + dim
                    + " | Threshold = " + threshold
                    + " | Iterations = " + maxIter + " ==========");

            List<RunResult> psoRuns = new ArrayList<>();
            System.out.println(">>> Running PSO ...");
            for (int r = 0; r < RUNS_PER_DIMENSION; r++) {
                long start = System.nanoTime();
                PSO pso = new PSO(swarmSize, dim, maxIter, minBounds, maxBounds, ackley);
                pso.run();
                long end = System.nanoTime();

                double bestY = pso.getGlobalBestFitness();
                double error = Math.abs(bestY - Y_STAR);
                double timeMs = (end - start) / 1_000_000.0;
                boolean success = error <= threshold;

                psoRuns.add(new RunResult(bestY, error, timeMs, success));
                System.out.printf("  PSO run %2d: Y=%.6e  err=%.6e  time=%.1fms  %s%n",
                        r + 1, bestY, error, timeMs, success ? "OK" : "FAIL");
            }
            DimensionResult psoResult = summarize("PSO", dim, threshold, psoRuns, Y_STAR);
            allResults.add(psoResult);

            List<RunResult> gaRuns = new ArrayList<>();
            System.out.println(">>> Running GA ...");
            for (int r = 0; r < RUNS_PER_DIMENSION; r++) {
                long start = System.nanoTime();
                GeneticAlgorithm ga = new GeneticAlgorithm(popSize, dim, maxIter,
                        minBounds, maxBounds, ackley);
                ga.run();
                long end = System.nanoTime();

                double bestY = ga.getBestFitness();
                double error = Math.abs(bestY - Y_STAR);
                double timeMs = (end - start) / 1_000_000.0;
                boolean success = error <= threshold;

                gaRuns.add(new RunResult(bestY, error, timeMs, success));
                System.out.printf("  GA  run %2d: Y=%.6e  err=%.6e  time=%.1fms  %s%n",
                        r + 1, bestY, error, timeMs, success ? "OK" : "FAIL");
            }
            DimensionResult gaResult = summarize("GA", dim, threshold, gaRuns, Y_STAR);
            allResults.add(gaResult);

            System.out.printf("  --> PSO: success=%.1f%%, rmse=%.6e, time=%.1fms%n",
                    psoResult.successRate, psoResult.rmse, psoResult.avgTimeMillis);
            System.out.printf("  --> GA : success=%.1f%%, rmse=%.6e, time=%.1fms%n",
                    gaResult.successRate, gaResult.rmse, gaResult.avgTimeMillis);
        }

        return allResults;
    }

    private static DimensionResult summarize(String name, int dim, double threshold,
                                             List<RunResult> runs, double yStar) {
        int successCount = 0;
        double sumSquaredError = 0.0;
        double sumTime = 0.0;

        for (RunResult r : runs) {
            if (r.success) successCount++;
            sumSquaredError += (r.bestFitness - yStar) * (r.bestFitness - yStar);
            sumTime += r.timeMillis;
        }

        double successRate = (successCount * 100.0) / runs.size();
        double rmse = Math.sqrt(sumSquaredError / runs.size());
        double avgTime = sumTime / runs.size();

        return new DimensionResult(name, dim, threshold, successRate, rmse, avgTime, runs);
    }
}