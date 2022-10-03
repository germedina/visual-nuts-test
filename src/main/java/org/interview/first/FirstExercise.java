package org.interview.first;

import java.util.Arrays;

public class FirstExercise {

    final String DIVISIBLE_BY_3 = "Visual";
    final String DIVISIBLE_BY_5 = "Nuts";
    int numbers = 100;

    public FirstExercise() {
    }

    public FirstExercise(int numbers) {
        this.numbers = numbers;
    }

    public String[] getValues() {
        String[] values = new String[numbers];
        for (int i = 1; i <= numbers; i++) {
            String value = "";
            if (i % 3 == 0) {
                value = DIVISIBLE_BY_3;
            }
            if (i % 5 == 0) {
                value += DIVISIBLE_BY_5;
            }
            values[i - 1] = value.length() > 0 ? value : String.valueOf(i);
        }
        return values;
    }

    public void printValues() {
        Arrays.stream(getValues()).forEach(System.out::println);
    }

}
