package p1;

public class GenericStack<E> {

    //private java.util.ArrayList<E> list = new java.util.ArrayList<>();
    private E[] elements;
    private int size;

    public GenericStack() {
        this(16);
    }

    public GenericStack(int initialCapacity) {
        if(initialCapacity>0){
        elements= (E[])new Object[initialCapacity];
        }else {
            elements=(E[])new Object[16];
        }
    }


    public int getSize() {
        return size;
    }

    public E peek() {
        return elements[size-1];
    }

    public void push(E o) {
        if (size>= elements.length){
            E[] newArray= (E[])new Object[2*elements.length];
            System.arraycopy(elements,0, newArray,0,elements.length);
            elements = newArray;
        }
        elements[size++]= o;
    }

    public E pop() {
        return elements[--size];
    }

    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public String toString() {
        String result ="stack: ";
        if (isEmpty()){
            result +="is empty";
        }else{
            for (E e:elements){
                result += e + "; ";
            }
        }
        return result;
    }
}