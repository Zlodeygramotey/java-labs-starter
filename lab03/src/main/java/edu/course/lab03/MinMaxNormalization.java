package edu.course.lab03;

public final class MinMaxNormalization implements NormalizationStrategy {
    @Override
    public double[] normalize(double[] values) {
        if (values == null) throw new IllegalArgumentException("values must not be null");
        double[] result = new double[values.length];
        if (values.length == 0) return result;
        double min = values[0], max = values[0];
        for (double value : values) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        if (max == min) return result;
        for (int i = 0; i < values.length; i++) {
            result[i] = (values[i] - min) / (max - min);
        }
        return result;
    }
}