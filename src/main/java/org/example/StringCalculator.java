package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int add(String input) {
        if(input.isEmpty()) {
            return 0;
        }

        List<String> delimiter = new ArrayList<>();
        delimiter.add(",");
        delimiter.add("\n");

        if(input.startsWith("//")) {
            delimiter.clear();

            int delimiterEndIndex = input.indexOf("\n");
            String delimiterPart = input.substring(2, delimiterEndIndex);

            if (delimiterPart.startsWith("[") && delimiterPart.contains("]")) {
                Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterPart);
                while(matcher.find()) {
                    delimiter.add(Pattern.quote(matcher.group(1)));
                }
            } else {
                delimiter.add(delimiterPart);
            }

            delimiter.add("\n");
            input = input.substring(delimiterEndIndex + 1);
        }

        String customDelimiter = (String.join("|", delimiter));

        String[] numbers = input.split(customDelimiter);
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
