package experiment;

import java.util.List;

/**
 * برنامه‌ی اصلی — اجرای آزمایش و چاپ جدول‌ها
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("  PSO vs GA on Ackley Function");
        System.out.println("  Dimensions: 1, 2, 3, 5, 10, 20, 30, 40, 50, 100");
        System.out.println("  Runs per dimension: 10");
        System.out.println("==============================================");

        long totalStart = System.nanoTime();
        List<DimensionResult> results = Experiment.runAll();
        long totalEnd = System.nanoTime();
        double totalSeconds = (totalEnd - totalStart) / 1_000_000_000.0;

        printTables(results);

        System.out.printf("%n Total experiment time: %.2f seconds%n", totalSeconds);
    }

    private static void printTables(List<DimensionResult> results) {
        // جدول ۱: Success Rate
        System.out.println("\n\n========== TABLE 1: SUCCESS RATE (%) ==========");
        System.out.printf("%-6s %-10s %-12s %-12s%n", "Dim", "Threshold", "PSO (%)", "GA (%)");
        System.out.println("--------------------------------------------------");
        for (int dim : Experiment.DIMENSIONS) {
            DimensionResult pso = find(results, "PSO", dim);
            DimensionResult ga  = find(results, "GA", dim);
            System.out.printf("%-6d %-10.4f %-12.1f %-12.1f%n",
                    dim, pso.threshold, pso.successRate, ga.successRate);
        }

        // جدول ۲: RMSE
        System.out.println("\n\n========== TABLE 2: RMSE ==========");
        System.out.printf("%-6s %-12s %-15s %-15s%n", "Dim", "Threshold", "PSO RMSE", "GA RMSE");
        System.out.println("------------------------------------------------------");
        for (int dim : Experiment.DIMENSIONS) {
            DimensionResult pso = find(results, "PSO", dim);
            DimensionResult ga  = find(results, "GA", dim);
            System.out.printf("%-6d %-12.4f %-15.6e %-15.6e%n",
                    dim, pso.threshold, pso.rmse, ga.rmse);
        }

        // جدول ۳: زمان
        System.out.println("\n\n========== TABLE 3: AVG TIME (ms) ==========");
        System.out.printf("%-6s %-15s %-15s%n", "Dim", "PSO Time (ms)", "GA Time (ms)");
        System.out.println("--------------------------------------");
        for (int dim : Experiment.DIMENSIONS) {
            DimensionResult pso = find(results, "PSO", dim);
            DimensionResult ga  = find(results, "GA", dim);
            System.out.printf("%-6d %-15.2f %-15.2f%n",
                    dim, pso.avgTimeMillis, ga.avgTimeMillis);
        }

        // جدول ۴: برنده در هر بعد
        System.out.println("\n\n========== TABLE 4: WINNER PER DIMENSION ==========");
        System.out.printf("%-6s %-15s %-15s %-15s%n",
                "Dim", "Success", "RMSE", "Time");
        System.out.println("------------------------------------------------------");
        for (int dim : Experiment.DIMENSIONS) {
            DimensionResult pso = find(results, "PSO", dim);
            DimensionResult ga  = find(results, "GA", dim);
            String winnerSuccess = winnerSuccess(pso, ga);
            String winnerRmse    = winnerRmse(pso, ga);
            String winnerTime    = winnerTime(pso, ga);
            System.out.printf("%-6d %-15s %-15s %-15s%n",
                    dim, winnerSuccess, winnerRmse, winnerTime);
        }
    }

    private static DimensionResult find(List<DimensionResult> list, String algo, int dim) {
        return list.stream()
                .filter(r -> r.algorithmName.equals(algo) && r.dimension == dim)
                .findFirst()
                .orElseThrow();
    }

    private static String winnerSuccess(DimensionResult a, DimensionResult b) {
        if (a.successRate > b.successRate) return a.algorithmName;
        if (b.successRate > a.successRate) return b.algorithmName;
        return "Tie";
    }

    private static String winnerRmse(DimensionResult a, DimensionResult b) {
        if (a.rmse < b.rmse) return a.algorithmName;
        if (b.rmse < a.rmse) return b.algorithmName;
        return "Tie";
    }

    private static String winnerTime(DimensionResult a, DimensionResult b) {
        if (a.avgTimeMillis < b.avgTimeMillis) return a.algorithmName;
        if (b.avgTimeMillis < a.avgTimeMillis) return b.algorithmName;
        return "Tie";
    }
}