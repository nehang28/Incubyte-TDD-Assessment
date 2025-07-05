package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String input) {
        if(input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,\n]";

        if(input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterEndIndex) + "|\n";
//            delimiter = Pattern.quote(input.substring(2, delimiterEndIndex));
            if(delimiter.startsWith("[") && delimiter.endsWith("]")) {
                delimiter = delimiter.substring(1, delimiter.length() - 1);
            }
            delimiter += "|\n";
            input = input.substring(delimiterEndIndex + 1);
        }

        String[] numbers = input.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;
        for(String number : numbers) {
            if(!number.trim().isEmpty()) {
                int numberInt = Integer.parseInt(number.trim());
                if(numberInt < 0) {
                    negativeNumbers.add(numberInt);
                }
                if(numberInt <= 1000) {
                    sum += numberInt;
                }
            }
        }
        if(!negativeNumbers.isEmpty()) {
            throw new NumberFormatException("negative number not allowed " + negativeNumbers);
        }
        return sum;
    }
}
