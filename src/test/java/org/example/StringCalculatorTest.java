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

    @Test
    void twoNumbersStringReturnsSumOfTwoNumbers() {
        Assertions.assertEquals(6, StringCalculator.add("1,5"));
        Assertions.assertEquals(44, StringCalculator.add("22,22"));
    }

    @Test
    void stringOfAnyNumbersReturnsSumOfThoseNumbers() {
        Assertions.assertEquals(22, StringCalculator.add("5,2,8,7"));
        Assertions.assertEquals(77, StringCalculator.add("11,22,33,11"));
        Assertions.assertEquals(18, StringCalculator.add("10,5,3"));
    }

    @Test
    void handleNewLineInNumbersStringReturnsSumOfThoseNumbers() {
        Assertions.assertEquals(6, StringCalculator.add("1\n2,3"));
        Assertions.assertEquals(44, StringCalculator.add("\n33,11"));
        Assertions.assertEquals(32, StringCalculator.add("22,10\n"));
    }

}
