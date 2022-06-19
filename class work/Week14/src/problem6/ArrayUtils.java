package problem6;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;

public class ArrayUtils {
    static void filterNumbers(Predicate<Integer> condition, int[] array)
    {
        if(array == null || array.length == 0 || condition == null) return;

        for (int i = 0; i < array.length; i++) {
            if(condition.test(array[i])){
                System.out.print(array[i] + " ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[20];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 10 + rand.nextInt( 41);
        }

        System.out.println(Arrays.toString(numbers));

        //a)
        System.out.print("Even: ");
        Predicate<Integer> even = a -> a%2 == 0;
        filterNumbers(even, numbers);

        //b)
        System.out.print("Interval [30-40]: ");
        Predicate<Integer> interval = a -> a >= 30 && a <= 40;
        filterNumbers(interval, numbers);

        //c)
        System.out.print("Prime: ");
        Predicate<Integer> prime = a -> {
            if(a < 2) return false;
            for (int i = 2; i < a/2; i++) {
                if(a % i == 0) return false;
            }
            return true;
        };
        filterNumbers(prime, numbers);
    }
}
