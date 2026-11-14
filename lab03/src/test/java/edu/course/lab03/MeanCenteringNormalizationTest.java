package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MeanCenteringNormalizationTest {
    @Test
    void centersAroundMeanAndDoesNotChangeInput() {
        double[] input = {1.0, 2.0, 3.0};
        double[] result = new MeanCenteringNormalization().normalize(input);
        assertArrayEquals(new double[]{-1.0, 0.0, 1.0}, result, 1e-9);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, input, 1e-9);
    }
    @Test
    void singleElementBecomesZero() {
        assertArrayEquals(new double[]{0.0}, new MeanCenteringNormalization().normalize(new double[]{42.0}), 1e-9);
    }
}