package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    public void emptyStringReturnsZero() {
        Assertions.assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void singleNumberStringReturnsThatNumber() {
        Assertions.assertEquals(8, StringCalculator.add("8"));
        Assertions.assertEquals(15, StringCalculator.add("15"));
    }

    @Test void twoNumbersStringReturnsSumOfTwoNumbers() {
        Assertions.assertEquals(7, StringCalculator.add("5,2"));
        Assertions.assertEquals(44, StringCalculator.add("22,22"));
    }
}
