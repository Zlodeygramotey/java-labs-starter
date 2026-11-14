package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PercentDiscountTest {
    @Test
    void appliesTwentyPercent() {
        assertEquals(80.0, new PercentDiscount(20).apply(100.0), 1e-9);
    }
    @Test
    void rejectsInvalidPercent() {
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(101));
    }
}