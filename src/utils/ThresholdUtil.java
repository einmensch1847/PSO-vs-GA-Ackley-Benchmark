package utils;

public class ThresholdUtil {

    public static double getThreshold(int dimensions) {
        if (dimensions <= 5) {
            return 0.001;
        } else if (dimensions <= 50) {
            return 0.01;
        } else {
            return 0.1;
        }
    }
}