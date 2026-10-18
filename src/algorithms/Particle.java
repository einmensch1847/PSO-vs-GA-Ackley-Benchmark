package algorithms;

import java.util.Arrays;
import java.util.Random;

public class Particle {
    private double[] position;
    private double[] velocity;
    private double[] bestPosition;
    private double bestFitness;
    private double fitness;

    private final int dimensions;
    private final double[] minBounds;
    private final double[] maxBounds;
    private static final Random random = new Random();

    public Particle(int dimensions, double[] minBounds, double[] maxBounds) {
        this.dimensions = dimensions;
        this.minBounds = minBounds;
        this.maxBounds = maxBounds;

        this.position = new double[dimensions];
        this.velocity = new double[dimensions];
        this.bestPosition = new double[dimensions];
        this.bestFitness = Double.MAX_VALUE;
        this.fitness = Double.MAX_VALUE;

        initializeRandomly();
    }

    private void initializeRandomly() {
        for (int i = 0; i < dimensions; i++) {
            position[i] = minBounds[i] + random.nextDouble() * (maxBounds[i] - minBounds[i]);
            double range = maxBounds[i] - minBounds[i];
            velocity[i] = (random.nextDouble() - 0.5) * range * 0.1;
        }
        System.arraycopy(position, 0, bestPosition, 0, dimensions);
    }

    public void updateVelocityAndPosition(double[] globalBestPosition,
                                          double inertiaWeight,
                                          double c1,
                                          double c2) {
        for (int i = 0; i < dimensions; i++) {
            double r1 = random.nextDouble();
            double r2 = random.nextDouble();

            double inertia = inertiaWeight * velocity[i];
            double cognitive = c1 * r1 * (bestPosition[i] - position[i]);
            double social = c2 * r2 * (globalBestPosition[i] - position[i]);

            velocity[i] = inertia + cognitive + social;

            double maxVelocity = (maxBounds[i] - minBounds[i]) * 0.2;
            if (velocity[i] > maxVelocity) velocity[i] = maxVelocity;
            if (velocity[i] < -maxVelocity) velocity[i] = -maxVelocity;

            position[i] += velocity[i];

            if (position[i] < minBounds[i]) {
                position[i] = minBounds[i];
                velocity[i] = 0;
            }
            if (position[i] > maxBounds[i]) {
                position[i] = maxBounds[i];
                velocity[i] = 0;
            }
        }
    }

    public void updatePersonalBest() {
        if (fitness < bestFitness) {
            bestFitness = fitness;
            System.arraycopy(position, 0, bestPosition, 0, dimensions);
        }
    }

    public double[] getPosition() { return position; }
    public double[] getBestPosition() { return bestPosition; }
    public double getBestFitness() { return bestFitness; }
    public double getFitness() { return fitness; }
    public void setFitness(double fitness) { this.fitness = fitness; }

    @Override
    public String toString() {
        return "Particle{position=" + Arrays.toString(position) +
                ", fitness=" + fitness + "}";
    }
}