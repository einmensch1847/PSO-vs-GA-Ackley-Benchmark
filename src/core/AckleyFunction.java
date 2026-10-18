package core;

public class AckleyFunction implements ObjectiveFunction {

    @Override
    public double evaluate(double[] x) {
        int n = x.length;
        double sumSq = 0.0;
        double sumCos = 0.0;

        for (double xi : x) {
            sumSq += xi * xi;
            sumCos += Math.cos(2.0 * Math.PI * xi);
        }

        double term1 = -20.0 * Math.exp(-0.2 * Math.sqrt(sumSq / n));
        double term2 = -Math.exp(sumCos / n);

        return term1 + term2 + 20.0 + Math.E;
    }
}