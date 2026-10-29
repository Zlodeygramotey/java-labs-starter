package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceCalculatorTest {
    @Test
    void policyCanBeReplacedWithoutChangingCalculator() {
        PriceCalculator calculator = new PriceCalculator(new NoDiscount());
        assertEquals(100.0, calculator.calculate(100.0), 1e-9);

        calculator = new PriceCalculator(new PercentDiscount(20));
        assertEquals(80.0, calculator.calculate(100.0), 1e-9);
    }
}