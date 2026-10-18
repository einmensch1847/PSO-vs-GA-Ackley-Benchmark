package algorithms;

import core.ObjectiveFunction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class GeneticAlgorithm {

    private final int populationSize;
    private final int dimensions;
    private final int maxGenerations;
    private final double[] minBounds;
    private final double[] maxBounds;
    private final ObjectiveFunction objective;

    private double crossoverRate = 0.9;
    private double mutationRate = 0.1;
    private double mutationStd = 0.2;
    private int tournamentSize = 3;
    private int elitismCount = 2;

    private final Random random = new Random();
    private Individual[] population;
    private Individual bestIndividual;

    public GeneticAlgorithm(int populationSize, int dimensions, int maxGenerations,
                            double[] minBounds, double[] maxBounds,
                            ObjectiveFunction objective) {
        this.populationSize = populationSize;
        this.dimensions = dimensions;
        this.maxGenerations = maxGenerations;
        this.minBounds = minBounds;
        this.maxBounds = maxBounds;
        this.objective = objective;
    }

    public void run() {
        initializePopulation();

        for (int gen = 0; gen < maxGenerations; gen++) {
            for (Individual ind : population) {
                if (ind.getFitness() == Double.MAX_VALUE) {
                    ind.setFitness(objective.evaluate(ind.getGenes()));
                }
            }

            Arrays.sort(population, Comparator.comparingDouble(Individual::getFitness));

            if (bestIndividual == null || population[0].getFitness() < bestIndividual.getFitness()) {
                bestIndividual = population[0].copy();
            }

            Individual[] newPopulation = new Individual[populationSize];

            for (int i = 0; i < elitismCount && i < populationSize; i++) {
                newPopulation[i] = population[i].copy();
            }

            int idx = elitismCount;
            while (idx < populationSize) {
                Individual parent1 = tournamentSelection();
                Individual parent2 = tournamentSelection();

                Individual[] children = crossover(parent1, parent2);
                mutate(children[0]);
                mutate(children[1]);

                children[0].setFitness(objective.evaluate(children[0].getGenes()));
                children[1].setFitness(objective.evaluate(children[1].getGenes()));

                newPopulation[idx++] = children[0];
                if (idx < populationSize) {
                    newPopulation[idx++] = children[1];
                }
            }

            population = newPopulation;
        }

        for (Individual ind : population) {
            double fit = objective.evaluate(ind.getGenes());
            if (fit < bestIndividual.getFitness()) {
                bestIndividual = ind.copy();
                bestIndividual.setFitness(fit);
            }
        }
    }

    private void initializePopulation() {
        population = new Individual[populationSize];
        for (int i = 0; i < populationSize; i++) {
            double[] genes = new double[dimensions];
            for (int d = 0; d < dimensions; d++) {
                genes[d] = minBounds[d] + random.nextDouble() * (maxBounds[d] - minBounds[d]);
            }
            Individual ind = new Individual(genes);
            ind.setFitness(objective.evaluate(genes));
            population[i] = ind;
        }
    }

    private Individual tournamentSelection() {
        Individual best = null;
        for (int i = 0; i < tournamentSize; i++) {
            Individual candidate = population[random.nextInt(populationSize)];
            if (best == null || candidate.getFitness() < best.getFitness()) {
                best = candidate;
            }
        }
        return best;
    }

    private Individual[] crossover(Individual p1, Individual p2) {
        double[] child1 = new double[dimensions];
        double[] child2 = new double[dimensions];

        if (random.nextDouble() < crossoverRate) {
            for (int d = 0; d < dimensions; d++) {
                double alpha = random.nextDouble();
                double min = Math.min(p1.getGenes()[d], p2.getGenes()[d]);
                double max = Math.max(p1.getGenes()[d], p2.getGenes()[d]);
                double diff = max - min;

                double c1 = min - alpha * diff;
                double c2 = max + alpha * diff;

                child1[d] = Math.max(minBounds[d], Math.min(maxBounds[d], c1));
                child2[d] = Math.max(minBounds[d], Math.min(maxBounds[d], c2));
            }
        } else {
            child1 = p1.getGenes().clone();
            child2 = p2.getGenes().clone();
        }

        return new Individual[]{new Individual(child1), new Individual(child2)};
    }

    private void mutate(Individual ind) {
        double[] genes = ind.getGenes();
        for (int d = 0; d < dimensions; d++) {
            if (random.nextDouble() < mutationRate) {
                double range = maxBounds[d] - minBounds[d];
                double delta = random.nextGaussian() * mutationStd * range;
                genes[d] += delta;
                if (genes[d] < minBounds[d]) genes[d] = minBounds[d];
                if (genes[d] > maxBounds[d]) genes[d] = maxBounds[d];
            }
        }
    }

    public Individual getBestIndividual() { return bestIndividual; }
    public double getBestFitness() {
        return bestIndividual != null ? bestIndividual.getFitness() : Double.MAX_VALUE;
    }
}