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

    @Test
    void customDelimiterInNumbersStringReturnsSumOfThoseNumbers() {
        Assertions.assertEquals(3, StringCalculator.add("//;\n1;2"));
        Assertions.assertEquals(6, StringCalculator.add("///\n1/2\n3"));
        Assertions.assertEquals(13, StringCalculator.add("//:\n1:2\n3:7"));
        Assertions.assertEquals(16, StringCalculator.add("// \n1 12 3"));
        Assertions.assertEquals(8, StringCalculator.add("//.\n1.2\n3.2"));
    }

    @Test
    void negativeNumberInNumbersStringThrowsException() {
        NumberFormatException ex1 = Assertions.assertThrows(NumberFormatException.class, () -> {
            StringCalculator.add("2\n-1");
        });
        Assertions.assertEquals("negative number not allowed <-1>", ex1.getMessage());

        NumberFormatException ex2 = Assertions.assertThrows(NumberFormatException.class, () -> {
            StringCalculator.add("-3,4,5");
        });
        Assertions.assertEquals("negative number not allowed <-3>", ex2.getMessage());

        NumberFormatException ex3 = Assertions.assertThrows(NumberFormatException.class, () -> {
            StringCalculator.add("\n16,4,-5");
        });
        Assertions.assertEquals("negative number not allowed <-5>", ex3.getMessage());
    }

}
