package p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

public class ArrayListTest {

    /*
    a) метод, който връща най- големия елемент в двумерен масив.
public static <E extends Comparable<E>> E max(E[][]
list)
b) метод, който разбърква по произволен начин (shuffles) елементите .на
ArrayList:
public static <E> void shuffle(ArrayList<E> list)
c) метод, който връща най- големия елемент на ArrayList:
public static <E extends Comparable<E>> E
max(ArrayList<E> list)
d) метод, който връща нов ArrayList. Новият списък на съдържа само
различните елементи от подадения като параметър списък .
public static <E> ArrayList<E>
removeDuplicates(ArrayList<E> list)
     */

    public static <E extends Comparable<E>> E max(E[][] list){
        if (list == null || list.length == 0)
            return null;
        ArrayList<E> elements = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            elements.addAll(Arrays.asList(list[i]));
        }

        return Collections.max(elements);
    }

    public static <E> void shuffle(ArrayList<E> list){
        if (list == null)
            return;
        Collections.shuffle(list);
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list){
        if (list == null)
            return null;
        return Collections.max(list);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        if (list == null)
            return null;
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    public static void main(String[] args) {
        Integer[][] array = new Integer[][]{
                {1, 3, -7, 4},
                {5, 6, -1, 0},
                {15, 2, -8, 10}
        };
        int max = max(array);
        System.out.println("Max of matrix: " + max);

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            list.add("s" + (i+1));
        }

        System.out.println("List: " + list);
        shuffle(list);
        System.out.println("Shuffled list: " + list);

        System.out.println("Max of list: " + max(list));

        ArrayList<Integer> duplicatesList = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            duplicatesList.add(i % 5);
        }

        System.out.println("Duplicates list: " + duplicatesList);
        System.out.println("No duplicates list: " + removeDuplicates(duplicatesList));
    }
}