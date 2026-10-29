package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MinMaxNormalizationTest {
    @Test
    void normalizesToZeroOneAndDoesNotChangeInput() {
        double[] input = {10.0, 20.0, 30.0};
        double[] result = new MinMaxNormalization().normalize(input);
        assertArrayEquals(new double[]{0.0, 0.5, 1.0}, result, 1e-9);
        assertArrayEquals(new double[]{10.0, 20.0, 30.0}, input, 1e-9);
    }
    @Test
    void constantVectorBecomesZeros() {
        assertArrayEquals(new double[]{0.0, 0.0}, new MinMaxNormalization().normalize(new double[]{5.0, 5.0}), 1e-9);
    }
}