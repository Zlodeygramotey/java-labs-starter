package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NoDiscountTest {
    @Test
    void returnsSamePrice() {
        assertEquals(100.0, new NoDiscount().apply(100.0), 1e-9);
    }
    @Test
    void rejectsNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> new NoDiscount().apply(-1.0));
    }
}