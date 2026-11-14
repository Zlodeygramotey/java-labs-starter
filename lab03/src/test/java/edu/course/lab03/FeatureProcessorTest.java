package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FeatureProcessorTest {
    @Test
    void strategyCanBeReplacedWithoutChangingProcessor() {
        double[] input = {1.0, 2.0, 3.0};

        FeatureProcessor processor = new FeatureProcessor(new MinMaxNormalization());
        assertArrayEquals(new double[]{0.0, 0.5, 1.0}, processor.process(input), 1e-9);

        processor = new FeatureProcessor(new MeanCenteringNormalization());
        assertArrayEquals(new double[]{-1.0, 0.0, 1.0}, processor.process(input), 1e-9);
    }
}