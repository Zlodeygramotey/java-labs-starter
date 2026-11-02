package edu.course.lab02;

public class DataSample {
    private final String id;
    private final String label;
    private SampleStatus status;
    private final double[] features;

    public DataSample(String id, String label, SampleStatus status, double[] features) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id не может быть пустым");
        }
        if (label == null || label.isBlank()) {
            throw new IllegalArgumentException("label не может быть пустым");
        }
        if (status == null) {
            throw new IllegalArgumentException("status не может быть null");
        }
        if (features == null || features.length == 0) {
            throw new IllegalArgumentException("features не может быть null или пустым");
        }

        for (double feature : features) {
            if (!Double.isFinite(feature)) {
                throw new IllegalArgumentException("Признаки должны быть конечными числами");
            }
        }

        this.id = id;
        this.label = label;
        this.status = status;
        this.features = features.clone();
    }

    public void changeStatus(SampleStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Новый статус не может быть null");
        }
        this.status = newStatus;
    }

    public boolean isReady() {
        return status == SampleStatus.READY;
    }

    public double averageFeatures() {
        double sum = 0.0;
        for (double feature : features) {
            sum += feature;
        }
        return sum / features.length;
    }

    public double[] getFeatures() {
        return features.clone();
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public SampleStatus getStatus() {
        return status;
    }

    public double[] normalizedFeatures() {
        double min = features[0];
        double max = features[0];

        for (double feature : features) {
            if (feature < min) {
                min = feature;
            }
            if (feature > max) {
                max = feature;
            }
        }

        double[] result = new double[features.length];

        if (min == max) {
            return features.clone();
        }

        for (int i = 0; i < features.length; i++) {
            result[i] = (features[i] - min) / (max - min);
        }

        return result;
    }
}