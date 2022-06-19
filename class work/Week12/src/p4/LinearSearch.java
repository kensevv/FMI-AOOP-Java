package p4;

public class LinearSearch {
    public static void main(String[] args) {
        Integer[]array= new Integer[]{1,2,3,5};
        System.out.println("Index of key 3 in array is: "+
                linearSearch(array,3));

        Double[]array2= new Double[]{1.,2.,3.,5.};
        System.out.println("Index of key 3.2 in array is: "+
                linearSearch(array2,3.2));
    }
    public static <E extends Comparable<E>> int linearSearch(E[] list,E key){
        if (list==null|| list.length==0) return -1;
        for (int i=0; i<list.length; i++){
            if (list[i].equals(key))return i;
        }
        return -1;
    }
}
