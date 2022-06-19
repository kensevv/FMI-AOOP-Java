package p5;

public class MaxElement {
    public static void main(String[] args) {
        Integer[][] array= new Integer[][]{
                {1,-2,4,6},
                {12,3,4,5}
        };
        System.out.println("Max"+max(array));
    }

    public static <E extends Comparable<E>> E max(E[][] list){
        if (list==null) return null;
        E max = list[0][0];
        for (int i =0; i<list.length; i++){
            for (int j =0; j<list[i].length; j++){
                if (list[i][j].compareTo(max)>0){
                    max=list[i][j];
                }
            }
        }

        return max;
    }
}
