package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseToolkitTest {

    // ===== isEven =====

    @Test
    void returnsTrueForPositiveEvenNumber() {
        assertTrue(CourseToolkit.isEven(8));
    }

    @Test
    void returnsFalseForPositiveOddNumber() {
        assertFalse(CourseToolkit.isEven(7));
    }

    @Test
    void returnsTrueForNegativeEvenNumber() {
        assertTrue(CourseToolkit.isEven(-8));
    }

    // ===== isPrime =====

    @Test
    void isPrimeReturnsFalseForNumbersLessThanTwo() {
        assertFalse(CourseToolkit.isPrime(-3));
        assertFalse(CourseToolkit.isPrime(0));
        assertFalse(CourseToolkit.isPrime(1));
    }

    @Test
    void isPrimeReturnsTrueForTwoAndPrimeNumber() {
        assertTrue(CourseToolkit.isPrime(2));
        assertTrue(CourseToolkit.isPrime(13));
    }

    @Test
    void isPrimeReturnsFalseForCompositeNumbers() {
        assertFalse(CourseToolkit.isPrime(4));
        assertFalse(CourseToolkit.isPrime(9));
        assertFalse(CourseToolkit.isPrime(15));
    }

    @Test
    void isPrimeHandlesSquareOfPrime() {
        assertFalse(CourseToolkit.isPrime(49));
    }

    // ===== isPalindrome =====

    @Test
    void isPalindromeReturnsTrueForExactPalindrome() {
        assertTrue(CourseToolkit.isPalindrome("level"));
        assertTrue(CourseToolkit.isPalindrome(""));
    }

    @Test
    void isPalindromeIsCaseSensitive() {
        assertFalse(CourseToolkit.isPalindrome("Level"));
    }

    @Test
    void isPalindromeTreatsSpacesAsSignificant() {
        assertFalse(CourseToolkit.isPalindrome("lev el"));
    }

    @Test
    void isPalindromeThrowsForNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.isPalindrome(null)
        );
    }

    // ===== average =====

    @Test
    void averageReturnsFractionalResult() {
        assertEquals(2.5, CourseToolkit.average(new int[]{1, 2, 3, 4}));
    }

    @Test
    void averageHandlesNegativeValues() {
        assertEquals(-2.0, CourseToolkit.average(new int[]{-1, -2, -3}));
    }

    @Test
    void averageThrowsForNullOrEmptyArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.average(null)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.average(new int[0])
        );
    }

    @Test
    void averageDoesNotModifyInputArray() {
        int[] values = {5, 1, 4};
        int[] original = values.clone();

        CourseToolkit.average(values);

        assertArrayEquals(original, values);
    }

    // ===== min / max (дополнительная часть) =====

    @Test
    void minReturnsSmallestValue() {
        assertEquals(1, CourseToolkit.min(new int[]{5, 1, 4, 2}));
    }

    @Test
    void minWorksForNegativeValues() {
        assertEquals(-7, CourseToolkit.min(new int[]{-3, -7, -5}));
    }

    @Test
    void maxReturnsLargestValue() {
        assertEquals(9, CourseToolkit.max(new int[]{5, 9, 4, 2}));
    }

    @Test
    void maxWorksForSingleElement() {
        assertEquals(42, CourseToolkit.max(new int[]{42}));
    }

    @Test
    void minAndMaxThrowForNullOrEmpty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.min(null)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.min(new int[0])
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.max(null)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.max(new int[0])
        );
    }
}