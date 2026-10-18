package algorithms;

import java.util.Arrays;

public class Individual {
    private double[] genes;
    private double fitness;
    private final int dimensions;

    public Individual(int dimensions) {
        this.dimensions = dimensions;
        this.genes = new double[dimensions];
        this.fitness = Double.MAX_VALUE;
    }

    public Individual(double[] genes) {
        this.dimensions = genes.length;
        this.genes = genes;
        this.fitness = Double.MAX_VALUE;
    }

    public double[] getGenes() { return genes; }
    public double getFitness() { return fitness; }
    public void setFitness(double fitness) { this.fitness = fitness; }
    public int getDimensions() { return dimensions; }

    public Individual copy() {
        Individual clone = new Individual(genes.clone());
        clone.fitness = this.fitness;
        return clone;
    }

    @Override
    public String toString() {
        return "Individual{fitness=" + fitness + ", genes=" + Arrays.toString(genes) + "}";
    }
}