package edu.course.lab03;

public final class MeanCenteringNormalization implements NormalizationStrategy {
    @Override
    public double[] normalize(double[] values) {
        if (values == null) throw new IllegalArgumentException("values must not be null");
        double[] result = new double[values.length];
        if (values.length == 0) return result;
        double sum = 0.0;
        for (double value : values) sum += value;
        double mean = sum / values.length;
        for (int i = 0; i < values.length; i++) result[i] = values[i] - mean;
        return result;
    }
}