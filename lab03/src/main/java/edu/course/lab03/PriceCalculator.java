package edu.course.lab03;

import java.util.Objects;

public final class PriceCalculator {
    private final DiscountPolicy policy;

    public PriceCalculator(DiscountPolicy policy) {
        this.policy = Objects.requireNonNull(policy);
    }

    public double calculate(double price) {
        return policy.apply(price);
    }
}