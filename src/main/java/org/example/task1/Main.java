package org.example.task1;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 10, 0, 2);

        // Среднее значение всех четных чисел

        OptionalDouble result = numbers.stream().filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .average();
        if (result.isPresent())
        {
            System.out.print(result.getAsDouble());
        }
    }
}
