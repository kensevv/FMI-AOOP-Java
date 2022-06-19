package p2;

import p1.GenericStack;

public class GenericStackAsArrayListTest {


        public static void main(String[] args) {
            GenericStack<String> genericStack = new GenericStack<>();
            for (int i=1; i<=5; i++){
                genericStack.push("str"+i);
            }
            while (!genericStack.isEmpty()){
                System.out.println(genericStack.pop());
            }

        }
        static class GenericStack<E> extends java.util.ArrayList<E>{

            public int getSize() {
                return size();
            }

            public E peek() {
                return get(getSize() - 1);
            }

            public void push(E o) {
                add(o);
            }

            public E pop() {
                E o = get(getSize() - 1);
                remove(getSize() - 1);
                return o;
            }

            public boolean isEmpty() {
                return super.isEmpty();
            }

            @Override
            public String toString() {
                return "stack: " + super.toString();
            }
        }
    }



