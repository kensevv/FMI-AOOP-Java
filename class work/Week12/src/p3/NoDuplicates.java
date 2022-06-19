package p3;

import java.util.ArrayList;

public class NoDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(-3);
        list.add(12);
        list.add(3);
        list.add(2);
        ArrayList<Integer> noDuplicates = removeDuplicates(list);
        System.out.println("List"+ list);
        System.out.println("No duplicates list"+ noDuplicates);

        ArrayList<Character> list2 = new ArrayList<>();
        list2.add('3');
        list2.add('2');
        list2.add('A');
        list2.add('B');
        list2.add('3');
        list2.add('2');
        ArrayList<Character> noDuplicates2 = removeDuplicates(list2);
        System.out.println("List"+ list2);
        System.out.println("No duplicates list"+ noDuplicates2);

    }
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        if (list==null) return null;
        ArrayList<E> noDuplicates = new ArrayList<>();

        for (E e: list){
            if (!noDuplicates.contains(e)){
                noDuplicates.add(e);
            }
        }
        return noDuplicates;
    }
}
