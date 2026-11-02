package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataSampleTest {

    @Test
    void createsValidSample() {
        DataSample sample = new DataSample("s1", "cat", SampleStatus.NEW, new double[]{1.0, 2.0, 3.0});

        assertEquals("s1", sample.getId());
        assertEquals("cat", sample.getLabel());
        assertEquals(SampleStatus.NEW, sample.getStatus());
        assertFalse(sample.isReady());
    }

    @Test
    void copiesFeaturesInConstructor() {
        double[] features = {1.0, 2.0, 3.0};
        DataSample sample = new DataSample("s1", "cat", SampleStatus.NEW, features);

        features[0] = 99.0;

        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, sample.getFeatures(), 0.0001);
    }

    @Test
    void returnsCopyFromAccessor() {
        DataSample sample = new DataSample("s1", "cat", SampleStatus.NEW, new double[]{1.0, 2.0});

        double[] returned = sample.getFeatures();
        returned[0] = 99.0;

        assertArrayEquals(new double[]{1.0, 2.0}, sample.getFeatures(), 0.0001);
    }

    @Test
    void computesAverage() {
        DataSample sample = new DataSample("s1", "cat", SampleStatus.NEW, new double[]{1.0, 2.0, 3.0});

        assertEquals(2.0, sample.averageFeatures(), 0.0001);
    }

    @Test
    void changesStatusAndReady() {
        DataSample sample = new DataSample("s1", "cat", SampleStatus.NEW, new double[]{1.0});

        sample.changeStatus(SampleStatus.READY);

        assertEquals(SampleStatus.READY, sample.getStatus());
        assertTrue(sample.isReady());
    }

    @Test
    void rejectsBlankId() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(" ", "cat", SampleStatus.NEW, new double[]{1.0}));
    }

    @Test
    void rejectsBlankLabel() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample("s1", "", SampleStatus.NEW, new double[]{1.0}));
    }

    @Test
    void rejectsNullStatus() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample("s1", "cat", null, new double[]{1.0}));
    }

    @Test
    void rejectsNullOrEmptyFeatures() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample("s1", "cat", SampleStatus.NEW, null));

        assertThrows(IllegalArgumentException.class,
                () -> new DataSample("s1", "cat", SampleStatus.NEW, new double[]{}));
    }

    @Test
    void rejectsNonFiniteFeature() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample("s1", "cat", SampleStatus.NEW, new double[]{Double.NaN}));

        assertThrows(IllegalArgumentException.class,
                () -> new DataSample("s1", "cat", SampleStatus.NEW, new double[]{Double.POSITIVE_INFINITY}));
    }

    @Test
    void normalizedFeaturesDoesNotChangeOriginal() {
        DataSample sample = new DataSample("s1", "cat", SampleStatus.NEW, new double[]{0.0, 5.0, 10.0});

        double[] normalized = sample.normalizedFeatures();

        assertArrayEquals(new double[]{0.0, 0.5, 1.0}, normalized, 0.0001);
        assertArrayEquals(new double[]{0.0, 5.0, 10.0}, sample.getFeatures(), 0.0001);
    }
}