package problem4;

import java.util.Enumeration;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Roll {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.printf("%-6s%-10s\n", "Face", "Frequency");
        IntStream.rangeClosed(0, 6_000_000)
                .mapToObj(number -> 1 + random.nextInt(6))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .forEach((face, frequency) ->
                        System.out.printf("%-6d%-10d\n", face, frequency));
    }
}
