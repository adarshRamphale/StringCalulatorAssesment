package com.stringCalculatorAssesment;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorAssesment {

    private static final String DEFAULT_DELIMITER = ",|\n";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(\\[.*?])+\\n");
    private int callCount = 0;

    public int add(String numbers) {
        callCount++;
        if(numbers.isEmpty()){
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;
        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile(String.valueOf(CUSTOM_DELIMITER_PATTERN)).matcher(numbers);
            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                delimiter = Pattern.quote(customDelimiter);
                numbers = numbers.substring(matcher.end());
            }
        }

        int sum = 0;
        String[] numArray = numbers.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        for (String num : numArray) {
            if (!num.isEmpty()) {
                int number = Integer.parseInt(num);
                if(number < 0){
                    negatives.add(number);
                }
                else if (number <= 1000) {
                    sum += number;
                }
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }

        return sum;
    }

    public int getCalledCount() {
        return callCount;
    }
}
