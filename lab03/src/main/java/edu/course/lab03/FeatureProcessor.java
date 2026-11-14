package edu.course.lab03;

import java.util.Objects;

public final class FeatureProcessor {
    private final NormalizationStrategy strategy;

    public FeatureProcessor(NormalizationStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy);
    }

    public double[] process(double[] values) {
        return strategy.normalize(values);
    }
}