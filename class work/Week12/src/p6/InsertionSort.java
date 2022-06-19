package p6;

import java.util.ArrayList;
import java.util.Random;

public class InsertionSort {
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        for (int i = 1; i < list.size(); i++) {
            E currentElement = list.get(i);
            int j;
            for (j = i - 1; j >= 0
                    && list.get(j).compareTo(currentElement) > 0; j--) {
                list.set(j + 1, list.get(j));

            }
            list.set(j + 1, currentElement);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            list.add(random.nextInt(101));
        }
        System.out.println("Unsorted: "+ list);
        sort(list);
        System.out.println("Sorted: "+ list);

        ArrayList<Double> list2 = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list2.add(random.nextInt(101)/10.);
        }
        System.out.println("Unsorted: "+ list2);
        sort(list);
        System.out.println("Sorted: "+ list2);
    }
}
