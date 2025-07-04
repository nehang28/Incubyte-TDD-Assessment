package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    public void test() {
        Assertions.assertEquals(0, StringCalculator.add(""));
    }
}
