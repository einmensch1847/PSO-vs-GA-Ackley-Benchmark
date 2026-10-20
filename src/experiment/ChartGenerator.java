package experiment;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChartGenerator {

    public static void showCharts(List<DimensionResult> results) {
        createSuccessRateChart(results);
        createRmseChart(results);
        createTimeChart(results);
    }

    private static void createSuccessRateChart(List<DimensionResult> results) {
        XYSeries psoSeries = new XYSeries("PSO");
        XYSeries gaSeries  = new XYSeries("GA");

        for (int dim : Experiment.DIMENSIONS) {
            DimensionResult pso = find(results, "PSO", dim);
            DimensionResult ga  = find(results, "GA", dim);
            psoSeries.add(dim, pso.successRate);
            gaSeries.add(dim, ga.successRate);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(psoSeries);
        dataset.addSeries(gaSeries);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Success Rate vs Dimension",
                "Dimension (Log Scale)", "Success Rate (%)",
                dataset, PlotOrientation.VERTICAL, true, true, false
        );

        XYPlot plot = chart.getXYPlot();
        plot.setDomainAxis(new LogarithmicAxis("Dimension (Log Scale)"));

        showWindow(chart, "Success Rate Chart");
    }

    private static void createRmseChart(List<DimensionResult> results) {
        XYSeries psoSeries = new XYSeries("PSO");
        XYSeries gaSeries  = new XYSeries("GA");

        for (int dim : Experiment.DIMENSIONS) {
            DimensionResult pso = find(results, "PSO", dim);
            DimensionResult ga  = find(results, "GA", dim);
            psoSeries.add(dim, Math.max(pso.rmse, 1e-16));
            gaSeries.add(dim, Math.max(ga.rmse, 1e-16));
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(psoSeries);
        dataset.addSeries(gaSeries);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "RMSE vs Dimension",
                "Dimension (Log Scale)", "RMSE (Log Scale)",
                dataset, PlotOrientation.VERTICAL, true, true, false
        );

        XYPlot plot = chart.getXYPlot();
        plot.setDomainAxis(new LogarithmicAxis("Dimension (Log Scale)"));
        plot.setRangeAxis(new LogarithmicAxis("RMSE (Log Scale)"));

        showWindow(chart, "RMSE Chart");
    }

    private static void createTimeChart(List<DimensionResult> results) {
        XYSeries psoSeries = new XYSeries("PSO");
        XYSeries gaSeries  = new XYSeries("GA");

        for (int dim : Experiment.DIMENSIONS) {
            DimensionResult pso = find(results, "PSO", dim);
            DimensionResult ga  = find(results, "GA", dim);
            psoSeries.add(dim, pso.avgTimeMillis);
            gaSeries.add(dim, ga.avgTimeMillis);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(psoSeries);
        dataset.addSeries(gaSeries);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Execution Time vs Dimension",
                "Dimension (Linear Scale)", "Average Time (ms)",
                dataset, PlotOrientation.VERTICAL, true, true, false
        );

        showWindow(chart, "Time Chart");
    }

    private static void showWindow(JFreeChart chart, String title) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame(title);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(800, 500));
            frame.setContentPane(chartPanel);
            frame.pack();
            frame.setLocationRelativeTo(null); 
            frame.setVisible(true);
        });
    }

    private static DimensionResult find(List<DimensionResult> list, String algo, int dim) {
        return list.stream()
                .filter(r -> r.algorithmName.equals(algo) && r.dimension == dim)
                .findFirst()
                .orElseThrow();
    }
}