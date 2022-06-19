package p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<>(Arrays.asList("Лили", "Мария", "Георги", "Илия", "Цвета", "Георги"));
        ArrayList<String> bList = new ArrayList<>(Arrays.asList("Лили, Георги".split(",")));

        Iterator<String> aIterator = aList.iterator();
        Iterator<String> bIterator;

        String aText;
        StringBuilder common = new StringBuilder();
        while(aIterator.hasNext()){
            bIterator = bList.iterator();
            aText = aIterator.next();
            while(bIterator.hasNext()){
                if(aText.equals(bIterator.next())){
                    common.append(aText).append(", ");
                }
            }
        }
        //String result = common.substring(0, common.length() - 2);
        if(common.length() != 0){
            common.deleteCharAt(common.length() - 1);
            common.deleteCharAt(common.length() - 1);
        }
        System.out.printf("Common elements: %s\n",
                common.length() == 0 ? "none" : common.toString());

        ArrayList<String> list = new ArrayList<>(Arrays.asList("Лили", "Мария", "Георги", "Илия", "Цвета", "Георги"));
        ListIterator<String> nameIterator = list.listIterator();
        System.out.println(list);
        while(nameIterator.hasNext()){
            if(nameIterator.next().equals("Георги")){
                list.add(nameIterator.nextIndex(), "Симеон");
                break;
            }
        }
        System.out.println(list);
    }
}
