package algorithms;

import core.ObjectiveFunction;

public class PSO {

    private final int swarmSize;
    private final int dimensions;
    private final int maxIterations;
    private final double[] minBounds;
    private final double[] maxBounds;
    private final ObjectiveFunction objective;

    private double inertiaMax = 0.9;
    private double inertiaMin = 0.4;
    private double c1 = 1.49445;
    private double c2 = 1.49445;

    private Particle[] swarm;
    private double[] globalBestPosition;
    private double globalBestFitness = Double.MAX_VALUE;

    public PSO(int swarmSize, int dimensions, int maxIterations,
               double[] minBounds, double[] maxBounds,
               ObjectiveFunction objective) {
        this.swarmSize = swarmSize;
        this.dimensions = dimensions;
        this.maxIterations = maxIterations;
        this.minBounds = minBounds;
        this.maxBounds = maxBounds;
        this.objective = objective;
    }

    public void run() {
        initializeSwarm();

        for (int iter = 0; iter < maxIterations; iter++) {
            double inertiaWeight = inertiaMax
                    - (inertiaMax - inertiaMin) * iter / maxIterations;

            for (Particle p : swarm) {
                double fit = objective.evaluate(p.getPosition());
                p.setFitness(fit);
                p.updatePersonalBest();

                if (fit < globalBestFitness) {
                    globalBestFitness = fit;
                    globalBestPosition = p.getPosition().clone();
                }
            }

            for (Particle p : swarm) {
                p.updateVelocityAndPosition(globalBestPosition, inertiaWeight, c1, c2);
            }
        }
    }

    private void initializeSwarm() {
        swarm = new Particle[swarmSize];
        for (int i = 0; i < swarmSize; i++) {
            swarm[i] = new Particle(dimensions, minBounds, maxBounds);
        }
    }

    public double[] getGlobalBestPosition() { return globalBestPosition; }
    public double getGlobalBestFitness() { return globalBestFitness; }
}