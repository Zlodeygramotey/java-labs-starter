package edu.course.lab03;

public final class PercentDiscount implements DiscountPolicy {
    private final double percent;

    public PercentDiscount(double percent) {
        if (!Double.isFinite(percent) || percent < 0 || percent > 100) {
            throw new IllegalArgumentException("percent must be in [0, 100]");
        }
        this.percent = percent;
    }

    @Override
    public double apply(double price) {
        if (price < 0) throw new IllegalArgumentException("price must be >= 0");
        return price * (1.0 - percent / 100.0);
    }
}